package api;

import negocio.Producto;

import java.util.ArrayList;

public interface CatalogoINT {
    void inicializar();
    void agregarProducto(Producto producto);
    void modificarProducto(String codigo);
    void eliminarProducto(String codigo);
}

