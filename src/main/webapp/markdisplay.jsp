<%@ page import="java.util.*,com.model.StudentMark" %>

<html>
<head>
<title>Display</title>

<style>
body { font-family: Arial; background: linear-gradient(to right,#74ebd5,#9face6);}
.container { width:80%; margin:40px auto; background:white; padding:25px; border-radius:10px;}
table { width:100%; border-collapse:collapse;}
th { background:#4CAF50; color:white; padding:10px;}
td { border:1px solid #ddd; padding:10px; text-align:center;}
</style>

</head>

<body>

<div class="container">
<h2>Student Marks</h2>

<%
List<StudentMark> list=(List<StudentMark>)request.getAttribute("data");

if(list!=null && !list.isEmpty()){
%>

<table>
<tr>
<th>ID</th><th>Name</th><th>Subject</th><th>Marks</th><th>Date</th>
</tr>

<%
for(StudentMark s:list){
%>

<tr>
<td><%=s.getStudentID()%></td>
<td><%=s.getStudentName()%></td>
<td><%=s.getSubject()%></td>
<td><%=s.getMarks()%></td>
<td><%=s.getExamDate()%></td>
</tr>

<%
}
%>

</table>

<%
}else{
%>
<p>No records found</p>
<%
}
%>

</div>

</body>
</html>