<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Listado De Productos</title>
</head>
<body>
    <h1>Listado De Productos</h1>
    <a href="ReverseLogic?enviar=index">Menu</a>
    

    <%-- Importar la clase UsuarioVo y UsuarioDao --%>
    <%@ page import="model.Producto.ProductoVo" %>
    <%@ page import="model.Producto.ProductoDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<ProductoVo> productos = null;
        try {
            productos = new ProductoDao().listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (productos != null && !productos.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (ProductoVo producto : productos) { %>
                        <div class="card">
                            <div class="card--img">
                                <img src="img/icons8-usuario-100.png" alt="a" width="150px" height="150px">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">NOMBRE PRODUCTO</p>
                                <p id="Prod_Nombre_<%= producto.getProd_id() %>" class="cardProdname"><%= producto.getProd_nombre() %></id=></p>
                                <p class="card--subtittle">CANTIDAD</p>
                                <p id="Prod_Cant_<%= producto.getProd_id() %>" class="cardProdCant"><%= producto.getProd_cant() %></p>
                                <p class="card--subtittle">PRECIO UNIDAD</p>
                                <p id="Prod_PrecioUni_<%= producto.getProd_id() %>" class="cardProdPrecioUni"><%= producto.getProd_preciouni() %></p>
                                <p class="card--subtittle">ID MATERIAL</p>
                                <p id="Mate_Id_<%= producto.getProd_id() %>" class="cardMateId"><%= producto.getMate_id() %></p>

                                <form action="ReverseLogic" method="post">
                                    <input type="hidden" name="enviar" value="eliminarProd">
                                    <input type="hidden" name="Prod_id" value="<%= producto.getProd_id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button>
                                </form>
                            <button class="btncal" data-prod-id="<%= producto.getProd_id() %>">Actualizar</button>
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

    <h2>Actualizar Usuario</h2>
    <form action="ReverseLogic" method="post">

        <label for="Prod_id"> ID PRODUCTO</label>
        <input type="text" name="Prod_id" id="Prod_id"  placeholder="Ingrese Su Id">

        <label for="Prod_Nombre"> NOMBRE PRODUCTO </label>
        <input type="text" name="Prod_Nombre" id="Prod_Nombre" placeholder="Ingrese Su Edad">

        <label for="Prod_Cant"> CANTIDAD</label>
        <input type="text" name="Prod_Cant" id="Prod_Cant"  placeholder="Ingrese Su Apellido">

        <label for="Prod_PrecioUni"> PRECIO UNIDAD</label>
        <input type="text" name="Prod_PrecioUni" id="Prod_PrecioUni"  placeholder="Ingrese Su Correo">

        <label for="Mate_Id"> ID MATERIAL</label>
        <input type="text" name="Mate_Id" id="Mate_Id"  placeholder="Ingrese Su Contraseña">

        <button id="btncal" class="ov-btn-grow-skew" name="enviar" value="updateProd">Enviar</button>

    </form>
    </div>
    </div>
    <script type="text/javascript" src="js/modal.js"></script>
    </body>
</html>