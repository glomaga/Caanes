<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">

	<spring:url value="/vaccine/" var="saveVaccine" />

	<form:form modelAttribute="vaccineForm" method="POST" action="${saveVaccine}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Animal: </td>
				<td style="width: 200px;padding:10px">
				<f:select path="animal_id" style="margin:10px">
						<option value="1">1</option>
						<option value="0">2</option>
						<!--<f:options items="${categoryList}" itemValue="id" itemLabel="category_name"/>-->
	       			</f:select> 
				</td>	
			</tr>
			<tr>
				<td>Birth Date : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="date" maxlength="10" type = "date" />
				</td>
			</tr>
			<tr>
				<td>Batch : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="batch" maxlength="10" />
				</td>
			</tr>
			<tr>
				<td>Doctor: </td>
				<td style="width: 200px;padding:10px">
				<f:select path="doctor_id" style="margin:10px">
						<option value="1">1</option>
						<option value="0">2</option>
						<!--<f:options items="${categoryList}" itemValue="id" itemLabel="category_name"/>-->
	       			</f:select> 
				</td>	
			</tr>
			<tr>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Animal id</th>
			<th>Date</th>
			<th>Name Vaccine</th>
			<th>Batch</th>
			<th>Doctor ID</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listVaccine}" var="vaccine">
			<tr>
				<td>${vaccine.id}</td>
				<td>${vaccine.animal_id}</td>
				<td>${vaccine.date}</td>
				<td>${vaccine.name}</td>
				<td>${vaccine.batch}</td>
				<td>${vaccine.doctor_id}</td>
				
				<td>
					<spring:url value="/vaccine/update?id=${vaccine.id}" var="updateVaccine" />
					<a type="button" class="btn btn-primary"
						href="${updateVaccine}">Update</a>
					<spring:url value="/vaccine/delete?id=${animal.id}" var="deleteVaccine" />
					<a type="button" class="btn btn-warning"
						href="${deleteAVaccine}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="common/footer.jspf"%>
