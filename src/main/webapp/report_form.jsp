<html>
<head>
<title>Report Input</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #74ebd5, #9face6);
}
.container {
    width: 50%;
    margin: 60px auto;
    background: white;
    padding: 25px;
    border-radius: 10px;
    text-align: center;
}
input {
    width: 80%;
    padding: 10px;
    margin: 8px;
}
input[type="submit"] {
    background: #4CAF50;
    color: white;
    border: none;
}
</style>
</head>

<body>

<div class="container">

<h2>Enter Report Details</h2>

<form action="reportCriteria" method="post">

<!-- ✅ VERY IMPORTANT -->
<input type="hidden" name="type" value="<%= request.getParameter("type") %>">

Marks (Above):
<input type="text" name="marks" placeholder="Enter marks"><br>

Subject:
<input type="text" name="subject" placeholder="Enter subject"><br>

Top N:
<input type="text" name="limit" placeholder="Enter number"><br><br>

<input type="submit" value="Generate Report">

</form>

</div>

</body>
</html>