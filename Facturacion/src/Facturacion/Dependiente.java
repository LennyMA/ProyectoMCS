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
    
    public String getNombre() {
        if (this.nombre.length() > 7) {
            return this.nombre.substring(0, 7);
        }
        if (this.nombre.length() < 6) {
            return this.nombre + "  ";
        }
        return this.nombre;
    }
    @Override
    public String toString() {
        return getNombre() + " " + this.apellido
                + " " + this.telefono;
    }
    
        public int buscarDependiente(LinkedList<Dependiente> dependiente, String codigo) {
        for (int i = 0; i < dependiente.size(); i++) {
            if (dependiente.get(i).nombre.equals(codigo)) {
                return i;
            }
        }
        return -1;
    }
}

