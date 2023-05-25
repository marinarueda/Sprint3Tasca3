import java.util.ArrayList;
import java.util.Scanner;

public class FloristeriaApp {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {

        boolean salir = false;
        do{
            switch (menu()) {
                case 1 -> {
                    Floristeria floristeria = addFloristeria();
                    System.out.println(floristeria);
                }
                case 2 -> {
                    addArbol(Floristeria.getArboles());
                    System.out.println(Floristeria.getArboles());
                }
                case 3 -> {
                    addFlor(Floristeria.getFlores());
                    System.out.println(Floristeria.getFlores());
                }
                case 4 -> {
                    addDecoracion(Decoracion.getDecoraciones());
                    System.out.println(Floristeria.getDecoraciones());
                }
                case 5 -> imprimirStock(Floristeria.getArboles(),Floristeria.getFlores(),Floristeria.getDecoraciones());
                case 0 -> {
                    System.out.println("Salir de la aplicación");
                    salir = true;
                }
            }
        }while(!salir);
    }

    private static void imprimirStock(ArrayList<Arbol> arboles, ArrayList<Flor> flores, ArrayList<Decoracion> decoraciones) {
        System.out.println("Stock de la Floristería:");

        System.out.println("Arboles:\n");
        for (Arbol arbol : arboles) {
            System.out.println(arbol);
        }

        System.out.println("Flores:\n");
        for (Flor flor : flores) {
            System.out.println(flor);
        }

        System.out.println("Decoraciones:\n");
        for (Decoracion decoracion : decoraciones) {
            System.out.println(decoracion);
        }
    }

    private static void addDecoracion(ArrayList<Decoracion> decoraciones) {
        System.out.print("Introduce el nombre del artículo: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce el precio del artículo: ");
        double precioArbol = entrada.nextDouble();
        System.out.print("Introduce la cantidad: ");
        int stock = entrada.nextInt();
        System.out.print("Introduce el material: ");
        String material = entrada.nextLine();
        entrada.nextLine(); // limpieza buffer

        Floristeria floristeria = addFloristeria();
        Decoracion decoracion = new Decoracion(nombre, precioArbol, stock, material);
        floristeria.addDecoracion(decoraciones, decoracion);
        System.out.println("Artículo añadido al catálogo en la floristería " + decoracion.getNombre());
    }


    private static void addFlor(ArrayList<Flor> flores) {
        System.out.print("Introduce el nombre de la flor: ");
        String nombreFlor = entrada.nextLine();
        System.out.print("Introduce el precio de la flor: ");
        double precioFlor = entrada.nextDouble();
        entrada.nextLine();
        System.out.print("Introduce el color de la flor: ");
        String color = entrada.nextLine();
        System.out.print("Introduce la cantidad de flores: ");
        int stock = entrada.nextInt();
        entrada.nextLine(); // limpieza buffer

        Flor flor = new Flor(nombreFlor, precioFlor, color, stock);
        flor.addFlor(flores, flor);
        System.out.println("Flor añadida a catalogo");

    }

    private static void addArbol(ArrayList<Arbol>arboles) {
        System.out.print("Introduce el nombre del arbol: ");
        String nombreArbol = entrada.nextLine();
        System.out.print("Introduce el precio del arbol: ");
        double precioArbol = entrada.nextDouble();
        System.out.print("Introduce la cantidad de arboles: ");
        int stock = entrada.nextInt();
        System.out.print("Introduce la altura del arbol: ");
        double alturaArbol = entrada.nextDouble();
        entrada.nextLine(); // limpieza buffer

        Floristeria floristeria = addFloristeria();
        Arbol arbol = new Arbol(nombreArbol, precioArbol, stock, alturaArbol);
        floristeria.addArbol(arboles, arbol);
        System.out.println("Arbol añadido al catálogo en la floristería " + floristeria.getNombre());

    }

    private static Floristeria addFloristeria() {
        System.out.println("¿Cómo se llama la Floristería?");
        String nombre = entrada.nextLine();
        return new Floristeria(nombre);
    }

    public static byte menu(){

        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 13;


        do{
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Crear Floristeria");
            System.out.println("2. Añadir Arbol");
            System.out.println("3. Añadir Flor");
            System.out.println("4. Añadir Decoración");
            System.out.println("5. Retirar Arbol");
            System.out.println("6. Retirar Flor");
            System.out.println("7. Retirar Decoración");
            System.out.println("8. Ver todos los productos");
            System.out.println("9. Ver Stock con cantidades");
            System.out.println("10. Ver valor total productos floristeria");
            System.out.println("11. Crear Tiquet de compra");
            System.out.println("12. Mostrar lista de tiquets antiguos");
            System.out.println("13. Ver total facturación(€)");
            System.out.println("0. Salir de la aplicación\n");
            opcio = entrada.nextByte();
            entrada.nextLine();
            if(opcio < MINIMO || opcio > MAXIMO){
                System.out.println("Elige una opción válida");
            }
        }while(opcio < MINIMO || opcio > MAXIMO);
        return opcio;
    }

}
