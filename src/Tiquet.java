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
}
