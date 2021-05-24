<#import "spring.ftl" as spring />
<div class="container">
  <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
      <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
      <img  width="40" height="40" src="https://www.eiturbanmobility.eu/wp-content/uploads/2020/03/EIT_Idea_small.jpg" class="rounded bi me-2" alt="...">
      <span ><@spring.message "header.title"/></span>
    </a>
<!--style="
                margin-right: 400px;
            " class="fs-4" !-->

    <ul class="nav nav-pills">
      <li class="nav-item"><a href="/" class="nav-link active"><@spring.message "header.home"/></a></li>
      <#if expert??>
      <li class="nav-item"><a href="/profile/${expert.id}" class="nav-link"><@spring.message "header.profile"/></a></li>
      </#if>
      <li class="nav-item"><a href="/faqs" class="nav-link"><@spring.message "header.FAQs"/></a></li>
      <li class="nav-item"><a href="/about" class="nav-link"><@spring.message "header.about"/></a></li>
    <h3>|</h3>
    <li class="nav-item"><a href="?lang=ua_UA" class="nav-link"><@spring.message "header.UA"/></a></li>
    <li class="nav-item"><a href="?lang=en" class="nav-link"><@spring.message "header.EN"/></a></li>
    </ul>

  </header>
</div>
