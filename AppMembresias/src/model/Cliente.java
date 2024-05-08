package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Cliente {
    private String dni;
    private String nombre;
    private String codigoMiembro;

    private String direccion;
    private String telefono;
    private String correoElectronico;
    private Membresia membresia;

    public Cliente() {
    }

    public Cliente(String dni,String nombre, String direccion, String telefono, String correoElectronico) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        membresia=new Membresia();
        codigoMiembro="cl"+dni+LocalDate.now().getYear()+LocalDate.now().getMonthValue();
        membresia.setCodigo(codigoMiembro);

    }

    public String getCodigoMiembro() {
        return codigoMiembro;
    }

    public void setCodigoMiembro(String codigoMiembro) {
        this.codigoMiembro = codigoMiembro;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }



    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", membresia=" + membresia +
                '}';
    }
}
