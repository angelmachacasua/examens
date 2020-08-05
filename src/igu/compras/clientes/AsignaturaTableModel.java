package igu.compras.clientes;

import data.AsignaturaData;
import entities.Asignatura;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import util.Config;

/**
 *
 * @author Asullom
 */
public class AsignaturaTableModel extends AbstractTableModel {

    private List<Asignatura> lis = new ArrayList();
    private String[] columns = {"#", "Asignatura"};
    private Class[] columnsType = {Integer.class, String.class};// Date.class

    SimpleDateFormat iguSDF = new SimpleDateFormat(Config.DEFAULT_DATE_STRING_FORMAT_PE);

    public AsignaturaTableModel() {
        lis = AsignaturaData.list("");
    }

    public AsignaturaTableModel(String filter) {
        lis = AsignaturaData.list(filter);
    }
    public AsignaturaTableModel(Asignatura L){
        this.lis = AsignaturaData.listArticlesById(L.getId());
        this.lis.add(new Asignatura());
    }
    

    @Override
    public Object getValueAt(int row, int column) {
        Asignatura d = (Asignatura) lis.get(row);
        switch (column) {
            case 0:
                return row + 1;
            case 1:
                return d.getAsignatura();

            default:
                return null;
        }
    }

    /*
    @Override
    public void setValueAt(Object valor, int row, int column) {
        Asignatura d = (Asignatura) lis.get(row);
        switch (column) {
            
           // case 0:
           //     int id = 0;
           //     try {
            //        if (valor instanceof Number) {
           //             id = Integer.parseInt("" + valor);
           //         }
           //     } catch (NumberFormatException nfe) {
            //        System.err.println("" + nfe);
             //   }
            //    d.setId(id);
             //   break;
             
            case 1:
                d.setAsignatura("" + valor);
                break;
            case 2:
                d.setDetalles("" + valor);
                break;

        }
        this.fireTableRowsUpdated(row, row);
        //fireTableCellUpdated(row, row);
    }
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        //Asignatura c = (Asignatura) lis.get(row);
        if (column >= 0 && column != 0) {
            //return true;
        }
        return false;//bloquear edicion
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class getColumnClass(int column) {
        return columnsType[column];
    }

    @Override
    public int getRowCount() {
        return lis.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    public void addRow(Asignatura d) { // con db no se usa
        this.lis.add(d);
        //this.fireTableDataChanged();
        this.fireTableRowsInserted(lis.size(), lis.size());
    }

    public void removeRow(int linha) { // con db no se usa
        this.lis.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public Object getRow(int row) { // usado para paintForm
        this.fireTableRowsUpdated(row, row);
        return lis.get(row);
    }

}
