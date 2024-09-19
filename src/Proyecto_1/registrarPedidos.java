
//Registrar Pedidos.

package Proyecto_1;

//Imports.
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registrarPedidos extends javax.swing.JPanel {

    //Arreglo para los Pedidos.
    private ArrayList<Pedido> pedidos;
    
    //Lista para los errores.
    private List<String> errores = new ArrayList<>();

    //Constructor.
    public registrarPedidos(ArrayList<Pedido> listaPedidos) {
        //Instancia los pedidos.
        this.pedidos = listaPedidos;
        
        //Inicializa los componentes.
        initComponents();

        //Actuliza el ID en el JTextField.
        actualizarID();
    }

    //Método para actualizar las ID.
    private void actualizarID() {
        int nuevoID = pedidos.size() + 1;
        ID.setText(String.valueOf(nuevoID));
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
        String telefonoText = telefono.getText();

        //Verifica si el campo de Teléfono está vacío.
        if (telefonoText.isEmpty()) {
            errores.add("El campo Teléfono no puede estar vacío.");
            resaltarBordeError(telefono);
            return false;
        }

        // Verifica que el campo tenga exactamente 8 dígitos numéricos.
        if (!telefonoText.matches("\\d{8}")) {
            errores.add("El número de teléfono debe tener exactamente números.");
            resaltarBordeError(telefono);
            return false;
        }

        //Restaura el borde.
        restaurarBordeOriginal(telefono);
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
        if (!nombreText.matches("[a-zA-Z0-9ÁÉÍÓÚáéíóú ñ]+")) {
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
        panelDatos = new javax.swing.JPanel();
        panelID = new javax.swing.JPanel();
        textoID = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        panelTipoPedido = new javax.swing.JPanel();
        textoTipoPedido = new javax.swing.JLabel();
        tipoPedido = new javax.swing.JComboBox<>();
        panelTipoCamiseta = new javax.swing.JPanel();
        textoTipoCamiseta = new javax.swing.JLabel();
        tipoCamiseta = new javax.swing.JComboBox<>();
        panelDireccion = new javax.swing.JPanel();
        textoDireccion = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        panelTalla = new javax.swing.JPanel();
        textoTalla = new javax.swing.JLabel();
        talla = new javax.swing.JComboBox<>();
        panelFormaPago = new javax.swing.JPanel();
        textoFormaPago = new javax.swing.JLabel();
        formaPago = new javax.swing.JComboBox<>();
        panelCantidad = new javax.swing.JPanel();
        textoCantidad = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        panelTelefono = new javax.swing.JPanel();
        textoTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        panelCodigo = new javax.swing.JPanel();
        textoCodigo = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        panelNombre = new javax.swing.JPanel();
        textoNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        panelGuardarBTN = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(720, 580));
        setMinimumSize(new java.awt.Dimension(720, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(0, 153, 153));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(720, 589));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(720, 589));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(720, 580));

        panelDatos.setOpaque(false);
        panelDatos.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 90, 25));

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
        tipoPedido.setPreferredSize(new java.awt.Dimension(180, 25));
        tipoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoPedidoActionPerformed(evt);
            }
        });
        panelTipoPedido.add(tipoPedido);

        panelDatos.add(panelTipoPedido);

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
        tipoCamiseta.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTipoCamiseta.add(tipoCamiseta);

        panelDatos.add(panelTipoCamiseta);

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
        direccion.setMargin(new java.awt.Insets(20, 50, 20, 20));
        direccion.setPreferredSize(new java.awt.Dimension(180, 25));
        direccion.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        direccion.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelDireccion.add(direccion);

        panelDatos.add(panelDireccion);

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
        talla.setPreferredSize(new java.awt.Dimension(180, 25));
        panelTalla.add(talla);

        panelDatos.add(panelTalla);

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
        formaPago.setPreferredSize(new java.awt.Dimension(180, 25));
        panelFormaPago.add(formaPago);

        panelDatos.add(panelFormaPago);

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
        cantidad.setMargin(new java.awt.Insets(20, 50, 20, 20));
        cantidad.setPreferredSize(new java.awt.Dimension(180, 25));
        cantidad.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        cantidad.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelCantidad.add(cantidad);

        panelDatos.add(panelCantidad);

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
        telefono.setMargin(new java.awt.Insets(20, 50, 20, 20));
        telefono.setPreferredSize(new java.awt.Dimension(180, 25));
        telefono.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        telefono.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelTelefono.add(telefono);

        panelDatos.add(panelTelefono);

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
        codigo.setMargin(new java.awt.Insets(20, 50, 20, 20));
        codigo.setPreferredSize(new java.awt.Dimension(180, 25));
        codigo.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        codigo.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelCodigo.add(codigo);

        panelDatos.add(panelCodigo);

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
        nombre.setMargin(new java.awt.Insets(20, 50, 20, 20));
        nombre.setPreferredSize(new java.awt.Dimension(180, 25));
        nombre.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        nombre.setSelectionColor(new java.awt.Color(102, 102, 255));
        panelNombre.add(nombre);

        panelDatos.add(panelNombre);

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

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(panelGuardarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelGuardarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    //- - - - - - - - - - - - - - - - - - - - - - - Diseños - - - - - - - - - - - - - - - - - - - - - - -//
    //Diseño del botón Guardar.
    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        panelGuardarBTN.setBackground(new Color(93, 196, 96));
        btnGuardar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        panelGuardarBTN.setBackground(new Color(255, 255, 255));
        btnGuardar.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnGuardarMouseExited

    //- - - - - - - - - - - - - - - - - - - - - Acción de Botones - - - - - - - - - - - - - - - - - - - -//
    //Acción del botón Guardar.
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked

        validarCampos();

        if (errores.isEmpty()) {
            //Captura los datos.
            String tipoCamisetaString = tipoCamiseta.getSelectedItem().toString();
            String tallaString = talla.getSelectedItem().toString();
            int cantidadInt = Integer.parseInt(cantidad.getText());
            String codigoDiseñoString = codigo.getText();
            String tipoPedidoString = tipoPedido.getSelectedItem().toString();
            String direccionEntregaString = direccion.getText();
            String formaPagoString = formaPago.getSelectedItem().toString();
            String telefonoCliente = telefono.getText();
            String nombreCliente = nombre.getText();
        
            //Agrega el pedido.
            Pedido nuevoPedido = new Pedido(tipoCamisetaString, tallaString, cantidadInt, codigoDiseñoString, tipoPedidoString, direccionEntregaString, formaPagoString, telefonoCliente, nombreCliente);

            //Añade el pedido.
            pedidos.add(nuevoPedido);

            //Muestra que se agrego el pedido correctamente.
            JOptionPane.showMessageDialog(this, "Pedido guardado con éxito. ID: " + nuevoPedido.getId());

            //Actualiza el ID para mostrarlo.
            actualizarID();

            //Limpiar los campos después de guardar
            limpiarCampos();
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    //Para validar que si es envio a domicilio se active el textfield de dirección.
    private void tipoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoPedidoActionPerformed
        String tipoPedidoString = tipoPedido.getSelectedItem().toString();
        
        if (tipoPedidoString == "Envío a domicilio") {
            direccion.setEnabled(true);
        }
    }//GEN-LAST:event_tipoPedidoActionPerformed

    //Método para limpiar los campos.
    private void limpiarCampos() {
        tipoCamiseta.setSelectedIndex(0);
        talla.setSelectedIndex(0);
        cantidad.setText("");
        codigo.setText("");
        tipoPedido.setSelectedIndex(0);
        direccion.setText("");
        direccion.setEnabled(false);
        formaPago.setSelectedIndex(0);
        telefono.setText("");
        nombre.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> formaPago;
    private javax.swing.JTextField nombre;
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
    private javax.swing.JPanel panelTipoCamiseta;
    private javax.swing.JPanel panelTipoPedido;
    private javax.swing.JComboBox<String> talla;
    private javax.swing.JTextField telefono;
    private javax.swing.JLabel textoCantidad;
    private javax.swing.JLabel textoCodigo;
    private javax.swing.JLabel textoDireccion;
    private javax.swing.JLabel textoFormaPago;
    private javax.swing.JLabel textoID;
    private javax.swing.JLabel textoNombre;
    private javax.swing.JLabel textoTalla;
    private javax.swing.JLabel textoTelefono;
    private javax.swing.JLabel textoTipoCamiseta;
    private javax.swing.JLabel textoTipoPedido;
    private javax.swing.JComboBox<String> tipoCamiseta;
    private javax.swing.JComboBox<String> tipoPedido;
    // End of variables declaration//GEN-END:variables
}
