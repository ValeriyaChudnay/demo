<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body class="text-center">
<#include "header.ftl">
<div class="container jumbotron p-3 p-md-5 rounded bg-light " style="width: 65%">
<img class="mb-4" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTNGx2OZ0ldgICXP76Z2gQx3PSn4eYKL0uhsA&usqp=CAU" alt="" width="70" height="70">
<h1 class="h3 mb-3 fw-normal">Please create anketa</h1>
<form onSubmit="return confirm('Anketa was created successfully!');this.submit();"  action="/createAnketa" method="post">
<#list 1..questionNumber as x>
 <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">${x}. Your question here:</label>
      <input type="text" name="question${x}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
</#list>
  <button type="submit" class="w-100 btn btn-lg btn-primary">Submit</button>
</form>
</div>
<#include "footer.ftl">
</body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>