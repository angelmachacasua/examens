/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Asus
 */
public class Asignatura {

    private int id;
    private String asignatura;
   /* public Asignatura(String asignatura) {//comboox dilema list
        this.asignatura= asignatura;
       
    }*/

    /*public Asignatura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    public Asignatura (){
        
        
    }
    public Asignatura (String nombre){
        this.asignatura = nombre;
        
    }
    public String toString(){
        return asignatura;
}

}
