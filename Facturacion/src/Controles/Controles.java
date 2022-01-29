package Controles;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controles {

    private Scanner tecla = new Scanner(System.in);
    private int numeroEnteroPositivo, numeroEntero;
    private float numeroDecimal, numeroDecimalPositivo;
    private String cadena, string, titulo;
    private char respuesta;
    private boolean repetir = true;

    public void ingresoCadena(String cadena) {
        //un metodo para mostrar mensajes al usuario
        setCadena(cadena);
    }

    public void ingresoTitulo(String titulo) {
        System.out.printf("\n%30S\n", titulo);
    }

    public String ingresoString() {
        //un metodo para ingresar cadenas por parte del usuario
        //imprimimos la candena que se paso en el metodo ingresoCadena

        do {
            System.out.print(getCadena());
            setString(tecla.nextLine());
            if (getString().length() < 3) {
                System.out.println("\nError: Número mínimo de caracteres 3");
            }
        } while (getString().length() < 3);
        return getString();
    }

    public char ingresoRespuesta() {
        //un metodo de tipo char para los caracteres
        System.out.print(getCadena());
        setRespuesta(tecla.nextLine().toUpperCase().charAt(0));
        return getRespuesta();
    }

    public void vaciarBuffer() {
        tecla.nextLine();
    }

    public int ingresoNumeroEnteroPositivo() {
        do {
            setRepetir(true); // se vuelve a inicializar em true la variable repetir para que funcione try-catch correctamente
            //y me vuelva a pedir el dato que se debe ingresar
            do {
                try {
                    //antes de llamar este metodo, ocupar el metodo ingresoCadena para enviar un mensaje de lo que se va a pedir
                    System.out.print(getCadena()); //imprimimos el valor de esa cadena
                    setNumeroEnteroPositivo(tecla.nextInt());
                    setRepetir(false);
                    if (getNumeroEnteroPositivo() <= 0) {
                        System.out.println("\nError: Ingrese un número positivo");
                    }
                } catch (InputMismatchException ex) {
                    System.out.println("\nError: Ingreso de datos no permitido");
                    tecla.nextLine();
                }
            } while (getNumeroEnteroPositivo() <= 0);
        } while (isRepetir() == true);
        tecla.nextLine();
        return getNumeroEnteroPositivo();
    }

    public int ingresoNumeroEntero() {
        do {
            setRepetir(true); //se vuelve a inicializar em true la variable repetir para que funcione try-catch correctamente
            //y me vuelva a pedir el dato que se debe ingresar
            try {
                //antes de llamar este metodo, ocupar el metodo ingresoCadena para enviar un mensaje de lo que se va a pedir
                System.out.print(getCadena()); //imprimimos el valor de esa cadena
                setNumeroEntero(tecla.nextInt());
                setRepetir(false);
            } catch (InputMismatchException ex) {
                System.out.println("\nError: Ingreso de datos no permitido");
                tecla.nextLine();
            }
        } while (isRepetir() == true);
        tecla.nextLine();
        return getNumeroEntero();
    }

    public float ingresoNumeroDecimal() {
        do {
            setRepetir(true); // se vuelve a inicializar em true la variable repetir para que funcione try-catch correctamente
            //y me vuelva a pedir el dato que se debe ingresar
            try {
                //antes de llamar este metodo, ocupar el metodo ingresoCadena para enviar un mensaje de lo que se va a pedir
                System.out.print(getCadena()); //imprimimos el valor de esa cadena
                setNumeroDecimal(tecla.nextFloat());
                setRepetir(false);
            } catch (InputMismatchException ex) {
                System.out.println("\nError: Ingreso de datos no permitido");
                tecla.nextLine();
            }
        } while (isRepetir() == true);
        tecla.nextLine();
        return getNumeroDecimal();
    }

    public float ingresoNumeroDecimalPositivo() {
        do {
            setRepetir(true); // se vuelve a inicializar em true la variable repetir para que funcione try-catch correctamente
            //y me vuelva a pedir el dato que se debe ingresar
            do {
                try {
                    //antes de llamar este metodo, ocupar el metodo ingresoCadena para enviar un mensaje de lo que se va a pedir
                    System.out.print(getCadena()); //imprimimos el valor de esa cadena
                    setNumeroDecimalPositivo(tecla.nextFloat());
                    setRepetir(false);
                } catch (InputMismatchException ex) {
                    System.out.println("\nError: Ingreso de datos no permitido");
                    tecla.nextLine();
                }
            } while (getNumeroDecimalPositivo() <= 0);
        } while (isRepetir() == true);
        tecla.nextLine();
        return getNumeroDecimalPositivo();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getNumeroDecimalPositivo() {
        return numeroDecimalPositivo;
    }

    public void setNumeroDecimalPositivo(float numeroDecimalPositivo) {
        this.numeroDecimalPositivo = numeroDecimalPositivo;
    }

    public int getNumeroEnteroPositivo() {
        return numeroEnteroPositivo;
    }

    public void setNumeroEnteroPositivo(int numeroEnteroPositivo) {
        this.numeroEnteroPositivo = numeroEnteroPositivo;
    }

    public int getNumeroEntero() {
        return numeroEntero;
    }

    public void setNumeroEntero(int numeroEntero) {
        this.numeroEntero = numeroEntero;
    }

    public float getNumeroDecimal() {
        return numeroDecimal;
    }

    public void setNumeroDecimal(float numeroDecimal) {
        this.numeroDecimal = numeroDecimal;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public char getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(char respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isRepetir() {
        return repetir;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
