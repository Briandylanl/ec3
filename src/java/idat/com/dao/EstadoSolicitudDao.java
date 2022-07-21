package idat.com.dao;

import idat.com.database.Conexion;
import idat.com.vo.EstadoSolicitudVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EstadoSolicitudDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public EstadoSolicitudDao() {
    }

    public Collection<EstadoSolicitudVo> findAll() {
        List<EstadoSolicitudVo> list = new ArrayList<>();

        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("select * from estadosolicitud");
            rs = ps.executeQuery();

            while (rs.next()) {
                EstadoSolicitudVo estadoSolicitud = new EstadoSolicitudVo();

                estadoSolicitud.setIdEstadoSolicitud(rs.getInt("idEstadoSolicitud"));
                estadoSolicitud.setNombre(rs.getString("nombre"));

                list.add(estadoSolicitud);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public EstadoSolicitudVo findById(int n_cuenta) {
        EstadoSolicitudVo estadoSolicitud = null;

        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("select * from estadosolicitud where idEstadoSolicitud=?");
            ps.setInt(1, n_cuenta);
            rs = ps.executeQuery();

            if (rs.next()) {
                estadoSolicitud = new EstadoSolicitudVo();
                estadoSolicitud.setIdEstadoSolicitud(rs.getInt("idEstadoSolicitud"));
                estadoSolicitud.setNombre(rs.getString("nombre"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return estadoSolicitud;
    }

    public void insert(EstadoSolicitudVo estadoSolicitud) {
        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("insert into estadosolicitud(nombre) values(?)");
            ps.setString(1, estadoSolicitud.getNombre());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(EstadoSolicitudVo estadoSolicitud) {
        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("update estadosolicitud set nombre=? where idEstadoSolicitud=?");
            ps.setString(1, estadoSolicitud.getNombre());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("delete from estadosolicitud where idEstadoSolicitud=?");
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
