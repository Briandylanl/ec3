
package idat.com.dao;
import idat.com.database.Conexion;
import idat.com.vo.ServiciosVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServiciosDao {
    
    private Connection c;
	    private PreparedStatement ps;
	    private ResultSet r;  
	    
	    public ServiciosDao(){}
	    
	    public Collection<ServiciosVo>Listartipo(){
	    List<ServiciosVo> list= new ArrayList<>();
	    
	    try{
	    c = Conexion.MySQL();
	    
	    ps= c.prepareStatement("Select*from servicios");
	    r= ps.executeQuery();
	    
	    while(r.next()){
	        
	       ServiciosVo usuario = new ServiciosVo();
	        
	        usuario.setIdServicios(r.getInt("idServicios"));
                usuario.setNombre(r.getString("nombre"));
                usuario.setPrecio(r.getString("precio"));
                usuario.setEstado(r.getString("estado"));
	       
	           
	           list.add(usuario);
	    }
	    }catch(Exception ex){
	    ex.printStackTrace();
	    }
	        return list;
	    
	    }
	    
            public void Registrarusuario(ServiciosVo usuario){
	  
	    try{
	    c = Conexion.MySQL();
	    ps = c.prepareStatement("insert into servicios(idServicios,nombre,precio,estado)values(?,?,?,?)");
	    
	    ps.setInt(1,usuario.getIdServicios());
	    ps.setString(2,usuario.getNombre());
            ps.setString(3,usuario.getPrecio());
            ps.setString(4,usuario.getEstado());
        
                        
	    int rows = ps.executeUpdate();
	    if(rows!= 1){
	    throw new Exception("Error...");
	    }
	    }catch(Exception ex){
	            ex.printStackTrace();
	            
	            }
            
            
            
            
            
	    
	    }
	    public int Actualizarusuario(ServiciosVo usuario){
	    int r=0;
	    try {
	    c = Conexion.MySQL();
	    ps = c.prepareStatement("UPDATE servicios SET  nombre =?, precio =?, estado =? WHERE idServicios=" + usuario.getIdServicios());
	    ps.setString(1,usuario.getNombre());
            ps.setString(2,usuario.getPrecio());
            ps.setString(3,usuario.getEstado());
            
	    
	    
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
	            ps = c.prepareStatement("DELETE FROM  servicios WHERE idServicios = " + nc);
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
