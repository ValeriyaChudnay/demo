<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<#include "header.ftl">
<div class="container py-5  g-lg-5 ">
<div class="bd-example">
<h1>MAI Result<h1>
<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th scope="col">Альтернатива</th>
      <th scope="col">Значение</th>
    </tr>
  </thead>
  <tbody>
    <#list mai.alternameName as alternate>
      <tr>
        <th style="
                font-size: x-large;
            "scope="row">${alternate}</th>
        <td>${result[alternate?index]}</td>
      </tr>
      </#list>
    </tbody>
  </table>
</div>
</div>


<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>