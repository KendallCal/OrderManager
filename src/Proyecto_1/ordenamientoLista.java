//Ordenamiento de la Lista.
package Proyecto_1;

//Imports.
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

public class ordenamientoLista extends javax.swing.JPanel {

    //Arreglo para los Pedidos.
    private ArrayList<Pedido> pedidos;

    //Constructor.
    public ordenamientoLista(ArrayList<Pedido> listaPedidos) {
        //Instancia los pedidos.
        this.pedidos = listaPedidos;

        //Inicializa los componentes.
        initComponents();
    }

    //Método para ordenar de menor a mayor por el campo “Número telefónico del cliente” utilizando el algoritmo “Por inserción”.
    private void ordenarAscendente() {
        //Convierte el ArrayList a arreglo.
        Pedido[] pedidosArray = pedidos.toArray(new Pedido[pedidos.size()]);

        //Ordenamiento por inserción.
        for (int i = 1; i < pedidosArray.length; i++) {
            Pedido key = pedidosArray[i];
            int j = i - 1;
            while (j >= 0 && pedidosArray[j].getTelefonoCliente().compareTo(key.getTelefonoCliente()) > 0) {
                pedidosArray[j + 1] = pedidosArray[j];
                j = j - 1;
            }
            pedidosArray[j + 1] = key;
        }

        //Convierte de nuevo a ArrayList.
        pedidos.clear();
        Collections.addAll(pedidos, pedidosArray);
    }

    //Método para ordenar descendente por el campo “Código de diseño” utilizando el algoritmo “Merge sort”.
    private void ordenarDescendente() {
        //Convierte el ArrayList a arreglo.
        Pedido[] pedidosArray = pedidos.toArray(new Pedido[pedidos.size()]);

        //Ordenamiento Merge sort.
        pedidosArray = mergeSort(pedidosArray);

        //Convertir de nuevo a ArrayList.
        pedidos.clear();
        Collections.addAll(pedidos, pedidosArray);
    }

    // Algoritmo Merge Sort. Divide recursivamente el array en dos mitades, las ordena y luego las combina.
    private Pedido[] mergeSort(Pedido[] array) {
        //Si el array tiene 1 o 0 elementos, ya está ordenado.
        if (array.length <= 1) {
            return array;
        }

        //Encuentra el punto medio del array.
        int mid = array.length / 2;

        //Crea subarrays para las mitades izquierda y derecha.
        Pedido[] left = new Pedido[mid];
        Pedido[] right = new Pedido[array.length - mid];

        //Copia la primera mitad del array original al array 'left'.
        System.arraycopy(array, 0, left, 0, mid);

        //Copia la segunda mitad del array original al array 'right'.
        System.arraycopy(array, mid, right, 0, array.length - mid);

        //Llama recursivamente a mergeSort en ambas mitades y combina los resultados.
        return merge(mergeSort(left), mergeSort(right));
    }

    //Función de combinación (merge). Ttoma dos subarrays ordenados (left y right) y los combina en un solo array ordenado.
    private Pedido[] merge(Pedido[] left, Pedido[] right) {
        //Crea un array resultante que tendrá el tamaño de la suma de los dos subarrays.
        Pedido[] result = new Pedido[left.length + right.length];

        //Inicializa los índices para recorrer los subarrays y el array resultante.
        int i = 0, j = 0, k = 0;

        //Compara los elementos de los subarrays y los coloca en el array resultante en orden descendente.
        while (i < left.length && j < right.length) {
            //Compara el código de diseño del pedido en la posición actual de los subarrays.
            if (left[i].getCodigoDiseño().compareTo(right[j].getCodigoDiseño()) > 0) {
                //Si el elemento del subarray izquierdo es mayor, se coloca en el array resultante.
                result[k++] = left[i++];
            } else {
                //Si el elemento del subarray derecho es mayor o igual, se coloca en el array resultante.
                result[k++] = right[j++];
            }
        }

        //Si quedan elementos en el subarray izquierdo, los agrega al array resultante.
        while (i < left.length) {
            result[k++] = left[i++];
        }

        //Si quedan elementos en el subarray derecho, los agrega al array resultante.
        while (j < right.length) {
            result[k++] = right[j++];
        }

        //Devuelve el array resultante, que ahora está ordenado.
        return result;
    }

    //Método para actualizar la tabla.
    private void actualizarTabla() {
        //Obtiene el modelo de tabla.
        DefaultTableModel model = (DefaultTableModel) tablaListaPedidos.getModel();

        //Reinicia el número de filas a 0.
        model.setRowCount(0);

        //Recorre los pedidos y los agrega a la fila.
        for (Pedido pedido : pedidos) {
            Object[] fila = {
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
            };
            model.addRow(fila);
        }
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelBotones = new javax.swing.JPanel();
        panelAscendente = new javax.swing.JPanel();
        textoAscendente = new javax.swing.JLabel();
        panelOrdenarAscendenteBTN = new javax.swing.JPanel();
        btnOrdenarAscendente = new javax.swing.JLabel();
        panelDescendente = new javax.swing.JPanel();
        textoOrdenarDescendente = new javax.swing.JLabel();
        panelOrdenarDescendenteBTN = new javax.swing.JPanel();
        btnOrdenarDescendente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListaPedidos = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(720, 580));
        setMinimumSize(new java.awt.Dimension(720, 580));
        setLayout(new java.awt.BorderLayout());

        panelPrincipal.setBackground(new java.awt.Color(0, 153, 153));

        panelBotones.setOpaque(false);
        panelBotones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 100, 5));

        panelAscendente.setOpaque(false);
        panelAscendente.setPreferredSize(new java.awt.Dimension(230, 100));
        panelAscendente.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        textoAscendente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        textoAscendente.setForeground(new java.awt.Color(255, 255, 255));
        textoAscendente.setText("Ordenamiento Ascendente");
        panelAscendente.add(textoAscendente);

        panelOrdenarAscendenteBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelOrdenarAscendenteBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelOrdenarAscendenteBTN.setPreferredSize(new java.awt.Dimension(200, 35));
        panelOrdenarAscendenteBTN.setLayout(new java.awt.BorderLayout());

        btnOrdenarAscendente.setBackground(new java.awt.Color(242, 242, 242));
        btnOrdenarAscendente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnOrdenarAscendente.setForeground(new java.awt.Color(0, 0, 0));
        btnOrdenarAscendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOrdenarAscendente.setText("Ordenar");
        btnOrdenarAscendente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenarAscendente.setPreferredSize(new java.awt.Dimension(150, 17));
        btnOrdenarAscendente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenarAscendenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOrdenarAscendenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOrdenarAscendenteMouseExited(evt);
            }
        });
        panelOrdenarAscendenteBTN.add(btnOrdenarAscendente, java.awt.BorderLayout.CENTER);

        panelAscendente.add(panelOrdenarAscendenteBTN);

        panelBotones.add(panelAscendente);

        panelDescendente.setOpaque(false);
        panelDescendente.setPreferredSize(new java.awt.Dimension(230, 100));
        panelDescendente.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));

        textoOrdenarDescendente.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        textoOrdenarDescendente.setForeground(new java.awt.Color(255, 255, 255));
        textoOrdenarDescendente.setText("Ordenamiento Descendente");
        panelDescendente.add(textoOrdenarDescendente);

        panelOrdenarDescendenteBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelOrdenarDescendenteBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelOrdenarDescendenteBTN.setPreferredSize(new java.awt.Dimension(200, 35));
        panelOrdenarDescendenteBTN.setLayout(new java.awt.BorderLayout());

        btnOrdenarDescendente.setBackground(new java.awt.Color(242, 242, 242));
        btnOrdenarDescendente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnOrdenarDescendente.setForeground(new java.awt.Color(0, 0, 0));
        btnOrdenarDescendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOrdenarDescendente.setText("Ordenar");
        btnOrdenarDescendente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenarDescendente.setPreferredSize(new java.awt.Dimension(150, 17));
        btnOrdenarDescendente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenarDescendenteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOrdenarDescendenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOrdenarDescendenteMouseExited(evt);
            }
        });
        panelOrdenarDescendenteBTN.add(btnOrdenarDescendente, java.awt.BorderLayout.CENTER);

        panelDescendente.add(panelOrdenarDescendenteBTN);

        panelBotones.add(panelDescendente);

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
        tablaListaPedidos.setRowHeight(23);
        tablaListaPedidos.setShowHorizontalLines(true);
        tablaListaPedidos.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tablaListaPedidos);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        add(panelPrincipal, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

//- - - - - - - - - - - - - - - - - - - - - - - Diseños - - - - - - - - - - - - - - - - - - - - - - -//
    //Diseño del botón Ordenar de forma Ascendente.
    private void btnOrdenarAscendenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarAscendenteMouseEntered
        panelOrdenarAscendenteBTN.setBackground(new Color(60, 63, 65));
        btnOrdenarAscendente.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnOrdenarAscendenteMouseEntered

    private void btnOrdenarAscendenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarAscendenteMouseExited
        panelOrdenarAscendenteBTN.setBackground(new Color(255, 255, 255));
        btnOrdenarAscendente.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnOrdenarAscendenteMouseExited

    //Diseño del botón Ordenar de forma Descendente.
    private void btnOrdenarDescendenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarDescendenteMouseEntered
        panelOrdenarDescendenteBTN.setBackground(new Color(60, 63, 65));
        btnOrdenarDescendente.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnOrdenarDescendenteMouseEntered

    private void btnOrdenarDescendenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarDescendenteMouseExited
        panelOrdenarDescendenteBTN.setBackground(new Color(255, 255, 255));
        btnOrdenarDescendente.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btnOrdenarDescendenteMouseExited

    //- - - - - - - - - - - - - - - - - - - - - Acción de Botones - - - - - - - - - - - - - - - - - - - -//
    //Acción del botón Ordenar de forma Ascendente.
    private void btnOrdenarAscendenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarAscendenteMouseClicked
        ordenarAscendente();
        actualizarTabla();
    }//GEN-LAST:event_btnOrdenarAscendenteMouseClicked

    //Acción del botón del botón Ordenar de forma Descendente.
    private void btnOrdenarDescendenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenarDescendenteMouseClicked
        ordenarDescendente();
        actualizarTabla();
    }//GEN-LAST:event_btnOrdenarDescendenteMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnOrdenarAscendente;
    private javax.swing.JLabel btnOrdenarDescendente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAscendente;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelDescendente;
    private javax.swing.JPanel panelOrdenarAscendenteBTN;
    private javax.swing.JPanel panelOrdenarDescendenteBTN;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tablaListaPedidos;
    private javax.swing.JLabel textoAscendente;
    private javax.swing.JLabel textoOrdenarDescendente;
    // End of variables declaration//GEN-END:variables
}
