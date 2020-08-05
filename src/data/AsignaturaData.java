package data;

import entities.Asignatura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ErrorLogger;
import java.util.logging.Level;

/**
 *
 * @author Asullom
 */
public class AsignaturaData{

    static Connection cn = Conn.connectSQLite();
    static PreparedStatement ps;
    static ErrorLogger log = new ErrorLogger(AsignaturaData.class.getName());

    public static int create(Asignatura d) {
        int rsId = 0;
        String[] returns = {"id"};
        String sql = "INSERT INTO cursos(asignatura) "
                + "VALUES(?)";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql, returns);
            ps.setString(++i, d.getAsignatura());
            rsId = ps.executeUpdate();// 0 no o 1 si commit
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    rsId = rs.getInt(1); // select tk, max(id)  from asignatura
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

    public static int update(Asignatura d) {
        System.out.println("actualizar d.getId(): " + d.getId());
        int comit = 0;
        String sql = "UPDATE cursos SET "
                + "asignatura=?, "
                + "WHERE id=?";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(++i, d.getAsignatura());
            ps.setInt(++i, d.getId());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "update", ex);
        }
        return comit;
    }

    public static int delete(int id) throws Exception {
        int comit = 0;
        String sql = "DELETE FROM cursos WHERE id = ?";
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

   /* public static List<Asignatura> listCmb(String filter) {//commboox
        List<Asignatura> ls = new ArrayList();
        ls.add(new Asignatura("Seleccione..."));
        ls.addAll(list(filter));
        return ls;
    }*/

    public static List<Asignatura> list(String filter) {
        String filtert = null;
        if (filter == null) {
            filtert = "";
        } else {
            filtert = filter;
        }
        System.out.println("list.filtert:" + filtert);

        List<Asignatura> ls = new ArrayList();

        String sql = "";
        if (filtert.equals("")) {
            sql = "SELECT * FROM cursos ORDER BY id";
        } else {
            sql = "SELECT * FROM cursos WHERE (id LIKE'" + filter + "%' OR "
                    + "asignatura LIKE'" + filter + "%' OR infoadic LIKE'" + filter + "%' OR "
                    + "id LIKE'" + filter + "%') "
                    + "ORDER BY asignatura";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Asignatura d =  new Asignatura();
                d.setId(rs.getInt("id"));
                d.setAsignatura(rs.getString("asignatura"));
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "list", ex);
        }
        return ls;
    }

    public static Asignatura getByPId(int id) {
        Asignatura d = new Asignatura();

        String sql = "SELECT * FROM cursos WHERE id = ? ";
        int i = 0;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(++i, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setAsignatura(rs.getString("asignatura"));
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "getByPId", ex);
        }
        return d;
    }
    public static List<Asignatura> listCmb(String filter) {
        List<Asignatura> ls = new ArrayList();
        ls.add(new Asignatura("Seleccione curso..."));
        ls.addAll(list(filter));
        return ls;
    }
    public static List<Asignatura> listArticlesById(int id){
        System.out.println("listById.idart:" + id);
        String sql = "";
        List<Asignatura> ls = new ArrayList<Asignatura>();

        sql = " SELECT * FROM cursos "
                + " WHERE id = " + id 
                + " ORDER BY id ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Asignatura d = new Asignatura();
                d.setId(rs.getInt("id"));
                try {
                    
                } catch (Exception e) {
                }

                d.setId(rs.getInt("id"));
                d.setAsignatura(rs.getString("asignatura"));
               

                
                ls.add(d);
            }
        } catch (SQLException ex) {
            log.log(Level.SEVERE, "listById", ex);
        }
        return ls;
    }
    
     
}


