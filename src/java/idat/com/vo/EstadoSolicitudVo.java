package idat.com.vo;

public class EstadoSolicitudVo {
    private int idEstadoSolicitud;
    private String nombre;

    public EstadoSolicitudVo() {
    }

    public EstadoSolicitudVo(int idEstadoSolicitud, String nombre) {
        this.idEstadoSolicitud = idEstadoSolicitud;
        this.nombre = nombre;
    }

    public int getIdEstadoSolicitud() {
        return idEstadoSolicitud;
    }

    public void setIdEstadoSolicitud(int idEstadoSolicitud) {
        this.idEstadoSolicitud = idEstadoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
