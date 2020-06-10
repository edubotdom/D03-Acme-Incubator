
package acme.forms;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	// Serialization identifier ---------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Attributes ------------------------------------------------------------

	//Numbers
	Integer						totalNumberOfNotices;
	Integer						totalNumberOfTechnologyRecords;
	Integer						totalNumberOfToolRecords;
	//Inquiries
	Double						minimumMoneyInquiries;
	Double						maximumMoneyInquiries;
	Double						averageMoneyInquiries;
	Double						standardDesviationMoneyInquiries;
	//Overtures
	Double						minimumMoneyOvertures;
	Double						maximumMoneyOvertures;
	Double						averageMoneyOvertures;
	Double						standardDesviationMoneyOvertures;

	// Chart atts.
	List<String>				technologySectors;
	List<Long>					numberTechnologiesBySector;

	List<String>				toolSectors;
	List<Long>					numberToolsBySector;

	Double						openSourceRatioTechnologies;
	Double						closedSourceRatioTechnologies;

	Double						openSourceRatioTools;
	Double						closedSourceRatioTools;

	// Derived attributes ------------------------------------------------------

	// Relationships -----------------------------------------------------------
}
