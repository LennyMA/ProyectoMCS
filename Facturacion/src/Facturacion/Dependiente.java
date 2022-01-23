package Facturacion;

import java.util.LinkedList;

public class Dependiente {
    String nombre, apellido, clave, telefono;
    char tipo;
    boolean activo;
    LinkedList<Factura> facturas;
    
    public Dependiente(){
        
    }
    
    public Dependiente(String nombre, String apellido, String telefono, String clave, char tipo, boolean activo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.clave = clave;
        this.tipo = tipo;
        this.activo = activo;
        this.facturas = new LinkedList();
    }
}

