package sistemagestionclientes2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SistemaGestionClientes2 extends JFrame {
    private final ListaClientesDoble listaClientes;
    private final JTextArea areaTexto;
    private final JButton botonInsertar;
    private final JButton botonListarDerecha;
    private final JButton botonListarIzquierda;
    
    public SistemaGestionClientes2() {
        super("Sistema de Gestión de Clientes");
        listaClientes = new ListaClientesDoble();
        
        // Configurar el frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        // Panel para botones
        JPanel panelBotones = new JPanel();
        
        botonInsertar = new JButton("Insertar Cliente");
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioCliente();
            }
        });
        
        botonListarDerecha = new JButton("Listar hacia Derecha");
        botonListarDerecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaDerecha();
            }
        });
        
        botonListarIzquierda = new JButton("Listar hacia Izquierda");
        botonListarIzquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarListaIzquierda();
            }
        });
        
        panelBotones.add(botonInsertar);
        panelBotones.add(botonListarDerecha);
        panelBotones.add(botonListarIzquierda);
        
        // Área de texto para mostrar resultados
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        
        // Añadir componentes al panel principal
        panelPrincipal.add(panelBotones, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        
        // Establecer el contenido del frame
        setContentPane(panelPrincipal);
    }
    
    
    // Muestra el formulario para insertar un nuevo cliente
     
    private void mostrarFormularioCliente() {
        FormularioCliente formulario = new FormularioCliente(this);
        formulario.setVisible(true);
        
        if (formulario.isGuardadoExitoso()) {
            Cliente cliente = formulario.getClienteCreado();
            listaClientes.insertarOrdenado(cliente);
            
            areaTexto.setText("""
                              Cliente insertado correctamente:
                              C\u00e9dula: """ + cliente.getCedula() + "\n" +
                    "Nombre: " + cliente.getNombre());
        }
    }
    
    
     //Muestra la lista de clientes de izquierda a derecha
     
    private void mostrarListaDerecha() {
        String resultado = listaClientes.listarDerecha();
        areaTexto.setText("Lista de Clientes (Izquierda -> Derecha):\n" + resultado);
    }
    
    
     //Muestra la lista de clientes de derecha a izquierda
     
    private void mostrarListaIzquierda() {
        String resultado = listaClientes.listarIzquierda();
        areaTexto.setText("Lista de Clientes (Derecha -> Izquierda):\n" + resultado);
    }
    
  
   // Método principal que inicia la aplicación
    //@param args argumentos de línea de comandos (no utilizados)
     
    public static void main(String[] args) {
        // Configurar look and feel nativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
        
        // Iniciar la aplicación en el EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SistemaGestionClientes2 sistema = new SistemaGestionClientes2();
                sistema.setVisible(true);
            }
        });
    }
}

