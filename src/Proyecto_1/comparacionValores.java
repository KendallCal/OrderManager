//Comparación de Valores.
package Proyecto_1;

//Imports.
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class comparacionValores extends javax.swing.JPanel {

    //Arreglo para los Pedidos.
    private ArrayList<Pedido> pedidos;

    //Constructor.
    public comparacionValores(ArrayList<Pedido> listaPedidos) {
        //Instancia los pedidos.
        this.pedidos = listaPedidos;

        //Inicializa los componentes.
        initComponents();
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        panelBuscarID = new javax.swing.JPanel();
        panelTelefono = new javax.swing.JPanel();
        textoTelefono = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        panelBuscarBTN = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JLabel();
        panelComparacion = new javax.swing.JPanel();
        contenedor = new javax.swing.JPanel();
        panelLabels = new javax.swing.JPanel();
        textoId = new javax.swing.JLabel();
        textoCantidad = new javax.swing.JLabel();
        textoValorBinario = new javax.swing.JLabel();
        panelResultados = new javax.swing.JPanel();
        resultadoId = new javax.swing.JLabel();
        resultadoCantidad = new javax.swing.JLabel();
        resultadoValorBinario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));
        setMaximumSize(new java.awt.Dimension(720, 580));
        setMinimumSize(new java.awt.Dimension(720, 580));

        titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 51, 51));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Comparación de Valores");

        panelBuscarID.setOpaque(false);
        panelBuscarID.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 125, 5));

        panelTelefono.setOpaque(false);
        panelTelefono.setPreferredSize(new java.awt.Dimension(220, 65));

        textoTelefono.setBackground(new java.awt.Color(0, 0, 0));
        textoTelefono.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoTelefono.setForeground(new java.awt.Color(255, 255, 255));
        textoTelefono.setText("ID del Pedido");
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

        panelBuscarID.add(panelTelefono);

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

        panelBuscarID.add(panelBuscarBTN);

        panelComparacion.setBackground(new java.awt.Color(255, 255, 255));
        panelComparacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));

        contenedor.setOpaque(false);
        contenedor.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        panelLabels.setOpaque(false);
        panelLabels.setPreferredSize(new java.awt.Dimension(100, 160));
        panelLabels.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        textoId.setBackground(new java.awt.Color(0, 0, 0));
        textoId.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoId.setForeground(new java.awt.Color(0, 0, 0));
        textoId.setText("ID del Pedido =");
        textoId.setPreferredSize(new java.awt.Dimension(100, 25));
        panelLabels.add(textoId);

        textoCantidad.setBackground(new java.awt.Color(0, 0, 0));
        textoCantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoCantidad.setForeground(new java.awt.Color(0, 0, 0));
        textoCantidad.setText("Cantidad =");
        textoCantidad.setPreferredSize(new java.awt.Dimension(100, 25));
        panelLabels.add(textoCantidad);

        textoValorBinario.setBackground(new java.awt.Color(0, 0, 0));
        textoValorBinario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        textoValorBinario.setForeground(new java.awt.Color(0, 0, 0));
        textoValorBinario.setText("Valor Binario =");
        textoValorBinario.setPreferredSize(new java.awt.Dimension(100, 25));
        panelLabels.add(textoValorBinario);

        contenedor.add(panelLabels);

        panelResultados.setOpaque(false);
        panelResultados.setPreferredSize(new java.awt.Dimension(100, 160));
        panelResultados.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 20));

        resultadoId.setBackground(new java.awt.Color(0, 0, 0));
        resultadoId.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        resultadoId.setForeground(new java.awt.Color(0, 0, 0));
        resultadoId.setPreferredSize(new java.awt.Dimension(100, 25));
        panelResultados.add(resultadoId);

        resultadoCantidad.setBackground(new java.awt.Color(0, 0, 0));
        resultadoCantidad.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        resultadoCantidad.setForeground(new java.awt.Color(0, 0, 0));
        resultadoCantidad.setPreferredSize(new java.awt.Dimension(100, 25));
        panelResultados.add(resultadoCantidad);

        resultadoValorBinario.setBackground(new java.awt.Color(0, 0, 0));
        resultadoValorBinario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        resultadoValorBinario.setForeground(new java.awt.Color(0, 0, 0));
        resultadoValorBinario.setPreferredSize(new java.awt.Dimension(100, 25));
        panelResultados.add(resultadoValorBinario);

        contenedor.add(panelResultados);

        javax.swing.GroupLayout panelComparacionLayout = new javax.swing.GroupLayout(panelComparacion);
        panelComparacion.setLayout(panelComparacionLayout);
        panelComparacionLayout.setHorizontalGroup(
            panelComparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComparacionLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelComparacionLayout.setVerticalGroup(
            panelComparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelComparacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBuscarID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titulo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(titulo)
                .addGap(38, 38, 38)
                .addComponent(panelBuscarID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(panelComparacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
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

    //- - - - - - - - - - - - - - - - - - - - - - - Acción de Botones - - - - - - - - - - - - - - - - - - - - - - -//
    //Acción del botón Buscar.
    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        //Obtiene el texto del campo de texto.
        String idPedidoText = telefono.getText();

        //Verifica si el campo de texto está vacío.
        if (idPedidoText.isEmpty()) {
            //Muestra un mensaje de error si el campo está vacío.
            JOptionPane.showMessageDialog(null, "El campo ID no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Verifica si el texto ingresado es un número entero.
        if (!idPedidoText.matches("\\d+")) {
            //Muestra un mensaje de error si el texto no es un número entero.
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Convierte el texto a un int.
        int idPedido = Integer.parseInt(idPedidoText);

        //Busca el pedido con el ID especificado.
        Pedido pedido = null;
        for (Pedido p : pedidos) {
            if (p.getId() == idPedido) {
                pedido = p;
                break;
            }
        }

        //Actualiza los campos según el resultado de la búsqueda.
        if (pedido != null) {
            int cantidad = pedido.getCantidad();
            resultadoId.setText(String.valueOf(idPedido));
            resultadoCantidad.setText(String.valueOf(cantidad));
            resultadoValorBinario.setText(decimalAbinario(cantidad));
        } else {
            JOptionPane.showMessageDialog(null, "Pedido no enocntrado, por favor intente de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarMouseClicked

   //Método para pasar de decimal a binario utilizando recursividad.
    private String decimalAbinario(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else {
            return decimalAbinario(n / 2) + String.valueOf(n % 2);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuscar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JPanel panelBuscarBTN;
    private javax.swing.JPanel panelBuscarID;
    private javax.swing.JPanel panelComparacion;
    private javax.swing.JPanel panelLabels;
    private javax.swing.JPanel panelResultados;
    private javax.swing.JPanel panelTelefono;
    private javax.swing.JLabel resultadoCantidad;
    private javax.swing.JLabel resultadoId;
    private javax.swing.JLabel resultadoValorBinario;
    private javax.swing.JTextField telefono;
    private javax.swing.JLabel textoCantidad;
    private javax.swing.JLabel textoId;
    private javax.swing.JLabel textoTelefono;
    private javax.swing.JLabel textoValorBinario;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
