package Facturacion;

public class Compra {

    float subTotal, precioUnitario;
    int cantidadProducto;
    Articulo articulo;

    public Compra(int cantidadProducto, Articulo nombreArticulo) {
        this.cantidadProducto = cantidadProducto;
        this.articulo = nombreArticulo;

    }

    public float subTotal() {
        return this.subTotal = this.cantidadProducto * this.articulo.precio;
    }

    @Override
    public String toString() {
        return this.articulo.getNombreArticulo() + "\t" + this.cantidadProducto
                + "\t" + ("$ " + subTotal());
    }

}
