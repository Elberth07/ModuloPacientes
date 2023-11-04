/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pacientes;

/**
 *
 * @author ebert
 */
import javax.swing.JOptionPane;

public class ModuloPacientes {

    public static void main(String[] args) {
        // Crear un arreglo de objetos Paciente para almacenar pacientes
        Paciente[] pacientes = new Paciente[10]; // Puedes ajustar el tamaño según tus necesidades

        // Variable para llevar el registro de la cantidad de pacientes agregados
        int cantidadPacientes = 0;

        while (true) {
            // Mostrar un menú de opciones
            String[] opciones = {"Agregar Paciente", "Mostrar Pacientes", "Salir"};
            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Módulo de Pacientes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

            switch (seleccion) {
                case 0 -> {
                    // Agregar Paciente
                    if (cantidadPacientes < pacientes.length) {
                        String nombre = JOptionPane.showInputDialog("Nombre del paciente:");
                        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del paciente:"));
                        String numeroExpediente = JOptionPane.showInputDialog("Número de Expediente:");

                        pacientes[cantidadPacientes] = new Paciente(nombre, edad, numeroExpediente);
                        cantidadPacientes++;
                        JOptionPane.showMessageDialog(null, "Paciente agregado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pueden agregar más pacientes. La lista está llena.");
                    }
                }

                case 1 -> {
                    // Mostrar Pacientes
                    StringBuilder infoPacientes = new StringBuilder();
                    for (int i = 0; i < cantidadPacientes; i++) {
                        infoPacientes.append("Paciente ").append(i + 1).append(":\n");
                        infoPacientes.append(pacientes[i].mostrarInformacion()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, infoPacientes.toString());
                }

                case 2 -> {
                    // Salir del programa
                    JOptionPane.showMessageDialog(null, "Saliendo del módulo de pacientes.");
                    System.exit(0);
                }

                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}

class Paciente {
    private final String nombre;
    private final int edad;
    private final String numeroExpediente;

    public Paciente(String nombre, int edad, String numeroExpediente) {
        this.nombre = nombre;
        this.edad = edad;
        this.numeroExpediente = numeroExpediente;
    }

    public String mostrarInformacion() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nNúmero de Expediente: " + numeroExpediente;
    }
}



