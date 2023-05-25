import java.util.ArrayList;

public class Tiquet {
    private ArrayList<Floristeria>compra;


    public Tiquet(ArrayList<Floristeria> compra) {
        this.compra = new ArrayList<Floristeria>();
    }

    public void addProducto(Floristeria producto, ArrayList<Floristeria> compra) {
        compra.add(producto);
    }

    public void setCompra(ArrayList<Floristeria> compra) {
        this.compra = compra;
    }

    public ArrayList<Floristeria> getCompra() {
        return compra;
    }
}
