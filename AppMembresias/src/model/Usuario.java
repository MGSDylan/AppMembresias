package model;

import model.util.Rol;

public abstract class  Usuario {

    private String user;
    private String password;
    private Rol rol ;


    public Usuario(String user, String password, Rol rol) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public abstract   boolean iniciarSesion(String user, String passwoord);




    public  void cerrarSesion(){
        System.out.println("sesion cerrada ...");
        };

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


}
