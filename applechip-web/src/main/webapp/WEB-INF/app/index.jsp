<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<!-- build:css(.) styles/vendor.css -->
<!-- bower:css -->
<!-- endbower -->
<!-- endbuild -->
<!-- build:css(.tmp) styles/main.css -->
<link rel="stylesheet" href="styles/main.css">
<!-- endbuild -->
</head>
<body ng-app="webInfApp">
	<!--[if lt IE 7]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

	<!-- Add your site or application content here -->
	<div class="container">
		<div class="header">
			<ul class="nav nav-pills pull-right">
				<li class="active"><a ng-href="#">Home</a></li>
				<li><a ng-href="#">About</a></li>
				<li><a ng-href="#">Contact</a></li>
			</ul>
			<h3 class="text-muted">webInf</h3>
		</div>

		<div ng-include="'main'" ng-controller="MainCtrl"></div>

		<div class="footer">
			<p>
				<span class="glyphicon glyphicon-heart"></span> from the Yeoman team
			</p>
		</div>
	</div>


	<!-- Google Analytics: change UA-XXXXX-X to be your site's ID -->
	<script>
		(function(i, s, o, g, r, a, m) {
			i['GoogleAnalyticsObject'] = r;
			i[r] = i[r] || function() {
				(i[r].q = i[r].q || []).push(arguments)
			}, i[r].l = 1 * new Date();
			a = s.createElement(o), m = s.getElementsByTagName(o)[0];
			a.async = 1;
			a.src = g;
			m.parentNode.insertBefore(a, m)
		})(window, document, 'script',
				'//www.google-analytics.com/analytics.js', 'ga');

		ga('create', 'UA-XXXXX-X');
		ga('send', 'pageview');
	</script>

	<!-- build:js(.) scripts/oldieshim.js -->
	<!--[if lt IE 9]>
    <script src="bower_components/es5-shim/es5-shim.js"></script>
    <script src="bower_components/json3/lib/json3.js"></script>
    <![endif]-->
	<!-- endbuild -->

	<!-- build:js(.) scripts/vendor.js -->
	<!-- bower:js -->
	<script src="bower_components/angular/angular.js"></script>
	<!-- endbower -->
	<!-- endbuild -->

	<!-- build:js({.tmp,app}) scripts/scripts.js -->
	<script src="resources/scripts/app.js"></script>
	<script src="resources/scripts/controllers/main.js"></script>
	<!-- endbuild -->
</body>
</html>
