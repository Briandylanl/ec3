
package idat.com.vo;

/**
 *
 * @author JHAIRO MENDOZA
 */
public class TipoVo {
    
    
        private int idTipoUsuario;
	private String nombre;


 public TipoVo() {
		super();
	}   

    public TipoVo(int idTipoUsuario, String nombre) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
 
}

