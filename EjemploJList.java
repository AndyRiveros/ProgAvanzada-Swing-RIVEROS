import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 8: Uso de JList con DefaultListModel
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJList extends JFrame {

    private DefaultListModel<String> modeloDisponibles;
    private DefaultListModel<String> modeloSeleccionados;
    private JList<String> listaDisponibles;
    private JList<String> listaSeleccionados;

    public EjemploJList() {
        super("Ejemplo JList - Gestión de materias");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Modelo y lista de disponibles
        modeloDisponibles = new DefaultListModel<>();
        modeloDisponibles.addElement("Programación Avanzada");
        modeloDisponibles.addElement("Bases de Datos");
        modeloDisponibles.addElement("Redes");
        modeloDisponibles.addElement("Sistemas Operativos");
        modeloDisponibles.addElement("Inteligencia Artificial");

        listaDisponibles = new JList<>(modeloDisponibles);
        listaDisponibles.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Modelo y lista de seleccionados
        modeloSeleccionados = new DefaultListModel<>();
        listaSeleccionados = new JList<>(modeloSeleccionados);
        listaSeleccionados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Paneles
        JPanel panelIzq = new JPanel(new BorderLayout());
        panelIzq.add(new JLabel("Disponibles:", SwingConstants.CENTER), BorderLayout.NORTH);
        panelIzq.add(new JScrollPane(listaDisponibles), BorderLayout.CENTER);

        JPanel panelDer = new JPanel(new BorderLayout());
        panelDer.add(new JLabel("Seleccionadas:", SwingConstants.CENTER), BorderLayout.NORTH);
        panelDer.add(new JScrollPane(listaSeleccionados), BorderLayout.CENTER);

        // Botones centrales
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton btnAgregar  = new JButton(">");
        JButton btnQuitar   = new JButton("<");
        JButton btnTodos    = new JButton(">>");

        btnAgregar.addActionListener(e -> moverSeleccionados(listaDisponibles, modeloDisponibles, modeloSeleccionados));
        btnQuitar.addActionListener(e  -> moverSeleccionados(listaSeleccionados, modeloSeleccionados, modeloDisponibles));
        btnTodos.addActionListener(e   -> moverTodos(modeloDisponibles, modeloSeleccionados));

        panelBotones.add(btnAgregar);
        panelBotones.add(btnQuitar);
        panelBotones.add(btnTodos);

        add(panelIzq, BorderLayout.WEST);
        add(panelBotones, BorderLayout.CENTER);
        add(panelDer, BorderLayout.EAST);

        setVisible(true);
    }

    private void moverSeleccionados(JList<String> fuente, DefaultListModel<String> modeloFuente,
                                     DefaultListModel<String> modeloDestino) {
        java.util.List<String> seleccionados = fuente.getSelectedValuesList();
        for (String item : seleccionados) {
            modeloFuente.removeElement(item);
            modeloDestino.addElement(item);
        }
    }

    private void moverTodos(DefaultListModel<String> modeloFuente, DefaultListModel<String> modeloDestino) {
        while (!modeloFuente.isEmpty()) {
            modeloDestino.addElement(modeloFuente.remove(0));
        }
    }

    public static void main(String[] args) {
        new EjemploJList();
    }
}
