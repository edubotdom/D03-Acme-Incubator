
package acme.features.administrator.dashboard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorDashboardRepository repository;


	// AbstractShowService<Administrator, Announcement>interface --------------
	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfNotices", "totalNumberOfTechnologyRecords", "totalNumberOfToolRecords", "minimumMoneyInquiries", "maximumMoneyInquiries", "averageMoneyInquiries", "standardDesviationMoneyInquiries",
			"minimumMoneyOvertures", "maximumMoneyOvertures", "averageMoneyOvertures", "standardDesviationMoneyOvertures", "technologySectors", "numberTechnologiesBySector", "toolSectors", "numberToolsBySector", "openSourceRatioTechnologies",
			"closedSourceRatioTechnologies", "openSourceRatioTools", "closedSourceRatioTools");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		//Numbers
		result.setTotalNumberOfNotices(this.repository.countNumberOfNotices());
		result.setTotalNumberOfTechnologyRecords(this.repository.countTechnologyRecords());
		result.setTotalNumberOfToolRecords(this.repository.countToolRecords());
		//Inquiries
		result.setMinimumMoneyInquiries(this.repository.minimumInquiry());
		result.setMaximumMoneyInquiries(this.repository.maximumInquiry());
		result.setAverageMoneyInquiries(this.repository.averageInquiry());
		result.setStandardDesviationMoneyInquiries(this.repository.standardDesviationInquiry());
		//Overtures
		result.setMinimumMoneyOvertures(this.repository.minimumOverture());
		result.setMaximumMoneyOvertures(this.repository.maximumOverture());
		result.setAverageMoneyOvertures(this.repository.averageOverture());
		result.setStandardDesviationMoneyOvertures(this.repository.standardDesviationOverture());

		//		Chart's atts

		List<String> techSectors = new ArrayList<>();
		List<Long> numTechs = new ArrayList<>();

		Collection<Object[]> a = this.repository.getNumTechBySector();
		for (Object[] ob : a) {
			techSectors.add((String) ob[1]);
			numTechs.add((Long) ob[0]);
		}

		result.setTechnologySectors(techSectors);
		result.setNumberTechnologiesBySector(numTechs);

		List<String> toolSectors = new ArrayList<>();
		List<Long> numTools = new ArrayList<>();

		Collection<Object[]> b = this.repository.getNumToolBySector();
		for (Object[] ob : b) {
			toolSectors.add((String) ob[1]);
			numTools.add((Long) ob[0]);
		}

		result.setToolSectors(toolSectors);
		result.setNumberToolsBySector(numTools);

		//Open and Closed source stats

		result.setOpenSourceRatioTechnologies(this.repository.openSourceRatioTechnologiesRatio());
		result.setClosedSourceRatioTechnologies(this.repository.closedSourceRatioTechnologiesRatio());

		result.setOpenSourceRatioTools(this.repository.openSourceRatioToolsRatio());
		result.setClosedSourceRatioTools(this.repository.closedSourceRatioToolsRatio());

		return result;
	}

}
