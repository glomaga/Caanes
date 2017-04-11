<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<spring:url value="/product/" var="saveProduct" />

	<form:form modelAttribute="productForm" method="POST" action="${saveProduct}">
		<f:hidden path="id"/>
		<table class="table">
			<tr>
				<td>
					<f:select id="categoryId" path="category_id" onchange="myFunc(value)">
						<option value="-1">Select Category</option>
						<f:options items="${categoryList}" itemValue="id" itemLabel="category_name"/>
       				</f:select>
                </td>
			</tr>
			<tr>
				<td>Product Code : </td>
				<td><f:input path="product_code"/>
				<td>Product Name : </td>
				<td><f:input path="product_name" />
				<td>Unit : </td>
				<td><f:input path="uom" />
				
				<td><button type="submit" class="btn btn-success">Save</button>
					<spring:url value="/product/" var="cancel" />
					<a type="button" class="btn btn-warning"
						href="${cancel}">Cancel</a>
						
				</td>
			</tr>
			<tr>
				<td colspan="5">
					<table class="table table-striped">
						<tr>
							<th>Product Code</th>
							<th>Product Name</th>
							<th>Unit</th>
							<th align="right"></th>
						</tr>
						<c:forEach items="${listProduct}" var="product">
							<tr>
								<td width="50px">${product.product_code}</td>
								<td width="250px">${product.product_name}</td>
								<td width="50px">${product.uom}</td>
								<td align="right">
									<spring:url value="/product/update?id=${product.id}" var="updateProduct" />
									<a type="button" class="btn btn-primary"
										href="${updateProduct}">Update</a>
									<spring:url value="/product/delete?id=${product.id}" var="deleteProduct" />
									<a type="button" class="btn btn-warning"
										href="${deleteProduct}">Delete</a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
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

