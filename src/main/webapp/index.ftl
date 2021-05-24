<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@spring.message "head.meta.title.index"/></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body onload="checkAlert()">
<#include "header.ftl">
</div>
<div class="container col-xl-10 col-xxl-8 px-4 py-5">
  <div class="row align-items-center g-5 py-5">
    <div class="col-lg-7 text-center text-lg-start">
      <h1 class="display-4 fw-bold lh-1 mb-3"><@spring.message "homepage.first.big.title"/></h1>
      <p class="col-lg-10 fs-4"><@spring.message "homepage.first.small.text"/></p>
    </div>
    <#if !expert??>
    <div class="col-10 mx-auto col-lg-5">
      <form class="p-5 border rounded-3 bg-light" action="/sign-in" method="post">
        <div class="form-floating mb-3">
          <input type="email" name="email" class="form-control" id="floatingInput" placeholder="name@example.com">
          <label for="floatingInput"><@spring.message "global.emailAddress"/></label>
        </div>
        <div class="form-floating mb-3">
          <input type="password"  name="password" class="form-control" id="floatingPassword" placeholder="Password">
          <label for="floatingPassword"><@spring.message "global.password"/></label>
        </div>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"><@spring.message "global.rememberme"/>
          </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit"><@spring.message "global.signin"/></button>
        <h1></h1>
        <a href="/sign-up" class="w-100 btn btn-lg btn-success" type="submit"><@spring.message "global.signup"/></a>
        <hr class="my-4">
        <small class="text-muted"><@spring.message "global.allow.t&c"/></small>
      </form>
    </div>
    <#else>
    <div class="col-10 mx-auto col-lg-5">
      <a href="/logout" class="w-100 btn btn-lg btn-success" >Выйти</a>
    </div>

    </#if>
  </div>
</div>

<#include "footer.ftl">
</body>
<script>
function checkAlert(){
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const alert = urlParams.get('alert');
if ( alert =="true") {
   confirm("This user not valid try again or go to sign-up");
}
}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>