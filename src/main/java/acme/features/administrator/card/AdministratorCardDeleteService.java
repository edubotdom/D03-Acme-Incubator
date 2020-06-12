
package acme.features.administrator.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banners.Banner;
import acme.entities.cards.Card;
import acme.features.administrator.banner.AdministratorBannerRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorCardDeleteService implements AbstractDeleteService<Administrator, Card> {

	@Autowired
	AdministratorCardRepository		repository;
	@Autowired
	AdministratorBannerRepository	bannerRepository;


	@Override
	public boolean authorise(final Request<Card> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Card> request, final Card entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Card> request, final Card entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "holder", "number", "brand", "cvv");
	}

	@Override
	public Card findOne(final Request<Card> request) {
		assert request != null;
		Card result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Card> request, final Card entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Card> request, final Card entity) {
		assert request != null;
		assert entity != null;

		Banner banner = this.repository.findBannerByCard(entity.getId());
		banner.setCard(null);

		this.bannerRepository.save(banner);
		this.repository.delete(entity);
	}

}
