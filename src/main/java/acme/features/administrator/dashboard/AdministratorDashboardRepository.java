/*
 * AuthenticatedUserAccountRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.administrator.dashboard;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Notice a")
	Integer countNumberOfNotices();

	@Query("select count(cr) from Technology cr")
	Integer countTechnologyRecords();

	@Query("select count(ir) from Tool ir")
	Integer countToolRecords();

	//Minimum, maximum, average, and standard deviation of the active inquiries

	@Query("select min(ar.money.amount) from Inquiry ar where ar.deadline >= current_date()")
	Double minimumInquiry();

	@Query("select max(ar.money.amount) from Inquiry ar where ar.deadline >= current_date()")
	Double maximumInquiry();

	@Query("select avg(ar.money.amount) from Inquiry ar where ar.deadline >= current_date()")
	Double averageInquiry();

	@Query("select stddev(ar.money.amount) from Inquiry ar where ar.deadline >= current_date()")
	Double standardDesviationInquiry();

	//Minimum, maximum, average, and standard deviation of the active overtures

	@Query("select min(ao.money.amount) from Overture ao where ao.deadline >= current_date()")
	Double minimumOverture();

	//@Query("select max((max_amount + min_amount)/2) from Acme_offer where deadline >= CURRENT_DATE")
	@Query("select max(ao.money.amount) from Overture ao where ao.deadline >= current_date()")
	Double maximumOverture();

	@Query("select avg(ao.money.amount) from Overture ao where ao.deadline >= current_date()")
	Double averageOverture();

	@Query("select stddev(ao.money.amount) from Overture ao where ao.deadline >= current_date()")
	Double standardDesviationOverture();

	@Query("select count(cr), cr.sector from Technology cr group by cr.sector order by cr.sector")
	Collection<Object[]> getNumTechBySector();

	@Query("select count(ir), ir.sector from Tool ir group by ir.sector order by ir.sector")
	Collection<Object[]> getNumToolBySector();

	@Query("select 1.0 * count(a) from Technology a where a.source = 'closed-source'")
	Double openSourceRatioTechnologiesRatio();

	@Query("select 1.0 * count(a) from Technology a where a.source = 'open-source'")
	Double closedSourceRatioTechnologiesRatio();

	@Query("select 1.0 * count(a) from Tool a where a.source = 'open-source'")
	Double openSourceRatioToolsRatio();

	@Query("select 1.0 * count(a) from Tool a where a.source = 'closed-source'")
	Double closedSourceRatioToolsRatio();

}
