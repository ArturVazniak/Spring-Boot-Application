<#import "parts/common.ftl" as cr>
<#import "parts/login.ftl" as lr>

<@cr.page>
  Login page
  <@lr.login "/login" />
  <a href="/registration">Add new user</a>
</@cr.page>