package Facturacion;

import java.util.LinkedList;

public class Dependiente {
    String nombre, apellido, clave, telefono;
    char tipo;
    boolean activo;
    LinkedList<Factura> facturas;
}
