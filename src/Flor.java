public class Flor extends Floristeria {
    private String nombre;
    private double precio;
    private int stock;
    private String color;

    // Constructor
    public Flor(String nombre, double precio, String color, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.color = color;
    }

    // Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Nombre:" + nombre + "/ Color: " + color + "/ Precio: " + precio + "€";
    }
}
