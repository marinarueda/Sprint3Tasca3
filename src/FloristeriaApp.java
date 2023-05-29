import java.util.ArrayList;
import java.util.Scanner;

public class FloristeriaApp {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        //productos para pruebas
        Floristeria floristeria = new Floristeria("EsViver");
        Arbol arbol1 = new Arbol("Pino", 25.0, 10, 2.5);
        floristeria.addProducto(arbol1);
        Flor flor1 = new Flor("Margarita",15.0,"Amarillo",15);
        floristeria.addProducto(flor1);
        Decoracion decoracion1 = new Decoracion("Macetero",40,30,"Plástico");
        floristeria.addProducto(decoracion1);

        boolean salir = false;
        do{
            switch (menu()) {
                case 1 -> addFloristeria();
                case 2 -> addArbol();
                case 3 -> addFlor();
                case 4 -> addDecoracion();
                case 5 -> retirarArbol(Tiquet.getProductos());
                case 6 -> retirarFlor(Tiquet.getProductos());
                case 7 -> retirarDecoracion(Tiquet.getProductos());
                case 8 -> imprimirStock(Tiquet.getProductos());
                case 9 -> stockConCantidades(floristeria);
                ****case 10 -> stockConPrecios(floristeria);
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
            System.out.println("Ingrese la cantidad del producto:");
            int cantidad = entrada.nextInt();
            entrada.nextLine();

            // Buscar el producto por su nombre en Floristeria
            Floristeria productoEncontrado = floristeria.buscarProductoPorNombre(nombreProducto);

            if (productoEncontrado != null) {
                // Agregar el producto al tiquet
                ticket.addProducto(productoEncontrado);
                System.out.println("Producto agregado al tiquet.");
                productoEncontrado.reducirStock(cantidad);

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
        double valorTotalProductos = floristeria.calcularValorTotalStock(Tiquet.getProductos());
        System.out.println("Valor total de los productos: " + valorTotalProductos);
    }

    private static void stockConCantidades(Floristeria floristeria) {
        floristeria.calcularStockCantidades(Tiquet.getProductos());
    }

    private static void retirarDecoracion(ArrayList<Floristeria> productos) {
        System.out.print("Introduce el nombre del articulo a retirar: ");
        String nombreArticulo = entrada.nextLine();
        System.out.print("Introduce la cantidad de unidades a retirar: ");
        int unidadesARetirar = entrada.nextInt();
        entrada.nextLine(); // Consumir el carácter de nueva línea

        for (Floristeria decoracion : Tiquet.getProductos()) {
            if (decoracion instanceof Decoracion && decoracion.getNombre().equalsIgnoreCase(nombreArticulo)) {
                int stockActual = ((Decoracion) decoracion).getStock();

                if (unidadesARetirar <= stockActual) {
                    ((Decoracion) decoracion).setStock(stockActual - unidadesARetirar);
                    System.out.println("Se retiraron " + unidadesARetirar + " unidades del artículo " + decoracion.getNombre());
                } else {
                    System.out.println("No hay suficientes unidades de ese artículo en el stock.");
                }
                return;
            }
        }

        System.out.println("No se encontró el artículo con ese nombre en el catálogo.");
    }

    private static void retirarFlor(ArrayList<Floristeria> productos) {
        System.out.print("Introduce el nombre de la flor a retirar: ");
        String nombreFlor = entrada.nextLine();
        System.out.print("Introduce la cantidad de unidades a retirar: ");
        int unidadesARetirar = entrada.nextInt();
        entrada.nextLine(); // Consumir el carácter de nueva línea

        for (Floristeria flor : Tiquet.getProductos()) {
            if (flor instanceof Flor && flor.getNombre().equalsIgnoreCase(nombreFlor)) {
                int stockActual = ((Flor) flor).getStock();

                if (unidadesARetirar <= stockActual) {
                    ((Flor) flor).setStock(stockActual - unidadesARetirar);
                    System.out.println("Se retiraron " + unidadesARetirar + " unidades de la flor " + flor.getNombre());
                } else {
                    System.out.println("No hay suficientes unidades de esa flor en el stock.");
                }
                return;
            }
        }
        System.out.println("No se encontró una flor con ese nombre en el catálogo.");
    }

    private static void retirarArbol(ArrayList<Floristeria> productos) {
        System.out.print("Introduce el nombre del árbol a retirar: ");
        String nombreArbol = entrada.nextLine();
        System.out.print("Introduce la cantidad de unidades a retirar: ");
        int unidadesARetirar = entrada.nextInt();
        entrada.nextLine(); // Consumir el carácter de nueva línea


        for (Floristeria arbol : Tiquet.getProductos()) {
            if (arbol instanceof Arbol && arbol.getNombre().equalsIgnoreCase(nombreArbol)) {
                int stockActual = ((Arbol) arbol).getStock();

                if (unidadesARetirar <= stockActual) {
                    ((Arbol) arbol).setStock(stockActual - unidadesARetirar);
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

    private static void imprimirStock(ArrayList<Floristeria> productos) {
        System.out.println("Stock de la Floristería:");

        System.out.println("Arboles:");
        for (Floristeria producto : productos) {
            if (producto instanceof Arbol) {
                System.out.println(producto);
            }
        }

        System.out.println("Flores:");
        for (Floristeria producto : productos) {
            if (producto instanceof Flor) {
                System.out.println(producto);
            }
        }

        System.out.println("Decoraciones:");
        for (Floristeria producto : productos) {
            if (producto instanceof Decoracion) {
                System.out.println(producto);
            }
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
        entrada.nextLine();
        System.out.print("Introduce el material: ");
        String material = entrada.nextLine();

        Decoracion decoracion = new Decoracion(nombre, precioArbol, stock, material);
        floristeria.addProducto(decoracion);
        System.out.println(Tiquet.getProductos());
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
        floristeria.addProducto(flor);
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
        floristeria.addProducto(arbol);
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
