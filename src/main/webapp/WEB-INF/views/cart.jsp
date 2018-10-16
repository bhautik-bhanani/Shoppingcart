<%@ include file="../template/header.jsp" %>
<h2 class="header-title">Cart</h2>
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
	<c:set var="total" value="0" />
	<c:forEach var="product"
		items="${sessionScope.cart.get(sessionScope.loginUser.userId)}">
		<tr>
			<td><img
				src='<c:url value="/resources/images/${product.productImg}"/>'
				style="max-width: 100px; max-height: 100px;" /></td>
			<td>${product.productName}</td>
			<td>${product.productDesc}</td>
			<td>${product.productType}</td>
			<td>$${product.productPrice}</td>
			<td><a href="./movetowishlist/${product.productId}">Move to
					Wishlist</a> | <a href="./removecart/${product.productId}">Remove</a></td>
		</tr>
		<c:set var="total" value="${total+product.productPrice}" />
	</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="5" align="right"><b>Total:</b></td>
			<td>$<c:out value="${total}" /></td>
		</tr>
	</tfoot>
</table>
<%@ include file="../template/footer.jsp" %>