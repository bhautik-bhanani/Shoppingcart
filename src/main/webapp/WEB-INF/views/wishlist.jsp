<%@ include file="../template/header.jsp" %>
<h2 class="header-title">Wish List</h2>
<table class="table">
	<thead>
		<tr>
			<th scope="col">Product Image</th>
			<th scope="col">Product Name</th>
			<th scope="col">Product Description</th>
			<th scope="col">Product Type</th>
			<th scope="col">Product Price</th>
			<th scope="col">Action</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="product" items="${wishlist}">
		<tr>
			<td><img
				src='<c:url value="/resources/images/${product.productImg}"/>'
				style="max-width: 100px; max-height: 100px;" /></td>
			<td>${product.productName}</td>
			<td>${product.productDesc}</td>
			<td>${product.productType}</td>
			<td>$${product.productPrice}</td>
			<td><a href="./movetocart/${product.productId}">Move to
					Cart</a> | <a href="./removewishlist/${product.productId}">Remove</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<%@ include file="../template/footer.jsp" %>