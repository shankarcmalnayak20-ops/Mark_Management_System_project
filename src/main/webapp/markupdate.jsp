<html>
<head>
<title>Update</title>

<style>
body { font-family: Arial; background: linear-gradient(to right,#74ebd5,#9face6);}
.container { width:50%; margin:60px auto; background:white; padding:25px; text-align:center; border-radius:10px;}
input { width:80%; padding:10px; margin:8px;}
input[type=submit]{background:orange;color:white;border:none;}
</style>

</head>

<body>
<div class="container">

<h2>Update Marks</h2>

<form action="update" method="post">
<input type="text" name="id" placeholder="ID">
<input type="text" name="name" placeholder="Name">
<input type="text" name="subject" placeholder="Subject">
<input type="text" name="marks" placeholder="Marks">
<input type="date" name="date">

<input type="submit" value="Update">
</form>

</div>
</body>
</html>