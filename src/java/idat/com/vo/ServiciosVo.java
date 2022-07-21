/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.com.vo;

/**
 *
 * @author A20204357
 */
public class ServiciosVo {
    
    
        
        private int idServicios;
	private String nombre;
	private String precio;
	private String estado;

    public ServiciosVo() {
    }

    public ServiciosVo(int idServicios, String nombre, String precio, String estado) {
        this.idServicios = idServicios;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdServicios() {
        return idServicios;
    }

    public void setIdServicios(int idServicios) {
        this.idServicios = idServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ServiciosVo{" + "idServicios=" + idServicios + ", nombre=" + nombre + ", precio=" + precio + ", estado=" + estado + '}';
    }

    
}
