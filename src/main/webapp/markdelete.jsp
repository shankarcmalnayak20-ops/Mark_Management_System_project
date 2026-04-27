<html>
<head>
<title>Delete</title>

<style>
body { font-family: Arial; background: linear-gradient(to right,#74ebd5,#9face6);}
.container { width:50%; margin:60px auto; background:white; padding:25px; text-align:center; border-radius:10px;}
input { width:80%; padding:10px; margin:8px;}
input[type=submit]{background:red;color:white;border:none;}
</style>

</head>

<body>
<div class="container">

<h2>Delete Record</h2>

<form action="delete" method="post">
<input type="text" name="id" placeholder="Enter ID">
<input type="submit" value="Delete">
</form>

</div>
</body>
</html>