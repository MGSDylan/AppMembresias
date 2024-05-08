package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Membresia {
    private String codigo;
    private boolean isActived;
    private LocalDate fechaInicio;
    private String fechaVencimiento;
    private List<Reserva> reservas;
    private List<Pago> pagos;

    public Membresia() {
        this.reservas=new ArrayList<>();
        this.pagos=new ArrayList<>();
    }

    public Membresia(String codigo, LocalDate fechaInicio, String fechaVencimiento) {
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isActived() {
        return isActived;
    }

    public void setActived(boolean actived) {
        isActived = actived;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public List<Reserva> listReserva() {
        return reservas;
    }

    public void registrarReserva(String codigoMembresia,String servicio,String fecha,String hora,String detalles) {

        reservas.add(new Reserva(fecha,hora,codigoMembresia,servicio,detalles));
    }


    public List<Reserva> consultarReserva(String codigoMembresia) {
        return listReserva().stream().filter(x->x.getCodigoMembresia().equals(codigoMembresia)).collect(Collectors.toList());
    }

    public void ActualizarReserva(String fecha,String hora ,String servicio,String detalles) {
        int actualizada=0;
        for (Reserva re : listReserva()) {
            if (re.getServicio().equals(servicio)) {
                re.setFecha(fecha);
                re.setHora(hora);
                re.setServicio(servicio);
                re.setDetalles(detalles);
                actualizada++;
            }
        }
        if (actualizada>0){
            System.out.println("Reserva Actualizada");
        }else {
            System.out.println("Error Reserva no encontrada!!!!!!!!");
        }

    }

    public void eliminarReserva(String servicio){
        boolean estado;
        estado = listReserva().removeIf(x-> x.getServicio().equals(servicio));
        if (estado){
            System.out.println("Reserva eliminada");
        }else {
            System.out.println("Reserva no encontrada!!!!");
        }

    }




    public List<Pago> listPagos() {
        return pagos;
    }

    public List<Pago> consultarPagoCliente(String codMembresia) {
        return pagos.stream().filter(x->x.getCodigoMembresia().equals(codMembresia)).collect(Collectors.toList());
    }



    public void estadoMembresia(String codigoMembresia){
        Club cu=new Club();
            for (Pago pa : pagos) {
                boolean mismoAnoYMes = (LocalDate.now().getYear()==pa.getFechaPago().getYear()) && (LocalDate.now().getMonthValue()==pa.getFechaPago().getMonthValue());
                if (mismoAnoYMes){
                     cu.membresiaActive(codigoMembresia);
                }
            }
    }


    public void registrarPago(String codigoMembresia,double monto) {
        pagos.add(new Pago(codigoMembresia,monto));
        estadoMembresia(codigoMembresia);

    }


    public void ActualizarPago(String codigoPago,String codigoMembresia,double monto) {
        int actualizada=0;
        for (Pago re : pagos) {
            if (re.getCodigoPago().equals(codigoPago)  && re.getCodigoMembresia().equals(codigoMembresia)) {
                re.setMonto(monto);
                re.setFechaPago(LocalDate.now());
                actualizada++;
            }
        }
        if (actualizada>0){
            System.out.println("Pago Actualizado");
        }else {
            System.out.println("Error Pago no encontrado!!!!!!!!");
        }

    }

    public void eliminarPago(String codPago){
        boolean estado;
        estado = pagos.removeIf(x->  x.getCodigoPago().equals(codPago));
        if (estado){
            System.out.println("Pago eliminado");
        }else {
            System.out.println("Pago no encontrado!!!!");
        }

    }

    @Override
    public String toString() {
        return "Membresia{" +
                "codigo='" + codigo + '\'' +
                ", isActived=" + isActived +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaVencimiento + '\'' +
                '}';
    }
}
