import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

/**
 * TP Formularios - Validacion FUERA DE CAMPO (al perder el foco)
 * Programacion Avanzada - UDA 2026
 * Alumno: Andres Fernando RIVEROS
 */
public class FormularioValidacionFueraDeCampo extends JFrame {

    private static final Color OK    = new Color(198, 239, 206);
    private static final Color ERROR = new Color(255, 199, 206);

    private JTextField txtNombre, txtApellido, txtTelefono, txtEmail, txtFecha;
    private JLabel lblNombreErr, lblApellidoErr, lblTelefonoErr, lblEmailErr, lblFechaErr;
    private JButton btnEnviar;

    public FormularioValidacionFueraDeCampo() {
        super("Formulario - Validacion FUERA DE CAMPO");
        setSize(500, 430);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Datos personales"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(3, 8, 0, 8);

        txtNombre   = new JTextField(); txtApellido = new JTextField();
        txtTelefono = new JTextField(); txtEmail    = new JTextField();
        txtFecha    = new JTextField();
        lblNombreErr   = label(); lblApellidoErr  = label();
        lblTelefonoErr = label(); lblEmailErr     = label();
        lblFechaErr    = label();

        int f = 0;
        f = row(panel, gbc, f, "Nombre:", txtNombre, lblNombreErr);
        f = row(panel, gbc, f, "Apellido:", txtApellido, lblApellidoErr);
        f = row(panel, gbc, f, "Telefono (10 digitos):", txtTelefono, lblTelefonoErr);
        f = row(panel, gbc, f, "Email:", txtEmail, lblEmailErr);
        f = row(panel, gbc, f, "Fecha nacimiento (DD/MM/AAAA):", txtFecha, lblFechaErr);

        txtNombre.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String v = txtNombre.getText().trim();
                if (v.length() < 3 || !v.matches("[a-zA-Z ]+"))
                    err(txtNombre, lblNombreErr, "Nombre invalido (min. 3 letras)");
                else ok(txtNombre, lblNombreErr);
                refreshBtn();
            }
        });
        txtApellido.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String v = txtApellido.getText().trim();
                if (v.length() < 2 || !v.matches("[a-zA-Z ]+"))
                    err(txtApellido, lblApellidoErr, "Apellido invalido (min. 2 letras)");
                else ok(txtApellido, lblApellidoErr);
                refreshBtn();
            }
        });
        txtTelefono.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (!txtTelefono.getText().matches("[0-9]{10}"))
                    err(txtTelefono, lblTelefonoErr, "Ingrese exactamente 10 digitos");
                else ok(txtTelefono, lblTelefonoErr);
                refreshBtn();
            }
        });
        txtEmail.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$",
                                     txtEmail.getText()))
                    err(txtEmail, lblEmailErr, "Email invalido");
                else ok(txtEmail, lblEmailErr);
                refreshBtn();
            }
        });
        txtFecha.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                if (!txtFecha.getText().matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"))
                    err(txtFecha, lblFechaErr, "Formato DD/MM/AAAA");
                else ok(txtFecha, lblFechaErr);
                refreshBtn();
            }
        });

        gbc.gridx = 0; gbc.gridy = f; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        btnEnviar = new JButton("Registrar persona");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(ev ->
            JOptionPane.showMessageDialog(this,
                "Registrado: " + txtNombre.getText() + " " + txtApellido.getText()));
        panel.add(btnEnviar, gbc);

        add(panel);
        setVisible(true);
    }

    private JLabel label() {
        JLabel l = new JLabel(" ");
        l.setForeground(Color.RED);
        l.setFont(new Font("Arial", Font.PLAIN, 11));
        return l;
    }

    private int row(JPanel p, GridBagConstraints g, int f, String t, JTextField c, JLabel e) {
        g.gridx = 0; g.gridy = f++; g.gridwidth = 2; p.add(new JLabel(t), g);
        g.gridy = f++; p.add(c, g);
        g.gridy = f++; p.add(e, g);
        return f;
    }

    private void err(JTextField c, JLabel l, String m) { c.setBackground(ERROR); l.setText(m); }
    private void ok(JTextField c, JLabel l)             { c.setBackground(OK);    l.setText(" "); }

    private void refreshBtn() {
        btnEnviar.setEnabled(txtNombre.getBackground().equals(OK) &&
                             txtApellido.getBackground().equals(OK) &&
                             txtTelefono.getBackground().equals(OK) &&
                             txtEmail.getBackground().equals(OK) &&
                             txtFecha.getBackground().equals(OK));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularioValidacionFueraDeCampo::new);
    }
}
