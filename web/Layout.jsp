<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="fa" lang="fa" dir="rtl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/> 
<link rel="stylesheet" type="text/css" href="style.css"  />

<title><tiles:getAsString name="Title" ignore="true"/></title>

</head>

<body><div id="back">
       
 <tiles:insert attribute="Header"/> 


<div id="LeftMenu">
     <tiles:insert attribute="LeftMenu"/> 
</div>

<div id="RightMenu">
    <tiles:insert attribute="RightUp"/> 
    <tiles:insert attribute="RightDown"/>     
</div>

<div id="Content">
    <tiles:insert attribute="Content"/> 
</div>

<div id="Footer">
Copyright &copy; 2007 (:D). Design by kty <a href="http://www.studio-plume.org">studio-plume.org</a> for <a href="http://www.oswd.org/">OSWD</a>.</div>

</div>
</body>
</html>
