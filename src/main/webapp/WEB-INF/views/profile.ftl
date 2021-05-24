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
<div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
      <h1 class="display-4 fst-italic"><@spring.message "profile.hello"/>${expert.name} </h1>
      <p class="lead my-3"><@spring.message "profile.inOrgProfile"/> ${expert.organizationCode} </p>
      <p class="lead mb-0"><a href="/project/create" class="text-white fw-bold"><@spring.message "profile.createProject"/></a></p>
    </div>
  </div>
<div class="row mb-2">
    <div class="col-md-6">
     <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
             <div class="col p-4 d-flex flex-column position-static">
               <strong class="d-inline-block mb-2 text-success"></strong>
               <h3 class="mb-0"><@spring.message "profile.paticiparte"/>:</h3>
                <div class="mb-1 text-muted">&zwj;</div>
                <#list members as project>
                <#if project.end==false>
               <div class="mb-1 text-muted"><a href="/project/${project.id}" class="btn btn-primary">${project.name}</a></div>
               </#if>
                </#list>
                <p class="mb-auto"></p>
             </div>
               <div class="col-auto d-none d-lg-block">
               <svg width="200" height="200"
                 xmlns="http://www.w3.org/2000/svg">
                 <image href="https://www.into-the-trees.co.uk/wp-content/uploads/2018/02/EF-Take-Part-Final.png" height="200" width="200"/>
               </svg>
                 </div>
           </div>
    </div>
    <div class="col-md-6">
         <div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
                 <div class="col p-4 d-flex flex-column position-static">
                   <strong class="d-inline-block mb-2 text-success"></strong>
                   <h3 class="mb-0"><@spring.message "profile.admin"/>:</h3>
                    <div class="mb-1 text-muted">&zwj;</div>
                    <#list admins as project>
                    <h1></h1>
                     <div  class="mb-1 text-muted"><a href="/project/${project.id}" class="btn <#if project.end==true>btn-danger<#else>btn-primary</#if>">${project.name}</a></div>
                    </#list>
                 </div>
                   <div class="col-auto d-none d-lg-block">
                   <svg width="200" height="200"
                     xmlns="http://www.w3.org/2000/svg">
                     <image href="https://png.pngtree.com/png-vector/20190301/ourlarge/pngtree-vector-administration-icon-png-image_747092.jpg" height="200" width="200"/>
                   </svg>
                     </div>
               </div>
        </div>
  </div>


<#include "footer.ftl">
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</html>