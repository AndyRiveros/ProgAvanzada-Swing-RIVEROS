import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 3: Uso de JButton con ActionListener
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJButton extends JFrame implements ActionListener {

    private JLabel lblResultado;
    private int contador = 0;

    public EjemploJButton() {
        super("Ejemplo JButton");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 20));

        // Botón con ActionListener
        JButton btnSumar = new JButton("Sumar +1");
        btnSumar.setBackground(Color.GREEN);
        btnSumar.setForeground(Color.WHITE);
        btnSumar.setFont(new Font("Arial", Font.BOLD, 14));
        btnSumar.addActionListener(this);
        btnSumar.setActionCommand("sumar");

        JButton btnRestar = new JButton("Restar -1");
        btnRestar.setBackground(Color.RED);
        btnRestar.setForeground(Color.WHITE);
        btnRestar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRestar.addActionListener(this);
        btnRestar.setActionCommand("restar");

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(this);
        btnReset.setActionCommand("reset");

        lblResultado = new JLabel("Contador: 0", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 18));
        lblResultado.setPreferredSize(new Dimension(300, 40));

        panel.add(btnSumar);
        panel.add(btnRestar);
        panel.add(btnReset);
        panel.add(lblResultado);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "sumar":  contador++; break;
            case "restar": contador--; break;
            case "reset":  contador = 0; break;
        }
        lblResultado.setText("Contador: " + contador);
    }

    public static void main(String[] args) {
        new EjemploJButton();
    }
}
