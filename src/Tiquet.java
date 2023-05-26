import java.util.ArrayList;

public class Tiquet {
    private ArrayList<Floristeria> compra;

    public Tiquet() {
        this.compra = new ArrayList<Floristeria>();
    }

    public void addProducto(Floristeria producto) {
        compra.add(producto);
    }

    public void setCompra(ArrayList<Floristeria> compra) {
        this.compra = compra;
    }

    public ArrayList<Floristeria> getCompra() {
        return compra;
    }

    public void calcularTotal() {
        int totalProductos = compra.size();
        double totalPrecio = 0.0;

        System.out.println("Artículos en el tiquet:");
        for (Floristeria producto : compra) {
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
}
