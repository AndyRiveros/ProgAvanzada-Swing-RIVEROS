import javax.swing.JFrame;

/**
 * Ejemplo 1: Ventana base con JFrame
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJFrame {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Mi Primera Ventana Swing");
        
        // Configurar tamaño
        ventana.setSize(400, 300);
        
        // Centrar en pantalla
        ventana.setLocationRelativeTo(null);
        
        // Cerrar aplicación al cerrar ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Hacer visible
        ventana.setVisible(true);
    }
}
