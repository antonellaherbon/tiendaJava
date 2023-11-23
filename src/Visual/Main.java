package Visual;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import negocio.Catalogo;
import negocio.Producto;
import negocio.Venta;

public class Main {

    public static void main(String[] args) {
        try {
            Catalogo listaDeProductos = new Catalogo();
            listaDeProductos.inicializar();

            Producto p1 = new Producto("123", "Lapicera", 10, 100, 1);
            listaDeProductos.agregarProducto(p1);
            Producto p2 = new Producto("153", "Lapiz", 15, 2, 1);
            listaDeProductos.agregarProducto(p2);
            Producto p3 = new Producto("153", "Lapiz", 15, 2, 1);
            listaDeProductos.agregarProducto(p3);
            Producto p4 = new Producto("193", "Cuaderno", 100, 5, 1);
            listaDeProductos.agregarProducto(p4);
            Producto p5 = new Producto("173", "Cartuchera", 150, 9, 1);
            listaDeProductos.agregarProducto(p5);
            Scanner teclado = new Scanner(System.in);

            JFrame frame = new JFrame("Market All");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);

            JPanel panel = new JPanel();

            JButton listarButton = new JButton("Listar Productos");
            JButton modificarButton = new JButton("Modificar Producto");
            JButton eliminarButton = new JButton("Eliminar Producto");
            JButton comprarButton = new JButton("Comprar Producto");

            listarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Catalogo.listarProductos(listaDeProductos.getProductos());
                }
            });

            modificarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codigo = JOptionPane.showInputDialog("Ingrese el código del producto que desea modificar:");
                    listaDeProductos.modificarProducto(codigo);
                }
            });

            eliminarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String codigo = JOptionPane.showInputDialog("Ingrese el código del producto que desea eliminar:");
                    listaDeProductos.eliminarProducto(codigo);
                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                }
            });

            comprarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    float precioTotal = 0;
                    ArrayList<Producto> productos = listaDeProductos.getProductos();

                    while (true) {
                        String productoDeseado = JOptionPane.showInputDialog("Ingrese el nombre del producto deseado (o -1 para salir):");

                        if (productoDeseado.equals("-1")) {
                            break;
                        }

                        int cantidadDeseada = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));

                        precioTotal += Venta.elegirProductos(productoDeseado, cantidadDeseada, productos);
                    }

                    if (precioTotal > 0) {
                        String medio = JOptionPane.showInputDialog("Ingrese método de pago (EFECTIVO/DEBITO/CREDITO):");
                        float totalFinalVenta = Venta.calcularTotal(medio, precioTotal);
                        JOptionPane.showMessageDialog(null, "USTED DEBERÁ PAGAR: " + totalFinalVenta);
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay productos para pagar");
                    }
                }
            });

            panel.add(listarButton);
            panel.add(modificarButton);
            panel.add(eliminarButton);
            panel.add(comprarButton);

            frame.add(panel);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}