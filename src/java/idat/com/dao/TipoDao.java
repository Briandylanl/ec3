
package idat.com.dao;
import idat.com.database.Conexion;
import idat.com.vo.TipoVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TipoDao {
    
    private Connection c;
	    private PreparedStatement ps;
	    private ResultSet r;  
	    
	    public TipoDao(){}
	    
	    public Collection<TipoVo>Listartipo(){
	    List<TipoVo> list= new ArrayList<>();
	    
	    try{
	    c = Conexion.MySQL();
	    
	    ps= c.prepareStatement("Select*from tipousuario");
	    r= ps.executeQuery();
	    
	    while(r.next()){
	        
	       TipoVo usuario = new TipoVo();
	        
	        usuario.setIdTipoUsuario(r.getInt("idTipoUsuario"));
                usuario.setNombre(r.getString("nombre"));
	       
	           
	           list.add(usuario);
	    }
	    }catch(Exception ex){
	    ex.printStackTrace();
	    }
	        return list;
	    
	    }
	    
            public void Registrarusuario(TipoVo usuario){
	  
	    try{
	    c = Conexion.MySQL();
	    ps = c.prepareStatement("insert into tipousuario(idTipoUsuario,nombre)values(?,?)");
	    
	    ps.setInt(1,usuario.getIdTipoUsuario());
	    ps.setString(2,usuario.getNombre());
	    
	    int rows = ps.executeUpdate();
	    if(rows!= 1){
	    throw new Exception("Error...");
	    }
	    }catch(Exception ex){
	            ex.printStackTrace();
	            
	            }
            
            
            
            
            
	    
	    }
	    public int Actualizarusuario(TipoVo usuario){
	    int r=0;
	    try {
	    c = Conexion.MySQL();
	    ps = c.prepareStatement("UPDATE tipousuario SET  nombre =? WHERE idTipoUsuario=" + usuario.getIdTipoUsuario());
	    ps.setString(1,usuario.getNombre());
            
	    
	    
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
	            ps = c.prepareStatement("DELETE FROM  tipousuario WHERE idTipoUsuario = " + nc);
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
    
    
}
