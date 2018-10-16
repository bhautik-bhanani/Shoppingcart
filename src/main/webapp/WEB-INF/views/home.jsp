<%@ include file="../template/header.jsp"%>
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
		<c:forEach var="product" items="${products}">
			<tr>
				<td><img
					src='<c:url value="/resources/images/${product.productImg}"/>'
					style="max-width: 80px; max-height: 80px;" /></td>
				<td>${product.productName}</td>
				<td>${product.productDesc}</td>
				<td>${product.productType}</td>
				<td>$${product.productPrice}</td>
				<td><a href="./addToCart/${product.productId}">Add to Cart</a>
					| <a href="./addToWishlist/${product.productId}">Add to
						Wishlist</a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@ include file="../template/footer.jsp"%>