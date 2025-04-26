/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemagestionclientesgui;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author USUARIO
 */
public class SistemaGestionClientesGUI extends JFrame{
private ListaClientesDoble listaClientes;
    
    // Componentes de la interfaz
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JButton btnInsertar;
    private JButton btnListarDerecha;
    private JButton btnListarIzquierda;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private JLabel lblEstado;
    
    // Colores pasteles para la interfaz
    private Color colorFondo = new Color(245, 242, 255); // Lavanda pálido
    private Color colorEncabezado = new Color(182, 148, 214); // Lila pastel
    private Color colorFormulario = new Color(231, 218, 252); // Lavanda claro
    private Color colorBotones = new Color(162, 205, 205); // Verde agua pastel
    private Color colorTextoBoton = new Color(50, 50, 50); // Gris oscuro
    private Color colorTabla = new Color(242, 251, 247); // Menta muy claro
    private Color colorFilaImpar = new Color(240, 255, 245); // Verde agua muy claro
    private Color colorFilaPar = new Color(255, 245, 249); // Rosa muy claro
    private Color colorEstado = new Color(225, 237, 255); // Azul pastel claro
    private Color colorBorde = new Color(162, 155, 204); // Púrpura pastel
    
    // Color especial para el botón insertar para hacerlo más visible
    private Color colorBotonInsertar = new Color(250, 129, 112); // Coral pastel
    private Color colorHoverInsertar = new Color(255, 161, 148); // Coral pastel claro
    private Color colorPresionadoInsertar = new Color(225, 95, 80); // Coral pastel oscuro
    
    /**
     * Constructor que inicializa la interfaz gráfica colorida
     */
    public SistemaGestionClientesGUI() {
        listaClientes = new ListaClientesDoble();
        
        // Configuración básica de la ventana
        setTitle("Sistema de Gestión de Clientes");
        setSize(650, 1050);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(colorFondo);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(colorFondo);
        
        // Panel de título
        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo.setBackground(colorEncabezado);
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE CLIENTES");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo);
        
        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(colorBorde, 1, true),
            BorderFactory.createEmptyBorder(0, 0, 0, 0)
        ));
        panelFormulario.setBackground(colorFormulario);
        
        JLabel lblCedula = new JLabel("Cédula:");
        lblCedula.setFont(new Font("Arial", Font.BOLD, 14));
        txtCedula = new JTextField(20);
        txtCedula.setFont(new Font("Arial", Font.PLAIN, 14));
        
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Arial", Font.BOLD, 14));
        txtNombre = new JTextField(20);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 14));
        
        btnInsertar = new JButton("INSERTAR CLIENTE");
        btnInsertar.setFont(new Font("Arial", Font.BOLD, 16));
        btnInsertar.setBackground(colorBotonInsertar);
        btnInsertar.setForeground(Color.BLACK);
        btnInsertar.setFocusPainted(false);
        btnInsertar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createRaisedBevelBorder(),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        
        panelFormulario.add(lblCedula);
        panelFormulario.add(txtCedula);
        panelFormulario.add(lblNombre);
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel()); // Espacio vacío
        panelFormulario.add(btnInsertar);
        
        // Panel de botones
// Panel de botones
JPanel panelBotones = new JPanel(new GridBagLayout());
panelBotones.setBackground(colorFondo);
GridBagConstraints gbc = new GridBagConstraints();
gbc.insets = new Insets(0, 10, 0, 10); // Espaciado entre botones

btnListarDerecha = new JButton("Listar Izquierda → Derecha");
btnListarDerecha.setFont(new Font("Arial", Font.BOLD, 13));
btnListarDerecha.setBackground(colorBotones);
btnListarDerecha.setForeground(colorTextoBoton);
btnListarDerecha.setFocusPainted(false);

btnListarIzquierda = new JButton("Listar Derecha → Izquierda");
btnListarIzquierda.setFont(new Font("Arial", Font.BOLD, 13));
btnListarIzquierda.setBackground(colorBotones);
btnListarIzquierda.setForeground(colorTextoBoton);
btnListarIzquierda.setFocusPainted(false);

// Posición para btnListarDerecha
gbc.gridx = 0;
panelBotones.add(btnListarDerecha, gbc);

// Posición para btnInsertar (en el centro)
gbc.gridx = 1;
panelBotones.add(btnInsertar, gbc);

// Posición para btnListarIzquierda
gbc.gridx = 2;
panelBotones.add(btnListarIzquierda, gbc);

        
        // Panel de tabla
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(colorBorde, 2, true),
                "Lista de Clientes",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14),
                colorBorde
            ),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        panelTabla.setBackground(colorTabla);
        
        // Crear tabla con modelo de datos
        String[] columnas = {"Cédula", "Nombre"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que la tabla no sea editable
            }
        };
        
        tablaClientes = new JTable(modeloTabla);
        tablaClientes.setFont(new Font("Arial", Font.PLAIN, 14));
        tablaClientes.setRowHeight(25);
        tablaClientes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tablaClientes.getTableHeader().setBackground(colorEncabezado);
        tablaClientes.getTableHeader().setForeground(Color.BLACK);
        
        // Colorear filas alternas
        tablaClientes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                if (!isSelected) {
                    component.setBackground(row % 2 == 0 ? colorFilaPar : colorFilaImpar);
                }
                
                return component;
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(tablaClientes);
        panelTabla.add(scrollPane, BorderLayout.CENTER);
        
        // Panel de estado
        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEstado.setBackground(colorEstado);
        lblEstado = new JLabel("Sistema listo. Total clientes: 0");
        lblEstado.setFont(new Font("Arial", Font.BOLD, 12));
        panelEstado.add(lblEstado);
        
        // Agregar paneles al panel principal
        panel.add(panelTitulo, BorderLayout.NORTH);
        panel.add(panelFormulario, BorderLayout.CENTER);
        
        // Panel que contendrá botones y tabla
        JPanel panelInferior = new JPanel(new BorderLayout(0, 10));
        panelInferior.setBackground(colorFondo);
        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(panelTabla, BorderLayout.CENTER);
        
        panel.add(panelInferior, BorderLayout.SOUTH);
        
        // Agregar panel principal a la ventana
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(panelEstado, BorderLayout.SOUTH);
        
        // Configurar eventos
        configurarEventos();
        
        // Efectos visuales para los botones
        configurarEfectos();
    }
    
    /**
     * Configura los efectos visuales para los componentes interactivos
     */
    private void configurarEfectos() {
        // Efecto hover para los botones normales
        MouseAdapter efectoBoton = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton boton = (JButton) e.getSource();
                boton.setBackground(new Color(192, 225, 225)); // Verde agua más claro
                boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton boton = (JButton) e.getSource();
                boton.setBackground(colorBotones);
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                JButton boton = (JButton) e.getSource();
                boton.setBackground(new Color(132, 175, 175)); // Verde agua más oscuro
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                JButton boton = (JButton) e.getSource();
                boton.setBackground(new Color(192, 225, 225)); // Verde agua más claro
            }
        };
        
        // Efecto especial para el botón insertar
        MouseAdapter efectoBotonInsertar = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnInsertar.setBackground(colorHoverInsertar);
                btnInsertar.setCursor(new Cursor(Cursor.HAND_CURSOR));
                // Efecto de sombra al pasar el mouse
                btnInsertar.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createRaisedBevelBorder(),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                btnInsertar.setBackground(colorBotonInsertar);
                // Volver al borde normal
                btnInsertar.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createRaisedBevelBorder(),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));
            }
            
            @Override
            public void mousePressed(MouseEvent e) {
                btnInsertar.setBackground(colorPresionadoInsertar);
                // Efecto de hundido al presionar
                btnInsertar.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLoweredBevelBorder(),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                btnInsertar.setBackground(colorHoverInsertar);
                // Volver al borde elevado
                btnInsertar.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createRaisedBevelBorder(),
                    BorderFactory.createEmptyBorder(5, 15, 5, 15)
                ));
            }
        };
        
        btnInsertar.addMouseListener(efectoBotonInsertar);
        btnListarDerecha.addMouseListener(efectoBoton);
        btnListarIzquierda.addMouseListener(efectoBoton);
    }
    
    /**
     * Configura los listeners para los eventos de la interfaz
     */
    private void configurarEventos() {
        // Evento del botón Insertar
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarCliente();
            }
        });
        
        // Evento del botón Listar Derecha
        btnListarDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarClientesDerecha();
            }
        });
        
        // Evento del botón Listar Izquierda
        btnListarIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarClientesIzquierda();
            }
        });
        
        // Eventos para facilitar el uso de la aplicación
        txtCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtNombre.requestFocus();
                }
            }
        });
        
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    insertarCliente();
                }
            }
        });
    }
    
    /**
     * Inserta un nuevo cliente en la lista
     */
    private void insertarCliente() {
        String cedula = txtCedula.getText().trim();
        String nombre = txtNombre.getText().trim();
        
        // Validar datos
        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Por favor, complete todos los campos", 
                "Error de validación", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Crear y insertar el cliente
        Cliente nuevoCliente = new Cliente(cedula, nombre);
        listaClientes.insertarOrdenado(nuevoCliente);
        
        // Actualizar interfaz
        txtCedula.setText("");
        txtNombre.setText("");
        txtCedula.requestFocus();
        
        // Mostrar animación de éxito (cambio de color en la etiqueta de estado)
        mostrarAnimacionExito();
        
        // Actualizar estado
        actualizarEstado("Cliente insertado correctamente. Total clientes: " + listaClientes.getTamaño());
        
        // Mostrar la lista actualizada
        listarClientesDerecha();
    }
    
    /**
     * Muestra una animación simple de éxito en la etiqueta de estado
     */
    private void mostrarAnimacionExito() {
        final Timer timer = new Timer(150, null);
        final Color colorOriginal = lblEstado.getForeground();
        final Color colorExito = new Color(93, 173, 117); // Verde pastel
        final int[] contador = {0};
        
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contador[0]++;
                if (contador[0] % 2 == 1) {
                    lblEstado.setForeground(colorExito);
                } else {
                    lblEstado.setForeground(colorOriginal);
                }
                
                if (contador[0] >= 6) {
                    timer.stop();
                    lblEstado.setForeground(colorOriginal);
                }
            }
        });
        
        timer.start();
    }
    
    /**
     * Muestra los clientes de izquierda a derecha en la tabla
     */
    private void listarClientesDerecha() {
        // Limpiar tabla
        modeloTabla.setRowCount(0);
        
        // Obtener datos
        Object[][] datos = listaClientes.getDatosTabla();
        
        // Agregar filas al modelo
        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }
        
        // Actualizar título de la tabla
        TitledBorder borde = (TitledBorder) ((JPanel)tablaClientes.getParent().getParent()).getBorder();
        borde.setTitle("Lista de Clientes (Izquierda → Derecha)");
        repaint();
        
        // Actualizar estado
        actualizarEstado("Mostrando clientes de izquierda a derecha. Total: " + listaClientes.getTamaño());
    }
    
    /**
     * Muestra los clientes de derecha a izquierda en la tabla
     */
    private void listarClientesIzquierda() {
        // Limpiar tabla
        modeloTabla.setRowCount(0);
        
        // Obtener datos
        Object[][] datos = listaClientes.getDatosTablaInverso();
        
        // Agregar filas al modelo
        for (Object[] fila : datos) {
            modeloTabla.addRow(fila);
        }
        
        // Actualizar título de la tabla
        TitledBorder borde = (TitledBorder) ((JPanel)tablaClientes.getParent().getParent()).getBorder();
        borde.setTitle("Lista de Clientes (Derecha → Izquierda)");
        repaint();
        
        // Actualizar estado
        actualizarEstado("Mostrando clientes de derecha a izquierda. Total: " + listaClientes.getTamaño());
    }
    
    /**
     * Actualiza el texto de la barra de estado
     * @param mensaje Mensaje a mostrar en la barra de estado
     */
    private void actualizarEstado(String mensaje) {
        lblEstado.setText(mensaje);
    }
    public static void main(String[] args) {
       try {
            // Establecer el look and feel del sistema operativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Crear y mostrar la ventana de la aplicación
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SistemaGestionClientesGUI app = new SistemaGestionClientesGUI();
                app.setVisible(true);
            }
        });
    }
}