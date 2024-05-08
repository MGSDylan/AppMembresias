package model;

import model.util.Rol;

public class Administrador extends Usuario{

    private String idAdministrador;
    private String nombre;


    public Administrador(String user, String password, Rol rol) {
        super(user, password, rol);
    }

    public Administrador(String user, String password, Rol rol, String idAdministrador, String nombre) {
        super(user, password, rol);
        this.idAdministrador = idAdministrador;
        this.nombre = nombre;
    }

    @Override
    public boolean iniciarSesion(String user, String passwoord) {
        Administrador administrador=new Administrador("admin","123",Rol.ADMINISTRADOR,"admin1","Dylan");

        if ((user.equals(administrador.getUser())) && (passwoord.equals(administrador.getPassword()))) {
            System.out.println("\n            Sesion Iniciada como Administrador              \n");
            System.out.println("Bienvenido al Sistema "+administrador.getNombre());
            return true;
        }
        else{
            System.err.println("\n         Usuario Invalido!!!!!             ");
            return false;
        }
    }

    public String getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(String idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador='" + idAdministrador + '\'' +
                ", nombre='" + nombre + '\'' +
                "} " + super.toString();
    }

}
