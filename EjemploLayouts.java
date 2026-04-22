import javax.swing.*;
import java.awt.*;

/**
 * Ejemplo 10: Demostración de Layouts (BorderLayout, FlowLayout, GridLayout, GridBagLayout)
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploLayouts extends JFrame {

    public EjemploLayouts() {
        super("Ejemplo de Layouts en Swing");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal con pestañas
        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("BorderLayout", crearBorderLayout());
        tabs.addTab("FlowLayout",   crearFlowLayout());
        tabs.addTab("GridLayout",   crearGridLayout());
        tabs.addTab("GridBagLayout", crearGridBagLayout());

        add(tabs);
        setVisible(true);
    }

    private JPanel crearBorderLayout() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(crearBoton("NORTE (NORTH)", Color.RED),    BorderLayout.NORTH);
        panel.add(crearBoton("SUR (SOUTH)", Color.BLUE),    BorderLayout.SOUTH);
        panel.add(crearBoton("ESTE (EAST)", Color.GREEN),   BorderLayout.EAST);
        panel.add(crearBoton("OESTE (WEST)", Color.ORANGE), BorderLayout.WEST);
        panel.add(crearBoton("CENTRO (CENTER)", Color.GRAY), BorderLayout.CENTER);
        return panel;
    }

    private JPanel crearFlowLayout() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 1; i <= 8; i++) {
            JButton btn = new JButton("Btn " + i);
            btn.setPreferredSize(new Dimension(80, 30));
            panel.add(btn);
        }
        return panel;
    }

    private JPanel crearGridLayout() {
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        String[] teclas = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        for (String t : teclas) {
            JButton btn = new JButton(t);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            panel.add(btn);
        }
        return panel;
    }

    private JPanel crearGridBagLayout() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 0: Nombre (ocupa 2 columnas)
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        panel.add(new JTextField(15), gbc);

        // Fila 1: Email
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; gbc.weightx = 0;
        panel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2; gbc.weightx = 1.0;
        panel.add(new JTextField(15), gbc);

        // Fila 2: Botón submit (centrado)
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 1; gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JButton("Enviar"), gbc);

        return panel;
    }

    private JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 12));
        return btn;
    }

    public static void main(String[] args) {
        new EjemploLayouts();
    }
}
