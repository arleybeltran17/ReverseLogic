<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
    <h1>Bienvenido Al Register De Productos</h1>

    <form action="ReverseLogic" method="post">

        <label for="Prod_Id"> ID Producto</label>
        <input type="text" name="Prod_Id" id="Prod_Id"  placeholder="Ingrese El Id Del Producto">

        <label for="Prod_Nombre"> Nombre Producto</label>
        <input type="text" name="Prod_Nombre" id="Prod_Nombre" placeholder="Ingrese El Nombre Del Producto">

        <label for="Prod_Cant"> Cantidad</label>
        <input type="text" name="Prod_Cant" id="Prod_Cant"  placeholder="Ingrese La Cantidad Del Producto">

        <label for="Prod_PrecioUni"> Precio Unidad</label>
        <input type="text" name="Prod_PrecioUni" id="Prod_PrecioUni"  placeholder="Ingrese El Precio Por Unidad Del Producto">

        <label for="Mate_ID"> Id Material</label>
        <input type="text" name="Mate_Id" id="Mate_Id"  placeholder="Ingrese El Id Del Material">

        <button name="enviar" value="registerProd">Enviar</button>

    </form>
</body>
</html>