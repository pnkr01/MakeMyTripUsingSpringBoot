<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Package List</title>
  <style>
    table {
      width: 100%;
      border-collapse: collapse;
    }
    table, th, td {
      border: 1px solid black;
    }
    th, td {
      padding: 10px;
      text-align: left;
    }
  </style>
</head>
<body>
<h2>Available Travel Packages</h2>
<table>
  <thead>
  <tr>
    <th>Package ID</th>
    <th>Source</th>
    <th>Destination</th>
    <th>Itenary</th>
    <th>Days</th>
    <th>Price</th>
    <th>Availability</th>
    <th>From Date</th>
    <th>To Date</th>
    <th>Description</th>
    <th>Total Trips</th>
    <th>Users Purchased So Far</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="pkg" items="${packages}">
    <tr>
      <td>${pkg.pkid.toString()}</td>
      <td>${pkg.pkg_src}</td>
      <td>${pkg.pkg_destination}</td>
      <td>${pkg.pkg_itenary}</td>
      <td>${pkg.pkg_days}</td>
      <td>${pkg.pkg_price}</td>
      <td>${pkg.pkg_isaval}</td>
      <td>${pkg.pkg_from_date}</td>
      <td>${pkg.pkg_to_date}</td>
      <td>${pkg.pkg_description}</td>
      <td>${pkg.pkg_total_trips}</td>
      <td>${pkg.pkg_user_purchased_so_far}</td>
    </tr>
  </c:forEach>

  </tbody>
</table>
</body>
</html>