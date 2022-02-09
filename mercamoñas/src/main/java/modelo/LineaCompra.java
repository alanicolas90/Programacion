package modelo;

public class LineaCompra {

    private Producto producto;
    private int quantity;

    public LineaCompra(Producto producto, int quantity) {
        this.producto = producto;
        this.quantity = quantity;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
