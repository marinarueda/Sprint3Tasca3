import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Floristeria> productos;

    public Catalogo(ArrayList<Floristeria> productos) {

        this.productos = new ArrayList<Floristeria>();
    }

    public ArrayList<Floristeria> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Floristeria> productos) {
        this.productos = productos;
    }
}
