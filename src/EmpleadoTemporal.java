import java.util.Date;

public class EmpleadoTemporal extends Empleado {
    private Date fechaFinalContrato;
    private double tasaPorHora;

    public EmpleadoTemporal(int id, String nombre, int edad, String sexo, Date fechaContratacion, Date fechaFinalContrato, double tasaPorHora) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.fechaFinalContrato = fechaFinalContrato;
        this.tasaPorHora = tasaPorHora;
    }

    @Override
    public void crear() {
        // Lógica para crear empleado temporal
    }

    @Override
    public void actualizar() {
        // Lógica para actualizar empleado temporal
    }

    @Override
    public void eliminar() {
        // Lógica para eliminar empleado temporal
    }
}
