import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private static Departamento instance;
    private int id;
    private String nombre;
    private String jefeDepartamento;
    private String descripcion;
    private List<Empleado> empleadosAsignados;

    Departamento(int id, String nombre, String jefeDepartamento, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.jefeDepartamento = jefeDepartamento;
        this.descripcion = descripcion;
        this.empleadosAsignados = new ArrayList<>();
    }

    public static synchronized Departamento getInstance(int id, String nombre, String jefeDepartamento, String descripcion) {
        if (instance == null) {
            instance = new Departamento(id, nombre, jefeDepartamento, descripcion);
        }
        return instance;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getJefeDepartamento() {
        return jefeDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void asignarEmpleado(Empleado empleado) {
        System.out.println("Asignando empleado: " + empleado.getNombre() + " al departamento: " + nombre);
    }

    public void eliminarEmpleado(Empleado empleado) {
        System.out.println("Eliminando empleado: " + empleado.getNombre() + " del departamento: " + nombre);
    }

    public String getDetalles() {
        StringBuilder detalles = new StringBuilder("Departamento: " + nombre + ", Jefe: " + jefeDepartamento + "\n");
        detalles.append("Empleados Asignados: \n");

        if (empleadosAsignados.isEmpty()) {
            detalles.append("No hay empleados asignados.\n");
        } else {
            for (Empleado empleado : empleadosAsignados) {
                detalles.append("- " + empleado.getNombre() + " (ID: " + empleado.getId() + ")\n");
            }
        }

        return detalles.toString();
    }

    // Método para buscar empleado por ID
    public Empleado buscarEmpleado(int id) {
        for (Empleado empleado : empleadosAsignados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }



    public void setNombre(String text) {
    }

    public void setJefeDepartamento(String text) {
    }

    public void setDescripcion(String text) {
    }
}
