/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Structures;

/**
 *
 * @author PC
 */
public class Capuccino {
    private int capuccinoRealizado;
    private int carry; 
    private int total; 
    private double totalPagar; 
    private String fecha;
    private int estado;

      public Capuccino (int cpR, int carry, int total, double totalPag, String fecha,int estado){
          this.capuccinoRealizado = cpR;
          this.total  = total; 
          this.totalPagar = totalPag;
          this.fecha = fecha;
          this.estado = estado;
          this.carry = carry;
      }

    /**
     * @return the capuccinoRealizado
     */
    public int getCapuccinoRealizado() {
        return capuccinoRealizado;
    }

    /**
     * @param capuccinoRealizado the capuccinoRealizado to set
     */
    public void setCapuccinoRealizado(int capuccinoRealizado) {
        this.capuccinoRealizado = capuccinoRealizado;
    }

    /**
     * @return the carry
     */
    public int getCarry() {
        return carry;
    }

    /**
     * @param carry the carry to set
     */
    public void setCarry(int carry) {
        this.carry = carry;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the totalPagar
     */
    public double getTotalPagar() {
        return totalPagar;
    }

    /**
     * @param totalPagar the totalPagar to set
     */
    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
  public String toWriteFile(){ 
      String salida = this.fecha + "," +String.valueOf(this.capuccinoRealizado) + "," + String.valueOf(this.carry)+","+String.valueOf(this.total)+","+String.valueOf(this.totalPagar)+","+String.valueOf(this.estado);
      return salida;
  }
   
}
