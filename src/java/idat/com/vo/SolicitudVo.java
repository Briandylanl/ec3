package idat.com.vo;

public class SolicitudVo {
    private int idSolicitud;
    private String fecha;
    private String estado;
    private int idUsuario;
    private int idServicios;

    public SolicitudVo() {
    }

    public SolicitudVo(int idSolicitud, String fecha, String estado, int idUsuario, int idServicios) {
        this.idSolicitud = idSolicitud;
        this.fecha = fecha;
        this.estado = estado;
        this.idUsuario = idUsuario;
        this.idServicios = idServicios;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }
    
    
}
