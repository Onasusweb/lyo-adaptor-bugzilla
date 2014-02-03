<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012 IBM Corporation.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 
 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 Contributors:
 
    Sam Padgett	  	- initial API and implementation
    Michael Fiedler	- adapted for OSLC4J
--%>

<%@ page import="org.eclipse.lyo.oslc4j.core.model.ServiceProviderCatalog" %>
<%@ page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider" %>
<%--
Start of user code imports
--%>
<%-- 
End of user code 
--%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
ServiceProviderCatalog catalog = (ServiceProviderCatalog)request.getAttribute("catalog");
%>
<%--
Start of user code getRequestAttributes
--%>
<%
String bugzillaUri = "https://landfill.bugzilla.org/bugzilla-4.0-branch/";
%>
<%--
End of user code
--%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>BugzillaAdaptor OSLC Adapter: Service Provider Catalog</title>
		<%-- 
Start of user code (RECOMMENDED) headStuff 
		--%>
		<link href="<%= bugzillaUri %>/skins/standard/global.css" rel="stylesheet" type="text/css">
		<link href="<%= bugzillaUri %>/skins/standard/index.css" rel="stylesheet" type="text/css">
		<link href="<%= bugzillaUri %>/skins/standard/global.css" rel="alternate stylesheet" title="Classic" type="text/css">
		<link href="<%= bugzillaUri %>/skins/standard/index.css" rel="alternate stylesheet" title="Classic" type="text/css">
		<link href="<%= bugzillaUri %>/skins/contrib/Dusk/global.css" rel="stylesheet" title="Dusk" type="text/css">
		<link href="<%= bugzillaUri %>/skins/contrib/Dusk/index.css" rel="stylesheet" title="Dusk" type="text/css">
		<link href="<%= bugzillaUri %>/skins/custom/global.css" rel="stylesheet" type="text/css">
		<link href="<%= bugzillaUri %>/skins/custom/index.css" rel="stylesheet" type="text/css">
		<link rel="shortcut icon" href="<%= bugzillaUri %>/images/favicon.ico">
		<%-- 
End of user code 
		--%>
	</head>
	<body onload="">
	
		<div id="header">
			<div id="banner"></div>
			<table border="0" cellspacing="0" cellpadding="0" id="titles">
				<tr>
					<td id="title">
						<p>
							OSLC Service Provider Catalog: Service Provider Catalog
						</p>
					</td>
					<td id="information">
						<p class="header_addl_info">
							version 0.1
						</p>
					</td>
				</tr>
			</table>
		</div>
		
		<div id="bugzilla-body">
			<div id="page-index">
			<%-- 
Start of user code (RECOMMENDED) bodyStuff1 
			--%>
			<img src="../../images/resources/bugzilla.gif" alt="icon" width="80" height="80" />
			<%-- 
End of user code 
			--%>
			<h1>Service Provider Catalog</h1>
			
			<p>OSLC Service Provider Catalog</p>

            <table>
	            <tr>
		            <td><b>This document</b>:</td>
		            <td><a href="<%= catalog.getAbout() %>">
                            <%= catalog.getAbout().toString() %>
                        </a></td>
	            </tr>
	            <tr>
					<%-- 
Start of user code (RECOMMENDED) bodyStuff2 
					--%>
		            <td><b>Bugzilla</b>:</td>
		            <td><a href="<%= bugzillaUri %>"><%= bugzillaUri %></a></td>
					<%-- 
End of user code 
					--%>
	            </tr>
	            <tr>
		            <td><b>Adapter Publisher</b>:</td>
		            <td>OSLC Tools Project</td>
	            </tr>
	            <tr>
		            <td><b>Adapter Identity</b>:</td>
		            <td>BugzillaAdaptor</td>
	            </tr>
            </table>
			
			<h2>Service Providers</h2>

			<% for (ServiceProvider s : catalog.getServiceProviders()) { %>
			<h3>Service Provider: <%= s.getTitle() %></h3>
			<p><a href="<%= s.getAbout() %>">
                    <%= s.getAbout() %></a></p>
			<% } %>		

			</div>
		</div>
		
		<div id="footer">
			<div class="intro"></div>
			<div class="outro">
				<div style="margin: 0 1em 1em 1em; line-height: 1.6em; text-align: left">
					<b>OSLC Tools Adapter Server 0.1</b> brought to you by <a href="http://eclipse.org/lyo">Eclipse Lyo</a><br>
				</div>
			</div>
		</div>
	</body>
</html>


