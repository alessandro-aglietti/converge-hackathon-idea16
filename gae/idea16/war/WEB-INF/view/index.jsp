<?xml version="1.0" encoding="utf-8"?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="/js/jquery-1.11.2.min.js" type="text/javascript"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="/bootstrap-3.3.2-dist/css/bootstrap.min.css">

	<!-- Optional theme -->
<link rel="stylesheet"
	href="/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">

	<!-- Latest compiled and minified JavaScript -->
<script src="/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-12 col-md-12">
				<a target="_blank" href="https://github.com/alessandro-aglietti/converge-hackathon-idea16" style="
				    z-index: 99;
				"><img style="position: absolute; top: 0; right: 0; border: 0;" src="https://camo.githubusercontent.com/e7bbb0521b397edbd5fe43e7f760759336b5e05f/68747470733a2f2f73332e616d617a6f6e6177732e636f6d2f6769746875622f726962626f6e732f666f726b6d655f72696768745f677265656e5f3030373230302e706e67" alt="Fork me on GitHub" data-canonical-src="https://s3.amazonaws.com/github/ribbons/forkme_right_green_007200.png"></a>
				<h1>Step of this trip!</h1>
				<ol>
					<c:forEach items="${tss}" var="ts">
						<li style="margin-top: 15px;">
							<a href="/tripstep?id=${ts.id}"><button type="button" class="btn btn-info">${ts.name}</button></a>
						</li>
					</c:forEach>
				</ol>
				<h1>Add new step!</h1>
				<form method="post" action="/add">
					<div class="form-group">
						<label for="input1">Name of trip step</label> <input
							class="form-control" type="text" placeholder="name of step"
							id="input1" name="name" />
					</div>
					<div class="form-group">
						<label for="input2">Public URL of photosphere image</label> <input
							class="form-control" type="text" placeholder="uri of image"
							id="input2" name="imageuri" />
					</div>
					<div class="form-group">
						<label for="input3">Public URL of a SoundCloud asset</label> <input
							class="form-control" type="text" placeholder="uri of soundcloud"
							id="input3" name="sounduri" />
					</div>
					<button class="btn btn-default" type="submit">Save</button>
					<button class="btn btn-default" type="reset">Reset</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>