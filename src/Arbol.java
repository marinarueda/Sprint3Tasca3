public class Arbol extends Floristeria {
    private String nombre;
    private double precio;
    private int stock;
    private double altura;

    // Constructor
    public Arbol(String nombre, double precio, int stock, double altura) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock  = stock;
        this.altura = altura;
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

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + "/ Altura: " + altura + "m/ Precio: " + precio + "€";
    }
}
