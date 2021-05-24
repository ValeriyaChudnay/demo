<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<#include "header.ftl">
<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
    <div class="col-md-20 p-lg-20 mx-auto my-20">
      <h1 class="display-4 fw-normal">${currentProject.name}</h1>
      <p class="lead fw-normal">${currentProject.description}</p>
      <a class="btn btn-outline-secondary" href="/project/create"><@spring.message "profile.createProject"/></a>
    </div>
  </div>
<div class="row mb-2">
    <div class="col-md-6">
     <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
             <div class="col p-4 d-flex flex-column position-static">
               <strong class="d-inline-block mb-2 text-success"></strong>
               <h3 class="mb-0"><@spring.message "project.methodDelfi"/></h3>
                <div class="mb-1 text-muted">&zwj;</div>
               <div class="mb-1 text-muted">
               <#switch currentProject.delfietap>
                 <#case 0>
                   <a href="/delfiChat" class="btn btn-primary"><@spring.message "project.methodDelfi-chat"/></a>
                   <#break>
                 <#case 1>
                  <#if isAdmin>
                     <form action="/endDelfiChat" method="get">
                                <div >
                                    <label><@spring.message "project.qNumber"/>:</label>
                                    <input type="number" value="10" name="questionNumber">
                                </div>
                                </br>
                                <button class="btn btn-dark" type="submit"><@spring.message "project.methodDelfiPrepareAnketa"/></button>
                            </form>
                    <#else>
                    <a href="#" disabled class="btn btn-light"><@spring.message "project.methodDelfiAdminAnketa"/></a>
                    </#if>
                   <#break>
                 <#case 2>
                 <#if isAdmin >
                    <a href="#"   onclick="confirm('<@spring.message "project.youAdmin"/>');"  disabled
                    class="btn btn-light"><@spring.message "project.wait"/></a>
                    <#elseif expertsIdPassed?seq_contains(expert.id)>
                      <a href="#"class="btn btn-light"><@spring.message "project.delfiDone"/></a>
                    <#else>
                     <a href="/getDelfiAnketa"
                                        class="btn btn-primary"><@spring.message "project.doAnket"/></a>
                    </#if>
                   <#break>
                 <#default>
                 <#if isAdmin >
                 <#list 1..currentProject.currentRound as r>
                   <a href="/delfiResult?round=${r}" class="btn btn-primary"><@spring.message "project.seeAnket"/> - ${r}</a>
                   <h1></h1>
                   </#list>
                   <#else>
                    <a href="/delfiChat" class="btn btn-primary"><@spring.message "project.methodDelfi-chat"/></a>
                    </#if>
               </#switch>
               </div>
               <div class="mb-1 text-muted">&zwj;</div>
                <p class="mb-auto"><@spring.message "project.descriptionDelfi"/></p>
             </div>
               <div class="col-auto d-none d-lg-block">
               <svg width="200" height="200"
                 xmlns="http://www.w3.org/2000/svg">
                 <image href="https://cdn.dribbble.com/users/63485/screenshots/10492219/delfi_logo_4x3_still_2x.gif" height="200" width="200"/>
               </svg>
                 </div>
           </div>
    </div>
    <div class="col-md-6">
         <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                 <div class="col p-4 d-flex flex-column position-static">
                   <strong class="d-inline-block mb-2 text-success"></strong>
                   <h3 class="mb-0"><@spring.message "project.methodMAI"/></h3>
                    <div class="mb-1 text-muted">&zwj;</div>
                   <div class="mb-1 text-muted">
                   <form action="/createMAI" method="get">
                       <div >
                           <label><@spring.message "project.criteriaCount"/>:</label>
                           <input type="number" value="2" name="criteria">
                       </div>
                       </br>
                       <div >
                          <label><@spring.message "project.alternateCount"/>:</label>
                          <input type="number" value="3" name="alternate">
                      </div>
                      </br>
                       <button class="btn btn-primary" type="submit"><@spring.message "project.methodMAI"/></button>
                   </form>
                   </div>
                   <div class="mb-1 text-muted">&zwj;</div>
                    <p class="mb-auto"><@spring.message "project.descriptionMAI"/></p>
                 </div>
                   <div class="col-auto d-none d-lg-block">
                   <svg width="200" height="200"
                     xmlns="http://www.w3.org/2000/svg">
                     <image href="https://cdn.iconscout.com/icon/free/png-512/m-characters-character-alphabet-letter-36047.png" height="200" width="200"/>
                   </svg>
                     </div>
               </div>
        </div>
  </div>
  <#if isAdmin>
  <main class="container">
  <div class="my-3 p-3 bg-body rounded shadow-sm">
      <h6 class="border-bottom pb-2 mb-0"><@spring.message "project.experts"/></h6>
      <#list experts as expert>
      <div class="d-flex text-muted pt-3">
        <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"></rect><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
        <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
          <div class="d-flex justify-content-between">
            <strong class="text-gray-dark">${expert.name}</strong>
            <a href="#">Follow</a>
          </div>
          <span class="d-block">${expert.email}</span>
        </div>
      </div>
      </#list>

      <small class="d-block text-end mt-3">
        <a href="#">All suggestions</a>
      </small>
    </div>
  </main>
  </#if>

<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>