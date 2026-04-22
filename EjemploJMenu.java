import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ejemplo 9: Menú con JMenuBar, JMenu, JMenuItem
 * Programación Avanzada - UDA
 * Autor: Andres Fernando RIVEROS
 */
public class EjemploJMenu extends JFrame {

    private JTextArea areaTexto;
    private JLabel lblEstado;

    public EjemploJMenu() {
        super("Ejemplo JMenuBar - Editor simple");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        menuArchivo.setMnemonic(KeyEvent.VK_A);

        JMenuItem itemNuevo  = new JMenuItem("Nuevo",  new ImageIcon());
        JMenuItem itemAbrir  = new JMenuItem("Abrir...");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir  = new JMenuItem("Salir");

        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));

        itemNuevo.addActionListener(e  -> { areaTexto.setText(""); lblEstado.setText("Nuevo archivo"); });
        itemAbrir.addActionListener(e  -> lblEstado.setText("Abrir: funcionalidad pendiente"));
        itemGuardar.addActionListener(e -> lblEstado.setText("Guardado: funcionalidad pendiente"));
        itemSalir.addActionListener(e  -> System.exit(0));

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        // Menú Editar
        JMenu menuEditar = new JMenu("Editar");
        JMenuItem itemCopiar  = new JMenuItem("Copiar");
        JMenuItem itemPegar   = new JMenuItem("Pegar");
        JMenuItem itemCortar  = new JMenuItem("Cortar");
        JCheckBoxMenuItem itemModo = new JCheckBoxMenuItem("Modo oscuro");

        itemCopiar.addActionListener(e  -> areaTexto.copy());
        itemPegar.addActionListener(e   -> areaTexto.paste());
        itemCortar.addActionListener(e  -> areaTexto.cut());
        itemModo.addActionListener(e -> {
            Color bg = itemModo.isSelected() ? Color.DARK_GRAY : Color.WHITE;
            Color fg = itemModo.isSelected() ? Color.WHITE : Color.BLACK;
            areaTexto.setBackground(bg);
            areaTexto.setForeground(fg);
        });

        menuEditar.add(itemCopiar);
        menuEditar.add(itemPegar);
        menuEditar.add(itemCortar);
        menuEditar.addSeparator();
        menuEditar.add(itemModo);

        // Menú Ayuda con JRadioButtonMenuItem
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcerca = new JMenuItem("Acerca de...");
        itemAcerca.addActionListener(e ->
            JOptionPane.showMessageDialog(this,
                "Editor Simple v1.0\nAutor: Andres Fernando RIVEROS\nUDA 2026",
                "Acerca de", JOptionPane.INFORMATION_MESSAGE));
        menuAyuda.add(itemAcerca);

        menuBar.add(menuArchivo);
        menuBar.add(menuEditar);
        menuBar.add(menuAyuda);
        setJMenuBar(menuBar);

        // Contenido
        areaTexto = new JTextArea("Escriba aquí...");
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 14));
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);

        lblEstado = new JLabel("Listo");
        lblEstado.setBorder(BorderFactory.createLoweredBevelBorder());
        add(lblEstado, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new EjemploJMenu();
    }
}
