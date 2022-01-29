package Facturacion;

import java.util.LinkedList;
import java.util.Scanner;
import Controles.Cedula;

public class Supermercado {

    private LinkedList<Dependiente> dependientes;
    private LinkedList<Cliente> clientes;
    private LinkedList<Articulo> inventario;
    private LinkedList<Compra> compras;
    private LinkedList<Factura> facturas;

    private Dependiente dependiente;
    private Articulo articulo;
    private Cliente cliente;
    private Factura factura; //
    private int codigo = 1;
    private Scanner tecla = new Scanner(System.in);

    public Supermercado() {

        this.dependiente = new Dependiente();
        this.articulo = new Articulo();
        this.cliente = new Cliente();
        this.factura = new Factura();

        this.dependientes = new LinkedList();
        this.clientes = new LinkedList();
        this.inventario = new LinkedList();
        this.compras = new LinkedList();
        this.facturas = new LinkedList();

        this.dependientes.add(new Dependiente("YADIRA", "ALLAUCA", "0994885578", "123", 'E', false));
        this.dependientes.add(new Dependiente("LENIN", "MORENO", "0996356845", "321", 'A', false));
        this.dependientes.add(new Dependiente("MELANY", "RECALDE", "0984739637", "111", 'E', false));

        this.inventario.add(new Articulo("CHOCOLATE", "1111", 0.35f, 30));
        this.inventario.add(new Articulo("ACEITE", "2222", 1.5f, 50));
        this.inventario.add(new Articulo("VODKA", "3333", 5f, 25));
        this.inventario.add(new Articulo("LARK", "4444", 0.40f, 15));
        this.inventario.add(new Articulo("AZÚCAR", "5555", 1f, 12));
        this.inventario.add(new Articulo("GELATINA", "6666", 0.8f, 15));

        this.clientes.add(new Cliente("YADIRA", "ALLAUCA", "1804573770", "TECHO PROPIO", "0994885578"));
        this.clientes.add(new Cliente("LENIN", "MORENO", "1804763918", "VICENTINA", "0996356845"));
        this.clientes.add(new Cliente("MELANY", "RECALDE", "1724499353", "TECHO PROPIO", "0984739637"));

    }

    public void iniciarSistema() {
        char iniciar;
        System.out.print("\n\t\t---- Iniciar Sistema ---\n");

        do {
            System.out.print("\nIngresar(S/N): ");
            iniciar = this.tecla.next().toUpperCase().charAt(0);
            if (iniciar != 'S' && iniciar != 'N') {
                System.out.println("S = Si, N = No");
            }
        } while (iniciar != 'S' && iniciar != 'N');

        if (iniciar != 'S') {
            System.out.println("\n\n\t\t=======");
            System.out.println("\t\tGracias");
            System.out.println("\t\t=======");
        } else {
            login();
        }

    }

    public void login() {

        String usuario, clave;
        char tipo;
        int posicionD;

        System.out.println("\n---Iniciar Sesión---\n");
        do {
            System.out.print("\nUsuario: ");
            usuario = this.tecla.nextLine().toUpperCase();
            System.out.print("\nContraseña: ");
            clave = this.tecla.nextLine().toUpperCase();
        } while (!this.dependiente.buscarClaveDependiente(this.dependientes, usuario, clave));

        posicionD = this.dependiente.buscarDependiente(dependientes, usuario);

        this.dependientes.get(posicionD).activo = true;

        if (this.dependiente.buscarClaveDependiente(this.dependientes, usuario, clave)) {
            System.out.println("\n-------------------------------");
            System.out.println("Seleccionando tipo de Empleado");
            System.out.println("-------------------------------");
            System.out.println("\t|BIENVENIDO " + usuario.toLowerCase().toUpperCase() + "|");
            System.out.println("\t------------------");

            tipo = this.dependiente.seleccionTipoDependiente(this.dependientes, usuario);
            if (tipo == 'E') {
                menuEmpleado();
            } else {
                menuAdministrador();
            }
        }
    }

    public void menuAdministrador() {
        int op, cantidadArticulo;
        String nombreUsuario, nombreArticulo, codigoArticulo;
        float precioArticulo;

        do {
            System.out.println("\n\t .: MENU ADMINISTRADOR :."
                    + "\n1) Mostrar Empleados"
                    + "\n2) Eliminar Empleado"
                    + "\n3) Mostrar Inventario"
                    + "\n4) Agregar artículo o actualizar cantidad"
                    + "\n5) Modificar artículo"
                    + "\n6) Reporte Estadístico"
                    + "\n7) Cerrar Sesión"
                    + "\n8) Cerrar Sistema");
            System.out.print("\nElija la opcion: ");
            op = this.tecla.nextInt();
            this.tecla.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\n\t .: Lista Empleados :.");
                    mostrarDependiente(this.dependientes);
                    break;
                case 2:
                    System.out.println("\n\t .: Eliminando Empleado :.");
                    System.out.print("\nNombre del Empleado: ");
                    nombreUsuario = this.tecla.nextLine().toUpperCase();
                    boolean eliminado = this.dependiente.eliminarDependiente(this.dependientes, nombreUsuario);
                    if (eliminado == true) {
                        System.out.println("\nEmpleado eliminado");
                    } else {
                        System.out.println("\nNo se encontro al empleado");
                    }
                    break;
                case 3:
                    System.out.println("\n\t .: Inventario :.");
                    mostrarArticulo(this.inventario);
                    break;
                case 4:
                    System.out.println("\n\t .: Agregar Artículo :.\n");
                    insertarArticuloInventario(this.inventario);
                    break;
                case 5:
                    System.out.println("\n\t .: Modificar Artículo :.\n");
                    System.out.print("\nNombre: ");
                    nombreArticulo = this.tecla.nextLine().toUpperCase();
                    System.out.print("\nCodigo: ");
                    codigoArticulo = this.tecla.nextLine().toUpperCase();
                    System.out.print("\nPrecio: ");
                    precioArticulo = this.tecla.nextFloat();
                    System.out.print("\nCantidad: ");
                    cantidadArticulo = this.tecla.nextInt();
                    this.tecla.nextLine();

                    break;
                case 6:
                    System.out.println("\n\t .: REPORTE ESTADÍSTICO :.");
                    break;
                case 7:
                    System.out.println("\n\t .: Cerrando Sesión :.");
                    login();
                    break;
                case 8:
                    char respuesta;
                    System.out.println("\n\t .: Cerrar Sistema :.");
                    System.out.println("\nEsta seguro que desea cerrar sistema? (S/N): ");
                    respuesta = this.tecla.next().toUpperCase().charAt(0);
                    if (respuesta == 'S') {
                        System.out.println("\nCerrando sistema...!");
                    }
                    break;
                default:
                    System.out.println("\nError: No existe la opción");
            }

        } while (op != 7 && op != 8);
    }

    public void menuEmpleado() {
        int op = 0, cantidadArticulo = 0, pos, articuloEncontrado;
        String codigoArticulo = "", id; //
        Dependiente dependienteActivo;
        char respuesta;

        do {
            System.out.println("\n\t .: MENU EMPLEADO :."
                    + "\n1) Mostrar Inventario"
                    + "\n2) Vender"
                    + "\n3) Mostrar Clientes"
                    + "\n4) Mostrar Lista de Facturas"
                    + "\n5) Mostrar Lista de Facturas por Cliente"
                    + "\n6) Cancelar Factura"
                    + "\n7) Reporte Estadístico"
                    + "\n8) Terminar Turno"
                    + "\n9) Cerrar Sistema");
            System.out.print("\nElija la opción: ");
            op = this.tecla.nextInt();
            this.tecla.nextLine();

            switch (op) {
                case 1:
                    System.out.println("\n\t .: Inventario :.");
                    mostrarArticulo(this.inventario);
                    break;
                case 2:
                    LinkedList<Compra> compraActual = new LinkedList();
                    Articulo articuloComprado;
                    System.out.println("\n\t .: Vender :.");
                    do {
                        do {
                            System.out.print("\nCódigo del Producto: ");
                            codigoArticulo = this.tecla.nextLine();
                            articuloEncontrado = this.articulo.buscarArticulo(this.inventario, codigoArticulo);
                            if (articuloEncontrado == -1) {
                                System.out.println("\nNo existe el producto con el código -> " + codigoArticulo);
                            }
                        } while (articuloEncontrado == -1);

                        System.out.print("\nCantidad: ");
                        cantidadArticulo = this.tecla.nextInt();
                        this.tecla.nextLine();
                        articuloComprado = vender(articuloEncontrado, cantidadArticulo, this.inventario.get(articuloEncontrado));

                        if (articuloComprado != null) {
                            compraActual.add(new Compra(cantidadArticulo, articuloComprado));
                        }
                        do {
                            System.out.print("\nSeguir vendiendo?(S/N): ");
                            respuesta = this.tecla.next().toUpperCase().charAt(0);
                            if (respuesta != 'S' && respuesta != 'N') {
                                System.out.println("S = Si, N = No");
                            }
                        } while (respuesta != 'S' && respuesta != 'N');
                    } while (respuesta == 'S');
                    if (!compraActual.isEmpty()) {
                        facturacion(compraActual);
                    }
                    System.out.println("\nCompra finalizada...!!");

                    break;
                case 3:
                    System.out.println("\n\t .: Lista de Clientes :.");
                    mostrarClientes(this.clientes);
                    break;
                case 4:
                    System.out.println("\n\t .: Lista de Facturas :.");
                    mostrarFacturas(this.facturas);
                    break;
                case 5:
                    System.out.println("\n\t .: Lista de Facturas por Cliente :.");
                    System.out.println("\nCedula: ");
                    id = this.tecla.nextLine();
                    pos = this.cliente.buscarCliente(this.clientes, id);
                    break;
                case 6:
                    int codigoFactura;
                    System.out.println("\n\t .: Cancelación de Factura :.");
                    System.out.println("\nCódigo: ");
                    codigoFactura = this.tecla.nextInt();
                    this.tecla.nextLine();

                    boolean cancelado = cancelarFactura(this.facturas, codigoFactura);

                    if (cancelado == true) {
                        Factura f = this.factura.buscarFactura(this.facturas, codigoFactura);
                        for (int i = 0; i < this.inventario.size(); i++) {
                            for (int j = 0; j < f.compras.size(); j++) {
                                if (f.compras.get(j).articulo.nombreArticulo.equals(this.inventario.get(i).nombreArticulo)) {
                                    this.inventario.get(i).cantidad += f.compras.get(j).cantidadProducto;
                                }
                            }
                        }
                        System.out.println("\nFactura cancelada");
                    } else {
                        System.out.println("\nNo se encontro la factura");
                    }
                    break;
                case 7:
                    System.out.println("\n\t .: REPORTE ESTADÍSTICO :.");
                    break;
                case 8:
                    System.out.println("\n\t .: Terminando Turno :.");
                    System.out.println("\nTurno Finalizado...!");

                    dependienteActivo = this.dependiente.buscarDependienteActivo(dependientes);
                    if (dependienteActivo != null) {
                        dependienteActivo.activo = false;
                    }
                    login();
                    break;
                case 9:
                    System.out.println("\n\t .: Cerrar Sistema :.");
                    do {
                        System.out.println("Está seguro que desea cerrar sistema? (S/N): ");
                        respuesta = this.tecla.next().toUpperCase().charAt(0);
                        if (respuesta != 'S' && respuesta != 'N') {
                            System.out.println("S = Si, N = No");
                        }
                    } while (respuesta != 'S' && respuesta != 'N');

                    if (respuesta == 'S') {
                        System.out.println("\nCerrando sistema...!");
                    }
                    break;
                default:
                    System.out.println("\nError: No existe la opción");
            }

        } while (op != 8 && op != 9);
    }

    public void insertarArticuloInventario(LinkedList<Articulo> inventario) {
        String nombreArticulo, codigoArticulo;
        float precioArticulo;
        int cantidadArticulo;
        char respuesta = ' ';
        Articulo articulo = null;

        do {
            System.out.print("\nCódigo: ");
            codigoArticulo = this.tecla.nextLine().toUpperCase();
            System.out.print("Nombre: ");
            nombreArticulo = this.tecla.nextLine().toUpperCase();

            System.out.print("Precio: ");
            precioArticulo = this.tecla.nextInt();
            this.tecla.nextLine();
            System.out.print("Cantidad: ");
            cantidadArticulo = this.tecla.nextInt();
            try {
                articulo = new Articulo(nombreArticulo, codigoArticulo, precioArticulo, cantidadArticulo);
            } catch (Exception ex) {
                System.out.println("\nError: No existe espacio en memoria");
            }
            do {
                System.out.print("\nAgregar otro artículo?(S/N): ");
                respuesta = this.tecla.next().toUpperCase().charAt(0);
                if (respuesta != 'S' && respuesta != 'N') {
                    System.out.println("S = Si, N = No");
                }
            } while (respuesta != 'S' && respuesta != 'N');
        } while (respuesta == 'S');
    }

    public void mostrarDependiente(LinkedList<Dependiente> dependiente) {
        System.out.printf("\n%-3s%-14s%-10s\n", "Nº", "Nombre", "Teléfono");
        for (int i = 0; i < dependiente.size(); i++) {
            System.out.println((i + 1) + "  " + dependiente.get(i).toString());
        }
    }

    public void mostrarArticulo(LinkedList<Articulo> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("\nNo existen artículos");
        } else {
            System.out.printf("\n%-3s%-12s%-7s"
                    + "%-9s%-14s%-12s\n",
                    "Nº", "Nombre", "Código", "Cantidad", "Precio-Unidad", "Valor-Total");
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println((i + 1) + "  " + inventario.get(i).toString());
            }
        }
    }

    private void mostrarFacturas(LinkedList<Factura> facturas) {
        if (facturas.isEmpty()) {
            System.out.println("\nNo existen facturas");
        } else {
            for (int i = 0; i < facturas.size(); i++) {
                facturas.get(i).imprimirFacturaDatos();
            }
        }

    }

    public void mostrarClientes(LinkedList<Cliente> cliente) {
        if (cliente.isEmpty()) {
            System.out.println("\nNo existen clientes");
        } else {
            System.out.printf("%-3s%-14s%-11s"
                    + "%-13s%-9s\n",
                    "Nº", "Nombre", "Cédula", "Dirección", "Teléfono");
            for (int i = 0; i < cliente.size(); i++) {
                System.out.println((i + 1) + "  " + cliente.get(i).toString());
            }
        }
    }

    public boolean crearCliente() {
        Cedula cedula = new Cedula();
        System.out.println("\n\t .: Creando Cliente :.");
        String nombreCliente, apellidoCliente, idCliente, direccionCliente, telefonoCliente;

        System.out.print("\nNombre: ");
        nombreCliente = this.tecla.nextLine().toUpperCase();
        System.out.print("Apellido: ");
        apellidoCliente = this.tecla.nextLine().toUpperCase();
        do {
            System.out.print("Cédula: ");
            idCliente = this.tecla.nextLine();
            if (cedula.verificarCedula(idCliente) == false) {
                System.out.println("\nError: Ingreso de cédula incorrecto");
            }
        } while (!cedula.verificarCedula(idCliente));
        System.out.print("Dirección: ");
        direccionCliente = this.tecla.nextLine().toUpperCase();
        do {
            System.out.print("Teléfono: ");
            telefonoCliente = this.tecla.nextLine().toUpperCase();
            if (telefonoCliente.length() != 10) {
                System.out.println("\nError: Debe ingresar 10 dígitos");
            }
        } while (telefonoCliente.length() != 10);
        try {
            this.clientes.add(new Cliente(nombreCliente, apellidoCliente, idCliente, direccionCliente, telefonoCliente));
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    public Articulo vender(int posicionArticulo, int cantidadArticulo, Articulo articulo) {

        if (this.inventario.get(posicionArticulo).cantidad < cantidadArticulo) {
            System.out.println("\nNo hay suficiente cantidad en stock"
                    + "\nCantidad disponible de " + this.inventario.get(posicionArticulo).nombreArticulo
                    + " -> " + this.inventario.get(posicionArticulo).cantidad);
            return null;
        }
        this.inventario.get(posicionArticulo).cantidad -= cantidadArticulo;
        this.compras.add(new Compra(cantidadArticulo, articulo));
        return this.inventario.get(posicionArticulo);
    }

    public void facturar(Cliente cliente, LinkedList<Compra> compras, Dependiente dependiente,
            int codigo, boolean cancelado) {
        Factura fac = new Factura(cliente, compras, dependiente, codigo, cancelado);
        //this.factura = new Factura(cliente, compras, dependiente, codigo, cancelado);
        this.factura = fac;
        this.facturas.add(fac);
        //cliente.facturas.add(fac); // <-error
        dependiente.facturas.add(fac);
    }

    public boolean cancelarFactura(LinkedList<Factura> factura, int codigo) {
        Factura facturaAux = this.factura.buscarFactura(factura, codigo);
        if (facturaAux != null) {
            facturaAux.cancelado = true;
            if (facturaAux.cliente != null) {
                facturaAux.cliente.facturas.remove(facturaAux);
            }
            facturaAux.dependiente.facturas.remove(facturaAux);
            return true;
        }
        return false;

    }

    public void facturacion(LinkedList<Compra> compraActual) {
        String id;
        int op, posicionCliente;
        Cedula cedula = new Cedula();
        System.out.println("\n\t .: CREANDO FACTURA :.");
        System.out.println("\n1) Factura con datos"
                + "\n2) Consumidor final");

        System.out.print("\nElija la opción: ");
        op = this.tecla.nextInt();
        this.tecla.nextLine();
        do {
            switch (op) {
                case 1:
                    System.out.println("\n\t .: FACTURA CON DATOS :.");
                    do {
                        System.out.print("\nCédula: ");
                        id = this.tecla.nextLine();
                        if (cedula.verificarCedula(id) == false) {
                            System.out.println("\nError: Ingreso de cédula incorrecto");
                        }
                    } while (!cedula.verificarCedula(id));

                    if (this.cliente.buscarCliente(this.clientes, id) == -1) {
                        System.out.println("\nNo existe el cliente");
                        crearCliente();
                    }
                    posicionCliente = this.cliente.buscarCliente(this.clientes, id);
                    facturar(this.clientes.get(posicionCliente),
                            compraActual, this.dependiente.buscarDependienteActivo(this.dependientes), this.codigo, false);
                    this.codigo++;
                    break;
                case 2:
                    System.out.println("\n\t .: CONSUMIDOR FINAL :.");
                    Cliente cliente = new Cliente("Consumidor", "Final", "9999999999", "", "");
                    facturar(cliente, compraActual, this.dependiente.buscarDependienteActivo(this.dependientes), this.codigo, false);
                    this.codigo++;
                    break;
                default:
                    System.out.println("\nError: Opción no válida");
            }
        } while (op != 1 && op != 2);
    }

    private void mostrarPromedioClientes() {
        System.out.printf("\n%5s%10s\n\n",
                "Nombre-Apellido", "Prom($)");
        for (int i = 0; i < this.clientes.size(); i++) {
            if (!this.clientes.get(i).facturas.isEmpty()) {
                System.out.printf("%5s%8s%10.2f\n", this.clientes.get(i).nombre,
                        this.clientes.get(i).apellido);
            }
        }
    }

    public Factura valorMaximoFacturado() {
        Factura auxF = this.facturas.get(0);
        for (int i = 1; i < this.facturas.size(); i++) {
            if (this.facturas.get(i).totalPago() > auxF.totalPago() && this.facturas.get(i).cancelado == false) {
                auxF = this.facturas.get(i);
            }
        }
        if (auxF == this.facturas.get(0) && auxF.cancelado != false) {
            auxF = null;
        }
        return auxF;
    }

    private float valorTotalFacturado(LinkedList<Factura> facturas) {
        float total = 0;
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).cancelado == false) {
                total = total + facturas.get(i).totalPago();
            }
        }
        return total;
    }
}
