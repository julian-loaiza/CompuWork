import java.util.Date;

public class ReporteDesempenio {
    private Date fechaGeneracion;
    private int puntaje;
    private String observaciones;

    public ReporteDesempenio(Date fechaGeneracion, int puntaje, String observaciones) {
        this.fechaGeneracion = fechaGeneracion;
        this.puntaje = puntaje;
        this.observaciones = observaciones;
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

    public void generarReporteIndividual(Empleado empleado) {
        System.out.println("Reporte de desempeño para: " + empleado.getNombre());
        System.out.println("Puntaje: " + puntaje + ", Observaciones: " + observaciones);
    }

    public void generarReporteDepartamento(Departamento departamento) {
        System.out.println("Generando reporte para el departamento: " + departamento.getNombre());
    }
}



