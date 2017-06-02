<#import "./app.ftl" as app/>
<!DOCTYPE html>
<html>
<@app.head></@app.head>
<body>
    <#--<#include "header.ftl">-->
    <#--<@app.article type="${type}"></@app.article>-->
    <div class="app app-header-fixed" id="menu_app">
        <@app.navbar></@app.navbar>
        <@app.menu></@app.menu>
        <@app.content></@app.content>
    </div>
</body>
</html>