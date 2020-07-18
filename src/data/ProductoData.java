
package data;

import entities.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.sqlite.SQLiteConfig;
import util.ErrorLogger;

/**
 *
 * @author Asullom
 */
public class ProductoData {

    static Connection cn = Conn.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(ProductoData.class.getName());

    static Date dt = new Date();
    static SimpleDateFormat sdf = new SimpleDateFormat(SQLiteConfig.DEFAULT_DATE_STRING_FORMAT);

    public static int create(Producto d) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO producto(nombres, cod, precio, fecha_ven) "
                + "VALUES(?,?,?,?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getNombres());
            ps.setString(++i, d.getCod());
            ps.setDouble(++i, d.getPrecio());
            ps.setString(++i, sdf.format(d.getFecha_ven()));
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1); // select tk, max(id)  from producto
                    //System.out.println("rs.getInt(rsId): " + rsId);
                }
                rs.close();
            }
        } catch (SQLException ex) {
            //System.err.println("create:" + ex.toString());
            log.log(Level.SEVERE, "create", ex);
        }
        return rsId;
    }

    public static int update(Producto d) {
        System.out.println("actualizar d.getId(): " + d.getId());
        int comit = 0;
        String sql = "UPDATE producto SET "
                + "nombres=?, "
                + "cod=?, "
                + "precio=?, "
                + "fecha_ven=? "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getNombres());
            ps.setString(++i, d.getCod());
            ps.setDouble(++i, d.getPrecio());
            ps.setString(++i, sdf.format(d.getFecha_ven()));

            ps.setInt(++i, d.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM producto WHERE id = ?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "delete", ex);
            // System.err.println("NO del " + ex.toString());
            throw new Exception("Detalle:" + ex.getMessage());
        }
        return comit;
    }

    public static List<Producto> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Producto> ls = new ArrayList();
        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM producto ORDER BY id";
        } else {
            sql = "SELECT * FROM producto WHERE (id LIKE'" + filter + "%' OR "
                    + "nombres LIKE'" + filter + "%' OR cod LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY id";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto d = new Producto();
                d.setId(rs.getInt("id"));
                d.setNombres(rs.getString("nombres"));
                d.setCod(rs.getString("cod"));
                d.setPrecio(rs.getDouble("precio"));

                String fecha = rs.getString("fecha_ven");
                try {
                    Date date = sdf.parse(fecha);
                 //   System.out.println("Xlist.date:" + date);
                    d.setFecha_ven(date);
                    
                    d.setDate_created(sdf.parse(rs.getString("date_created")));
                   // System.out.println("list.date_created:" + rs.getString("date_created"));
                } catch (Exception e) {
                }

                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static Producto getByPId(int id) {
        Producto d = new Producto();

        String sql = "SELECT * FROM producto WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setNombres(rs.getString("nombres"));
                d.setCod(rs.getString("cod"));
                d.setPrecio(rs.getDouble("precio"));

                String fecha = rs.getString("fecha_ven");
                try {
                    Date date = sdf.parse(fecha);
                    d.setFecha_ven(date);
                    
                    d.setDate_created(sdf.parse(rs.getString("date_created")));
                } catch (Exception e) {
                }
                
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }
}
