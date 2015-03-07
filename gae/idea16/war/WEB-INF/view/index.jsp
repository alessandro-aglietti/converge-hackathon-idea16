<?xml version="1.0" encoding="utf-8"?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<c:forEach items="${tss}" var="ts">
		<p>
			<a href="/tripstep?id=${ts.id}">${ts.name}</a>
		</p>
	</c:forEach>
	<div>
		<form method="post" action="/">
			<input type="text" placeholder="name of step" name="name"/>
			<br />
			<input type="text" placeholder="uri of image" name="imageuri"/>
			<br />
			<input type="text" placeholder="uri of soundcloud" name="sounduri"/>
			<br />
			<input type="submit" value="save" />
			<br />
			<input type="reset" value="cancel" />
		</form>
	</div>
</body>
</html>