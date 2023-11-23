package negocio;
import java.util.ArrayList;
import java.util.Scanner;
public class Venta {
    private String metodoDePago;

    public Venta(String metodoDePago){
        this.metodoDePago = metodoDePago;
    }
    public static float elegirProductos(String nombreProducto, int cantidad, ArrayList<Producto> lista) {
        for (Producto producto : lista) {
            if (producto.getDescripcion().equalsIgnoreCase(nombreProducto.trim())) {
                if (cantidad <= producto.getCantidadEnStock()) {
                    System.out.println("El producto fue encontrado y tiene stock");
                    producto.setCantidadEnStock(producto.getCantidadEnStock() - cantidad);
                    return producto.getPrecioUnitario() * cantidad;
                } else {
                    System.out.println("No hay stock suficiente. El maximo que puede comprar es " +producto.getCantidadEnStock());
                    return 0;
                }
            }
        }
        System.out.println("El producto que usted desea comprar no existe");
        return 0;
    }
    public static float calcularTotal(String mediodepago, float precio) {
        Scanner teclado = new Scanner(System.in);
        while (!mediodepago.toLowerCase().equals("efectivo") && !mediodepago.toLowerCase().equals("debito") && !mediodepago.toLowerCase().equals("credito")){
            System.out.println("dato incorrecto");
            System.out.println("Ingrese nuevamente");
            mediodepago = teclado.nextLine();
        }
        if (mediodepago.toLowerCase().equals("efectivo")) {
            return precio - (precio * 10) / 100;
        } else if (mediodepago.toLowerCase().equals("debito")) {
            return precio;
        } else if (mediodepago.toLowerCase().equals("credito")){
            System.out.println("ingresa la cantidad de cuotas que queres (2-3-6): ");
            int cuotas = teclado.nextInt();
            while (cuotas != 2 && cuotas != 3 && cuotas !=6){
                System.out.println("dato incorrecto");
                System.out.println("Ingrese nuevamente.");
                cuotas = teclado.nextInt();
            }
            if (cuotas == 2) {
                return precio + (precio * 6) / 100;
            } else if (cuotas == 3) {
                return precio + (precio * 12) / 100;
            } else if (cuotas == 6) {
                return precio + (precio * 20) / 100;
            }
        }
        return 0;
    }
}



