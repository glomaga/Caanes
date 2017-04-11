<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<spring:url value="/category/" var="saveCategory" />

	<form:form modelAttribute="categoryForm" method="POST" action="${saveCategory}">
		<f:hidden path="id" />
		<table>
			<tr>
				<td>Category Name : </td>
				<td style="width: 200px"><f:input path="category_name" />
				<td><button type="submit" class="btn btn-success">Save</button></td>
			</tr>
		</table>
	</form:form>
 
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Category Name</th>
			<th colspan="2"> Action</th>
		</tr>
		<c:forEach items="${listCategory}" var="category">
			<tr>
				<td>${category.id}</td>
				<td>${category.category_name}</td>
				
				<td>
					<spring:url value="/category/update?id=${category.id}" var="updateCategory" />
					<a type="button" class="btn btn-primary"
						href="${updateCategory}">Update</a>
					<spring:url value="/category/delete?id=${category.id}" var="deleteCategory" />
					<a type="button" class="btn btn-warning"
						href="${deleteCategory}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<script src="js/app-ajax.js" type="text/javascript"></script>

<%@ include file="common/footer.jspf"%>

