<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<acme:form-hidden path="isCardEmpty"/>
	<acme:form-hidden path="linkCreateCC"/>
	<acme:form-hidden path="linkShowCC"/>
		
	<acme:form-textbox code="administrator.banner.form.label.slogan" path="slogan"/>

	<acme:form-url code="administrator.banner.form.label.picture" path="picture"/>
	<acme:form-url code="administrator.banner.form.label.url" path="url"/>
	
	<jstl:if test="${isCardEmpty=='true'}">
	<acme:form-return code="administrator.banner.form.button.createCC" action="${linkCreateCC}"/>
	</jstl:if>
	<jstl:if test="${isCardEmpty=='false'}">
	<acme:form-return code="administrator.banner.form.button.showCC" action="${linkShowCC}"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.banner.form.button.create"
		action="/administrator/banner/create"/>	
		
	<acme:form-submit test="${command!= 'create'}" code="administrator.banner.form.button.update"
		action="/administrator/banner/update" />
		
	<acme:form-submit test="${command!= 'create'}" code="administrator.banner.form.button.delete"
		action="/administrator/banner/delete" />
	
  	<acme:form-return code="administrator.banner.form.button.return"/>
</acme:form>
