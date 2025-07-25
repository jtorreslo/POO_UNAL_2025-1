/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.crud;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 *
 * @author USUARIO
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        Number = new javax.swing.JTextField();
        Create = new javax.swing.JButton();
        Read = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        Delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("Contact number:");

        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        Create.setText("Create");
        Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateActionPerformed(evt);
            }
        });

        Read.setText("Read");
        Read.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReadActionPerformed(evt);
            }
        });

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Name)
                            .addComponent(Number)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Create)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Read)
                        .addGap(12, 12, 12)
                        .addComponent(Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Delete)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Create)
                    .addComponent(Read)
                    .addComponent(Update)
                    .addComponent(Delete))
                .addGap(89, 89, 89))
        );

        pack();
    }// </editor-fold>                        

    private void CreateActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {

            String newName = String.valueOf(Name.getText());
            long newNumber = Long.parseLong(Number.getText());

            String nameNumberString;
            String name;
            long number;
            int index;

            File file = new File("C:\\Users\\USUARIO\\Desktop\\uni\\POO\\Agenda.txt");

            if (file.exists() == false) {

                file.createNewFile();
    }
            RandomAccessFile raf
                = new RandomAccessFile(file, "rw");
            boolean found = false;

            // Checking whether the name
            // of contact already exists.
            // getFilePointer() give the current offset
            // value from start of the file.
            while (raf.getFilePointer() < raf.length()) {

                // reading line from the file.
                nameNumberString = raf.readLine();

                // splitting the string to get name and
                // number
                String[] lineSplit
                    = nameNumberString.split("!");

                // separating name and number.
                name = lineSplit[0];
                number = Long.parseLong(lineSplit[1]);

                // if condition to find existence of record.
                if (name == newName
                    || number == newNumber) {
                    found = true;
                    break;
                }
            }

            if (found == false) {

                // Enter the if block when a record
                // is not already present in the file.
                nameNumberString
                    = newName + "!"
                      + String.valueOf(newNumber);

                // writeBytes function to write a string
                // as a sequence of bytes.
                raf.writeBytes(nameNumberString);

                // To insert the next record in new line.
                raf.writeBytes(System.lineSeparator());

                // Print the message
                System.out.println(" Friend added. ");

                // Closing the resources.
                raf.close();
            }
            // The contact to be updated
            // could not be found
            else {

                // Closing the resources.
                raf.close();

                // Print the message
                System.out.println(" Input name"
                                   + " does not exists. ");
            }
        }

        catch (IOException ioe) {

            System.out.println(ioe);
        }
        catch (NumberFormatException nef) {

            System.out.println(nef);
        }
    
            
    }                                      

    private void ReadActionPerformed(java.awt.event.ActionEvent evt) {                                     

    try {
        String buscarNombre = Name.getText();

        File file = new File("C:\\Users\\USUARIO\\Desktop\\uni\\POO\\Agenda.txt");
        if (!file.exists()) {
            System.out.println("No hay contactos aún.");
            return;
        }

        RandomAccessFile raf = new RandomAccessFile(file, "r");
        boolean found = false;

        while (raf.getFilePointer() < raf.length()) {
            String[] line = raf.readLine().split("!");
            if (line[0].equals(buscarNombre)) {
                Name.setText(line[0]);
                Number.setText(line[1]);
                System.out.println("Contacto encontrado: " + line[0] + ", " + line[1]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("El contacto no existe.");
        }

        raf.close();
    } catch (Exception e) {
        System.out.println(e);
    } 
    }                                    

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {                                       
try {
        String newName = Name.getText();
        long newNumber = Long.parseLong(Number.getText());

        File file = new File("C:\\Users\\USUARIO\\Desktop\\uni\\POO\\Agenda.txt");
        File tmpFile = new File("C:\\Users\\USUARIO\\Desktop\\uni\\POO\\tmp_contactos.txt");

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile, "rw");

        boolean found = false;

        while (raf.getFilePointer() < raf.length()) {
            String line = raf.readLine();
            String[] parts = line.split("!");
            if (parts[0].equals(newName)) {
                tmpRaf.writeBytes(newName + "!" + newNumber + System.lineSeparator());
                found = true;
            } else {
                tmpRaf.writeBytes(line + System.lineSeparator());
            }
        }

        raf.close();
        tmpRaf.close();

        if (found) {
            file.delete();
            tmpFile.renameTo(file);
            System.out.println("Contacto actualizado.");
        } else {
            tmpFile.delete();
            System.out.println("El contacto no existe.");
        }

    } catch (Exception e) {
        System.out.println(e);
    }        // TODO add your handling code here:
    }                                      

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {                                       
 try {
        String borrarNombre = Name.getText();

        File file = new File("C:\\Users\\USUARIO\\Desktop\\uni\\POO\\Agenda.txt");
        File tmpFile = new File("C:\\Users\\USUARIO\\Desktop\\uni\\POO\\tmp_contactos.txt");

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        RandomAccessFile tmpRaf = new RandomAccessFile(tmpFile, "rw");

        boolean found = false;

        while (raf.getFilePointer() < raf.length()) {
            String line = raf.readLine();
            String[] parts = line.split("!");
            if (parts[0].equals(borrarNombre)) {
                found = true;
                continue; // no escribirlo en tmp
            }
            tmpRaf.writeBytes(line + System.lineSeparator());
        }

        raf.close();
        tmpRaf.close();

        if (found) {
            file.delete();
            tmpFile.renameTo(file);
            System.out.println("Contacto eliminado.");
        } else {
            tmpFile.delete();
            System.out.println("El contacto no existe.");
        }

    } catch (Exception e) {
        System.out.println(e);
    }        // TODO add your handling code here:
    }                                      

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        new Principal().setVisible(true);
    });
}


    // Variables declaration - do not modify                     
    private javax.swing.JButton Create;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Number;
    private javax.swing.JButton Read;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration                   
}
