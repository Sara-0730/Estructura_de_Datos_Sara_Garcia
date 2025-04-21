package sistemagestionclientes2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Clase para el formulario de ingreso de clientes
 */
class FormularioCliente extends JDialog {
    private final JTextField campoCedula;
    private final JTextField campoNombre;
    private final JButton botonGuardar;
    private final JButton botonCancelar;
    private boolean guardadoExitoso = false;
    private Cliente clienteCreado = null;
    
    /**
     * Constructor del formulario
     * @param parent Ventana padre
     */
    public FormularioCliente(JFrame parent) {
        super(parent, "Ingresar Cliente", true);
        
        // Configurar componentes
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Etiqueta y campo para cédula
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Cédula:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        campoCedula = new JTextField(15);
        panel.add(campoCedula, gbc);
        
        // Etiqueta y campo para nombre
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nombre:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        campoNombre = new JTextField(15);
        panel.add(campoNombre, gbc);
        
        // Panel para botones
        JPanel panelBotones = new JPanel();
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarCliente();
            }
        });
        
        botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        panelBotones.add(botonGuardar);
        panelBotones.add(botonCancelar);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(panelBotones, gbc);
        
        // Configurar el diálogo
        setContentPane(panel);
        pack();
        setLocationRelativeTo(parent);
        setResizable(false);
    }
    
    /**
     * Valida y guarda los datos del cliente
     */
    private void guardarCliente() {
        String cedula = campoCedula.getText().trim();
        String nombre = campoNombre.getText().trim();
        
        // Validaciones
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La cédula no puede estar vacía.", 
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            campoCedula.requestFocus();
            return;
        }
        
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", 
                    "Error de validación", JOptionPane.ERROR_MESSAGE);
            campoNombre.requestFocus();
            return;
        }
        
        // Crear el cliente
        clienteCreado = new Cliente(cedula, nombre);
        guardadoExitoso = true;
        dispose();
    }
    
    /**
     * Verifica si el cliente se guardó exitosamente
     * @return true si se guardó, false si se canceló
     */
    public boolean isGuardadoExitoso() {
        return guardadoExitoso;
    }
    
    /**
     * Obtiene el cliente creado
     * @return Cliente creado o null si se canceló
     */
    public Cliente getClienteCreado() {
        return clienteCreado;
    }
}