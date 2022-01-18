package Facturacion;

public class Articulo {

    String codigo, nombreArticulo;
    int cantidad;
    float precio;

    public Articulo() {
    }

    public Articulo(String codigo, String nombreArticulo, int cantidad, float precio) {
        this.codigo = codigo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Articulo(String nombreArticulo, int cantidad) {
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
    }

}
