import java.util.Date;

abstract class Empleado {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String sexo;
    protected Date fechaContratacion;
    protected Departamento departamento;

    public Empleado(int id, String nombre, int edad, String sexo, Date fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.fechaContratacion = fechaContratacion;
    }

    public abstract void crear();
    public abstract void actualizar();
    public abstract void eliminar();

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
        departamento.asignarEmpleado(this);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
