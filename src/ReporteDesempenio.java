import java.util.Date;

public class ReporteDesempenio {
    private Date fechaGeneracion;
    private int puntaje;
    private String observaciones;
    private Empleado empleado;
    private Departamento departamento;

    public ReporteDesempenio(Date fechaGeneracion, int puntaje, String observaciones) {
        this.fechaGeneracion = fechaGeneracion;
        this.puntaje = puntaje;
        this.observaciones = observaciones;
    }

    public void generarReporteIndividual(Empleado empleado) {
        this.empleado = empleado;
        // Lógica para generar el reporte individual
    }

    public void generarReporteDepartamento(Departamento departamento) {
        this.departamento = departamento;
        // Lógica para generar el reporte del departamento
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public String getObservaciones() {
        return observaciones;
    }
}
