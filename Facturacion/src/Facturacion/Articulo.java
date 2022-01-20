package Facturacion;

import java.util.LinkedList;

public class Articulo {

    String codigo, nombreArticulo;
    int cantidad;
    float precio;

    public Articulo() {
    }

    public Articulo(String codigo, String nombreArticulo, float precio, int cantidad) {
        this.codigo = codigo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Articulo(String nombreArticulo, int cantidad) {
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
    }

    public void insertarArticulo(LinkedList<Articulo> inventario, String nombreArticulo,
            String codigoArticulo, float precioArticulo, int cantidadArticulo) {
        inventario.add(new Articulo(nombreArticulo, codigoArticulo, precioArticulo, cantidadArticulo));
    }

    public int buscarArticulo(LinkedList<Articulo> inventario, String codigoArticulo) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).codigo.equals(codigoArticulo)) {
                return i;
            }
        }
        return -1;
    }
}
