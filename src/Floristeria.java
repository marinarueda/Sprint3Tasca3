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

    // Métodos para añadir diferentes productos al catalogo
    public void addArbol(ArrayList<Arbol> arboles, Arbol arbol) {
        arboles.add(arbol);
        System.out.println("Arbol añadido a catalogo");
        arbol.setStock(arbol.getStock() + 1);
    }

    public void addFlor(ArrayList<Flor> flores, Flor flor) {
        flores.add(flor);
        System.out.println("Flor añadida a catalogo");
        flor.setStock(flor.getStock() + 1);
    }

    public void addDecoracion(ArrayList<Decoracion> decoraciones, Decoracion decoracion) {
        decoraciones.add(decoracion);
        System.out.println("Artículo añadido a catalogo");
        decoracion.setStock(decoracion.getStock() + 1);
    }

    // Método para calcular el total del stock
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
