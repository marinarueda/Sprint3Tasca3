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
        arboles = new ArrayList<>();
        flores = new ArrayList<>();
        decoraciones = new ArrayList<>();
        stockTotal = stockTotal;
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

        int stock = 0;

        if (producto instanceof Arbol arbol) {
            int stockActual = arbol.getStock() + stock;
            arbol.setStock(stockActual);
        } else if (producto instanceof Flor flor) {
            flor.setStock(flor.getStock());
        } else if (producto instanceof Decoracion decoracion) {
            decoracion.setStock(decoracion.getStock());
        }
    }


    //MÉTODOS:
    public void reducirStock(Floristeria productoEncontrado, int cantidad) {
        if (productoEncontrado instanceof Arbol arbol) {
            arbol.setStock(arbol.getStock() - cantidad);
        } else if (productoEncontrado instanceof Flor flor) {
            flor.setStock(flor.getStock() - cantidad);
        } else if (productoEncontrado instanceof Decoracion decoracion) {
            decoracion.setStock(decoracion.getStock() - cantidad);
        }
    }

    public double calcularValorTotalStock(ArrayList<Floristeria> productos) {
        double valorTotalStock = 0.0;

        for (Floristeria producto : productos) {
            if (producto instanceof Arbol arbol) {
                valorTotalStock += arbol.getStock() * arbol.getPrecio();
            } else if (producto instanceof Flor flor) {
                valorTotalStock += flor.getStock() * flor.getPrecio();
            } else if (producto instanceof Decoracion decoracion) {
                valorTotalStock += decoracion.getStock() * decoracion.getPrecio();
            }
        }

        return valorTotalStock;
    }

    public void calcularStockCantidades(ArrayList<Floristeria> productos) {
        System.out.println("STOCK");

        for (Floristeria producto : productos) {
            if (producto instanceof Arbol arbol) {
                System.out.println("ARBOLES:\n" + (arbol.getStock()));
            } else if (producto instanceof Flor flor) {
                System.out.println("FLORES:\n" + (flor.getStock()));
            } else if (producto instanceof Decoracion decoracion) {
                System.out.println("DECORACIÓN:\n" + (decoracion.getStock()));
            }
        }
    }

    public Floristeria buscarProductoPorNombre(String nombreProducto) {

        for (Floristeria arbol : Tiquet.getProductos()) {
            if (arbol.getNombre().equalsIgnoreCase(nombreProducto)) {
                return arbol;
            }
        }

        for (Floristeria flor : Tiquet.getProductos()) {
            if (flor.getNombre().equalsIgnoreCase(nombreProducto)) {
                return flor;
            }
        }

        for (Floristeria decoracion : Tiquet.getProductos()) {
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

    public static ArrayList<Arbol> getArboles() {
        return arboles;
    }

    public static ArrayList<Decoracion> getDecoraciones() {
        return decoraciones;
    }

    public Tiquet getTiquet() {

        return null;
    }

    public void verDetalleTiquet() {
        Tiquet.verHistorialTiquets(Tiquet.getCompras());
    }

    @Override
    public String toString() {
        return "Floristeria:" + nombre;
    }





}