package igu.util.tables;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Asullom
 */
public class TableCellFormatter implements TableCellRenderer{

    JFormattedTextField ftfcampo;
    
    public TableCellFormatter() {
       ftfcampo = new JFormattedTextField();
       ftfcampo.setHorizontalAlignment(JTextField.RIGHT);
       ftfcampo.setFont(new Font("Tahoma", 1, 14));
       ftfcampo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));       
       ftfcampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new FormatoDecimal("#,##0.00",true))));
       
    }
    
     public TableCellFormatter(String formato) {
       ftfcampo = new JFormattedTextField();
       ftfcampo.setHorizontalAlignment(JTextField.RIGHT);
       ftfcampo.setFont(new Font("Tahoma", 1, 14));
       ftfcampo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));   
       if(formato == null || formato.isEmpty())
       {
            formato = "#0";
       }
       ftfcampo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(formato))));
       
    }
    
    

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ftfcampo.setValue(value);
        if(isSelected)
        {
            ftfcampo.setBackground(table.getSelectionBackground());
        }else{
            ftfcampo.setBackground(null);
        }
        
        
        return ftfcampo;
    }
    
}
