public class Decoracion extends Floristeria{
    private String nombre;
    private double precio;
    private int stock;
    private String material;

    public Decoracion(String nombre, double precio, int stock, String material) {
        super(nombre);
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.material = material;
    }

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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material.equalsIgnoreCase("madera") || material.equalsIgnoreCase("plastico")) {
            this.material = material;
        } else {
            throw new IllegalArgumentException("Material solo puede ser 'madera' o 'plastico'.");
        }
    }
    @Override
    public String toString() {
        return "Artículo:" +nombre+ "/ Material:"+material+"/ Precio:"+precio+" €/ Stock: "+stock;
    }
}
