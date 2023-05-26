import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Floristeria> productos;

    public Catalogo() {
        productos = new ArrayList<>();
    }

    public ArrayList<Floristeria> getProductos() {
        return productos;
    }

    public void addProducto(Floristeria producto) {
        productos.add(producto);
    }
}

