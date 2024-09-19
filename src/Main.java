import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear algunos departamentos
        Departamento departamento1 = new Departamento(1, "Recursos Humanos", "Juan Pérez", "Manejo de personal");
        Departamento departamento2 = new Departamento(2, "Desarrollo", "Ana Gómez", "Desarrollo de software");

        // Crear empleados permanentes
        EmpleadoPermanente empleado1 = new EmpleadoPermanente(1, "Carlos López", 30, "M", new Date(), "Seguro médico", 2500);
        EmpleadoPermanente empleado2 = new EmpleadoPermanente(2, "María Torres", 28, "F", new Date(), "Vacaciones pagadas", 2300);

        // Asignar empleados a departamentos
        empleado1.setDepartamento(departamento1);
        empleado2.setDepartamento(departamento2);

        // Crear empleados temporales
        EmpleadoTemporal empleado3 = new EmpleadoTemporal(3, "Luis Fernández", 25, "M", new Date(), new Date(System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000), 15);
        EmpleadoTemporal empleado4 = new EmpleadoTemporal(4, "Sofía Rojas", 22, "F", new Date(), new Date(System.currentTimeMillis() + 60L * 24 * 60 * 60 * 1000), 12);

        // Asignar empleados temporales a un departamento
        empleado3.setDepartamento(departamento1);
        empleado4.setDepartamento(departamento2);

        // Crear reportes de desempeño
        ReporteDesempenio reporte1 = new ReporteDesempenio(new Date(), 85, "Buen desempeño general.");
        ReporteDesempenio reporte2 = new ReporteDesempenio(new Date(), 90, "Excelente colaboración en equipo.");

        // Generar reportes individuales
        reporte1.generarReporteIndividual(empleado1);
        reporte2.generarReporteIndividual(empleado2);

        // Mostrar información de los departamentos y empleados
        mostrarInformacion(departamento1);
        mostrarInformacion(departamento2);
    }

    private static void mostrarInformacion(Departamento departamento) {
        System.out.println("Departamento: " + departamento.getNombre());
        System.out.println("Jefe de Departamento: " + departamento.getJefeDepartamento());
        System.out.println("Descripción: " + departamento.getDescripcion());
        System.out.println("Empleados:");

        for (Empleado emp : departamento.getEmpleados()) {
            System.out.println(" - " + emp.getNombre() + " (ID: " + emp.getId() + ")");
        }

        System.out.println();
    }
}
