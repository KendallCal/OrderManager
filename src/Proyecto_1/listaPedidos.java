
//Listado de Pedidos.

package Proyecto_1;

//Imports.
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class listaPedidos extends javax.swing.JPanel {

    //Arreglo para los Pedidos.
    private ArrayList<Pedido> pedidos;
    
    //Constructor.
    public listaPedidos(ArrayList<Pedido> listaPedidos) {
        //Instancia los pedidos.
        this.pedidos = listaPedidos;
        
        //Inicializa los componentes.
        initComponents();
        
        //Muestra la tabla.
        actualizarTabla();
    }

    private void actualizarTabla() {
        //Obtiene el modelo de tabla.
        DefaultTableModel model = (DefaultTableModel) tablaListaPedidos.getModel();
        
        //Reinicia el número de filas a 0.
        model.setRowCount(0);

        //Se crea el iterador para recorrer las filas de Pedidos.
        Iterator<Pedido> it = pedidos.iterator();
        
        //Bucle mientras hay elementos en la lista.
        while (it.hasNext()) {
            //Obtiene el siguiente pedido.
            Pedido pedido = it.next();
            
            //Lo añade a la tabla.
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
    
    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaPedidos = new javax.swing.JTable();
        titulo = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(720, 580));
        setMinimumSize(new java.awt.Dimension(720, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(0, 153, 153));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setHorizontalScrollBar(null);

        tablaListaPedidos.setBackground(new java.awt.Color(242, 242, 242));
        tablaListaPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tablaListaPedidos.setForeground(new java.awt.Color(60, 63, 65));
        tablaListaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
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
        tablaListaPedidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaListaPedidos.setMaximumSize(new java.awt.Dimension(720, 368));
        tablaListaPedidos.setMinimumSize(new java.awt.Dimension(720, 368));
        tablaListaPedidos.setPreferredSize(new java.awt.Dimension(720, 368));
        tablaListaPedidos.setRowHeight(23);
        tablaListaPedidos.setShowHorizontalLines(true);
        tablaListaPedidos.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaListaPedidos);
        if (tablaListaPedidos.getColumnModel().getColumnCount() > 0) {
            tablaListaPedidos.getColumnModel().getColumn(0).setMinWidth(50);
            tablaListaPedidos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaListaPedidos.getColumnModel().getColumn(0).setMaxWidth(50);
            tablaListaPedidos.getColumnModel().getColumn(2).setMinWidth(50);
            tablaListaPedidos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tablaListaPedidos.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        titulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(51, 51, 51));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Lista de Pedidos");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(titulo)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaListaPedidos;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
