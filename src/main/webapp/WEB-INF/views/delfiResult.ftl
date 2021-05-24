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
<div class="row align-items-center g-lg-5 py-5">
      <div class="col-lg-7 text-center text-lg-start">
        <h3>Середньогрупова самооцінка</h3>
        <p class="col-lg-10 fs-4">Середньогрупова самооцінка = ${groupRef} %.</p>
      </div>
      <div class="col-md-10 mx-auto col-lg-5">
      <#if currentProject.end==true>
         <h1></h1>
       <a href="#" onclick="" class="w-100 btn btn-lg btn-success" type="submit">Проект завершен</a>
         <#else>
         <h1></h1>
                         <a href="/endDelfiProject" class="w-100 btn btn-lg btn-success" type="submit">Завершить</a>
                         <h1></h1>

                   <a href="/newRoundProject" class="w-100 btn btn-lg btn-success" type="submit">Повториить</a>
         </#if>
      </div>
    </div>
<div class="container px-1 py-1" id="hanging-icons">
    <h2>Довіра - виражається у процентах</h2>
    <div class="row g-1 py-2 row-cols-1 row-cols-lg-3">
      <div class="col d-flex align-items-start">
        <div>
          <h4>Середнє значення оцінки = X%</h4>
          <p>Відношення
             суми оцінок послуг експертами до кількості експертів</p>
        </div>
      </div>
      <div class="col d-flex align-items-start">
        <div>
          <h4>Середньозважена оцінка = X%</h4>
          <p>Відношення суми добутків коефіцієнтів
          самооцінки на рівень обслуговування до суми коефіцієнтів самооцінки</p>
        </div>
      </div>

      <div class="col d-flex align-items-start">
        <div>
          <h4>Оцінка довіри</h4>
          <h6>Квартиль =X%</h6>
          <h6>Нижня межа області довіри = X%</h6>
          <h6>Верхня межа області довіри = X%</h6>
          <p>Область довіри дорівнюватиме
             проміжку від мінімальної оцінки плюс квартиль до максимальної оцінки мінус квартиль</p>
        </div>
      </div>
    </div>
<#list questions as question>
    <h2 class="pb-2
    <#if currentProject.trust<(question.hightTrust-question.lowTrust)>
    bg-danger text-white
    </#if>
    border-bottom">${question.text}</h2>
    <h2>Довіра - ${question.hightTrust-question.lowTrust}</h2>
    <div class="row g-1 py-2 row-cols-1 row-cols-lg-3">
      <div class="col d-flex align-items-start">
        <div>
          <h4>Середнє значення оцінки = ${question.scoreAverage}%</h4>
        </div>
      </div>
      <div class="col d-flex align-items-start">
        <div>
          <h4>Середньозважена оцінка = ${question.scoreSelfMult}%</h4>

        </div>
      </div>

      <div class="col d-flex align-items-start">
        <div>
          <h4>Оцінка довіри</h4>
          <h6>Квартиль = ${question.kvartil}%</h6>
          <h6>Нижня межа області довіри = ${question.lowTrust}%</h6>
          <h6>Верхня межа області довіри = ${question.hightTrust}%</h6>

        </div>
      </div>
    </div>

  </#list>
</div>

<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>