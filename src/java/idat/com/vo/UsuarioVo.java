
package idat.com.vo;

/**
 *
 * @author JHAIRO MENDOZA
 */
public class UsuarioVo {
    
        private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
        private String contraseña;
        private int TipoUsuario;

	public UsuarioVo() {
		super();
	}

    public UsuarioVo(int idUsuario, String nombre, String apellido, String correo, String contraseña, int TipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.TipoUsuario = TipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(int TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

        
        
        
}

    
    
    
    
    

