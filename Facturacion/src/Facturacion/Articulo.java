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

    public boolean insertarArticulo(LinkedList<Articulo> inventario, String nombreArticulo,
            String codigoArticulo, float precioArticulo, int cantidadArticulo) {
        int pos = buscarArticulo(inventario, codigoArticulo);
        if (pos == -1) {
            inventario.add(new Articulo(nombreArticulo, codigoArticulo, precioArticulo, cantidadArticulo));
            return true;
        } else {
            inventario.get(pos).cantidad += cantidadArticulo;
        }
        return false;
    }

    public int buscarArticulo(LinkedList<Articulo> inventario, String codigoArticulo) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).codigo.equals(codigoArticulo)) {
                return i;
            }
        }
        return -1;
    }

    public String getNombreArticulo() {
        if (nombreArticulo.length() > 9) {
            return nombreArticulo.substring(0, 9);
        }
        if (nombreArticulo.length() < 5) {
            return nombreArticulo + "  ";
        }
        return nombreArticulo;
    }

    @Override
    public String toString() {
        return this.getNombreArticulo() + "\t" + this.codigo + "\t" + this.cantidad + "\t" + ("$ " + this.precio) + "\t\t"
                + ("$ " + (this.precio * this.cantidad));
    }

    public boolean modificarArticulo(LinkedList<Articulo> inventario, String nombreArticulo,
            String codigoArticulo, float precioArticulo, int cantidadArticulo) {
        int pos = buscarArticulo(inventario, codigoArticulo);
        if (pos != -1) {
            inventario.get(pos).nombreArticulo = nombreArticulo;
            inventario.get(pos).codigo = codigoArticulo;
            inventario.get(pos).precio = precioArticulo;
            inventario.get(pos).cantidad = cantidadArticulo;
            return true;
        } else {
            return false;
        }
    }
}
