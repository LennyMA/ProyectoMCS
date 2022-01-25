package Facturacion;

import java.util.LinkedList;

public class Factura {
    
    LinkedList<Compra> compras;
    Cliente cliente;
    Dependiente dependiente;
    boolean cancelado;
    int codigo;
    final float IVA = 0.12f;
    
    
    public Factura(){
        
    }
    
    public Factura(Cliente cliente, LinkedList<Compra> compras, Dependiente dependiente,
            int codigo, boolean cancelado){
        this.cliente = cliente;
        this.compras = compras;
        this.dependiente = dependiente;
        this.codigo = codigo;
        this.cancelado = cancelado;
        
    }
    
    public Factura buscarFactura(LinkedList<Factura> facturas, int codigo){
        if(!facturas.isEmpty()){
            for(int i = 0; i < facturas.size(); i++){
                if(facturas.get(i).codigo == codigo){
                    return facturas.get(i);
                }
            }
        }
        System.out.println("\nNo existen facturas");
        return null;
    }
    
}
