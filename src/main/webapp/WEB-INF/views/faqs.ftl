<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>
    </head>
<body>
<#include "header.ftl">
<div class="container">
    <br />
    <br />
    <br />

    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        This section contains a wealth of information, related to <strong>PrepBootstrap</strong> and its store. If you cannot find an answer to your question,
        make sure to contact us.
    </div>

    <br />

    <div class="" id="accordion">
        <div class="faqHeader">General questions</div>
        <div class="card ">
           <p>
             <button style="width: -webkit-fill-available;" class="btn btn-light" type="button" p-5 m-5 data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
               Button with data-bs-target
             </button>
           </p>
           <div class="collapse" id="collapseExample">
             <div class="card card-body">
               Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
             </div>
           </div>
        </div>
          <div class="card ">
                   <p>
                     <button style="width: -webkit-fill-available;" class="btn btn-light" type="button" p-5 m-5 data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                       Button with data-bs-target
                     </button>
                   </p>
                   <div class="collapse" id="collapseExample">
                     <div class="card card-body">
                       Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
                     </div>
                   </div>
                </div>
                  <div class="card ">
                           <p>
                             <button style="width: -webkit-fill-available;" class="btn btn-light" type="button" p-5 m-5 data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                               Button with data-bs-target
                             </button>
                           </p>
                           <div class="collapse" id="collapseExample">
                             <div class="card card-body">
                               Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
                             </div>
                           </div>
                        </div>
    </div>
      <div class="faqHeader">General questions</div>
            <div class="card ">
               <p>
                 <button style="width: -webkit-fill-available;" class="btn btn-light" type="button" p-5 m-5 data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                   Button with data-bs-target
                 </button>
               </p>
               <div class="collapse" id="collapseExample">
                 <div class="card card-body">
                   Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
                 </div>
               </div>
            </div>
        </div>
</div>

<style>
    .faqHeader {
        font-size: 27px;
        margin: 20px;
    }

    .panel-heading [data-toggle="collapse"]:after {
        font-family: 'Glyphicons Halflings';
        content: "e072"; /* "play" icon */
        float: right;
        color: #F58723;
        font-size: 18px;
        line-height: 22px;
        /* rotate "play" icon from > (right arrow) to down arrow */
        -webkit-transform: rotate(-90deg);
        -moz-transform: rotate(-90deg);
        -ms-transform: rotate(-90deg);
        -o-transform: rotate(-90deg);
        transform: rotate(-90deg);
    }

    .panel-heading [data-toggle="collapse"].collapsed:after {
        /* rotate "play" icon from > (right arrow) to ^ (up arrow) */
        -webkit-transform: rotate(90deg);
        -moz-transform: rotate(90deg);
        -ms-transform: rotate(90deg);
        -o-transform: rotate(90deg);
        transform: rotate(90deg);
        color: #454444;
    }
</style>
<script>
var collapseElementList = [].slice.call(document.querySelectorAll('.collapse'))
var collapseList = collapseElementList.map(function (collapseEl) {
  return new bootstrap.Collapse(collapseEl)
})
</script>




<#include "footer.ftl">
</body>
</html>