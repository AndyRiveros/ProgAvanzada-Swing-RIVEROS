import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 5: Uso de JCheckBox
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJCheckBox extends JFrame {

    private JCheckBox chkJava;
    private JCheckBox chkPython;
    private JCheckBox chkCpp;
    private JCheckBox chkJavaScript;
    private JLabel lblSeleccion;

    public EjemploJCheckBox() {
        super("Ejemplo JCheckBox - Selección de lenguajes");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Seleccione lenguajes de programación:"));

        chkJava = new JCheckBox("Java", true);
        chkPython = new JCheckBox("Python");
        chkCpp = new JCheckBox("C++");
        chkJavaScript = new JCheckBox("JavaScript");

        ItemListener listener = e -> actualizarSeleccion();

        chkJava.addItemListener(listener);
        chkPython.addItemListener(listener);
        chkCpp.addItemListener(listener);
        chkJavaScript.addItemListener(listener);

        lblSeleccion = new JLabel();
        lblSeleccion.setForeground(Color.BLUE);

        JButton btnMostrar = new JButton("Ver selección");
        btnMostrar.addActionListener(e -> actualizarSeleccion());

        panel.add(chkJava);
        panel.add(chkPython);
        panel.add(chkCpp);
        panel.add(chkJavaScript);
        panel.add(btnMostrar);
        panel.add(lblSeleccion);

        add(panel);
        actualizarSeleccion();
        setVisible(true);
    }

    private void actualizarSeleccion() {
        StringBuilder sb = new StringBuilder("Seleccionados: ");
        if (chkJava.isSelected()) sb.append("Java ");
        if (chkPython.isSelected()) sb.append("Python ");
        if (chkCpp.isSelected()) sb.append("C++ ");
        if (chkJavaScript.isSelected()) sb.append("JS ");
        lblSeleccion.setText(sb.toString());
    }

    public static void main(String[] args) {
        new EjemploJCheckBox();
    }
}
