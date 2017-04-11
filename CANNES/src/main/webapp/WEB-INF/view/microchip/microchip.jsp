<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<spring:url value="/microchip/" var="savemicrochip" />

	<form:form modelAttribute="microchipForm" method="POST" action="${saveMicrochip}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Microchip Description : </td>
				<td style="width: 200px"><f:input path="description" />
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Description</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listMicrochip}" var="microchip">
			<tr>
				<td>${microchip.id}</td>
				<td>${microchip.description}</td>
				
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

<script src="../js/app-ajax.js" type="text/javascript"></script>

<%@ include file="../common/footer.jspf"%>
