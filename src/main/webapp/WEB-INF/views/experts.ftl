<#import "spring.ftl" as spring />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
<#include "header.ftl">


<h1><@spring.message "homepage.greeting.text"/></h1>
<a href="?lang=ua_UA">Change lang</a>
<table>
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>password</th>
</tr>
</table>
    <#list users as user>
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.email}</th>
            <th>${user.password}</th>
        </tr>
    </#list>
<#include "footer.ftl">
</body>
</html>

