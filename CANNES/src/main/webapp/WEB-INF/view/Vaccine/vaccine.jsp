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
				<td style="width: 200px; ">Name Animal: </td>
								<td>
					<f:select id="animal_id" path="animal_id" onchange="myFunc(value)">
						<option value="-1">Select Animal</option>
						<f:options items="${AnimalList}" itemValue="id" itemLabel="animal"/>
       				</f:select>
                </td>
					</tr>
					<tr>
				<td style="width: 200px; ">Date: </td>						
				<td style="width: 355px"><f:input path="date" />
				</tr>
				<tr>
				<td style="width: 200px; ">Name Vaccine: </td>
				<td style="width: 200px"><f:input path="name" />
				</tr>
				<tr>
				<td style="width: 200px; ">Batch: </td>
				<td style="width: 200px"><f:input path="batch" />
				</tr>
				<tr><td>
				<button type="submit" class="btn btn-success">Save</button></td>
				</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Animal</th>
			<th>Date</th>
			<th>Name</th>
			<th>Batch</th>
			<th>Doctor</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listVaccione}" var="vaccine">
			<tr>
				<td>${vaccine.id}</td>
				<td>${vaccine.Animal_id}</td>
				<td>${vaccine.date}</td>
				<td>${vaccine.name}</td>
				<td>${vaccine.batch}</td>
				<td>${vaccine.doctor}</td>
				<td>
					<spring:url value="/vaccine/update?id=${vaccine.id}" var="updateVaccine" />
					<a type="button" class="btn btn-primary"
						href="${updateVaccine}">Update</a>
					<spring:url value="/vaccine/delete?id=${vaccine.id}" var="deleteVaccine" />
					<a type="button" class="btn btn-warning"
						href="${deleteVaccine}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript">
	function myFunc() {
    var  selectedValue= $("#animal_id").val();
    alert(selectedValue);
   }
</script>
<script src="js/app-ajax.js" type="text/javascript"></script>

<%@ include file="common/footer.jspf"%>

