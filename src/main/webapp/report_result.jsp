<%@ page import="java.util.*, com.model.StudentMark" %>

<html>
<head>
<title>Report Result</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #74ebd5, #9face6);
}

.container {
    width: 80%;
    margin: 40px auto;
    background: white;
    padding: 25px;
    border-radius: 10px;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    border: 1px solid black;
    padding: 10px;
    text-align: center;
}

th {
    background-color: #4CAF50;
    color: white;
}

h2 {
    text-align: center;
}
</style>
</head>

<body>

<div class="container">

<h2>Report Result</h2>

<%
List<StudentMark> list = (List<StudentMark>) request.getAttribute("reportList");

if (list != null && !list.isEmpty()) {
%>

<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Subject</th>
<th>Marks</th>
<th>Date</th>
</tr>

<%
for (StudentMark s : list) {
%>

<tr>
<td><%= s.getStudentID() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getSubject() %></td>
<td><%= s.getMarks() %></td>
<td><%= s.getExamDate() %></td>
</tr>

<%
}
%>

</table>

<%
} else {
%>

<p style="text-align:center; color:red;">No records found</p>

<%
}
%>

</div>

</body>
</html>