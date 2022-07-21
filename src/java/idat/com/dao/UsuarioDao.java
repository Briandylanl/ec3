
package idat.com.dao;

import idat.com.database.Conexion;
import idat.com.vo.UsuarioVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author JHAIRO MENDOZA
 */
public class UsuarioDao {
    
            private Connection c;
	    private PreparedStatement ps;
	    private ResultSet r;  
	    
	    public UsuarioDao(){}
	    
	    public Collection<UsuarioVo>ListarUsuario(){
	    List<UsuarioVo> list= new ArrayList<>();
	    
	    try{
	    c = Conexion.MySQL();
	    
	    ps= c.prepareStatement("Select*from usuario");
	    r= ps.executeQuery();
	    
	    while(r.next()){
	        
	       UsuarioVo usuario = new UsuarioVo();
	        
	        usuario.setIdUsuario(r.getInt("idUsuario"));
                usuario.setNombre(r.getString("nombre"));
	        usuario.setApellido(r.getString("apellido"));
	        usuario.setCorreo(r.getString("correo"));
	        usuario.setContraseña(r.getString("contraseña"));
                usuario.setTipoUsuario(r.getInt("TipoUsuario"));
	           
	           list.add(usuario);
	    }
	    }catch(Exception ex){
	    ex.printStackTrace();
	    }
	        return list;
	    
	    }
	    
            public void RegistrarUsuario(UsuarioVo usuario){
	  
	    try{
	    c = Conexion.MySQL();
	    ps = c.prepareStatement("insert into usuario(idUsuario,nombre,apellido,correo,contraseña,TipoUsuario)values(?,?,?,?,?,?)");
	    
	    ps.setInt(1,usuario.getIdUsuario());
	    ps.setString(2,usuario.getNombre());
	    ps.setString(3,usuario.getApellido());
	    ps.setString(4,usuario.getCorreo());
            ps.setString(5,usuario.getContraseña());
            ps.setInt(6,usuario.getTipoUsuario());
	    
	    int rows = ps.executeUpdate();
	    if(rows!= 1){
	    throw new Exception("Error...");
	    }
	    }catch(Exception ex){
	            ex.printStackTrace();
	            
	            }
            
            
            
            
            
	    
	    }
	    public int Actualizarusuario(UsuarioVo usuario){
	    int r=0;
	    try {
	    c = Conexion.MySQL();
	    ps = c.prepareStatement("UPDATE usuario SET  nombre =?,apellido =?, correo =? , contraseña =?, TipoUsuario =? WHERE idUsuario=" + usuario.getIdUsuario());
	    ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getApellido());
	    ps.setString(3,usuario.getCorreo());
	    ps.setString(4,usuario.getContraseña());
            ps.setInt(5,usuario.getTipoUsuario());
	    
	    int rows = ps.executeUpdate();
	    if(rows!=1){
	        throw new Exception("ERROR....");
	    } else {
	    r=1;
	    }
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return r;
	    }
            
            
            
            
            
            
	   public int Eliminarusuario(int nc) {

	        int r = 0;

	        try {
	            c = Conexion.MySQL();
	            ps = c.prepareStatement("DELETE FROM  usuario WHERE idUsuario = " + nc);
	            int rows = ps.executeUpdate();
	            if (rows != 1) {
	                throw new Exception("Error.....");
	            } else {
	                r = 1;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return r;
	    }

    public Collection<UsuarioVo> ListarServicios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
