package negocio;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;
import api.CatalogoINT;
public class Catalogo implements CatalogoINT {
    private ArrayList<Producto> Productos;
    public ArrayList<Producto> getProductos() {
        return Productos;
    }

    @Override
    public void inicializar() {
        this.Productos = new ArrayList<Producto>();
    }

    @Override
    public void agregarProducto(Producto producto){
        for (Producto p : Productos) {
            if (p.getCodigo().equals(producto.getCodigo())) {
                p.setCantidadEnStock(p.getCantidadEnStock() + producto.getCantidadEnStock());
                return;
            }
        }
        this.Productos.add(producto);
    }
    @Override
    public void modificarProducto(String codigo) {
        for (Producto p : Productos) {
            if (p.getCodigo().equals(codigo)) {
                System.out.println("El producto que va a modificar va a ser " +p.getDescripcion());

                Scanner teclado = new Scanner(System.in);

                System.out.println("Ingrese la nueva descripcion del producto");

                String nuevaDesc = teclado.nextLine();

                System.out.println("Ingrese la nueva cantidad en Stock del producto");

                int nuevaCantStock = teclado.nextInt();

                System.out.println("Ingrese el nuevo precio del producto");

                int precioUnitNuevo = teclado.nextInt();

                p.setDescripcion(nuevaDesc);
                p.setCantidadEnStock(nuevaCantStock);
                p.setPrecioUnitario(precioUnitNuevo);
            }
        }
    }
    @Override
    public void eliminarProducto(String codigo) {
        Iterator<Producto> iterator = Productos.iterator();
        while (iterator.hasNext()) {
            Producto p = iterator.next();
            if (p.getCodigo().equals(codigo)) {
                iterator.remove();
                return;
            }
        }
    }
    public static void listarProductos(ArrayList<Producto> lista){
        for (Producto producto : lista){
            System.out.println(producto);
        }
    }
}