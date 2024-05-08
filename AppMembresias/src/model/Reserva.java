package model;

public class Reserva {

    private String fecha;
    private String hora;
    private String codigoMembresia;
    private String servicio;
    private String detalles;

    public Reserva() {
    }

    public Reserva(String fecha, String hora, String codigoMembresia, String servicio, String detalles) {
        this.fecha = fecha;
        this.hora = hora;
        this.codigoMembresia = codigoMembresia;
        this.servicio = servicio;
        this.detalles = detalles;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCodigoMembresia() {
        return codigoMembresia;
    }

    public void setCodigoMembresia(String codigoMembresia) {
        this.codigoMembresia = codigoMembresia;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", codigoMembresia='" + codigoMembresia + '\'' +
                ", servicio='" + servicio + '\'' +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
