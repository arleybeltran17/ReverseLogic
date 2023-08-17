package model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.*;
import model.Conexion;
import model.Producto.ProductoVo;
public class EmpleadoDao {

    
    //!ADVERTENCIA:  En las clases Dao podremos realizar diferentes ejecucuines como lo hacemos en phpMyAdmin o WorkBench.
    //?  Atrubutos para realizar acciones en la base de datos.   e
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia


    //? Registrar Empleado.
    public int registrarEmple(EmpleadoVo Empleado) throws SQLException{

        sql="INSERT INTO Empleado (Emple_Tipo_Doc, Emple_Num_Doc, Emple_Nombre, Emple_Apellido,Emple_Cargo,Emple_Direccion,Emple_Email) values (?,?,?,?,?,?,?)";
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Empleado.getEmple_Tipo_Doc());
            ps.setInt(2,    Empleado.getEmple_Num_Doc());
            ps.setString(3, Empleado.getEmple_Nombre());
            ps.setString(4, Empleado.getEmple_Apellido());
            ps.setString(5, Empleado.getEmple_Cargo());
            ps.setString(6, Empleado.getEmple_Direccion());
            ps.setString(7, Empleado.getEmple_Email());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            

        }catch(Exception e){

            System.out.println("EmpleadoDao Registrar_Empleado: Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//?cerrando conexión
            System.out.println("Se Registró El Empleado Correctamente, Revisa La Base De Datos.");
        }
        return r;
    }


    //? Consultar usuario.
    public List<EmpleadoVo> listarEmple() throws SQLException {
        List<EmpleadoVo> empleado = new ArrayList<>();
        sql = "select * from empleado";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                EmpleadoVo r = new EmpleadoVo();
                r.setEmple_Id(rs.getInt("Emple_Id"));
                r.setEmple_Tipo_Doc(rs.getString("Emple_Tipo_Doc"));
                r.setEmple_Num_Doc(rs.getInt("Emple_Num_Doc"));
                r.setEmple_Nombre(rs.getString("Emple_Nombre"));
                r.setEmple_Apellido(rs.getString("Emple_Apellido"));
                r.setEmple_Cargo(rs.getString("Emple_Cargo"));
                r.setEmple_Direccion(rs.getString("Emple_Direccion"));
                r.setEmple_Email(rs.getString("Emple_Email"));
                empleado.add(r);
            }
            ps.close();
            System.out.println("EmpleadoDao Dice:consulta exitosa");
        } catch (SQLException e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage().toString());
            throw e; // Lanzar la excepción para ser manejada en el método que invoca a listar()
        } finally {
            con.close();
        }
    
        return empleado;
    }

    //? Actualizar usuario.
    public int actualizarEmple(EmpleadoVo Empleado) throws SQLException{

        sql="update empleado set Emple_Tipo_Doc = ?, Emple_Num_Doc = ?, Emple_Nombre = ?, Emple_Apellido=?,Emple_Cargo = ?,Emple_Direccion = ?,Emple_Email = ? where Emple_Id = ? "; 
        System.out.println(sql);

        try{
            con=Conexion.conectar(); //abrir conexión.
            ps=con.prepareStatement(sql); //preparar sentencia.
            ps.setString(1, Empleado.getEmple_Tipo_Doc());
            ps.setInt(2,    Empleado.getEmple_Num_Doc());
            ps.setString(3, Empleado.getEmple_Nombre());
            ps.setString(4, Empleado.getEmple_Apellido());
            ps.setString(5, Empleado.getEmple_Cargo());
            ps.setString(6, Empleado.getEmple_Direccion());
            ps.setString(7, Empleado.getEmple_Email());
            ps.setInt(8,    Empleado.getEmple_Id());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del Empleado correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("EmpleadoDao Actualizar dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }

    public void eliminarEmple(int EmpleId) throws SQLException {
        sql = "DELETE FROM empleado WHERE Emple_id = ?";
        try (Connection con = Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, EmpleId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar El Empleado: " + e.getMessage());
            throw e;
        }
}
    
}
