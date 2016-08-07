<html>
<head>
    <meta charset="utf-8">
    <style>
        body {
            background-color: #FFC0CB;
        }</style>
        </head>
        <body>
        <h1> Hi,  Twój produkt:  ${product} </h1>

        <#list products as product1>
        <p>${product1}
<#--        <#else>
        <p>No products-->
        </#list>
        </body>
        </html>