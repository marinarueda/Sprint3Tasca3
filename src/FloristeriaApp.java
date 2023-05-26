import java.util.ArrayList;
import java.util.Scanner;

public class FloristeriaApp {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        //productos para pruebas
        Floristeria floristeria = new Floristeria("EsViver");
        Arbol arbol1 = new Arbol("Pino", 25.0, 10, 2.5);
        floristeria.addArbol(arbol1);
        Flor flor1 = new Flor("Margarita",15.0,"Amarillo",15);
        floristeria.addFlor(flor1);
        Decoracion decoracion1 = new Decoracion("Macetero",40.50,30,"Plástico");
        floristeria.addDecoracion(decoracion1);

        boolean salir = false;
        do{
            switch (menu()) {
                case 1 -> addFloristeria();
                case 2 -> addArbol();
                case 3 -> addFlor();
                case 4 -> addDecoracion();
                case 5 -> retirarArbol(Floristeria.getArboles());
                case 6 -> retirarFlor(Floristeria.getFlores());
                case 7 -> retirarDecoracion(Floristeria.getDecoraciones());
                case 8 -> imprimirStock(Floristeria.getArboles(),Floristeria.getFlores(),Floristeria.getDecoraciones());
                case 9 -> stockConCantidades(floristeria);
                case 10 -> stockConPrecios(floristeria);
                case 11 -> crearTiquet(floristeria);
                //case 12 -> historialTiquets();
                //case 13 -> totalFacturacion();
                case 0 -> {
                    System.out.println("Salir de la aplicación");
                    salir = true;
                }
            }
        }while(!salir);
    }

    private static void crearTiquet(Floristeria floristeria) {
        boolean agregarProductos = true;
        Tiquet ticket = new Tiquet();

        while(agregarProductos){
            System.out.println("Ingrese el nombre del producto:");
            String nombreProducto = entrada.nextLine();

            // Buscar el producto por su nombre en Floristeria
            Floristeria productoEncontrado = floristeria.buscarProductoPorNombre(nombreProducto);

            if (productoEncontrado != null) {
                // Agregar el producto al tiquet
                ticket.addProducto(productoEncontrado);
                System.out.println("Producto agregado al tiquet.");

                System.out.println("¿Desea agregar otro producto? (S/N)");
                String opcion = entrada.nextLine();
                if (opcion.equalsIgnoreCase("N")) {
                    agregarProductos = false;
                }
            } else {
                System.out.println("No se encontró el producto en la Floristería.");
            }

        }

        ticket.calcularTotal();
    }

    private static void stockConPrecios(Floristeria floristeria) {
        double valorTotalProductos = floristeria.calcularValorTotalStock();
        System.out.println("Valor total de los productos: " + valorTotalProductos);
    }

    private static void stockConCantidades(Floristeria floristeria) {
        floristeria.calcularStockCantidades(Floristeria.getArboles(),Floristeria.getFlores(),Floristeria.getDecoraciones());
    }

    private static void retirarDecoracion(ArrayList<Decoracion> decoraciones) {
        System.out.print("Introduce el nombre del articulo a retirar: ");
        String nombreArticulo = entrada.nextLine();
        System.out.print("Introduce la cantidad de unidades a retirar: ");
        int unidadesARetirar = entrada.nextInt();

        // Buscar el árbol con el nombre especificado
        for (Decoracion decoracion : decoraciones) {
            if (decoracion.getNombre().equalsIgnoreCase(nombreArticulo)) {
                int stockActual = decoracion.getStock();

                if (unidadesARetirar <= stockActual) {
                    decoracion.setStock(stockActual - unidadesARetirar);
                    System.out.println("Se retiraron " + unidadesARetirar + " unidades de la flor " + decoracion.getNombre());
                } else {
                    System.out.println("No hay suficientes unidades de esa flor en el stock.");
                }
                return; // Salir del método después de retirar las unidades
            }
        }

        System.out.println("No se encontró una flor con ese nombre en el catálogo.");
    }

    private static void retirarFlor(ArrayList<Flor> flores) {
        System.out.print("Introduce el nombre de la flor a retirar: ");
        String nombreFlor = entrada.nextLine();
        System.out.print("Introduce la cantidad de unidades a retirar: ");
        int unidadesARetirar = entrada.nextInt();

        for (Flor flor : flores) {
            if (flor.getNombre().equalsIgnoreCase(nombreFlor)) {
                int stockActual = flor.getStock();

                if (unidadesARetirar <= stockActual) {
                    flor.setStock(stockActual - unidadesARetirar);
                    System.out.println("Se retiraron " + unidadesARetirar + " unidades de la flor " + flor.getNombre());
                } else {
                    System.out.println("No hay suficientes unidades de esa flor en el stock.");
                }
                return;
            }
        }
        System.out.println("No se encontró una flor con ese nombre en el catálogo.");
    }

    private static void retirarArbol(ArrayList<Arbol> arboles) {
        System.out.print("Introduce el nombre del árbol a retirar: ");
        String nombreArbol = entrada.nextLine();
        System.out.print("Introduce la cantidad de unidades a retirar: ");
        int unidadesARetirar = entrada.nextInt();

        // Buscar el árbol con el nombre especificado
        for (Arbol arbol : arboles) {
            if (arbol.getNombre().equalsIgnoreCase(nombreArbol)) {
                int stockActual = arbol.getStock();

                if (unidadesARetirar <= stockActual) {
                    arbol.setStock(stockActual - unidadesARetirar);
                    System.out.println("Se retiraron " + unidadesARetirar + " unidades del árbol " + arbol.getNombre());
                } else {
                    System.out.println("No hay suficientes unidades de ese árbol en el stock.");
                }
                return;
            }
        }
        // Si no se encontró ningún árbol con el nombre especificado
        System.out.println("No se encontró un árbol con ese nombre en el catálogo.");
    }

    private static void imprimirStock(ArrayList<Arbol> arboles, ArrayList<Flor> flores, ArrayList<Decoracion> decoraciones) {
        System.out.println("Stock de la Floristería:");

        System.out.println("Arboles:");
        for (Arbol arbol : arboles) {
            System.out.println(arbol);
        }

        System.out.println("Flores:");
        for (Flor flor : flores) {
            System.out.println(flor);
        }

        System.out.println("Decoraciones:");
        for (Decoracion decoracion : decoraciones) {
            System.out.println(decoracion);
        }
    }

    private static void addDecoracion() {
        Floristeria floristeria = addFloristeria();

        System.out.print("Introduce el nombre del artículo: ");
        String nombre = entrada.nextLine();
        System.out.print("Introduce el precio del artículo: ");
        double precioArbol = entrada.nextDouble();
        System.out.print("Introduce la cantidad: ");
        int stock = entrada.nextInt();
        System.out.print("Introduce el material: ");
        String material = entrada.nextLine();

        Decoracion decoracion = new Decoracion(nombre, precioArbol, stock, material);
        floristeria.addDecoracion(decoracion);
        System.out.println("Artículo añadido al catálogo en la floristería " + floristeria.getNombre());
    }

    private static void addFlor() {
        Floristeria floristeria = addFloristeria();

        System.out.print("Introduce el nombre de la flor: ");
        String nombreFlor = entrada.nextLine();
        System.out.print("Introduce el precio de la flor: ");
        double precioFlor = entrada.nextDouble();
        entrada.nextLine();
        System.out.print("Introduce el color de la flor: ");
        String color = entrada.nextLine();
        System.out.print("Introduce la cantidad de flores: ");
        int stock = entrada.nextInt();

        Flor flor = new Flor(nombreFlor, precioFlor, color, stock);
        floristeria.addFlor(flor);
        System.out.println("Flor añadida al catálogo en la floristería " + floristeria.getNombre());

    }

    private static void addArbol() {
        Floristeria floristeria = addFloristeria();

        System.out.print("Introduce el nombre del arbol: ");
        String nombreArbol = entrada.nextLine();
        System.out.print("Introduce el precio del arbol: ");
        double precioArbol = entrada.nextDouble();
        System.out.print("Introduce la cantidad de arboles: ");
        int stock = entrada.nextInt();
        System.out.print("Introduce la altura del arbol: ");
        double alturaArbol = entrada.nextDouble();

        Arbol arbol = new Arbol(nombreArbol, precioArbol, stock, alturaArbol);
        floristeria.addArbol(arbol);
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
