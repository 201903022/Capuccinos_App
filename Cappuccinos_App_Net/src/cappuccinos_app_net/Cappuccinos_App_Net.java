/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cappuccinos_app_net;
import Interface.MainIterface;

import Structures.Capuccino;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *
 * @author PC
 */
public class Cappuccinos_App_Net {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
            ArrayList<Capuccino> capuccinoList = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fecha = "";
            int capuccinos = 0;

            try {
                System.out.println("Hola Mundo");
                System.out.println("*************************************************************************************************");
                System.out.print("Ingrese Cantidad de Capuccinos: ");

                String input = reader.readLine();
                capuccinos = Integer.parseInt(input);
                 if(capuccinos % 3 ==0){ 
                     System.out.println("divisible");
                 }else{ 
                     System.out.println("no Divisible");
                 }
                // Obtener la fecha actual
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                fecha = currentDate.format(formatter);

                System.out.println("*************************************************************************************************");
                System.out.println("Fecha: " + fecha);
                System.out.println("Capuccinos Ingresados: " + capuccinos);
            } catch (IOException e) {
                System.err.println("Error leyendo la entrada del usuario: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.err.println("Por favor, ingrese un número válido para la cantidad de capuccinos.");
            }
*/
            showInterface();
           
       }
    
        public static void showInterface() { 
            MainIterface main = new MainIterface();
            main.setVisible(true);
            main.setLocationRelativeTo(null);
        }
    }
    

