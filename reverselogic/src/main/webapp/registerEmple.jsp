<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
    <h1>Bienvenido Al Register De Empleados</h1>

    <form action="Empleado" method="post">

        <label for="Emple_Id"> ID Empleado</label>
        <input type="text" name="Emple_Id" id="Emple_Id"  placeholder="Ingrese El Id Del Empleado">

        <label for="Emple_Tipo_Doc"> Tipo De Documento</label>
        <input type="text" name="Emple_Tipo_Doc" id="Emple_Tipo_Doc" placeholder="Ingrese El Tipo De Documento">

        <label for="Emple_Num_Doc"> Numero De Documento</label>
        <input type="text" name="Emple_Num_Doc" id="Emple_Num_Doc"  placeholder="Ingrese El Numero De Documento">

        <label for="Emple_Nombre"> Nombre</label>
        <input type="text" name="Emple_Nombre" id="Emple_Nombre"  placeholder="Ingrese El Nombre Del Empleado">

        <label for="Emple_Apellido"> Apellido</label>
        <input type="text" name="Emple_Apellido" id="Emple_Apellido"  placeholder="Ingrese El Apellido Del Empleado">

        <label for="Emple_Cargo"> Cargo</label>
        <input type="text" name="Emple_Cargo" id="Emple_Cargo"  placeholder="Ingrese El Cargo Del Empleado">

        <label for="Emple_Direccion"> Direccion</label>
        <input type="text" name="Emple_Direccion" id="Emple_Direccion"  placeholder="Ingrese La Direccion Del Empleado">

        <label for="Emple_Email"> Email</label>
        <input type="text" name="Emple_Email" id="Emple_Email"  placeholder="Ingrese El Email Del Empleado">

        <button id="btncal" name="enviar" value="registerEmple">Enviar</button>

    </form>
</body>
</html>