<html>
<head>
<title>Add Marks</title>

<style>
body { font-family: Arial; background: linear-gradient(to right,#74ebd5,#9face6);}
.container { width:50%; margin:60px auto; background:white; padding:25px; text-align:center; border-radius:10px;}
input { width:80%; padding:10px; margin:8px;}
input[type=submit]{background:#4CAF50;color:white;border:none;}
</style>

<script>
function validateForm(){
    let m=document.forms["f"]["marks"].value;
    if(m=="" || m<0 || m>100){
        alert("Marks must be 0-100");
        return false;
    }
}
</script>

</head>

<body>
<div class="container">

<h2>Add Marks</h2>

<form name="f" action="add" method="post" onsubmit="return validateForm()">
<input type="text" name="id" placeholder="ID">
<input type="text" name="name" placeholder="Name">
<input type="text" name="subject" placeholder="Subject">
<input type="text" name="marks" placeholder="Marks">
<input type="date" name="date">

<input type="submit" value="Add">
</form>

</div>
</body>
</html>