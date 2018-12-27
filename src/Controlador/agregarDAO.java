package Controlador;
import Modelo.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import vista.*;

public class agregarDAO {
    
    public boolean ingresarInventario(Inventario inv)
    {
        boolean resultado=false;
         try {
            Connection con=Conectar.getConexion();
            String query="insert into inventario (id,nombre,cantidad,fecha_vencimiento) values (?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, inv.getId());
            ps.setString(2,inv.getNombre());
            ps.setInt(3, inv.getCantidad());
            ps.setString(4,inv.getFecha_vencimiento());
            resultado=ps.executeUpdate()==1;
            ps.close();
          } catch (SQLException ex) {
            Logger.getLogger(agregarDAO.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return resultado;
    }
    
     public ArrayList<Inventario> obtenerTodo()
    {
        ArrayList <Inventario> inv=new ArrayList<Inventario>();
        try {
            Connection con=Conectar.getConexion();
            String query="select * from inventario";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
               Inventario in = new Inventario();
               in.setId(rs.getInt("id"));
               in.setNombre(rs.getString("nombre"));
               in.setCantidad(rs.getInt("cantidad"));
               in.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
               inv.add(in);
             
                
            }
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(agregarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inv;
    }
 public boolean borrarInventario(int id)
    {
        boolean resultado=false;
        
        try {
            Connection con=Conectar.getConexion();
            String query="delete from inventario where id=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,id);
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(agregarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(agregarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
 
}   
 
    

