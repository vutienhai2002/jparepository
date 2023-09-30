<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
</head>
<body>

	<h1>Update Product</h1>

	<form:form action="edit" method="post" modelAttribute="product">
		<table>
			<tr>
				<td><form:label path="id">ID:</form:label></td>
				<td><form:input path="id" readonly="true" /> <form:errors
						path="id" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Tên sản phẩm:</form:label></td>
				<td><form:input path="name" /> <form:errors path="name"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Giá:</form:label></td>
				<td><form:input path="price" /> <form:errors path="price"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="image">Image:</form:label></td>
				<td><form:input path="image" /> <form:errors path="image"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${not empty error}">
						<span class="error">Message: ${error}</span>
					</c:if> <c:if test="${not empty success}">
						<span class="success">Message: ${success}</span>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
