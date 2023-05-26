import java.util.ArrayList;

public class Tiquet {
    private static int contadorTiquets = 0;
    private int numeroTiquet;
    private static ArrayList<Floristeria> compras;

    public Tiquet() {
        this.numeroTiquet = ++contadorTiquets;
        this.compras = new ArrayList<Floristeria>();
    }

    public void verHistorialTiquets() {
        System.out.println("Historial de Tiquets:");
        for (int i = 0; i < compras.size(); i++) {
            Floristeria tiquet = compras.get(i);
            System.out.println("Tiquet #" + (i + 1));
            // Aquí puedes imprimir los detalles del tiquet, como los productos, precios, etc.
        }
    }

    public void calcularTotal() {
        int totalProductos = compras.size();
        double totalPrecio = 0.0;

        System.out.println("Artículos en el tiquet:");
        for (Floristeria producto : compras) {
            if (producto instanceof Flor) {
                Flor flor = (Flor) producto;
                System.out.println("- Flor: " + flor.getNombre() + ": Precio: " + flor.getPrecio()+"€");
                totalPrecio += flor.getPrecio();
            } else if (producto instanceof Arbol) {
                Arbol arbol = (Arbol) producto;
                System.out.println("- Árbol: " + arbol.getNombre() + ": Precio: " + arbol.getPrecio()+"€");
                totalPrecio += arbol.getPrecio();
            } else if (producto instanceof Decoracion) {
                Decoracion decoracion = (Decoracion) producto;
                System.out.println("- Decoración: " + decoracion.getNombre() + ": Precio: " + decoracion.getPrecio()+"€");
                totalPrecio += decoracion.getPrecio();
            }
        }

        System.out.println("Total de productos en el tiquet: " + totalProductos);
        System.out.println("Total de precio en el tiquet: " + totalPrecio);
    }

    public void addProducto(Floristeria producto, int cantidad) {
        compras.add(producto);
        producto.reducirStock(cantidad); // Restar cantidad al stock del producto
    }


    public void setCompras(ArrayList<Floristeria> compra) {
        this.compras = compra;
    }

    public static ArrayList<Floristeria> getCompras() {
        return compras;
    }


}
