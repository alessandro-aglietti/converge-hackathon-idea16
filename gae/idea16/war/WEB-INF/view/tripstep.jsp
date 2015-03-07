<?xml version="1.0" encoding="utf-8"?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<script src="/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="https://w.soundcloud.com/player/api.js" type="text/javascript"></script>
	<script>
		var TripStepModel = ${tsjson};
		console.log(TripStepModel);
		
		$(function() {
			var widgetIframe = document.getElementById('sc-widget');
			var widget = SC.Widget(widgetIframe);

			widget.bind(SC.Widget.Events.READY, function() {
				widget.play();
				widget.setVolume(100);
				$(widgetIframe).hide();
			});
		});
	</script>
</head>
<body>
	<iframe id="sc-widget"
		src="https://w.soundcloud.com/player/?url=${ts.soundCloudURI}"
		width="100%" height="465" scrolling="no" frameborder="no"></iframe>
</body>
</html>