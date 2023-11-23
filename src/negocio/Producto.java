package negocio;

public class Producto {
    private String codigo;
    private String descripcion;
    private float precioUnitario;
    private int cantidadEnStock;
    private int stockMinimo;

    public Producto(String codigo, String descripcion, float precioUnitario, int cantidadEnStock, int stockMinimo){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidadEnStock = cantidadEnStock;
        this.stockMinimo = stockMinimo;
    }



    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public String toString() {
        return "Descripción: " + descripcion + ", Precio Unitario: " + precioUnitario + ", Stock: " + cantidadEnStock;
    }

}