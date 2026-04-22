import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 4: JTextField y JPasswordField
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJTextField extends JFrame {

    private JTextField txtNombre;
    private JTextField txtEdad;
    private JPasswordField txtPassword;
    private JLabel lblResultado;

    public EjemploJTextField() {
        super("Ejemplo JTextField y JPasswordField");
        setSize(450, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField(20);
        txtNombre.setToolTipText("Ingrese su nombre completo");
        panel.add(txtNombre);

        panel.add(new JLabel("Edad:"));
        txtEdad = new JTextField(5);
        panel.add(txtEdad);

        panel.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField(20);
        panel.add(txtPassword);

        JButton btnMostrar = new JButton("Mostrar datos");
        btnMostrar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String edad = txtEdad.getText().trim();
            String pass = new String(txtPassword.getPassword());
            if (nombre.isEmpty() || edad.isEmpty()) {
                lblResultado.setText("Completar todos los campos");
                lblResultado.setForeground(Color.RED);
            } else {
                lblResultado.setText("Hola " + nombre + " (" + edad + " años)");
                lblResultado.setForeground(Color.BLUE);
            }
        });

        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(e -> {
            txtNombre.setText("");
            txtEdad.setText("");
            txtPassword.setText("");
            lblResultado.setText("");
        });

        panel.add(btnMostrar);
        panel.add(btnLimpiar);

        lblResultado = new JLabel("", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 13));
        panel.add(lblResultado);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJTextField();
    }
}
