/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igu.util.tables;

import com.sun.javafx.scene.control.skin.TableRowSkin;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.*;

/**
 *
 * @author
 */
public class EstiloTablaRenderer extends DefaultTableCellRenderer {

    private String tipo = "texto";

    //se definen por defecto los tipos de datos a usar
    private Font normal = new Font("Verdana", Font.PLAIN, 12);
    private Font bold = new Font("Verdana", Font.BOLD, 12);
    //etiqueta que almacenará el icono a mostrar
    private JLabel label = new JLabel();
    //iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga
   // private ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/igu/imgs/img/ico_guardar.png"));
   // private ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/igu/imgs/img/ico_buscar.png"));

    public EstiloTablaRenderer() {

    }

    /**
     * Constructor explicito con el tipo de dato que tendrá la celda
     *
     * @param tipo
     */
    public EstiloTablaRenderer(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        int x = table.getRowCount();
        //if (row == x - 1) {
            //componenete.setForeground(new Color(58, 159, 171));
            //componenete.setBackground(new Color(255, 255, 255));
            //this.setBackground(new Color(58, 159, 171));
            //this.setForeground(Color.WHITE);
        //} else {
            if (row % 2 == 0) {
                this.setForeground(new Color(58, 159, 171));
                this.setBackground(new Color(255, 255, 255));
            } else {
                this.setForeground(new Color(58, 159, 171));
                this.setBackground(new Color(255, 255, 255));
            }
            if (selected) {
                this.setForeground(Color.white);
                this.setBackground(new Color(32, 178, 170));
                this.setFont(new Font("Tahoma", Font.BOLD, 14));
            }
       // }
         
        
        //Color colorFondo = null;
           // Color colorFondoPorDefecto = new Color(192, 192, 192);
           // Color colorFondoSeleccion = new Color(140, 140, 140);

            if (selected) {
               // this.setBackground(colorFondoPorDefecto);
            } else {
                //Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
               // this.setBackground(Color.white);
            }
            
            if (focused) {
                   // colorFondo = colorFondoSeleccion;
                } else {
                    //colorFondo = colorFondoPorDefecto;
                }
                



            if (tipo.equals("texto")) {
                //si es tipo texto define el color de fondo del texto y de la celda así como la alineación
                
                this.setHorizontalAlignment(JLabel.LEFT);
                this.setText((String) value);
                //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
                //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
              //  this.setBackground((selected) ? colorFondo : Color.WHITE);
                this.setFont(normal);
                //this.setFont(bold);
                return this;
            }
/*
            //si el tipo es icono entonces valida cual icono asignar a la etiqueta.
            if (tipo.equals("icono")) {
                if (String.valueOf(value).equals("PERFIL")) {
                    label.setIcon(iconoBuscar);
                } else if (String.valueOf(value).equals("EVENTO")) {
                    label.setIcon(iconoGuardar);
                }
                label.setHorizontalAlignment(JLabel.LEFT);
                label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
//            return boton;
                return label;
            }*/
            
            if (tipo.equals("fecha")) {
                //si es tipo texto define el color de fondo del texto y de la celda así como la alineación
                
                this.setHorizontalAlignment(JLabel.CENTER);
                this.setText((String) value);
                //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
                //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
              //  this.setBackground((selected) ? colorFondo : Color.WHITE);
                this.setFont(normal);
                //this.setFont(bold);
                return this;
            }

            //definie si el tipo de dato el numerico para personalizarlo
            if (tipo.equals("numerico")) {
                
                // System.out.println(value);
                this.setHorizontalAlignment(JLabel.RIGHT);
                this.setText((String) value);
                this.setForeground((selected) ? new Color(255, 255, 255) : new Color(32, 117, 32));
                //this.setBackground((selected) ? colorFondo : Color.WHITE);
                // this.setBackground( (selected)? colorFondo :Color.MAGENTA);
                this.setFont(bold);
                return this;
            }
     

        return this;

    }
    /*
    //https://www.youtube.com/watch?v=sW4FyA-z5Yg&t=979s
    private Component componenete;
    


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        //this.setHorizontalAlignment(0);
        //this.setBorder(null);
        //this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(58, 159, 171)));
        
        if (row % 2 == 0) {
            componenete.setForeground(new Color(58, 159, 171));
            componenete.setBackground(new Color(255, 255, 255));
        } else {
            componenete.setForeground(new Color(58, 159, 171));
            componenete.setBackground(new Color(255, 255, 255));
        }
        if (isSelected) {
            componenete.setForeground(Color.white);
            componenete.setBackground(new Color(32, 178, 170));
            componenete.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        //table.g
        //TableColumnModel columnModel = table.getColumnModel();
        //TableRowSkin t= table.
        int x = table.getRowCount();
        if (row == x - 1) {
            //componenete.setForeground(new Color(58, 159, 171));
            //componenete.setBackground(new Color(255, 255, 255));
            componenete.setBackground(new Color(58, 159, 171));
            componenete.setForeground(Color.WHITE);
        } else {
            if (row % 2 == 0) {
                componenete.setForeground(new Color(58, 159, 171));
                componenete.setBackground(new Color(255, 255, 255));
            } else {
                componenete.setForeground(new Color(58, 159, 171));
                componenete.setBackground(new Color(255, 255, 255));
            }
            if (isSelected) {
                componenete.setForeground(Color.white);
                componenete.setBackground(new Color(32, 178, 170));
                componenete.setFont(new Font("Tahoma", Font.BOLD, 14));
            }
        }

        return componenete;

    }
*/
}
