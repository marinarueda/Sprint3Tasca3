import java.util.ArrayList;
public class Floristeria {
    private String nombre;
    private static ArrayList<Arbol> arboles;
    private static ArrayList<Flor> flores;
    private static ArrayList<Decoracion> decoraciones;
    private double stockTotal;

    // Constructor
    public Floristeria(String nombre) {
        this.nombre = nombre;
        arboles = new ArrayList<Arbol>();
        flores = new ArrayList<Flor>();
        decoraciones = new ArrayList<Decoracion>();
        stockTotal = stockTotal;
    }

    public Floristeria() {

    }

    // Getter y Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getStockTotal() {
        return stockTotal;
    }

    public void setStockTotal(double stockTotal) {
        this.stockTotal = stockTotal;
    }

    public static void addProducto(Floristeria producto) {
        Tiquet.getProductos().add(producto);
        System.out.println("Producto añadido al catálogo");

        if (producto instanceof Arbol) {
            Arbol arbol = (Arbol) producto;
            arbol.setStock(arbol.getStock() + 1);
        } else if (producto instanceof Flor) {
            Flor flor = (Flor) producto;
            flor.setStock(flor.getStock() + 1);
        } else if (producto instanceof Decoracion) {
            Decoracion decoracion = (Decoracion) producto;
            decoracion.setStock(decoracion.getStock() + 1);
        }
    }

    public double calcularValorTotalStock(ArrayList<Floristeria>productos) {
        double valorTotalStock = 0.0;

        for (Floristeria producto : productos) {
            if (producto instanceof Arbol) {
                Arbol arbol = (Arbol) producto;
                valorTotalStock += arbol.getStock() * arbol.getPrecio();
            } else if (producto instanceof Flor) {
                Flor flor = (Flor) producto;
                valorTotalStock += flor.getStock() * flor.getPrecio();
            } else if (producto instanceof Decoracion) {
                Decoracion decoracion = (Decoracion) producto;
                valorTotalStock += decoracion.getStock() * decoracion.getPrecio();
            }
        }

        return valorTotalStock;
    }

    public void calcularStockCantidades(ArrayList<Floristeria>productos) {
        System.out.println("STOCK");

        for (Floristeria producto : productos) {
            if (producto instanceof Arbol) {
                Arbol arbol = (Arbol) producto;
                System.out.println("ARBOLES:\n" + (arbol.getStock() - 1));
            } else if (producto instanceof Flor) {
                Flor flor = (Flor) producto;
                System.out.println("FLORES:\n" + (flor.getStock() - 1));
            } else if (producto instanceof Decoracion) {
                Decoracion decoracion = (Decoracion) producto;
                System.out.println("DECORACIÓN:\n" + (decoracion.getStock() - 1));
            }
        }
    }

    public Floristeria buscarProductoPorNombre(String nombreProducto) {

        for (Arbol arbol : Floristeria.getArboles()) {
            if (arbol.getNombre().equalsIgnoreCase(nombreProducto)) {
                return arbol;
            }
        }

        for (Flor flor : Floristeria.getFlores()) {
            if (flor.getNombre().equalsIgnoreCase(nombreProducto)) {
                return flor;
            }
        }

        for (Decoracion decoracion : Floristeria.getDecoraciones()) {
            if (decoracion.getNombre().equalsIgnoreCase(nombreProducto)) {
                return decoracion;
            }
        }

        return null;
    }

    // Getter y Setter para listas
    public static ArrayList<Flor> getFlores() {
        return flores;
    }

    public void setFlores(ArrayList<Flor> flores) {
        this.flores = flores;
    }

    public static ArrayList<Arbol> getArboles() {
        return arboles;
    }

    public void setArboles(ArrayList<Arbol> arboles) {
        this.arboles = arboles;
    }

    public static ArrayList<Decoracion> getDecoraciones() {
        return decoraciones;
    }

    public void setDecoraciones(ArrayList<Decoracion> decoraciones) {
        this.decoraciones = decoraciones;
    }


    @Override
    public String toString() {
        return "Floristeria:" + nombre ;
    }

    public void reducirStock(int cantidad) {
    }
}
