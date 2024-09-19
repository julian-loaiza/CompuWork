import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String nombre;
    private String jefeDepartamento;
    private String descripcion;
    private List<Empleado> empleados;

    public Departamento(int id, String nombre, String jefeDepartamento, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.jefeDepartamento = jefeDepartamento;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();
    }

    public void crear() {
        // Lógica para crear departamento
    }

    public void modificar() {
        // Lógica para modificar departamento
    }

    public void eliminar() {
        // Lógica para eliminar departamento
    }

    public void asignarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // Método para obtener el nombre del departamento
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el jefe de departamento
    public String getJefeDepartamento() {
        return jefeDepartamento;
    }

    // Método para obtener la descripción del departamento
    public String getDescripcion() {
        return descripcion;
    }
}
