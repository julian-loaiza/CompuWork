import java.util.Date;

public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private double salarioBase;

    public EmpleadoPermanente(int id, String nombre, int edad, String sexo, Date fechaContratacion, String beneficios, double salarioBase) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.beneficios = beneficios;
        this.salarioBase = salarioBase;
    }

    @Override
    public void crear() {
        // Lógica para crear empleado permanente
    }

    @Override
    public void actualizar() {
        // Lógica para actualizar empleado permanente
    }

    @Override
    public void eliminar() {
        // Lógica para eliminar empleado permanente
    }
}
