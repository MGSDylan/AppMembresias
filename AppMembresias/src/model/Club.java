package model;

import model.Cliente;
import model.Reserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Club {

    private List<Cliente>  clientes;

    public Club() {
        clientes=new ArrayList<>();
    }




    public void registrarCliente( String dni,String nombre, String direccion, String telefono, String correoElectronico){
        clientes.add(new Cliente(dni,nombre,direccion,telefono,correoElectronico));
        System.out.println("\nCliente Registrado\n");
    }

    public Cliente consultarCliente(String dni) {
        Cliente cliente = clientes.stream().filter(x -> x.getDni().equals(dni)).findFirst().orElse(null);
        return cliente;
    }


   

    public void membresiaActive(String codigoMembresia){
        for (Cliente cl:clientes) {
            if (cl.getCodigoMiembro().equals(codigoMembresia)) {
                cl.getMembresia().setActived(true);
                if (cl.getMembresia().listPagos().isEmpty()){
                    cl.getMembresia().setFechaInicio(LocalDate.now());
                }
            } else if (cl.getCodigoMiembro().equals(codigoMembresia) && cl.getMembresia().getFechaInicio().getMonthValue()<LocalDate.now().getMonthValue() && cl.getMembresia().getFechaInicio().getYear()<LocalDate.now().getYear()) {
                cl.getMembresia().setActived(false);
            }
        }
    }


    public void actualizarCliente(String dni,String nombre, String direccion, String telefono, String correoElectronico) {
        int actualizada=0;
        for (Cliente re : clientes) {
            if (re.getDni().equals(dni)) {
                re.setNombre(nombre);
                re.setDireccion(direccion);
                re.setTelefono(telefono);
                re.setCorreoElectronico(correoElectronico);
                actualizada++;
            }
        }
        if (actualizada>0){
            System.out.println("Cliente Actualizado");
        }else {
            System.out.println("Error Cliente no encontrado!!!!!!!!");
        }

    }

    public void eliminarCliente(String dni){
        boolean estado;
        estado = clientes.removeIf(x-> x.getDni().equals(dni));
        if (estado){
            System.out.println("Cliente eliminado");
        }else {
            System.out.println("Cliente no encontrado!!!!");
        }

    }

    public List<Cliente> getClientes() {
        return clientes;
    }


    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Club{" +
                "clientes=" + clientes +
                '}';
    }
}
