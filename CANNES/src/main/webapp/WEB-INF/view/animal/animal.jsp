<%@ include file="common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">

	<spring:url value="/animal/" var="saveAnimal" />

	<form:form modelAttribute="animalForm" method="POST" action="${saveAnimal}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Animal Name : </td>
				<td style="width: 200px;padding:10px">
					<f:input path="name"  />
				</td>
				
			</tr>
			<tr>
				<td>Animal Gender : </td>
				<td>
					<f:select path="gender" style="margin:10px">
					    
				        <c:forEach items="${listStatus}" var="option">
				                <option value="${option}" ${option == selectedGender ? 'selected="selected"' : ''}>
				                    <c:out value="${option}"></c:out>
				                </option>
				        </c:forEach>
					</f:select>
       			</td>			
				
			</tr>
			<tr>
				<td>Is Neuter : </td>
				<td style="padding:10px;">
					<f:checkbox path="neutered" />
       			</td>		
			</tr>
			<tr>
				<td>Birth Date : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="birth" maxlength="10" type = "date" />
				</td>
			</tr>
			<tr>
				<td>Color : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="color" maxlength="10" />
				</td>
			</tr>
			<tr>
				<td>Deceased : </td>
				<td style="width: 20px;padding:10px">
					<f:input path="deceased" maxlength="10" type="date"  />
				</td>
			</tr>
			<tr>
				<td>Is Active : </td>
				<td style="padding:10px;">
					<f:checkbox path="status" />
       			</td>			
			</tr>
			<tr>		
					
			</tr>
			
			
			<tr>
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Animal Name</th>
			<th>Gender</th>
			<th>Is Neutered</th>
			<th>Birth Date</th>
			<th>Deceased</th>
			<th>Is Active</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listAnimal}" var="animal">
			<tr>
				<td>${animal.id}</td>
				<td>${animal.name}</td>
				<td>${animal.gender}</td>
				<td>${animal.neutered}</td>
				<td>${animal.birth}</td>
				<td>${animal.deceased}</td>
				<td>${animal.status}</td>
				
				<td>
					<spring:url value="/animal/update?id=${animal.id}" var="updateAnimal" />
					<a type="button" class="btn btn-primary"
						href="${updateAnimal}">Update</a>
					<spring:url value="/animal/delete?id=${animal.id}" var="deleteAnimal" />
					<a type="button" class="btn btn-warning"
						href="${deleteAnimal}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<%@ include file="common/footer.jspf"%>
<script>
	$(document).ready(function () {
	    var url = window.location;
	    $('ul.nav > li').removeClass('active');
	    $('ul.nav a[href="'+ url +'"]').parent().addClass('active');
	    $('ul.nav a').filter(function() {
	         return this.href == url;
	    }).parent().addClass('active');
	});
</script>
