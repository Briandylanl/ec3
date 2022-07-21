package idat.com.dao;

import idat.com.database.Conexion;
import idat.com.vo.EstadoSolicitudVo;
import idat.com.vo.SolicitudVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SolicitudDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public SolicitudDao() {
    }

    public Collection<SolicitudVo> findAll() {
        List<SolicitudVo> list = new ArrayList<>();

        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("select * from solicitud");
            rs = ps.executeQuery();

            while (rs.next()) {
                SolicitudVo solicitud = new SolicitudVo();

                solicitud.setIdSolicitud(rs.getInt("idSolicitud"));
                solicitud.setFecha(rs.getString("fecha"));
                solicitud.setEstado(rs.getString("estado"));
                solicitud.setIdUsuario(rs.getInt("idUsuario"));
                solicitud.setIdServicios(rs.getInt("idServicios"));

                list.add(solicitud);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public SolicitudVo findById(int id) {
        SolicitudVo solicitud = null;

        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("select * from solicitud where idSolicitud=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                solicitud = new SolicitudVo();
                solicitud.setIdSolicitud(rs.getInt("idSolicitud"));
                solicitud.setFecha(rs.getString("fecha"));
                solicitud.setEstado(rs.getString("estado"));
                solicitud.setIdUsuario(rs.getInt("idUsuario"));
                solicitud.setIdServicios(rs.getInt("idServicios"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return solicitud;
    }

    public void insert(SolicitudVo solicitud) {
        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("insert into solicitud(fecha, estado, idUsuario, idServicios) values(?,?,?,?)");
            ps.setString(1, solicitud.getFecha());
            ps.setString(2, solicitud.getEstado());
            ps.setInt(3, solicitud.getIdUsuario());
            ps.setInt(4, solicitud.getIdServicios());

            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(SolicitudVo solicitud) {
        try {
            conn = Conexion.MySQL();
            ps = conn.prepareStatement("update solicitud set fecha=?, estado=?, idUsuario=?, idServicios=? where idSolicitud=?");
            ps.setString(1, solicitud.getFecha());
            ps.setString(2, solicitud.getEstado());
            ps.setInt(3, solicitud.getIdUsuario());
            ps.setInt(4, solicitud.getIdServicios());
            ps.setInt(5, solicitud.getIdSolicitud());

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
            ps = conn.prepareStatement("delete from solicitud where idSolicitud=?");
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
