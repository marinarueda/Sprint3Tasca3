import java.util.ArrayList;

public class Tiquet {
    private static int contadorTiquets = 0;
    private int numeroTiquet;
    private static ArrayList<Floristeria> compras;
    private static ArrayList<Floristeria> productos;

    static {
        productos = new ArrayList<>();
    }
    static {
        compras = new ArrayList<>();
    }

    public static ArrayList<Floristeria> getProductos() {
        return productos;
    }

    public Tiquet() {
        this.numeroTiquet = ++contadorTiquets;
        compras = new ArrayList<>();
    }

    public void addCompras(Floristeria productoEncontrado) {
        compras.add(productoEncontrado);
    }



    public static void verHistorialTiquets(ArrayList<Floristeria> compras) {
        System.out.println("Historial de Tiquets:");
        for (int i = 0; i < compras.size(); i++) {
            Floristeria tiquet = compras.get(i);
            System.out.println("Tiquet #" + (i + 1));
            tiquet.verDetalleTiquet();
            System.out.println(); // Salto de línea para separar los tiquets
        }
    }

    public static double calcularTotal() {
        int totalProductos = compras.size();
        double totalPrecio = 0.0;

        System.out.println("Artículos en el tiquet:");
        for (Floristeria producto : compras) {
            if (producto instanceof Flor flor) {
                System.out.println("- Flor: " + flor.getNombre() + ": Precio: " + flor.getPrecio() + "€");
                totalPrecio += flor.getPrecio();
            } else if (producto instanceof Arbol arbol) {
                System.out.println("- Árbol: " + arbol.getNombre() + ": Precio: " + arbol.getPrecio() + "€");
                totalPrecio += arbol.getPrecio();
            } else if (producto instanceof Decoracion decoracion) {
                System.out.println("- Decoración: " + decoracion.getNombre() + ": Precio: " + decoracion.getPrecio() + "€");
                totalPrecio += decoracion.getPrecio();
            }
        }

        System.out.println("Total de productos en el tiquet: " + totalProductos);
        System.out.println("Total de precio en el tiquet: " + totalPrecio);

        return totalPrecio;
    }

    public void setCompras(ArrayList<Floristeria> compras) {
        Tiquet.compras = compras;
    }

    public static ArrayList<Floristeria> getCompras() {
        return compras;
    }

    public static void setProductos(ArrayList<Floristeria> productos) {
        Tiquet.productos = productos;
    }

    public int getNumeroTiquet() {
        return numeroTiquet;
    }

    public void setNumeroTiquet(int numeroTiquet) {
        this.numeroTiquet = numeroTiquet;
    }
}
