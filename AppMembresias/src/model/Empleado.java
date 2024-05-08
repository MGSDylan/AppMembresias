package model;

import model.util.Rol;

public class Empleado extends Usuario{

    private String idEmpleado;
    private String nombre;

    public Empleado(String user, String password, Rol rol) {
        super(user, password, rol);
    }

    public Empleado(String user, String password, Rol rol, String idEmpleado, String nombre) {
        super(user, password, rol);
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "idEmpleado='" + idEmpleado + '\'' +
                ", nombre='" + nombre + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean iniciarSesion(String user, String passwoord) {
        Empleado empleado=new Empleado("emp","123",Rol.EMPLEADO,"emp1","Pool");

        if ((user.equals(empleado.getUser())) && (passwoord.equals(empleado.getPassword()))) {
            System.out.println("\n                     Sesion Iniciada como Empleado               \n ");
            System.out.println("Bienvenido al Sistema " + empleado.getNombre());
            return true;
        }else{
            System.err.println("\n         Usuario Invalido!!!!!          ");
            return false;
        }
    }
}
