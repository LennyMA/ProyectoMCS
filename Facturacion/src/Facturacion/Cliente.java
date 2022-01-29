package Facturacion;

import java.util.LinkedList;

public class Cliente {

    String nombre, apellido, direccion, id, telefono;
    LinkedList<Compra> compras;
    LinkedList<Factura> facturas;

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

    public int buscarCliente(LinkedList<Cliente> cliente, String id) {
        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).id.equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public boolean agregarCliente(LinkedList<Cliente> cliente, String nombreCliente,
            String apellidoCliente, String idCliente, String direccionCliente, String telefonoCliente) {
        int pos = buscarCliente(cliente, idCliente);
        if (pos != -1) {
            return false;
        } else {
            cliente.add(new Cliente(nombreCliente, apellidoCliente, idCliente, direccionCliente, telefonoCliente));
            return true;
        }
    }
    
    public float promedioCompras() {
        float sum = 0;
        for (int i = 0; i < this.facturas.size(); i++) {
            sum = sum + this.facturas.get(i).totalPago();
        }
        return (sum / this.facturas.size());
    }

    public String getNombre() {
        if (this.nombre.length() > 7) {
            return this.nombre.substring(0, 7);
        } else if (this.nombre.length() < 6) {
            return this.nombre + "  ";
        }
        return this.nombre;
    }
    
    public String getDireccion(){
        if(this.direccion.length() > 13){
            return this.direccion.substring(0, 13);
        }else if(this.direccion.length() < 10){
            return this.direccion + "   ";
        }
        return this.direccion;
    }
    
    @Override
    public String toString(){
        return getNombre() + " " + this.apellido + " " + this.id + " "
                + this.getDireccion() + " " + this.telefono;
    }
}
