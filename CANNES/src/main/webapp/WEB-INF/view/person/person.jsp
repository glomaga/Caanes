<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<spring:url value="/person/" var="savePerson" />

	<form:form modelAttribute="personForm" method="POST" action="${savePerson}">
		<f:hidden path="id"/>
		<table style="margin: 10 10 10 10">
			<tr>
				<%-- <td>Type</td><td width="10px"></td><td width="15px">:</td>
				<td>
					<f:radiobuttons path="type" items="${personType}" />
                </td> --%>
			</tr>
			<tr>
				<td>Title</td><td/><td>:
				<td>
					<%-- <f:select id="titleList" path="title">
						<option value="-1">Select</option>
						<f:options items="${titleList}"/>
       				</f:select> --%>
				</td>
			</tr>
			<tr>
				<td>First Name</td><td/><td>:</td>
				<td><f:input path="firstName"/>
			</tr>
			<tr>
				<td>Last Name</td><td/><td>:</td>
				<td><f:input path="lastName" />
			</tr>
			<tr>
				<td>Gender</td><td/><td>:</td>
				<td>
       				<f:radiobuttons path="gender" items="${genderList}" />
       		</tr>
       		<tr>
				<td>Status</td><td/><td>:</td>
				<td>
       				<f:radiobuttons path="status" items="${statusList}" />
       		</tr>
       		<tr>
				<td colspan="4" align="right">
					<button type="submit" class="btn btn-success">Save</button>
					<spring:url value="/person" var="cancel" />
					<a type="button" class="btn btn-warning"
						href="${cancel}">Cancel</a>
				</td>
			</tr>
		</table>
		
		<table class="table table-striped">
			<tr>
				<th>Title</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Gender</th>
				<th>Type</th>
				<th>Status</th>
				<th align="right"></th>
			</tr>
			
			<!-- 
			<c:forEach items="${personList}" var="persons">
				<tr>
					<td width="30px">${persons.title}</td>
					<td width="150px">${persons.firstName}</td>
					<td width="150px">${persons.lastName}</td>
					<td width="40px">${persons.gender}</td>
					<td width="40px">${persons.type}</td>
					<td width="40px">${persons.status}</td>
					<td align="right">
						<spring:url value="/person/update?id=${persons.id}" var="updatePerson" />
						<a type="button" class="btn btn-primary"
							href="${updatePerson}">Update</a>
						<spring:url value="/person/delete?id=${persons.id}" var="deletePerson" />
						<a type="button" class="btn btn-warning"
							href="${deletePerson}">Delete</a>
					</td>
				</tr>
			</c:forEach>
			 -->
		</table>
	</form:form>
 
	
</div>
<script type="text/javascript">
	function myFunc() {
    var  selectedValue= $("#categoryId").val();
    alert(selectedValue);
   }
</script>

<script src="js/app-ajax.js" type="text/javascript"></script>

<%@ include file="common/footer.jspf"%>

