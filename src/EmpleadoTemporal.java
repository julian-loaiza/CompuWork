import java.util.Date;

public class EmpleadoTemporal extends Empleado {
    private Date fechaFinalContrato;
    private float tasaPorHora;

    public EmpleadoTemporal(int id, String nombre, int edad, String sexo, Date fechaContratacion, Date fechaFinalContrato, float tasaPorHora) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.fechaFinalContrato = fechaFinalContrato;
        this.tasaPorHora = tasaPorHora;
    }

    public float getTasaPorHora() {
        return tasaPorHora;
    }

    @Override
    public void crear() {
        System.out.println("Creando empleado temporal: " + getNombre());
    }

    @Override
    public String getDetalles() {
        return "Empleado Temporal - Nombre: " + getNombre() + ", Tasa por Hora: " + tasaPorHora;
    }

    @Override
    public void actualizar(String nombre, int edad, String sexo) {
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        System.out.println("Empleado Temporal actualizado: " + getNombre());
    }

    @Override
    public void eliminar() {
        System.out.println("Empleado Temporal eliminado: " + getNombre());
    }
}
