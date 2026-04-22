import javax.swing.*;
import java.awt.*;

/**
 * Ejemplo 2: Uso de JLabel con texto e ícono
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJLabel extends JFrame {

    public EjemploJLabel() {
        super("Ejemplo JLabel");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel con FlowLayout
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Etiqueta simple
        JLabel lblTexto = new JLabel("Hola Swing!");
        lblTexto.setFont(new Font("Arial", Font.BOLD, 18));
        lblTexto.setForeground(Color.BLUE);

        // Etiqueta con alineación
        JLabel lblAlineado = new JLabel("Texto a la derecha", SwingConstants.RIGHT);
        lblAlineado.setPreferredSize(new Dimension(200, 30));
        lblAlineado.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Etiqueta HTML
        JLabel lblHTML = new JLabel("<html><b>Negrita</b> y <i>cursiva</i></html>");

        panel.add(lblTexto);
        panel.add(lblAlineado);
        panel.add(lblHTML);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJLabel();
    }
}
