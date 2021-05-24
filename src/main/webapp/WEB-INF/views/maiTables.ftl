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
<form action="/doMAI" method="post">
<h1>Criteria<h1>
<table class="table table-striped table-hover">
  <thead>
    <tr>
      <th scope="col">#</th>
      <#list 1..mai.criteria?size as n>
      <th scope="col"><input class="form-control" type="text" name="criName${n}" value="Some Value"></th>
      </#list>
    </tr>
  </thead>
  <tbody>
   <#list 0..mai.criteria?size-1 as n>
    <tr>
      <th style="
              font-size: x-large;
          "scope="row">${n+1}</th>
      <#list 0..mai.criteria?size-1 as c>
      <td><input class="form-control" type="number" step="0.01" name="cri_id=${n}:${c}"></td>
      </#list>
    </tr>
    </#list>
  </tbody>
</table>
</div>
<div class="bd-example">
  <h1>Alternate Name<h1>
<table class="table table-striped table-hover">
<thead>
    <tr>
      <th scope="col">#</th>
      <#list 1..mai.alternate as n>
      <th scope="col"><input class="form-control" type="text" name="altName${n}" value="Some Value"></th>
      </#list>
    </tr>
  </thead>
  </table>
  </div>

<#list 1..mai.criteria?size as a>
<h1></h1>
<div class="bd-example">
<table class="table table-striped table-hover">

  <h1>Alternate ${a}<h1>
  <tbody>
   <#list 0..mai.alternate-1 as n>
    <tr>
      <th style="
              font-size: x-large;
          "scope="row">${n+1}</th>
      <#list 0..mai.alternate-1 as c>
      <td><input class="form-control" type="number" step="0.01" name="alt${a}_id=${n}:${c}"></td>
      </#list>
    </tr>
    </#list>
  </tbody>
</table>
</div>
</#list>
</div>
</div>
<button style="
            margin-left: 700px;
        " class="btn btn-dark" type="submit">Завершить</button>
       <h1></h1>
</form>

<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>