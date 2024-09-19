
//Clase Pedido

package Proyecto_1;

public class Pedido {
    
    //Variables.
    private static int contadorID = 0;
    private int id;
    private String tipoCamiseta;
    private String talla;
    private int cantidad;
    private String codigoDiseño;
    private String tipoPedido;
    private String direccionEntrega;
    private String formaPago;
    private String telefonoCliente;
    private String nombreCliente;

    //Constructor.
    public Pedido(String tipoCamiseta, String talla, int cantidad, String codigoDiseño, String tipoPedido, String direccionEntrega, String formaPago, String telefonoCliente, String nombreCliente) {
        this.id = ++contadorID;
        this.tipoCamiseta = tipoCamiseta;
        this.talla = talla;
        this.cantidad = cantidad;
        this.codigoDiseño = codigoDiseño;
        this.tipoPedido = tipoPedido;
        this.direccionEntrega = direccionEntrega;
        this.formaPago = formaPago;
        this.telefonoCliente = telefonoCliente;
        this.nombreCliente = nombreCliente;
    }

    //Getters and Setters.
    public static int getContadorID() {
        return contadorID;
    }

    public static void setContadorID(int contadorID) {
        Pedido.contadorID = contadorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoCamiseta() {
        return tipoCamiseta;
    }

    public void setTipoCamiseta(String tipoCamiseta) {
        this.tipoCamiseta = tipoCamiseta;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoDiseño() {
        return codigoDiseño;
    }

    public void setCodigoDiseño(String codigoDiseño) {
        this.codigoDiseño = codigoDiseño;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    //Override para representacion de los Strings.
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", tipoCamiseta='" + tipoCamiseta + '\'' +
                ", talla='" + talla + '\'' +
                ", cantidad=" + cantidad +
                ", codigoDiseno='" + codigoDiseño + '\'' +
                ", tipoPedido='" + tipoPedido + '\'' +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", formaPago='" + formaPago + '\'' +
                ", telefonoCliente='" + telefonoCliente + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
