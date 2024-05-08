package model;

import java.time.LocalDate;

public class Pago {

    private String codigoPago;
    private String codigoMembresia;
    private LocalDate fechaPago;
    private double monto;

    public Pago() {
    }

    public Pago( String codigoMembresia, double monto) {
        this.codigoPago = "pa-"+codigoMembresia+LocalDate.now().getMonthValue();
        this.codigoMembresia = codigoMembresia;
        this.fechaPago = LocalDate.now();
        this.monto = monto;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    public String getCodigoMembresia() {
        return codigoMembresia;
    }

    public void setCodigoMembresia(String codigoMembresia) {
        this.codigoMembresia = codigoMembresia;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "codigoPago='" + codigoPago + '\'' +
                ", codigoMembresia='" + codigoMembresia + '\'' +
                ", fechaPago='" + fechaPago + '\'' +
                ", monto=" + monto +
                '}';
    }
}

