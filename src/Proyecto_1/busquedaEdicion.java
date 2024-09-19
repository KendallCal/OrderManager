//Busqueda y Eidición de los Pedidos
package Proyecto_1;

//Imports.
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class busquedaEdicion extends javax.swing.JPanel {

    //Arreglo para los Pedidos.
    private ArrayList<Pedido> pedidos;

    //Lista para los errores.
    private List<String> errores = new ArrayList<>();

    //Pedido actualmente seleccionado
    private Pedido pedidoSeleccionado;

    //Constructor.
    public busquedaEdicion(ArrayList<Pedido> listaPedidos) {
        //Instancia los pedidos.
        this.pedidos = listaPedidos;

        //Inicializa los componentes.
        initComponents();

        //Carga el mouse listener de la tabla para seleccionar una fila.
        tablaListaPedidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Verifica si se hizo doble clic-
                if (e.getClickCount() == 2) {
                    
                    //Obtiene la fila seleccionada en la tabla.
                    int filaSeleccionada = tablaListaPedidos.getSelectedRow();
                    
                    //Verifica si se seleccionó alguna fila.
                    if (filaSeleccionada != -1) {
                        
                        //Obtiene el ID del pedido seleccionado en la tabla.
                        int idPedido = (int) tablaListaPedidos.getValueAt(filaSeleccionada, 0);
                        
                        //Busca el pedido correspondiente en la lista de pedidos.
                        pedidoSeleccionado = buscarPedidoPorID(idPedido);
                        
                        //Actualiza los campos del formulario con los datos del pedido seleccionado.
                        actualizarCamposDesdePedido();
                    }
                }
            }
        });
    }

    //Método para buscar el Pedido por su ID.
    private Pedido buscarPedidoPorID(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
    
    //Método para actualizar los campos del formulario con los datos del pedido seleccionado.
    private void actualizarCamposDesdePedido() {
        if (pedidoSeleccionado != null) {
            ID.setText(String.valueOf(pedidoSeleccionado.getId()));
            tipoCamiseta.setSelectedItem(pedidoSeleccionado.getTipoCamiseta());
            talla.setSelectedItem(pedidoSeleccionado.getTalla());
            cantidad.setText(String.valueOf(pedidoSeleccionado.getCantidad()));
            codigo.setText(pedidoSeleccionado.getCodigoDiseño());
            tipoPedido.setSelectedItem(pedidoSeleccionado.getTipoPedido());
            direccion.setText(pedidoSeleccionado.getDireccionEntrega());
            formaPago.setSelectedItem(pedidoSeleccionado.getFormaPago());
            telefono1.setText(pedidoSeleccionado.getTelefonoCliente());
            nombre.setText(pedidoSeleccionado.getNombreCliente());
        }
    }
    
    //Método para devolver el pedido al Menu.
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    /* - - - - - - - - - - - - - - - - - - Métodos para Validación - - - - - - - - - - - - - - - - - - */
    //Método para validar todos los campos.
    private void validarCampos() {
        String tipoPedidoString = tipoPedido.getSelectedItem().toString();        

        //Limpia la lista antes de verificar.
        errores.clear();

        //Llama cada método de validación.
        validaCantidad(errores);
        validaCodigo(errores);
        if (tipoPedidoString == "Envío a domicilio") {
            validaDireccion(errores);
        }
        validaTelefono(errores);
        validaNombre(errores);

        //Muestra los errores.
        if (!errores.isEmpty()) {
            mostrarErrores(errores);
        }
    }

    //Método para mostrar los errores.
    private void mostrarErrores(List<String> errores) {
        StringBuilder mensajeError = new StringBuilder("Se encontraron los siguientes errores:\n");

        //Recorre el arreglo y muestra los errores.
        for (String error : errores) {
            mensajeError.append("- ").append(error).append("\n");
        }

        //Muestra el JOptionPanel de los erroe¿res.
        JOptionPane.showMessageDialog(this, mensajeError.toString(), "Errores de validación.", JOptionPane.ERROR_MESSAGE);
    }

    //Método para validar la Cantidad.
    private boolean validaCantidad(List<String> errores) {
        String cantidadString = cantidad.getText();

        //Verifica si el campo de cantidad está vacío.
        if (cantidadString.isEmpty()) {
            errores.add("El campo Cantidad no puede estar vacío.");
            resaltarBordeError(cantidad);
            return false;
        }

        //Verifica si la cantidad es un número entero de 1 o 2 dígitos.
        if (!cantidadString.matches("\\d{1,2}")) {
            errores.add("La cantidad debe ser un número entero de 1 o 2 dígitos.");
            resaltarBordeError(cantidad);
            return false;
        }

        //Verifica si la cantidad es un número entero y mayor a cero.
        if (!cantidadString.matches("\\d+") || Integer.parseInt(cantidadString) <= 0) {
            errores.add("La cantidad debe ser un número entero válido y mayor a cero.");
            resaltarBordeError(cantidad);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(cantidad);
        return true;
    }

    //Método para validar el Código de Diseño.
    private boolean validaCodigo(List<String> errores) {
        String codigoText = codigo.getText();

        //Verifica si el campo de Código de Diseño está vacío.
        if (codigoText.isEmpty()) {
            errores.add("El campo Código de Diseño no puede estar vacío.");
            resaltarBordeError(codigo);
            return false;
        }

        //Verifica que sea un código alfanumerico.
        if (!codigoText.matches("[a-zA-Z0-9]+")) {
            errores.add("El Código de Diseño debe contener solo letras y números.");
            resaltarBordeError(codigo);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(codigo);
        return true;
    }

    //Método para validar la Dirección.
    private boolean validaDireccion(List<String> errores) {
        String direccionText = direccion.getText();

        //Verifica si el campo de Dirección está vacío.
        if (direccionText.isEmpty()) {
            errores.add("El campo Dirección no puede estar vacío.");
            resaltarBordeError(direccion);
            return false;
        }

        //Verifica que pueda tener letras, numeros, tildes, comas y puntos.
        if (!direccionText.matches("[a-zA-Z0-9ÁÉÍÓÚáéíóú,. ñ]+")) {
            errores.add("La Dirección solo tener letras, números, tildes, comas y puntos.");
            resaltarBordeError(direccion);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(direccion);
        return true;
    }

    //Método para validar el Número de Teléfono.
    private boolean validaTelefono(List<String> errores) {
        String telefonoText = telefono1.getText();

        //Verifica si el campo de Teléfono está vacío.
        if (telefonoText.isEmpty()) {
            errores.add("El campo Teléfono no puede estar vacío.");
            resaltarBordeError(telefono1);
            return false;
        }

        // Verifica que el campo tenga exactamente 8 dígitos numéricos.
        if (!telefonoText.matches("\\d{8}")) {
            errores.add("El número de teléfono debe tener exactamente números.");
            resaltarBordeError(telefono1);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(telefono1);
        return true;
    }

    //Método para validar el Nombre.
    private boolean validaNombre(List<String> errores) {
        String nombreText = nombre.getText();

        //Verifica si el campo de Nombre está vacío.
        if (nombreText.isEmpty()) {
            errores.add("El campo Nombre no puede estar vacío.");
            resaltarBordeError(nombre);
            return false;
        }

        //Verifica que pueda tener letras, numeros, tildes.
        if (!nombreText.matches("[a-zA-Z0-9ÁÉÍÓÚáéíóúñ ]+")) {
            errores.add("El Nombre solo puede contener letras y letras.");
            resaltarBordeError(nombre);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(nombre);
        return true;
    }

    //Método para resaltar los bordes del JTextField.
    private void resaltarBordeError(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(Color.RED));
    }

    //Método para restaurar los bordes del JTextField.
    private void restaurarBordeOriginal(JTextField textField) {
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBustarTeledono = new javax.swing.JPanel();
        panelTelefono = new javax.swing.JPanel();
        textoTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        panelBuscarBTN = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaPedidos = new javax.swing.JTable();
        panelDatos = new javax.swing.JPanel();
        panelID = new javax.swing.JPanel();
        textoID = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        panelTipoCamiseta = new javax.swing.JPanel();
        textoTipoCamiseta = new javax.swing.JLabel();
        tipoCamiseta = new javax.swing.JComboBox<>();
        panelTalla = new javax.swing.JPanel();
        textoTalla = new javax.swing.JLabel();
        talla = new javax.swing.JComboBox<>();
        panelCantidad = new javax.swing.JPanel();
        textoCantidad = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        panelCodigo = new javax.swing.JPanel();
        textoCodigo = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        panelTipoPedido = new javax.swing.JPanel();
        textoTipoPedido = new javax.swing.JLabel();
        tipoPedido = new javax.swing.JComboBox<>();
        panelDireccion = new javax.swing.JPanel();
        textoDireccion = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        panelFormaPago = new javax.swing.JPanel();
        textoFormaPago = new javax.swing.JLabel();
        formaPago = new javax.swing.JComboBox<>();
        panelTelefono1 = new javax.swing.JPanel();
        textoTelefono1 = new javax.swing.JLabel();
        telefono1 = new javax.swing.JTextField();
        panelNombre = new javax.swing.JPanel();
        textoNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        panelBoton = new javax.swing.JPanel();
        panelGuardarBTN = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();

        setMaximumSize(new java.awt.Dimension(720, 580));
        setMinimumSize(new java.awt.Dimension(720, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(0, 153, 153));

        panelBustarTeledono.setOpaque(false);
        panelBustarTeledono.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 125, 5));

        panelTelefono.setOpaque(false);
        panelTelefono.setPreferredSize(new java.awt.Dimension(220, 65));

        textoTelefono.setBackground(new java.awt.Color(0, 0, 0));
        textoTelefono.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoTelefono.setForeground(new java.awt.Color(255, 255, 255));
        textoTelefono.setText("Telefono del Cliente");
        textoTelefono.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTelefono.add(textoTelefono);

        telefono.setBackground(new java.awt.Color(242, 242, 242));
        telefono.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(60, 63, 65));
        telefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        telefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        telefono.setCaretColor(new java.awt.Color(102, 102, 102));
        telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        telefono.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        telefono.setMargin(new java.awt.Insets(20, 20, 20, 20));
        telefono.setPreferredSize(new java.awt.Dimension(180, 25));
        telefono.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        telefono.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelTelefono.add(telefono);

        panelBustarTeledono.add(panelTelefono);

        panelBuscarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelBuscarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelBuscarBTN.setPreferredSize(new java.awt.Dimension(100, 35));
        panelBuscarBTN.setLayout(new java.awt.BorderLayout());

        btnBuscar.setBackground(new java.awt.Color(242, 242, 242));
        btnBuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMouseExited(evt);
            }
        });
        panelBuscarBTN.add(btnBuscar, java.awt.BorderLayout.CENTER);

        panelBustarTeledono.add(panelBuscarBTN);

        tablaListaPedidos.setBackground(new java.awt.Color(242, 242, 242));
        tablaListaPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaListaPedidos.setForeground(new java.awt.Color(60, 63, 65));
        tablaListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Camiseta", "Talla", "Cantidad", "Codigo", "Pedido", "Dirección", "Forma de Pago", "Teléfono", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListaPedidos.setRowHeight(23);
        tablaListaPedidos.setShowHorizontalLines(true);
        tablaListaPedidos.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaListaPedidos);

        panelDatos.setOpaque(false);
        panelDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        panelID.setOpaque(false);
        panelID.setPreferredSize(new java.awt.Dimension(220, 65));

        textoID.setBackground(new java.awt.Color(0, 0, 0));
        textoID.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoID.setForeground(new java.awt.Color(255, 255, 255));
        textoID.setText("ID del Pedido");
        textoID.setPreferredSize(new java.awt.Dimension(180, 25));
        panelID.add(textoID);

        ID.setBackground(new java.awt.Color(242, 242, 242));
        ID.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(60, 63, 65));
        ID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ID.setCaretColor(new java.awt.Color(102, 102, 102));
        ID.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ID.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        ID.setEnabled(false);
        ID.setMargin(new java.awt.Insets(20, 50, 20, 20));
        ID.setPreferredSize(new java.awt.Dimension(180, 25));
        ID.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        ID.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelID.add(ID);

        panelDatos.add(panelID);

        panelTipoCamiseta.setOpaque(false);
        panelTipoCamiseta.setPreferredSize(new java.awt.Dimension(220, 65));

        textoTipoCamiseta.setBackground(new java.awt.Color(0, 0, 0));
        textoTipoCamiseta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoTipoCamiseta.setForeground(new java.awt.Color(255, 255, 255));
        textoTipoCamiseta.setText("Tipo de Camiseta");
        textoTipoCamiseta.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTipoCamiseta.add(textoTipoCamiseta);

        tipoCamiseta.setBackground(new java.awt.Color(242, 242, 242));
        tipoCamiseta.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tipoCamiseta.setForeground(new java.awt.Color(0, 0, 0));
        tipoCamiseta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lisa manga larga", "Polo manga corta", "Estampado manga corta", "Lisa manga corta", "Deportiva manga larga", "Deportiva manga corta", "Deportiva sin mangas" }));
        tipoCamiseta.setEnabled(false);
        tipoCamiseta.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTipoCamiseta.add(tipoCamiseta);

        panelDatos.add(panelTipoCamiseta);

        panelTalla.setOpaque(false);
        panelTalla.setPreferredSize(new java.awt.Dimension(220, 65));

        textoTalla.setBackground(new java.awt.Color(0, 0, 0));
        textoTalla.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoTalla.setForeground(new java.awt.Color(255, 255, 255));
        textoTalla.setText("Talla");
        textoTalla.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTalla.add(textoTalla);

        talla.setBackground(new java.awt.Color(242, 242, 242));
        talla.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        talla.setForeground(new java.awt.Color(0, 0, 0));
        talla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "2XL" }));
        talla.setEnabled(false);
        talla.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTalla.add(talla);

        panelDatos.add(panelTalla);

        panelCantidad.setOpaque(false);
        panelCantidad.setPreferredSize(new java.awt.Dimension(220, 65));

        textoCantidad.setBackground(new java.awt.Color(0, 0, 0));
        textoCantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoCantidad.setForeground(new java.awt.Color(255, 255, 255));
        textoCantidad.setText("Cantidad");
        textoCantidad.setPreferredSize(new java.awt.Dimension(180, 25));
        panelCantidad.add(textoCantidad);

        cantidad.setBackground(new java.awt.Color(242, 242, 242));
        cantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cantidad.setForeground(new java.awt.Color(60, 63, 65));
        cantidad.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        cantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cantidad.setCaretColor(new java.awt.Color(102, 102, 102));
        cantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        cantidad.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        cantidad.setEnabled(false);
        cantidad.setMargin(new java.awt.Insets(20, 20, 20, 20));
        cantidad.setPreferredSize(new java.awt.Dimension(180, 25));
        cantidad.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        cantidad.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelCantidad.add(cantidad);

        panelDatos.add(panelCantidad);

        panelCodigo.setOpaque(false);
        panelCodigo.setPreferredSize(new java.awt.Dimension(220, 65));

        textoCodigo.setBackground(new java.awt.Color(0, 0, 0));
        textoCodigo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoCodigo.setForeground(new java.awt.Color(255, 255, 255));
        textoCodigo.setText("Código de Diseño");
        textoCodigo.setPreferredSize(new java.awt.Dimension(180, 25));
        panelCodigo.add(textoCodigo);

        codigo.setBackground(new java.awt.Color(242, 242, 242));
        codigo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        codigo.setForeground(new java.awt.Color(60, 63, 65));
        codigo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        codigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        codigo.setCaretColor(new java.awt.Color(102, 102, 102));
        codigo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        codigo.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        codigo.setEnabled(false);
        codigo.setMargin(new java.awt.Insets(20, 20, 20, 20));
        codigo.setPreferredSize(new java.awt.Dimension(180, 25));
        codigo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        codigo.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelCodigo.add(codigo);

        panelDatos.add(panelCodigo);

        panelTipoPedido.setOpaque(false);
        panelTipoPedido.setPreferredSize(new java.awt.Dimension(220, 65));

        textoTipoPedido.setBackground(new java.awt.Color(0, 0, 0));
        textoTipoPedido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoTipoPedido.setForeground(new java.awt.Color(255, 255, 255));
        textoTipoPedido.setText("Tipo de Pedido");
        textoTipoPedido.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTipoPedido.add(textoTipoPedido);

        tipoPedido.setBackground(new java.awt.Color(242, 242, 242));
        tipoPedido.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tipoPedido.setForeground(new java.awt.Color(0, 0, 0));
        tipoPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recoger en tienda", "Envío a domicilio" }));
        tipoPedido.setEnabled(false);
        tipoPedido.setPreferredSize(new java.awt.Dimension(180, 25));
        tipoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPedidoActionPerformed(evt);
            }
        });
        panelTipoPedido.add(tipoPedido);

        panelDatos.add(panelTipoPedido);

        panelDireccion.setOpaque(false);
        panelDireccion.setPreferredSize(new java.awt.Dimension(220, 65));

        textoDireccion.setBackground(new java.awt.Color(0, 0, 0));
        textoDireccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoDireccion.setForeground(new java.awt.Color(255, 255, 255));
        textoDireccion.setText("Dirección de Entrega");
        textoDireccion.setPreferredSize(new java.awt.Dimension(180, 25));
        panelDireccion.add(textoDireccion);

        direccion.setBackground(new java.awt.Color(242, 242, 242));
        direccion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        direccion.setForeground(new java.awt.Color(60, 63, 65));
        direccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        direccion.setCaretColor(new java.awt.Color(102, 102, 102));
        direccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        direccion.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        direccion.setEnabled(false);
        direccion.setMargin(new java.awt.Insets(20, 20, 20, 20));
        direccion.setPreferredSize(new java.awt.Dimension(180, 25));
        direccion.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        direccion.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelDireccion.add(direccion);

        panelDatos.add(panelDireccion);

        panelFormaPago.setOpaque(false);
        panelFormaPago.setPreferredSize(new java.awt.Dimension(220, 65));

        textoFormaPago.setBackground(new java.awt.Color(0, 0, 0));
        textoFormaPago.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoFormaPago.setForeground(new java.awt.Color(255, 255, 255));
        textoFormaPago.setText("Forma de Pago");
        textoFormaPago.setPreferredSize(new java.awt.Dimension(180, 25));
        panelFormaPago.add(textoFormaPago);

        formaPago.setBackground(new java.awt.Color(242, 242, 242));
        formaPago.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        formaPago.setForeground(new java.awt.Color(0, 0, 0));
        formaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Sinpe móvil", "Transferencia bancaria", "Tarjeta de débito/crédito" }));
        formaPago.setEnabled(false);
        formaPago.setPreferredSize(new java.awt.Dimension(180, 25));
        panelFormaPago.add(formaPago);

        panelDatos.add(panelFormaPago);

        panelTelefono1.setOpaque(false);
        panelTelefono1.setPreferredSize(new java.awt.Dimension(220, 65));

        textoTelefono1.setBackground(new java.awt.Color(0, 0, 0));
        textoTelefono1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoTelefono1.setForeground(new java.awt.Color(255, 255, 255));
        textoTelefono1.setText("Telefono del Cliente");
        textoTelefono1.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTelefono1.add(textoTelefono1);

        telefono1.setBackground(new java.awt.Color(242, 242, 242));
        telefono1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        telefono1.setForeground(new java.awt.Color(60, 63, 65));
        telefono1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        telefono1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        telefono1.setCaretColor(new java.awt.Color(102, 102, 102));
        telefono1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        telefono1.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        telefono1.setEnabled(false);
        telefono1.setMargin(new java.awt.Insets(20, 20, 20, 20));
        telefono1.setPreferredSize(new java.awt.Dimension(180, 25));
        telefono1.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        telefono1.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelTelefono1.add(telefono1);

        panelDatos.add(panelTelefono1);

        panelNombre.setOpaque(false);
        panelNombre.setPreferredSize(new java.awt.Dimension(220, 65));

        textoNombre.setBackground(new java.awt.Color(0, 0, 0));
        textoNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoNombre.setForeground(new java.awt.Color(255, 255, 255));
        textoNombre.setText("Nombre del Cliente");
        textoNombre.setPreferredSize(new java.awt.Dimension(180, 25));
        panelNombre.add(textoNombre);

        nombre.setBackground(new java.awt.Color(242, 242, 242));
        nombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(60, 63, 65));
        nombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nombre.setCaretColor(new java.awt.Color(102, 102, 102));
        nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nombre.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        nombre.setEnabled(false);
        nombre.setMargin(new java.awt.Insets(20, 20, 20, 20));
        nombre.setPreferredSize(new java.awt.Dimension(180, 25));
        nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        nombre.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelNombre.add(nombre);

        panelDatos.add(panelNombre);

        panelBoton.setOpaque(false);
        panelBoton.setPreferredSize(new java.awt.Dimension(220, 65));
        panelBoton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 13));

        panelGuardarBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelGuardarBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelGuardarBTN.setPreferredSize(new java.awt.Dimension(150, 40));
        panelGuardarBTN.setLayout(new java.awt.BorderLayout());

        btnGuardar.setBackground(new java.awt.Color(242, 242, 242));
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setEnabled(false);
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        panelGuardarBTN.add(btnGuardar, java.awt.BorderLayout.CENTER);

        panelBoton.add(panelGuardarBTN);

        panelDatos.add(panelBoton);

        titulo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 51, 51));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Seleccione un pedido para editar");

        titulo1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        titulo1.setForeground(new java.awt.Color(51, 51, 51));
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Editar Pedido");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(panelBustarTeledono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(separador1)
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(separador2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addComponent(titulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBustarTeledono, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(titulo)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(separador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    //- - - - - - - - - - - - - - - - - - - - - - - Diseños - - - - - - - - - - - - - - - - - - - - - - -//
    //Diseño del botón Buscar.
    private void btnBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseEntered
        panelBuscarBTN.setBackground(new Color(60, 63, 65));
        btnBuscar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnBuscarMouseEntered

    private void btnBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseExited
        panelBuscarBTN.setBackground(new Color(255, 255, 255));
        btnBuscar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnBuscarMouseExited

    //Diseño del botón Guardar.
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        if (btnGuardar.isEnabled()) {
            panelGuardarBTN.setBackground(new Color(93, 196, 96));
            btnGuardar.setForeground(new Color(0, 0, 0));
        }
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        panelGuardarBTN.setBackground(new Color(255, 255, 255));
        btnGuardar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnGuardarMouseExited

    //- - - - - - - - - - - - - - - - - - - - - - - Acción de Botones - - - - - - - - - - - - - - - - - - - - - - -//
    //Acción del botón Buscar.
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        String telefonoText = telefono.getText();

        //Limpia la lista antes de verificar.
        errores.clear();

        //Verifica si el campo de Teléfono está vacío.
        if (telefonoText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo Teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            resaltarBordeError(telefono);
        } else if (!telefonoText.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(null, "El número de teléfono debe tener exactamente 8 números.", "Error", JOptionPane.ERROR_MESSAGE);
            resaltarBordeError(telefono);
        } else {
            //Restaura el borde.
            restaurarBordeOriginal(telefono);

            //Obtiene el modelo de tabla.
            DefaultTableModel model = (DefaultTableModel) tablaListaPedidos.getModel();

            //Reinicia el número de filas a 0.
            model.setRowCount(0);

            //Agrega el Pedido a la lista según el teléfono.
            for (Pedido pedido : pedidos) {
                if (pedido.getTelefonoCliente().equals(telefonoText)) {
                    model.addRow(new Object[]{
                        pedido.getId(),
                        pedido.getTipoCamiseta(),
                        pedido.getTalla(),
                        pedido.getCantidad(),
                        pedido.getCodigoDiseño(),
                        pedido.getTipoPedido(),
                        pedido.getDireccionEntrega(),
                        pedido.getFormaPago(),
                        pedido.getTelefonoCliente(),
                        pedido.getNombreCliente()
                    });
                }
            }

            //Habilita los botones.
            tipoCamiseta.setEnabled(true);
            talla.setEnabled(true);
            cantidad.setEnabled(true);
            codigo.setEnabled(true);
            tipoPedido.setEnabled(true);
            formaPago.setEnabled(true);
            telefono1.setEnabled(true);
            nombre.setEnabled(true);
            btnGuardar.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

    //Acción del botón Guardar.
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        if (btnGuardar.isEnabled()) {
            //Valida los campos.
            validarCampos();

            //Si no hay errores sigue.
            if (errores.isEmpty()) {
                //Si no se ha seleccionado ningún pedido muestra el error.
                if (pedidoSeleccionado == null) {
                    JOptionPane.showMessageDialog(this, "Por favor, seleccione un pedido para editar.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                //Actualiza los campos del pedido seleccionado con los valores del formulario
                pedidoSeleccionado.setTipoCamiseta((String) tipoCamiseta.getSelectedItem());
                pedidoSeleccionado.setTalla((String) talla.getSelectedItem());
                pedidoSeleccionado.setCantidad(Integer.parseInt(cantidad.getText()));
                pedidoSeleccionado.setCodigoDiseño(codigo.getText());
                pedidoSeleccionado.setTipoPedido((String) tipoPedido.getSelectedItem());
                pedidoSeleccionado.setDireccionEntrega(direccion.getText());
                pedidoSeleccionado.setFormaPago((String) formaPago.getSelectedItem());
                pedidoSeleccionado.setTelefonoCliente(telefono1.getText());
                pedidoSeleccionado.setNombreCliente(nombre.getText());

                //Limpiar los campos.
                limpiarCampos();

                //Deshabilita los campos.
                tipoCamiseta.setEnabled(false);
                talla.setEnabled(false);
                cantidad.setEnabled(false);
                codigo.setEnabled(false);
                tipoPedido.setEnabled(false);
                direccion.setEnabled(false);
                formaPago.setEnabled(false);
                telefono1.setEnabled(false);
                nombre.setEnabled(false);
                btnGuardar.setEnabled(false);

                //Limpiar el JTable.
                DefaultTableModel model = (DefaultTableModel) tablaListaPedidos.getModel();
                model.setRowCount(0);

                //Mensaje de éxito.
                JOptionPane.showMessageDialog(this, "Pedido actualizado exitosamente.");
            }
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    //Habilita la dirección si se elige enviar a domocilio.
    private void tipoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPedidoActionPerformed
        String tipoPedidoString = tipoPedido.getSelectedItem().toString();
        
        if (tipoPedidoString == "Envío a domicilio") {
            direccion.setEnabled(true);
        }
    }//GEN-LAST:event_tipoPedidoActionPerformed

    //Método para limpiar los campos.
    private void limpiarCampos() {
        ID.setText("");
        tipoCamiseta.setSelectedIndex(0);
        talla.setSelectedIndex(0);
        cantidad.setText("");
        codigo.setText("");
        tipoPedido.setSelectedIndex(0);
        direccion.setText("");
        formaPago.setSelectedIndex(0);
        telefono.setText("");
        telefono1.setText("");
        nombre.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> formaPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombre;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelBuscarBTN;
    private javax.swing.JPanel panelBustarTeledono;
    private javax.swing.JPanel panelCantidad;
    private javax.swing.JPanel panelCodigo;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelDireccion;
    private javax.swing.JPanel panelFormaPago;
    private javax.swing.JPanel panelGuardarBTN;
    private javax.swing.JPanel panelID;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTalla;
    private javax.swing.JPanel panelTelefono;
    private javax.swing.JPanel panelTelefono1;
    private javax.swing.JPanel panelTipoCamiseta;
    private javax.swing.JPanel panelTipoPedido;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador2;
    private javax.swing.JTable tablaListaPedidos;
    private javax.swing.JComboBox<String> talla;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField telefono1;
    private javax.swing.JLabel textoCantidad;
    private javax.swing.JLabel textoCodigo;
    private javax.swing.JLabel textoDireccion;
    private javax.swing.JLabel textoFormaPago;
    private javax.swing.JLabel textoID;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoTalla;
    private javax.swing.JLabel textoTelefono;
    private javax.swing.JLabel textoTelefono1;
    private javax.swing.JLabel textoTipoCamiseta;
    private javax.swing.JLabel textoTipoPedido;
    private javax.swing.JComboBox<String> tipoCamiseta;
    private javax.swing.JComboBox<String> tipoPedido;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    // End of variables declaration//GEN-END:variables
}
