package Modelo;

public class Inventario {

   private int id ;
   private String nombre;
   private int cantidad;
   private String fecha_vencimiento;

    public Inventario() {
    }

    public Inventario(int id, String nombre, int cantidad, String fecha_vencimiento) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
   
   
   
    
}
