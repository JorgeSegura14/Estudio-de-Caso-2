package caso.pkg2;

import javax.swing.JOptionPane;

public class Caso2 {
    public static void main(String[] args) {
        CineApp cineApp = new CineApp(); 
        cineApp.iniciar(); 
    }
}

class CineApp {
    public void iniciar() {
        Cine cine = new Cine("Megalodon 2", 5, 6); // creamos un objeto de tipo Cine
        
        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Bienvenido al sistema de gestion del Cine:\n"
                    + "1. Mostrar asientos\n"
                    + "2. Cambiar pelicula\n"
                    + "3. Asignar asiento\n"
                    + "4. Salir\n"
                    + "Ingrese el numero de la opcion:"));

            switch (opcion) {
                case 1:
                    cine.mostrarAsientos();
                    break;
                case 2:
                    String nuevaPelicula = JOptionPane.showInputDialog("Ingrese el nombre de la nueva pelicula:");
                    cine.setNombrePelicula(nuevaPelicula);
                    break;
                case 3:
                    cine.asignarAsiento();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Gracias por usar el sistema del Cine");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida, por favor ingrese un numero del 1 al 4.");
                    break;
            }
        } while (opcion != 4);
    }
}

class Cine {
    private String nombrePelicula;
    private char[][] asientos;

    public Cine(String nombrePelicula, int filas, int columnas) {
        this.nombrePelicula = nombrePelicula;
        this.asientos = new char[filas][columnas]; // creamos la matriz de asientos
        // iniciamos todos los asientos como libres (L)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.asientos[i][j] = 'L';
            }
        }
    }

    public void mostrarAsientos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pelicula: ").append(nombrePelicula).append("\n");
        sb.append("L: libre\n O: ocupado\n\n");
        sb.append("      Pantalla\n");
        char fila = 'A';
        for (int i = 0; i < asientos.length; i++) {
            sb.append(fila++).append("   ");
            for (int j = 0; j < asientos[i].length; j++) {
                sb.append(asientos[i][j]).append("  ");
            }
            sb.append("\n");
        }
        sb.append("     ");
        for (int i = 1; i <= asientos[0].length; i++) {
            sb.append(i).append("  ");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public void asignarAsiento() {
        String filaInput = JOptionPane.showInputDialog("Ingrese la fila (A-E):");
        char filaChar = filaInput.toUpperCase().charAt(0);
        int fila = filaChar - 'A';
        int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna (1-6):")) - 1;
        
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna] == 'L') {
                asientos[fila][columna] = 'O';
                JOptionPane.showMessageDialog(null, "Asiento asignado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El asiento ya esta ocupado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Asiento fuera de rango. por favor, ingrese una fila (A-E) y columna validas (1-6).");
        }
    }
}

