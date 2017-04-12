<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<spring:url value="/vaccine/" var="saveVaccine" />

	<form:form modelAttribute="vaccineForm" method="POST" action="${saveVaccine}">
		<f:hidden path="id" />
		<table style="width: 499px; height: 265px; ">
			<tr>
				<td>Description: </td>
				<td style="width: 200px"><f:input path="description" />
					</tr>
					<tr>
				<td>Brand Name: </td>						
				<td style="width: 355px"><f:input path="brand" />
				</tr>
				<tr>
				<td>Implant Date: </td>
				<td style="width: 200px"><f:input path="implantDate" />
				</tr>
				<tr>
			<td>Implant Site: </td>
			<td style="width: 200px">
					<f:select id="implantSite" path="implantSite" onchange="myFunc(key)">
						<option value="-1">Select implantSite</option>
						<f:options items="${ImplantSiteList}" itemValue="value" itemLabel="key"/>
       				</f:select>
					</tr>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Description</th>
			<th>Brand</th>
			<th>Implant Date</th>
			<th>Implant Site</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listMicrochip}" var="microchip">
			<tr>
				<td>${microchip.id}</td>
				<td>${microchip.description}</td>
				<td>${microchip.brand}</td>
				<td>${microchip.implantDate}</td>

				
				<td>${microchip.implantSite}</td>

				<td>
					<spring:url value="/microchip/update?id=${microchip.id}" var="updateMicrochip" />
					<a type="button" class="btn btn-primary"
						href="${updateMicrochip}">Update</a>
					<spring:url value="/microchip/delete?id=${microchip.id}" var="deleteMicrochip" />
					<a type="button" class="btn btn-warning"
						href="${deleteMicrochip}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript">
	function myFunc() {
    var  selectedValue= $("#key").val();
    alert(selectedValue);
   }
</script>
<script src="js/app-ajax.js" type="text/javascript"></script>

<%@ include file="common/footer.jspf"%>

