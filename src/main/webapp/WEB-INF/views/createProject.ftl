<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

</head>
<body class="text-center">
<#include "header.ftl">
<div class="p-1 p-md-1 mb-1 text-white rounded bg-dark">
    <div class="col">
      <p class="lead my-3"><@spring.message "createProject.info"/></p>
    </div>
  </div>
<main class="container p-3"  style="width: 40%">
<div class="container p-3 my-3">
<form method="post" action="/project/create">
<img class="mb-4" src="https://www.eiturbanmobility.eu/wp-content/uploads/2020/03/EIT_Idea_small.jpg" alt="" width="70" height="70">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label"><@spring.message "createProject.name"/></label>
    <input type="projectName" name="name" class="form-control"  aria-describedby="emailHelp">
    <div id="emailHelp" class="form-text"><@spring.message "createProject.notshare"/></div>
  </div>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label"><@spring.message "createProject.description"/></label>
    <input type="projectName" name="description" class="form-control"  aria-describedby="emailHelp">
  </div>

<div class="mb-3">
     <label for="exampleInputEmail1" class="form-label"><@spring.message "createProject.trust"/></label>
      <p><span id="expert">50</span>% </p>
      <div class="form-group">
        <input type="range" class="form-range" name="trust" min="0" max="100" step="1" id="formControlRange1">
    </div>
   <div class="mb-3">
      <label for="exampleInputEmail1" class="form-label"><@spring.message "createProject.choiseExpert"/></label>
    </div>
    <div class="mb-3">
     <select class="selectpicker" name="experts" multiple data-live-search="true">
       <#list experts as expert>
       <option name="${expert.id}" value="${expert.id}">${expert.name}</option>
        </#list>
     </select>
    </div>
  <button type="submit" class="btn btn-primary"><@spring.message "global.submit"/></button>
</form>
</div>
</main>

<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script>

const range = document.getElementById('formControlRange1');
const client = document.getElementById('expert');

range.addEventListener('change', (e) => {
  const clientValue = e.target.value;
  client.textContent = clientValue;
});
</script>
</html>