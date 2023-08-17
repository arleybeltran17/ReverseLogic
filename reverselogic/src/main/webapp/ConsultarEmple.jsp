<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Listado De EmpLEados</title>
</head>
<body>
    <h1>Listado De Empleados</h1>
    <a href="ReverseLogic?enviar=index">Menu</a>
    
    <%@ page import="model.Empleado.EmpleadoVo" %>
    <%@ page import="model.Empleado.EmpleadoDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<EmpleadoVo> empleados = null;
        try {
            empleados = new EmpleadoDao().listarEmple();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (empleados != null && !empleados.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (EmpleadoVo empleado : empleados) { %>
                        <div class="card">
                            <div class="card--img">
                                <img src="img/icons8-usuario-100.png" alt="a" width="150px" height="150px">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">NOMBRE PRODUCTO</p>
                                <p id="Emple_Tipo_Doc_<%= empleado.getEmple_Id() %>" class="cardEmpleTipoDoc"><%= empleado.getEmple_Tipo_Doc() %></id=></p>
                                <p class="card--subtittle">CANTIDAD</p>
                                <p id="Emple_Num_Doc_<%= empleado.getEmple_Id() %>" class="cardEmpleNumDoc"><%= empleado.getEmple_Num_Doc() %></p>
                                <p class="card--subtittle">PRECIO UNIDAD</p>
                                <p id="Emple_Nombre_<%= empleado.getEmple_Id() %>" class="cardEmpleNombre"><%= empleado.getEmple_Nombre() %></p>
                                <p class="card--subtittle">ID MATERIAL</p>
                                <p id="Emple_Apellido_<%= empleado.getEmple_Id() %>" class="cardEmpleApellido"><%= empleado.getEmple_Apellido() %></p>
                                <p class="card--subtittle">NOMBRE PRODUCTO</p>
                                <p id="Emple_Cargo_<%= empleado.getEmple_Id() %>" class="cardEmpleCargo"><%= empleado.getEmple_Cargo() %> </p>
                                <p class="card--subtittle">NOMBRE PRODUCTO</p>
                                <p id="Emple_Direccion_<%= empleado.getEmple_Id() %>" class="cardEmpleDireccion"><%= empleado.getEmple_Direccion() %> </p>
                                <p class="card--subtittle">NOMBRE PRODUCTO</p>
                                <p id="Emple_Email_<%= empleado.getEmple_Id() %>" class="cardEmpleEmail"><%= empleado.getEmple_Email() %> </p>

                                <form action="Empleado" method="post">
                                    <input type="hidden" name="enviar" value="eliminarEmple">
                                    <input type="hidden" name="Emple_Id" value="<%= empleado.getEmple_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button>
                                </form>
                            <button class="btncal" data-emple-id="<%= empleado.getEmple_Id() %>">Actualizar</button>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No se encontraron usuarios.</p>
                    </div>
                <% } %>
            </div>
            </body>
            <div id="myModal1" class="modal1">
            <div class="modal-content1">
            <span class="close1">X</span>
        
            <h2>Actualizar Empleado</h2>
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
    
            <button class="btncal" name="enviar" value="updateEmple">Enviar</button>
        
            </form>
            </div>
            </div>
            <script type="text/javascript" src="js/modal1.js"></script>
            </body>
</html>