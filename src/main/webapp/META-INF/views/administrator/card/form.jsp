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
	<acme:form-textbox code="administrator.card.form.label.holder" path="holder"/>
	<acme:form-textbox code="administrator.card.form.label.number" path="number"/>
	<acme:form-textbox code="administrator.card.form.label.brand" path="brand"/>
	<acme:form-textbox code="administrator.card.form.label.cvv" path="cvv"/>
	
	<acme:form-hidden path="id_banner"/>
	
	<acme:form-submit test="${command == 'create'}" code="administrator.card.form.button.create"
		action="/administrator/card/create"/>	
		
	<acme:form-submit test="${command!= 'create'}" code="administrator.card.form.button.update"
		action="/administrator/card/update" />
		
	<acme:form-submit test="${command!= 'create'}" code="administrator.card.form.button.delete"
		action="/administrator/card/delete" />
	
  	<acme:form-return code="administrator.card.form.button.return"/>
</acme:form>
