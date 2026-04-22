import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 7: Uso de JComboBox (lista desplegable)
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJComboBox extends JFrame {

    private JComboBox<String> cmbProvincia;
    private JComboBox<String> cmbLocalidad;
    private JLabel lblSeleccion;

    private static final String[] PROVINCIAS = {
        "Mendoza", "Buenos Aires", "Córdoba", "Santa Fe"
    };

    private static final String[][] LOCALIDADES = {
        {"Capital", "Godoy Cruz", "Guaymallén", "Las Heras"},
        {"La Plata", "Mar del Plata", "Quilmes", "Tigre"},
        {"Córdoba", "Río Cuarto", "Villa María", "San Francisco"},
        {"Rosario", "Santa Fe", "Rafaela", "Venado Tuerto"}
    };

    public EjemploJComboBox() {
        super("Ejemplo JComboBox - Selector de ubicación");
        setSize(420, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Provincia:"));
        cmbProvincia = new JComboBox<>(PROVINCIAS);
        cmbProvincia.addActionListener(e -> actualizarLocalidades());
        panel.add(cmbProvincia);

        panel.add(new JLabel("Localidad:"));
        cmbLocalidad = new JComboBox<>(LOCALIDADES[0]);
        panel.add(cmbLocalidad);

        JButton btnSeleccionar = new JButton("Confirmar");
        btnSeleccionar.addActionListener(e -> mostrarSeleccion());
        panel.add(btnSeleccionar);

        lblSeleccion = new JLabel("", SwingConstants.CENTER);
        lblSeleccion.setForeground(Color.BLUE);
        panel.add(lblSeleccion);

        add(panel);
        setVisible(true);
    }

    private void actualizarLocalidades() {
        int idx = cmbProvincia.getSelectedIndex();
        cmbLocalidad.removeAllItems();
        for (String loc : LOCALIDADES[idx]) {
            cmbLocalidad.addItem(loc);
        }
    }

    private void mostrarSeleccion() {
        lblSeleccion.setText(cmbLocalidad.getSelectedItem()
                + ", " + cmbProvincia.getSelectedItem());
    }

    public static void main(String[] args) {
        new EjemploJComboBox();
    }
}
