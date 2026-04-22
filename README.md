# ProgAvanzada-Swing-RIVEROS

## Práctica Base Swing — Programación Avanzada
### Universidad del Aconcagua (UDA) — 2026

**Alumno:** Andres Fernando RIVEROS  
**Materia:** Programación Avanzada — FCSAIDSPA  
**Práctica:** Base Swing (Java AWT y Swing)  
**Vencimiento:** 29/04/2026 16:00  

---

## Descripción

Este proyecto contiene las clases individuales correspondientes a cada uno de los ejemplos del apunte **"Swing completo"**, completando los ejemplos que estaban incompletos según la consigna y el Capítulo 12 del libro Deitel (Java: How to Program).

---

## Clases incluidas

| # | Clase | Componente(s) demostrado(s) |
|---|-------|----------------------------|
| 1 | `EjemploJFrame.java` | JFrame básico, setSize, setLocationRelativeTo, EXIT_ON_CLOSE |
| 2 | `EjemploJLabel.java` | JLabel con texto, fuente, color, alineación y HTML |
| 3 | `EjemploJButton.java` | JButton con ActionListener, ActionCommand, contador |
| 4 | `EjemploJTextField.java` | JTextField, JPasswordField, GridLayout, validación básica |
| 5 | `EjemploJCheckBox.java` | JCheckBox, ItemListener, selección múltiple |
| 6 | `EjemploJRadioButton.java` | JRadioButton, ButtonGroup, selección exclusiva |
| 7 | `EjemploJComboBox.java` | JComboBox dinámico (provincias → localidades dependientes) |
| 8 | `EjemploJList.java` | JList, DefaultListModel, JScrollPane, selección múltiple, transferencia |
| 9 | `EjemploJMenu.java` | JMenuBar, JMenu, JMenuItem, JCheckBoxMenuItem, aceleradores, JTextArea |
| 10 | `EjemploLayouts.java` | BorderLayout, FlowLayout, GridLayout, GridBagLayout, JTabbedPane |

---

## Cómo ejecutar

Cada clase tiene su propio método `main`. Se puede compilar y ejecutar de forma independiente:

```bash
javac EjemploJFrame.java
java EjemploJFrame
```

O importar el proyecto en **NetBeans** y ejecutar cada clase por separado.

---

## Contenido detallado

### 1. EjemploJFrame
Ventana base mínima con JFrame. Muestra cómo configurar tamaño, centrar en pantalla y definir comportamiento al cerrar.

### 2. EjemploJLabel  
Uso de etiquetas con diferentes propiedades: fuente personalizada, color de texto, alineación y contenido HTML enriquecido.

### 3. EjemploJButton  
Contador interactivo con tres botones (Sumar, Restar, Reset). Implementa ActionListener mediante interface y usa ActionCommand para distinguir eventos.

### 4. EjemploJTextField y JPasswordField  
Formulario con campos de texto, contraseña y validación básica. Usa GridLayout para organizar los componentes en filas.

### 5. EjemploJCheckBox  
Selector múltiple de lenguajes de programación. Usa ItemListener para actualizar en tiempo real y ButtonGroup para agrupar lógicamente.

### 6. EjemploJRadioButton  
Selector de nivel profesional (Junior/Semi-Senior/Senior) con ButtonGroup para garantizar selección exclusiva.

### 7. EjemploJComboBox  
Combo de provincias y localidades dependientes. Al cambiar la provincia se actualizan dinámicamente las localidades disponibles.

### 8. EjemploJList  
Selector de materias con transferencia entre listas (disponibles ↔ seleccionadas). Usa DefaultListModel para manipulación dinámica y JScrollPane para listas largas.

### 9. EjemploJMenu  
Editor de texto simple con menú completo: JMenuBar, JMenu, JMenuItem, JCheckBoxMenuItem, separadores, aceleradores de teclado y JOptionPane.

### 10. EjemploLayouts  
Demostración de los cuatro layouts principales organizados en JTabbedPane: BorderLayout (brújula), FlowLayout (calculadora), GridLayout (botones fluidos), GridBagLayout (formulario preciso).

---

## Tecnologías

- **Lenguaje:** Java SE 8+
- **API:** javax.swing, java.awt, java.awt.event
- **IDE recomendado:** NetBeans 8.2+

---

*Proyecto creado para la materia Programación Avanzada — UDA 2026*
