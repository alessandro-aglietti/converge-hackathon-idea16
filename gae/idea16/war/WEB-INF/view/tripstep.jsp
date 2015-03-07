<?xml version="1.0" encoding="utf-8"?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<script>
		var TripStepModel = ${tsjson};
		console.log(TripStepModel);
		var SC_WIDGET;
	</script>

	<script src="/js/jquery-1.11.2.min.js" type="text/javascript"></script>
	<script src="/js/three/three.min.js" type="text/javascript"></script>
	<script src="/js/three/Detector.js" type="text/javascript"></script>
	<script src="/js/three/DeviceOrientationControls.js" type="text/javascript"></script>
	<script src="/js/three/main.js" type="text/javascript"></script>
	<script src="https://w.soundcloud.com/player/api.js" type="text/javascript"></script>
	<script>	
		$(function() {
			var widgetIframe = document.getElementById('sc-widget');
			SC_WIDGET = SC.Widget(widgetIframe);

			SC_WIDGET.bind(SC.Widget.Events.READY, function() {
				SC_WIDGET.setVolume(100);
				$(widgetIframe).hide();
			});
		});
	</script>
</head>
<body onclick="fullscreen()">
	<h1 id="help" style="z-index: 99; position: absolute; margin-top: 15%;">When you're ready, tap on the screen and relax!</h1>
	<iframe id="sc-widget"
		src="https://w.soundcloud.com/player/?url=${ts.soundCloudURI}"
		width="100%" height="465" scrolling="no" frameborder="no"></iframe>
	<div id="spheresx"
		style="background-color: blue; width: 50%; position: absolute; height: 100%; left: 0px; top: 0px;"></div>
	<div id="spheredx"
		style="background-color: yellow; width: 50%; position: absolute; height: 100%; right: 0px; top: 0px;"></div>
</body>
</html>