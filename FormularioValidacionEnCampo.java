import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

/**
 * TP Formularios - Validación EN CAMPO (mientras el usuario escribe)
 * Se valida usando DocumentListener: las reglas se evalúan en tiempo real.
 * 
 * Campos validados:
 *   - Nombre: solo letras y espacios, mínimo 3 caracteres
 *   - Email: formato válido (contiene @ y dominio)
 *   - DNI: solo dígitos, entre 7 y 8 caracteres
 *   - Contraseña: mínimo 8 caracteres, al menos 1 número
 *
 * Programación Avanzada — UDA 2026
 * Alumno: Andres Fernando RIVEROS
 */
public class FormularioValidacionEnCampo extends JFrame {

    // Colores de validación
    private static final Color OK    = new Color(198, 239, 206);  // verde claro
    private static final Color ERROR = new Color(255, 199, 206);  // rojo claro
    private static final Color NEUTRO = Color.WHITE;

    // Campos
    private JTextField  txtNombre;
    private JTextField  txtEmail;
    private JTextField  txtDNI;
    private JPasswordField txtPassword;

    // Etiquetas de error
    private JLabel lblNombreError;
    private JLabel lblEmailError;
    private JLabel lblDNIError;
    private JLabel lblPassError;

    // Botón submit
    private JButton btnEnviar;

    public FormularioValidacionEnCampo() {
        super("Formulario - Validación EN CAMPO");
        setSize(480, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 0, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // ---- Nombre ----
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(new JLabel("Nombre completo:"), gbc);

        gbc.gridy = 1;
        txtNombre = new JTextField();
        panel.add(txtNombre, gbc);

        gbc.gridy = 2;
        lblNombreError = crearLblError();
        panel.add(lblNombreError, gbc);

        // ---- Email ----
        gbc.gridy = 3;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridy = 4;
        txtEmail = new JTextField();
        panel.add(txtEmail, gbc);

        gbc.gridy = 5;
        lblEmailError = crearLblError();
        panel.add(lblEmailError, gbc);

        // ---- DNI ----
        gbc.gridy = 6;
        panel.add(new JLabel("DNI (7-8 dígitos):"), gbc);

        gbc.gridy = 7;
        txtDNI = new JTextField();
        panel.add(txtDNI, gbc);

        gbc.gridy = 8;
        lblDNIError = crearLblError();
        panel.add(lblDNIError, gbc);

        // ---- Contraseña ----
        gbc.gridy = 9;
        panel.add(new JLabel("Contraseña (mín. 8 chars + 1 número):"), gbc);

        gbc.gridy = 10;
        txtPassword = new JPasswordField();
        panel.add(txtPassword, gbc);

        gbc.gridy = 11;
        lblPassError = crearLblError();
        panel.add(lblPassError, gbc);

        // ---- Botón ----
        gbc.gridy = 12;
        gbc.insets = new Insets(15, 4, 4, 4);
        btnEnviar = new JButton("Registrar");
        btnEnviar.setEnabled(false);
        btnEnviar.addActionListener(e ->
            JOptionPane.showMessageDialog(this,
                "Registro exitoso: " + txtNombre.getText(),
                "Éxito", JOptionPane.INFORMATION_MESSAGE));
        panel.add(btnEnviar, gbc);

        // ---- DocumentListeners ----
        txtNombre.getDocument().addDocumentListener(new ValidadorEnCampo() {
            @Override protected boolean validar(String texto) {
                if (texto.trim().length() < 3) {
                    setError(txtNombre, lblNombreError, "Mínimo 3 caracteres");
                    return false;
                }
                if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                    setError(txtNombre, lblNombreError, "Solo letras y espacios");
                    return false;
                }
                setOk(txtNombre, lblNombreError);
                return true;
            }
        });

        txtEmail.getDocument().addDocumentListener(new ValidadorEnCampo() {
            @Override protected boolean validar(String texto) {
                if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", texto)) {
                    setError(txtEmail, lblEmailError, "Email inválido");
                    return false;
                }
                setOk(txtEmail, lblEmailError);
                return true;
            }
        });

        txtDNI.getDocument().addDocumentListener(new ValidadorEnCampo() {
            @Override protected boolean validar(String texto) {
                if (!texto.matches("\\d{7,8}")) {
                    setError(txtDNI, lblDNIError, "7 u 8 dígitos numéricos");
                    return false;
                }
                setOk(txtDNI, lblDNIError);
                return true;
            }
        });

        txtPassword.getDocument().addDocumentListener(new ValidadorEnCampo() {
            @Override protected boolean validar(String texto) {
                if (texto.length() < 8) {
                    setError(txtPassword, lblPassError, "Mínimo 8 caracteres");
                    return false;
                }
                if (!texto.matches(".*\\d.*")) {
                    setError(txtPassword, lblPassError, "Debe contener al menos 1 número");
                    return false;
                }
                setOk(txtPassword, lblPassError);
                return true;
            }
        });

        add(panel);
        setVisible(true);
    }

    private JLabel crearLblError() {
        JLabel lbl = new JLabel(" ");
        lbl.setForeground(Color.RED);
        lbl.setFont(new Font("Arial", Font.PLAIN, 11));
        return lbl;
    }

    private void setError(JComponent campo, JLabel lbl, String msg) {
        campo.setBackground(ERROR);
        lbl.setText(msg);
        btnEnviar.setEnabled(false);
    }

    private void setOk(JComponent campo, JLabel lbl) {
        campo.setBackground(OK);
        lbl.setText(" ");
        verificarTodo();
    }

    private void verificarTodo() {
        btnEnviar.setEnabled(
            txtNombre.getBackground().equals(OK) &&
            txtEmail.getBackground().equals(OK) &&
            txtDNI.getBackground().equals(OK) &&
            txtPassword.getBackground().equals(OK)
        );
    }

    /** Clase abstracta base para validación en campo con DocumentListener */
    abstract class ValidadorEnCampo implements DocumentListener {
        protected abstract boolean validar(String texto);

        @Override public void insertUpdate(DocumentEvent e)  { evaluar(e); }
        @Override public void removeUpdate(DocumentEvent e)  { evaluar(e); }
        @Override public void changedUpdate(DocumentEvent e) { evaluar(e); }

        private void evaluar(DocumentEvent e) {
            SwingUtilities.invokeLater(() -> {
                try {
                    validar(e.getDocument().getText(0, e.getDocument().getLength()));
                } catch (Exception ex) { ex.printStackTrace(); }
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularioValidacionEnCampo::new);
    }
}
