import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 6: Uso de JRadioButton con ButtonGroup
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJRadioButton extends JFrame {

    private JRadioButton rbJunior;
    private JRadioButton rbSemi;
    private JRadioButton rbSenior;
    private JLabel lblSeleccion;

    public EjemploJRadioButton() {
        super("Ejemplo JRadioButton");
        setSize(380, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Seleccione su nivel:"));

        // ButtonGroup asegura selección exclusiva
        ButtonGroup grupo = new ButtonGroup();

        rbJunior = new JRadioButton("Junior (0-2 años)");
        rbSemi   = new JRadioButton("Semi-Senior (2-5 años)", true);
        rbSenior = new JRadioButton("Senior (5+ años)");

        grupo.add(rbJunior);
        grupo.add(rbSemi);
        grupo.add(rbSenior);

        ActionListener listener = e -> actualizarNivel();
        rbJunior.addActionListener(listener);
        rbSemi.addActionListener(listener);
        rbSenior.addActionListener(listener);

        lblSeleccion = new JLabel();
        lblSeleccion.setForeground(Color.BLUE);
        lblSeleccion.setFont(new Font("Arial", Font.BOLD, 13));

        JButton btnVer = new JButton("Ver nivel seleccionado");
        btnVer.addActionListener(e -> actualizarNivel());

        panel.add(rbJunior);
        panel.add(rbSemi);
        panel.add(rbSenior);
        panel.add(btnVer);
        panel.add(lblSeleccion);

        add(panel);
        actualizarNivel();
        setVisible(true);
    }

    private void actualizarNivel() {
        String nivel = "";
        if (rbJunior.isSelected()) nivel = "Junior";
        else if (rbSemi.isSelected()) nivel = "Semi-Senior";
        else if (rbSenior.isSelected()) nivel = "Senior";
        lblSeleccion.setText("Nivel seleccionado: " + nivel);
    }

    public static void main(String[] args) {
        new EjemploJRadioButton();
    }
}
