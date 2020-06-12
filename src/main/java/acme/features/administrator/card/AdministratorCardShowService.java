
package acme.features.administrator.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.cards.Card;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCardShowService implements AbstractShowService<Administrator, Card> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorCardRepository repository;


	// AbstractShowService<Administrator, Announcement>interface --------------
	@Override
	public boolean authorise(final Request<Card> request) {
		assert request != null;

		return true;
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
}