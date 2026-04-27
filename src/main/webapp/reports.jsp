<html>
<head>
<title>Reports</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #74ebd5, #9face6);
}
.container {
    width: 60%;
    margin: 50px auto;
    background: white;
    padding: 25px;
    border-radius: 10px;
    text-align: center;
}
input[type="text"] {
    padding: 8px;
    margin-left: 10px;
}
input[type="submit"] {
    margin-top: 15px;
    padding: 10px;
    background: #4CAF50;
    color: white;
    border: none;
}
</style>
</head>

<body>

<div class="container">

<h3>Select Report</h3>

<form action="reportCriteria" method="post">

<input type="radio" name="type" value="above">
Marks Above Value
<input type="text" name="marks"><br><br>

<input type="radio" name="type" value="subject">
By Subject
<input type="text" name="subject"><br><br>

<input type="radio" name="type" value="top">
Top N Students
<input type="text" name="limit"><br><br>

<input type="submit" value="Generate Report">

</form>

</div>

</body>
</html>