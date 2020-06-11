
package acme.features.administrator.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.cards.Card;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorCardUpdateService implements AbstractUpdateService<Administrator, Card> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorCardRepository repository;


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
	public void update(final Request<Card> request, final Card entity) {

		this.repository.save(entity);

	}

}
