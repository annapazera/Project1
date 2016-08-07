<html>
<head>
    <meta charset="utf-8">
    <style>
        body {
            background-color: #FFC0CB;
        }</style>
</head>
<body>
<h1> W sklepie Ani na pewno znajdziesz coś dla siebie ! </h1>
<table>
    <thread>
        <tr>
            <th>Nazwa produktu</th><th>Kategoria</th><th>Cena</th><th>Opis</th>
        </tr>
    </thread>

<#list products as product1>
<tr>
    <td>
<p>${product1.name}</td><td>${product1.category}</td><td>${product1.price} zł</td><td>${product1.description}</td>
<#--        <#else>
        <p>No products-->
</tr></#list>

</table>
    <br><br>
    <a href="form01.html">Dodaj kolejny produkt! </a>
</body>
</html>