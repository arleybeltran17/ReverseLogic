package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.*;

public class ProductoDao {


    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia


    //? Registrar usuario.
    public int registrar(ProductoVo Producto) throws SQLException{

        sql="INSERT INTO producto (Prod_Nombre, Prod_Cant, Prod_PrecioUni, Mate_Id) values (?,?,?,?)";
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Producto.getProd_nombre());
            ps.setInt(2, Producto.getProd_cant());
            ps.setInt(3, Producto.getProd_preciouni());
            ps.setInt(4, Producto.getMate_id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            

        }catch(Exception e){

            System.out.println("ProductoDao Registrar_Producto: Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//?cerrando conexión
            System.out.println("Se registró el Producto correctamente, revisa la base de datos.");
        }
        return r;
    }


    //? Consultar usuario.
    public List<ProductoVo> listar() throws SQLException {
        List<ProductoVo> producto = new ArrayList<>();
        sql = "select * from producto";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                ProductoVo r = new ProductoVo();
                r.setProd_id(rs.getInt("Prod_Id"));
                r.setProd_nombre(rs.getString("Prod_Nombre"));
                r.setProd_cant(rs.getInt("Prod_Cant"));
                r.setProd_preciouni(rs.getInt("Prod_PrecioUni"));
                r.setMate_id(rs.getInt("Mate_Id"));
                producto.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return producto;
    }

    //? Actualizar usuario.
    public int actualizar(ProductoVo Producto) throws SQLException{

        sql="update producto set Prod_Nombre = ?, Prod_Cant = ?, Prod_PrecioUni = ?, Mate_Id=? where Prod_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Producto.getProd_nombre());
            ps.setInt(2, Producto.getProd_cant());
            ps.setInt(3, Producto.getProd_preciouni());
            ps.setInt(4,    Producto.getProd_id());
            ps.setInt(5, Producto.getMate_id());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del producto correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("ProductoDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }



    public ProductoVo obtenerUsuarioPorId(int Prod_Id) throws SQLException {
        sql = "SELECT * FROM producto WHERE Prod_id = ?";
        ProductoVo producto = null;
        try(Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {
    
            ps.setInt(1, Prod_Id);
    
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = new ProductoVo();
                    producto.setProd_id(rs.getInt("Prod_Id"));
                    producto.setProd_nombre(rs.getString("Prod_Nombre"));
                    producto.setProd_cant(rs.getInt("Prod_Cant"));
                    producto.setProd_preciouni(rs.getInt("Prod_PrecioUni"));
                    producto.setMate_id(rs.getInt("Mate_Id"));
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener el Producto:" + e.getMessage());
            }
            return producto;
        }
    }

}

