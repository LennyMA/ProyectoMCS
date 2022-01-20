package Facturacion;

import java.util.LinkedList;

public class Cliente {

    String nombre, apellido, direccion, id, telefono;
    LinkedList<Compra> compras;
    LinkedList<Compra> facturas;

    public Cliente() {

    }

    public Cliente(String nombre, String apellido, String id, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.direccion = direccion;
        this.telefono = telefono;
        this.compras = new LinkedList();
        this.facturas = new LinkedList();
    }
}
