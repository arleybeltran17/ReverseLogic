import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.ProductoDao;
import model.ProductoVo;

public class ReverseLogic extends HttpServlet {
    ProductoVo r=new ProductoVo(); 
    ProductoDao rd=new ProductoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //NOTA: Aqui debe llegar 

        System.out.println("Entró al DoGet");
        String enviar=req.getParameter("enviar");

        switch(enviar){
            case "index":{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Index");
            break;
}
            case "register":
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Register");
            break;

            case "update":
            req.getRequestDispatcher("update.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Update");
            break;

            case "consultar":
            req.getRequestDispatcher("consultar.jsp").forward(req, resp);
            System.out.println("Se Ha Redireccionado Al Consult");
            break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String enviar=req.getParameter("enviar");
        switch(enviar){
            case "register":
                System.out.println("Acabas de entrar al caso 'add'");
                add(req,resp);
            break;

            case "update": 
                System.out.println("Acabas de entrar al caso 'update'");
                actualizar(req, resp);
            break;

            case "listar":
            System.out.println("Acabas de entrar al caso 'listar'");
            listar(req, resp);
            break;
        }
    }

    //? METODOS

    //? ADD - REGISTER+
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Prod_Nombre")!=null){
            r.setProd_nombre( req.getParameter("Prod_Nombre")); 
        }
        if(req.getParameter("Prod_Cant")!=null){
            r.setProd_cant(Integer.parseInt(req.getParameter("Prod_Cant"))); 
        }
        if(req.getParameter("Prod_PrecioUni")!=null){
         
            r.setProd_preciouni(Integer.parseInt(req.getParameter("Prod_PrecioUni"))); 
        }
        else{
            System.out.println("Error Al Registrar Datos");
        }
        try {
            rd.registrar(r);
            System.out.println("Registro insertado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("register.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }
    //? UPDATE - ACTUALIZAR
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("Prod_Nombre")!=null){
            r.setProd_nombre( req.getParameter("Prod_Nombre")); 
        }
        if(req.getParameter("Prod_Cant")!=null){
            r.setProd_cant(Integer.parseInt(req.getParameter("Prod_Cant"))); 
        }
        if(req.getParameter("Prod_PrecioUni")!=null){
         
            r.setProd_preciouni(Integer.parseInt(req.getParameter("Prod_PrecioUni"))); 
        }
        
        try {
            rd.actualizar(r);
            System.out.println("Registro actualizado correctamente");

            //? Redireccionamiento preventivo.       
            req.getRequestDispatcher("update.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error en la actualizacion del registro "+e.getMessage().toString());
        }
    }

    

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List<ProductoVo> usuario = rd.listar();
        req.setAttribute("usuarios", usuario);
        req.getRequestDispatcher("consulta.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
    }
}
