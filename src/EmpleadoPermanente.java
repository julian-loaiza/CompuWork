import java.util.Date;

public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private float salarioBase;

    public EmpleadoPermanente(int id, String nombre, int edad, String sexo, Date fechaContratacion, String beneficios, float salarioBase) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.beneficios = beneficios;
        this.salarioBase = salarioBase;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    @Override
    public void crear() {
        System.out.println("Creando empleado permanente: " + getNombre());
    }

    @Override
    public void actualizar(String nombre, int edad, String sexo) {
        setNombre(nombre);
        setEdad(edad);
        setSexo(sexo);
        System.out.println("Empleado Permanente actualizado: " + getNombre());
    }

    @Override
    public void eliminar() {
        System.out.println("Empleado Permanente eliminado: " + getNombre());
    }

    @Override
    public String getDetalles() {
        return "Empleado Permanente - Nombre: " + getNombre() + ", Beneficios: " + beneficios + ", Salario Base: " + salarioBase;
    }
}
