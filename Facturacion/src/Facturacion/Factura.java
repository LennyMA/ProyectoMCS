package Facturacion;

import java.util.LinkedList;

public class Factura {

    LinkedList<Compra> compras;
    Cliente cliente;
    Dependiente dependiente;
    boolean cancelado;
    int codigo;
    final float IVA = 0.12f;

    public Factura() {

    }

    public Factura(Cliente cliente, LinkedList<Compra> compras, Dependiente dependiente,
            int codigo, boolean cancelado) {
        this.cliente = cliente;
        this.compras = compras;
        this.dependiente = dependiente;
        this.codigo = codigo;
        this.cancelado = cancelado;
    }

    public Factura buscarFactura(LinkedList<Factura> facturas, int codigo) {
        if (!facturas.isEmpty()) {
            for (int i = 0; i < facturas.size(); i++) {
                if (facturas.get(i).codigo == codigo) {
                    return facturas.get(i);
                }
            }
        }
        System.out.println("\nNo existen Facturas");
        return null;
    }

    private String generarEstadoCancelada() {
        if (this.cancelado == true) {
            return "\nEstado: ANULADA";
        }
        return "";
    }

    public float subTotalPago() {
        float subTotal = 0;
        for (int i = 0; i < this.compras.size(); i++) {
            subTotal += this.compras.get(i).subTotal;
        }
        return subTotal;
    }

    public float totalPago() {
        return subTotalPago() + (subTotalPago() * this.IVA);
    }

    public void mostrarCompras() {
        if (this.compras.isEmpty()) {
            System.out.println("\nNo se han realizado compras");
        } else {
            System.out.printf("%-3s%-12s%-9s"
                    + "%-9s\n",
                    "Nº", "Producto", "Cantidad", "SubTotal");
            for (int i = 0; i < this.compras.size(); i++) {
                System.out.println((i + 1) + "  " + compras.get(i).toString());
            }
        }
    }

    public void imprimirFacturaDatos() {
        System.out.printf("\n%26s\n", ".: FACTURA :.");
        System.out.println("Factura Nº " + this.codigo);
        System.out.println(generarEstadoCancelada());
        System.out.println("\t .: Datos del Cliente :.\n");
        System.out.printf("%-15s%-11s%-13s%-11s\n", "Nombre", "Cédula", "Dirección", "Teléfono");
        System.out.printf(this.cliente.toString());
        System.out.printf("\n\n\t .: Datos del Empleado :.\n");
        System.out.printf("\n%-16s%-10s\n", "Nombre", "Télefono");
        System.out.printf(this.dependiente.toString());
        System.out.println("\n\n\t.: Lista de Compras :.\n");
        mostrarCompras();
        System.out.println("\nTotal: " + subTotalPago()
                + "\nTotal + IVA: " + totalPago());
    }

}
