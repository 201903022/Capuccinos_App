/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Structures.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class EditarFrame extends javax.swing.JFrame {
 public ArrayList<Capuccino> capuccinoList = DataS.getInstance().cappuccinoList;
    /**
     * Creates new form EditarFrame
     * @param capuccinoList
     */
    public EditarFrame() {
        setTitle("Editar Cappuccino");
        initComponents();
        //leerData();
        showTable();
        addTableListener();
    }
    private void showTable() {
        DefaultTableModel model = (DefaultTableModel) TableContenido.getModel();
        model.setRowCount(0); // Limpiar la tabla

        if (!capuccinoList.isEmpty()) {
            for (Capuccino capu : capuccinoList) {
                int estado = capu.getEstado();
                model.addRow(new Object[]{
                    capu.getFecha(),
                    capu.getCapuccinoRealizado(),
                    capu.getCarry(),
                    capu.getTotal(),
                    String.format("Q.%.2f", capu.getTotalPagar()),
                    estado == 0 ? 0 : 1
                });
            }
        }
    }
    
   private void leerData(){ 
        // cpR,  carry,  total,  totalPag,  fecha, estado
        String filePath = "src/Data/dataCappuccinos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {          
            String line;
            while ((line = br.readLine()) != null) {
                // Separar la línea por comas
                int cpR = 0, carry = 0, estado = 0,total = 0;
                double toPay = 0.0;
                String fecha = "";            
                String[] values = line.split(",");

                // Asignar los valores a las variables
                fecha = values[0];
                cpR = Integer.parseInt(values[1]);
                carry = Integer.parseInt(values[2]);
                total = Integer.parseInt(values[3]);
                toPay = Double.parseDouble(values[4]);
                estado = Integer.parseInt(values[5]);
                Capuccino cpAdd = new Capuccino(cpR,carry,total,toPay,fecha,estado);
                capuccinoList.add(cpAdd);                
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e);
        }         
    }

    private void addTableListener() {
        DefaultTableModel model = (DefaultTableModel) TableContenido.getModel();
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 5) { // Columna "Estado"
                    String estadoStr = (String) model.getValueAt(row, column);
                    estadoStr = estadoStr.trim();
                    int estado = estadoStr.equals("1") ? 1 : 0;
                    System.out.println("Cabmio a : " + estado);
                    capuccinoList.get(row).setEstado(estado);
                }
            }
        });
        System.out.println("Cambios Realizados");
    }   
   private void EditarData(){ 
       
   }    

     private void OverWriteFile(){ 
        String filePath = "src/Data/dataCappuccinos.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false)) {
            if (!capuccinoList.isEmpty()) {
                for (int i = 0; i < capuccinoList.size(); i++) {
                      Capuccino capu = capuccinoList.get(i);
                      fileWriter.write(capu.toWriteFile());
                }
            }
            System.out.println("Archivo limpiado y sobrescrito con éxito.");
        } catch (IOException e) {
            System.err.println("Error al limpiar y sobrescribir el archivo: " + e.getMessage());
        }     
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        scrollPane1 = new java.awt.ScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableContenido = new javax.swing.JTable();
        ButtonCancel = new javax.swing.JButton();
        ButtonEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableContenido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Default", "Default", "Default", "Default", "Q.0.00", "Default"}
            },
            new String [] {
                "Fecha", "Realizados", "Carry", "Total Realizados", "Total a Pagar", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableContenido);

        scrollPane1.add(jScrollPane1);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
        );

        ButtonCancel.setText("Salir");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        ButtonEdit.setText("Editar");
        ButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonEdit)
                        .addGap(31, 31, 31)
                        .addComponent(ButtonCancel)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(ButtonEdit))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void ButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditActionPerformed
        // TODO add your handling code here:
          int response = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea editar los cambios?", "Confirmar Edición",
          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        // Si el usuario selecciona "Sí", realizar la sobrescritura del archivo
           if (response == JOptionPane.YES_OPTION) {
                OverWriteFile();
            }
    }//GEN-LAST:event_ButtonEditActionPerformed

    

    

 
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JTable TableContenido;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
