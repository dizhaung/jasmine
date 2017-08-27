<#import "./app.ftl" as app/>
<#import "./introduction.ftl" as introduction>
<#import "./navbar.ftl" as navbar/>
<!DOCTYPE html>
<html>
<head lang="en">
    <@app.head/>
</head>
<body>
    <div class="app app-header-fixed" id="menu_app">
        <@navbar.navbar></@navbar.navbar>
        <@introduction.introduction></@introduction.introduction>
        <div class="app-content">
            <@app.article type="${type!}"></@app.article>
        </div>
        <@app.footer></@app.footer>
    </div>
</body>
</html>