<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href="/docs/5.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    </head>
<body class="text-center">
<#include "header.ftl">
<div class="container jumbotron p-3 p-md-5 rounded bg-light " style="width: fit-content">
<img class="mb-4" src="https://www.eiturbanmobility.eu/wp-content/uploads/2020/03/EIT_Idea_small.jpg" alt="" width="70" height="70">
<h1 class="h3 mb-3 fw-normal">Please sign up</h1>
<form action="/sign-up" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
  </div>
  <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Nick Name</label>
      <input type="text" name="name" class="form-control" >
      <div id="emailHelp" class="form-text">We'll never share your data.</div>
    </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label">Organization Code</label>
      <input type="text" name="organizationCode" class="form-control" >
      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
   <div class="mb-3">
      <label for="exampleInputPassword1" class="form-label">Рівень компетенції експерта</label>
      <p><span id="expert">50</span>% </p>
      <div class="form-group">
        <label for="formControlRange">Expert</label>
        <input type="range" class="form-range" name="score" min="0" max="100" step="1" id="formControlRange1">
    </div>
    </div>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label style="width: 300px;" class="check-label" for="exampleCheck1"><@spring.message "global.allow.t&c"/></label>
  </div>
  <button type="submit" class="w-100 btn btn-lg btn-primary">Submit</button>
</form>
</div>


<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="form-validation.js"></script>
<script>

const range = document.getElementById('formControlRange1');
const client = document.getElementById('expert');

range.addEventListener('change', (e) => {
  const clientValue = e.target.value;
  client.textContent = clientValue;
});
</script>
</html>