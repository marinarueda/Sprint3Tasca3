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
        this.arboles = new ArrayList<Arbol>();
        this.flores = new ArrayList<Flor>();
        this.decoraciones = new ArrayList<Decoracion>();
        this.stockTotal = stockTotal;
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

    public void addArbol(Arbol arbol) {
        arboles.add(arbol);
        System.out.println("Arbol añadido a catalogo");
        arbol.setStock(arbol.getStock() + 1);
    }

    public void addFlor(Flor flor) {
        flores.add(flor);
        System.out.println("Flor añadida a catalogo");
        flor.setStock(flor.getStock() + 1);
    }

    public void addDecoracion(Decoracion decoracion) {
        decoraciones.add(decoracion);
        System.out.println("Artículo añadido a catalogo");
        decoracion.setStock(decoracion.getStock() + 1);
    }

    public double calcularValorTotalStock() {
        double valorTotalStock = 0.0;

        for (Arbol arbol : arboles) {
            valorTotalStock += arbol.getStock();
        }

        for (Flor flor : flores) {
            valorTotalStock += flor.getStock();
        }

        for (Decoracion decoracion : decoraciones) {
            valorTotalStock += decoracion.getStock();
        }

        return valorTotalStock;
    }

    public void calcularStockCantidades(ArrayList<Arbol> arboles, ArrayList<Flor> flores, ArrayList<Decoracion> decoraciones) {
        System.out.println("STOCK");
        for (Arbol arbol : Floristeria.arboles) {
            System.out.println("ARBOLES:\n" + (arbol.getStock()-1));
        }
        for (Flor flor : Floristeria.flores) {
            System.out.println("FLORES:\n" + (flor.getStock()-1));
        }
        for (Decoracion decoracion : Floristeria.decoraciones) {
            System.out.println("DECORACIÓN:\n" + (decoracion.getStock()-1));
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

}
