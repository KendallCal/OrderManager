
/*

    Kendall Andrey Calderón Burgos.

    Proyecto 1. Estructuras de Datos.

    Segundo Cuatrimestre 2024.

*/

//Menú Principal
package Proyecto_1;

//Imports.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Menu extends javax.swing.JFrame {

    //Areglo
    private ArrayList<Pedido> listaPedidos;
    
    //Variables.
    int xMouse, yMouse;
    
    //Constructor.
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Sistema de Registros de Notas de Estudiantes");
        
        // Inicializa la lista de pedidos
        listaPedidos = new ArrayList<>();
        
        //Redondear bordes de la ventana.
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
    }
    
    /* - - - - - - - - - - - - - - - - - - - - Métodos - - - - - - - - - - - - - - - - - - - - */
    //Método para cambiar opción.
    private void cambiarOpcion(JPanel opcion) {
        opcion.setSize(720, 580); //Establece el tamaño de la ventana.
        opcion.setLocation(0, 0); //Establece la posición de la ventana..
        panelPrincipal.removeAll(); //Elimina lo que se muestra en la ventana.
        panelPrincipal.add(opcion, BorderLayout.CENTER); //Agrega la ventana al Jframe.
        panelPrincipal.revalidate(); //Revalida el diseño despues de haber cargado cada componente.
        panelPrincipal.repaint(); //Se repinta la ventana despues de haberlo hecho.
    }

    //Design.
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedorPrincipal = new javax.swing.JPanel();
        barraSuperior = new javax.swing.JPanel();
        panelSalir = new javax.swing.JPanel();
        btnSalir = new javax.swing.JLabel();
        panelTitulo = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        contenedorBTNS = new javax.swing.JPanel();
        panelRegistrarPedidosBTN = new javax.swing.JPanel();
        btnRegistrarPedidos = new javax.swing.JLabel();
        panelListaPedidosBTN = new javax.swing.JPanel();
        btnListaPedidos = new javax.swing.JLabel();
        panelBusquedaEdicionBTN = new javax.swing.JPanel();
        btnBusquedaEdicion = new javax.swing.JLabel();
        panelComparacionValoresBTN = new javax.swing.JPanel();
        btnComparacionValores = new javax.swing.JLabel();
        panelOrdenamientoListaBTN = new javax.swing.JPanel();
        btnOrdenamientoLista = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenedorPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraSuperior.setBackground(new java.awt.Color(242, 242, 242));
        barraSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        barraSuperior.setAlignmentX(0.0F);
        barraSuperior.setAlignmentY(0.0F);
        barraSuperior.setDoubleBuffered(false);
        barraSuperior.setName(""); // NOI18N
        barraSuperior.setPreferredSize(new java.awt.Dimension(860, 45));
        barraSuperior.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraSuperiorMouseDragged(evt);
            }
        });
        barraSuperior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraSuperiorMousePressed(evt);
            }
        });

        panelSalir.setAlignmentX(0.0F);
        panelSalir.setAlignmentY(0.0F);
        panelSalir.setOpaque(false);
        panelSalir.setPreferredSize(new java.awt.Dimension(40, 40));

        btnSalir.setFont(new java.awt.Font("Hack Nerd Font", 0, 30)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 0, 0));
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setText("x");
        btnSalir.setAlignmentY(0.0F);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelSalirLayout = new javax.swing.GroupLayout(panelSalir);
        panelSalir.setLayout(panelSalirLayout);
        panelSalirLayout.setHorizontalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );
        panelSalirLayout.setVerticalGroup(
            panelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        panelTitulo.setOpaque(false);

        Titulo.setBackground(new java.awt.Color(51, 51, 51));
        Titulo.setFont(new java.awt.Font("Sitka Text", 1, 15)); // NOI18N
        Titulo.setForeground(new java.awt.Color(51, 51, 51));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Estructuras de Datos");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout barraSuperiorLayout = new javax.swing.GroupLayout(barraSuperior);
        barraSuperior.setLayout(barraSuperiorLayout);
        barraSuperiorLayout.setHorizontalGroup(
            barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraSuperiorLayout.createSequentialGroup()
                .addContainerGap(386, Short.MAX_VALUE)
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349)
                .addComponent(panelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraSuperiorLayout.setVerticalGroup(
            barraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        contenedorPrincipal.add(barraSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 40));

        panelPrincipal.setBackground(new java.awt.Color(242, 242, 242));
        panelPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        panelPrincipal.setForeground(new java.awt.Color(247, 247, 247));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(720, 580));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(720, 580));

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        contenedorPrincipal.add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 720, 580));
        panelPrincipal.getAccessibleContext().setAccessibleDescription("");

        contenedorBTNS.setBackground(new java.awt.Color(242, 242, 242));
        contenedorBTNS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        contenedorBTNS.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 50));

        panelRegistrarPedidosBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelRegistrarPedidosBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelRegistrarPedidosBTN.setPreferredSize(new java.awt.Dimension(200, 60));
        panelRegistrarPedidosBTN.setLayout(new java.awt.BorderLayout());

        btnRegistrarPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnRegistrarPedidos.setForeground(new java.awt.Color(60, 63, 65));
        btnRegistrarPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrarPedidos.setText("Registrar Pedidos");
        btnRegistrarPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrarPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarPedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarPedidosMouseExited(evt);
            }
        });
        panelRegistrarPedidosBTN.add(btnRegistrarPedidos, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelRegistrarPedidosBTN);

        panelListaPedidosBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelListaPedidosBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelListaPedidosBTN.setPreferredSize(new java.awt.Dimension(200, 60));
        panelListaPedidosBTN.setLayout(new java.awt.BorderLayout());

        btnListaPedidos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnListaPedidos.setForeground(new java.awt.Color(60, 63, 65));
        btnListaPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnListaPedidos.setText("Lista de Pedidos");
        btnListaPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListaPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnListaPedidosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnListaPedidosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnListaPedidosMouseExited(evt);
            }
        });
        panelListaPedidosBTN.add(btnListaPedidos, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelListaPedidosBTN);

        panelBusquedaEdicionBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelBusquedaEdicionBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelBusquedaEdicionBTN.setPreferredSize(new java.awt.Dimension(200, 60));
        panelBusquedaEdicionBTN.setLayout(new java.awt.BorderLayout());

        btnBusquedaEdicion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnBusquedaEdicion.setForeground(new java.awt.Color(60, 63, 65));
        btnBusquedaEdicion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBusquedaEdicion.setText("Busqueda y Edición");
        btnBusquedaEdicion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBusquedaEdicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBusquedaEdicion.setMaximumSize(new java.awt.Dimension(24, 30));
        btnBusquedaEdicion.setMinimumSize(new java.awt.Dimension(24, 30));
        btnBusquedaEdicion.setName(""); // NOI18N
        btnBusquedaEdicion.setPreferredSize(new java.awt.Dimension(24, 30));
        btnBusquedaEdicion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusquedaEdicionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusquedaEdicionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBusquedaEdicionMouseExited(evt);
            }
        });
        panelBusquedaEdicionBTN.add(btnBusquedaEdicion, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelBusquedaEdicionBTN);

        panelComparacionValoresBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelComparacionValoresBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelComparacionValoresBTN.setPreferredSize(new java.awt.Dimension(200, 60));
        panelComparacionValoresBTN.setLayout(new java.awt.BorderLayout());

        btnComparacionValores.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnComparacionValores.setForeground(new java.awt.Color(60, 63, 65));
        btnComparacionValores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnComparacionValores.setText("Comparación de Valores");
        btnComparacionValores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnComparacionValores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnComparacionValoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnComparacionValoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnComparacionValoresMouseExited(evt);
            }
        });
        panelComparacionValoresBTN.add(btnComparacionValores, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelComparacionValoresBTN);

        panelOrdenamientoListaBTN.setBackground(new java.awt.Color(242, 242, 242));
        panelOrdenamientoListaBTN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(60, 63, 65)));
        panelOrdenamientoListaBTN.setPreferredSize(new java.awt.Dimension(200, 60));
        panelOrdenamientoListaBTN.setLayout(new java.awt.BorderLayout());

        btnOrdenamientoLista.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnOrdenamientoLista.setForeground(new java.awt.Color(60, 63, 65));
        btnOrdenamientoLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnOrdenamientoLista.setText("Ordenamieno de los Pedidos");
        btnOrdenamientoLista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOrdenamientoLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenamientoListaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOrdenamientoListaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOrdenamientoListaMouseExited(evt);
            }
        });
        panelOrdenamientoListaBTN.add(btnOrdenamientoLista, java.awt.BorderLayout.CENTER);

        contenedorBTNS.add(panelOrdenamientoListaBTN);

        contenedorPrincipal.add(contenedorBTNS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 220, 590));

        getContentPane().add(contenedorPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Diseño y acción de la barra superior.
    private void barraSuperiorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorMousePressed
        xMouse = evt.getX(); //Guarda la posición x.
        yMouse = evt.getY(); //Guarda la posición y.
    }//GEN-LAST:event_barraSuperiorMousePressed

    private void barraSuperiorMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraSuperiorMouseDragged
        int x = evt.getXOnScreen(); //Guarda la posición x del mouse en la pantalla.
        int y = evt.getYOnScreen(); //Guarda la posición y del mouse en la pantalla.
        this.setLocation(x - xMouse, y - yMouse); //Lo posiciona en la posición indicada.
    }//GEN-LAST:event_barraSuperiorMouseDragged

    //Diseño y acción del botón para Salir.
    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        panelSalir.setOpaque(true);
        panelSalir.setBackground(new Color(247, 83, 96, 255));
        btnSalir.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnSalirMouseEntered
    
    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        panelSalir.setOpaque(false);
        panelSalir.setBackground(new Color(244, 49, 19, 0));
        btnSalir.setForeground(new Color(18, 18, 18));
    }//GEN-LAST:event_btnSalirMouseExited
     
    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0); //Sirve para salir del programa.
    }//GEN-LAST:event_btnSalirMouseClicked

    /* - - - - - - - - - - - - - - - - Diseños de las opciones - - - - - - - - - - - - - - - - */
    //Diseño del Registro de Pedidos.
    private void btnRegistrarPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPedidosMouseEntered
        panelRegistrarPedidosBTN.setOpaque(true);
        panelRegistrarPedidosBTN.setBackground(new Color(60, 63, 65));
        btnRegistrarPedidos.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnRegistrarPedidosMouseEntered

    private void btnRegistrarPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPedidosMouseExited
        panelRegistrarPedidosBTN.setOpaque(false);
        panelRegistrarPedidosBTN.setBackground(new Color(60, 63, 65));
        btnRegistrarPedidos.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnRegistrarPedidosMouseExited

    //Diseño del Listado de Pedidos.
    private void btnListaPedidosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaPedidosMouseEntered
        panelListaPedidosBTN.setOpaque(true);
        panelListaPedidosBTN.setBackground(new Color(60, 63, 65));
        btnListaPedidos.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnListaPedidosMouseEntered

    private void btnListaPedidosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaPedidosMouseExited
        panelListaPedidosBTN.setOpaque(false);
        panelListaPedidosBTN.setBackground(new Color(60, 63, 65));
        btnListaPedidos.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnListaPedidosMouseExited

    //Diseño del Busqueda y Edición de un Pedido.
    private void btnBusquedaEdicionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaEdicionMouseEntered
        panelBusquedaEdicionBTN.setOpaque(true);
        panelBusquedaEdicionBTN.setBackground(new Color(60, 63, 65));
        btnBusquedaEdicion.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnBusquedaEdicionMouseEntered

    private void btnBusquedaEdicionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaEdicionMouseExited
        panelBusquedaEdicionBTN.setOpaque(false);
        panelBusquedaEdicionBTN.setBackground(new Color(60, 63, 65));
        btnBusquedaEdicion.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnBusquedaEdicionMouseExited

    //Diseño del botón Comparación de Valores.
    private void btnComparacionValoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComparacionValoresMouseEntered
        panelComparacionValoresBTN.setOpaque(true);
        panelComparacionValoresBTN.setBackground(new Color(60, 63, 65));
        btnComparacionValores.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnComparacionValoresMouseEntered

    private void btnComparacionValoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComparacionValoresMouseExited
        panelComparacionValoresBTN.setOpaque(false);
        panelComparacionValoresBTN.setBackground(new Color(60, 63, 65));
        btnComparacionValores.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnComparacionValoresMouseExited

    //Diseño del Ordenamiento de la Lista de Eventos.
    private void btnOrdenamientoListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenamientoListaMouseExited
        panelOrdenamientoListaBTN.setOpaque(false);
        panelOrdenamientoListaBTN.setBackground(new Color(60, 63, 65));
        btnOrdenamientoLista.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_btnOrdenamientoListaMouseExited

    private void btnOrdenamientoListaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenamientoListaMouseEntered
        panelOrdenamientoListaBTN.setOpaque(true);
        panelOrdenamientoListaBTN.setBackground(new Color(60, 63, 65));
        btnOrdenamientoLista.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnOrdenamientoListaMouseEntered

    /* - - - - - - - - - - - - - - - - Métodos de las opciones - - - - - - - - - - - - - - - - */
    //Método del botón Registro de Pedidos.
    private void btnRegistrarPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPedidosMouseClicked
        registrarPedidos opcion = new registrarPedidos(listaPedidos);
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Registro de Pedidos");
            
        //Cambia la ventana a Registro de Pedidos.
        cambiarOpcion(opcion);
        
        listaPedidos = opcion.getPedidos();
    }//GEN-LAST:event_btnRegistrarPedidosMouseClicked

    //Método del botón Listado de Pedidos.
    private void btnListaPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnListaPedidosMouseClicked
        listaPedidos opcion = new listaPedidos(listaPedidos);
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Listado de Pedidos");
        
        //Cambia la ventana a Listado de Pedidos.
        cambiarOpcion(opcion);
        
    }//GEN-LAST:event_btnListaPedidosMouseClicked

    //Método del botón Busqueda y Edición de un Pedido.
    private void btnBusquedaEdicionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaEdicionMouseClicked
        busquedaEdicion opcion = new busquedaEdicion(listaPedidos);
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Busqueda y Edición de un Pedido");
            
        //Cambia la ventana a Busqueda y Edición de un Pedido.
        cambiarOpcion(opcion);
        
        listaPedidos = opcion.getPedidos();
    }//GEN-LAST:event_btnBusquedaEdicionMouseClicked

    //Método del botón Comparación de Valores.
    private void btnComparacionValoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnComparacionValoresMouseClicked
        comparacionValores opcion = new comparacionValores(listaPedidos);
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Comparación de Valores");
        
        //Cambia la ventana a Filtrar Promedios.
        cambiarOpcion(opcion);
    }//GEN-LAST:event_btnComparacionValoresMouseClicked

    //Método del botón Ordenamiento de la Lista de Eventos.
    private void btnOrdenamientoListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenamientoListaMouseClicked
        ordenamientoLista opcion = new ordenamientoLista(listaPedidos);
        
        //Cambia el titulo de la barra superior.
        Titulo.setText("Ordenamiento de la Lista de Eventos");
        
        //Cambia la ventana a Ordenamiento de la Lista de Eventos.
        cambiarOpcion(opcion);
    }//GEN-LAST:event_btnOrdenamientoListaMouseClicked

    //Main.
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JPanel barraSuperior;
    private javax.swing.JLabel btnBusquedaEdicion;
    private javax.swing.JLabel btnComparacionValores;
    private javax.swing.JLabel btnListaPedidos;
    private javax.swing.JLabel btnOrdenamientoLista;
    private javax.swing.JLabel btnRegistrarPedidos;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JPanel contenedorBTNS;
    private javax.swing.JPanel contenedorPrincipal;
    private javax.swing.JPanel panelBusquedaEdicionBTN;
    private javax.swing.JPanel panelComparacionValoresBTN;
    private javax.swing.JPanel panelListaPedidosBTN;
    private javax.swing.JPanel panelOrdenamientoListaBTN;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRegistrarPedidosBTN;
    private javax.swing.JPanel panelSalir;
    private javax.swing.JPanel panelTitulo;
    // End of variables declaration//GEN-END:variables
}