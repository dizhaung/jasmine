<#import "./app.ftl" as app/>
<!DOCTYPE html>
<html>
<@app.head></@app.head>
<body>
    <#include "header.ftl">
    <@app.article type="${type}"></@app.article>
</body>
</html>