import java.util.Date;

public class EmpleadoFactory {

    public static Empleado crearEmpleado(String tipo, int id, String nombre, int edad, String sexo, Date fechaContratacion, String beneficios, float salarioBase, Date fechaFinalContrato, float tasaPorHora) {
        if ("permanente".equalsIgnoreCase(tipo)) {
            return new EmpleadoPermanente(id, nombre, edad, sexo, fechaContratacion, beneficios, salarioBase);
        } else if ("temporal".equalsIgnoreCase(tipo)) {
            return new EmpleadoTemporal(id, nombre, edad, sexo, fechaContratacion, fechaFinalContrato, tasaPorHora);
        } else {
            throw new IllegalArgumentException("Tipo de empleado no válido");
        }
    }
}
