import java.util.Date;

public abstract class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private String sexo;
    private Date fechaContratacion;

    public Empleado(int id, String nombre, int edad, String sexo, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaContratacion = fechaContratacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    // Métodos setter para permitir la actualización de los datos del empleado
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Métodos abstractos que implementarán las subclases
    public abstract void crear();

    public abstract void actualizar(String nombre, int edad, String sexo);

    public abstract void eliminar();

    public abstract String getDetalles();
}
