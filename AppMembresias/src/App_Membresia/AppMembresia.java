package App_Membresia;
import model.*;
import model.Club;
import model.util.Rol;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AppMembresia {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean acceso = false;
    private static Club club=new Club();
    private static Membresia membresia=new Membresia();

    public static void main(String[] args)   {

        logging();

       if (acceso){
            boolean salir = false;
                while (!salir) {
                    int opcion ;
                    while (true) {
                        try {
                            opcion = scanner.nextInt();
                            scanner.nextLine(); // Limpiar
                            break; // Salir del bucle si la entrada es correcta
                        } catch (InputMismatchException e) {
                            System.err.println("Entrada no válida. Por favor, ingrese un número válido:");
                            scanner.nextLine(); // Limpiar
                        }
                    }
                        switch (opcion) {
                            case 1:
                                mostrarMenuCliente();
                                break;
                            case 2:
                                mostrarMenuReserva();
                                break;
                            case 3:
                                mostrarMenuPago();
                                break;
                            case 4:
                                salir = true;
                                System.out.println("Saliendo del sistema...");
                                break;
                            default:
                                System.err.println("Opción no válida. Intente de nuevo.");
                        }
                }
            }
        }




    private static void logging()   {
        while (true) {
            try {
                System.out.println("\n***       SISTEMA DE MEMBRESÍAS        ***");
                System.out.println("\n            LOGIN DE USUARIO           ");
                System.out.print("            ----------------           ");
                System.out.print("\nUsuario:");
                String user = scanner.nextLine();
                System.out.print("Password:");
                String password = scanner.nextLine();

                System.out.println("\n1.- Administrador");
                System.out.println("2.- Empleado");
                System.out.print("Seleccione Rol: ");
                int rol = Integer.parseInt(scanner.nextLine());
                Usuario user1 = switch (rol) {
                    case 1 -> new Administrador(user, password, Rol.ADMINISTRADOR);
                    case 2 -> new Empleado(user, password, Rol.EMPLEADO);
                    default -> null;
                };

                if (user1 == null) {
                    System.out.println("Rol inválido, por favor intente de nuevo.");
                } else if (user1.iniciarSesion(user, password)) {
                    acceso = true;
                    mostrarMenuPrincipal();
                    break;
                } else {
                    System.err.println("         Usuario o contraseña incorrectos!!!!, por favor intente de nuevo.\n");
                }
            } catch (NumberFormatException i) {
                System.err.println("         Debe ingresar el número correspondiente de rol!!!!!!!!        \n");
            }
        }
    }



    private static void mostrarMenuPrincipal() {
        System.out.println("\n*** SISTEMA DE MEMBRESÍAS ***");

        System.out.println("1. Cliente");
        System.out.println("2. Reservar");
        System.out.println("3. Pagos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMenuCliente() {
        boolean mC=true;
        while (mC){
            try {
                System.out.println("\n*** CLIENTE ***");
                System.out.println("1. Registro (nombre, apellido, dirección, teléfono, correo)");
                System.out.println("2. Lista Clientes");
                System.out.println("3. Actualizar");
                System.out.println("4. Eliminar");
                System.out.println("5. Consultar por Dni");
                System.out.println("6. Regresar");
                System.out.print("Seleccione una opción: ");

                int opcion ;
                while (true) {
                    try {
                        opcion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar
                        break; // Salir del bucle si la entrada es correcta
                    } catch (InputMismatchException e) {
                        System.err.println("Entrada no válida. Por favor, ingrese un número válido:");
                        scanner.nextLine(); // Limpiar
                    }
                }

                switch (opcion) {
                    case 1:
                        System.out.println("Registro de cliente...");
                        System.out.println("1. Registro (dni, nombre, direccion, teléfono, correo)");
                        System.out.println("Ingrese Numero de Dni: ");
                        String dni= scanner.nextLine();
                        System.out.println("Ingrese Numero de Nombre: ");
                        String nombre= scanner.nextLine();
                        System.out.println("Ingrese Numero de Direccion: ");
                        String direccion= scanner.nextLine();
                        System.out.println("Ingrese Numero de Telefono: ");
                        String telefono= scanner.nextLine();
                        System.out.println("Ingrese Numero de Correo: ");
                        String correoElectronico= scanner.nextLine();
                        club.registrarCliente(dni,nombre,direccion,telefono,correoElectronico);
                        // se implementara la funcionalidad

                        break;
                    case 2:
                        System.out.println("Lista de clientes...");
                        // se implementara la funcionalidad
                        club.getClientes().forEach(System.out::println);

                        break;
                    case 3:
                        System.out.println("Actualización de cliente...");
                        // se implementara la funcionalidad
                        System.out.println("Ingrese Numero de Dni: ");
                        String dniUpdate= scanner.nextLine();

                        if ((club.consultarCliente(dniUpdate))!=null){
                            System.out.println("Ingrese Numero de Nombre: ");
                            String nombreUpdate= scanner.nextLine();
                            System.out.println("Ingrese Numero de Direccion: ");
                            String direccionUpdate= scanner.nextLine();
                            System.out.println("Ingrese Numero de Telefono: ");
                            String telefonoUpdate= scanner.nextLine();
                            System.out.println("Ingrese Numero de Correo: ");
                            String correoElectronicoUpdate= scanner.nextLine();
                            club.actualizarCliente(dniUpdate,nombreUpdate,direccionUpdate,telefonoUpdate,correoElectronicoUpdate);

                        }else {
                            System.err.println("cliente no encontrado!!!");
                        }
                        break;
                    case 4:
                        System.out.println("Eliminación de cliente...");
                        // se implementara la funcionalidad
                        System.out.println("Actualización de cliente...");
                        // se implementara la funcionalidad
                        System.out.println("Ingrese Numero de Dni: ");
                        String dniDelete= scanner.nextLine();

                        if ((club.consultarCliente(dniDelete))!=null){
                            club.eliminarCliente(dniDelete);
                        }else{
                            System.err.println("Cliente no existe o dni erroneo!!");
                        }
                        break;
                    case 5:
                        System.out.println("Consultar cliente  por Dni ...");
                        // se implementara la funcionalidad
                        System.out.println("Ingrese Numero de Dni: ");
                        String dniConsulta= scanner.nextLine();
                        Cliente cl= club.consultarCliente(dniConsulta);
                        if (cl!=null){
                            System.out.println(cl);
                            System.out.println("\nCodigo De Miembro : "+cl.getCodigoMiembro()+"\n");
                        }else{
                            System.err.println("Cliente no existe o dni erroneo!!");
                        }

                        break;
                    case 6:
                        // Regresar al menú principal
                        mC=false;
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }catch (InputMismatchException i) {
                System.err.println("Entrada no válida. Por favor, ingrese un número válido:");
            }
        }
    }

    private static void mostrarMenuReserva() {
        boolean mR=true;
        while (mR){

                System.out.println("\n*** RESERVAR ***");
                System.out.println("1. Registrar reserva (String codigoMembresia,String servicio,String fecha,String hora,String detalles)");
                System.out.println("2. Listar reservas");
                System.out.println("3. Consultar por cliente");
                System.out.println("4. Actualizar reserva");
                System.out.println("5. Eliminar reserva");
                System.out.println("6. Regresar");
                System.out.print("Seleccione una opción: ");

                int opcion ;
                while (true) {
                    try {
                        opcion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar
                        break; // Salir del bucle si la entrada es correcta
                    } catch (InputMismatchException e) {
                        System.err.println("Entrada no válida. Por favor, ingrese un número válido:");
                        scanner.nextLine(); // Limpiar
                    }
                }


                switch (opcion) {
                    case 1:
                        System.out.println("Registro de reserva...");
                        System.out.println("Ingrese codigo de Membresia: ");
                        String codigoMembresia=scanner.nextLine();

                        boolean mem= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresia));
                        if (mem){
                            System.out.println("Ingrese servicio: ");
                            String servicio=scanner.nextLine();
                            System.out.println("Ingrese fecha: ");
                            String fecha=scanner.nextLine();
                            System.out.println("Ingrese hora: ");
                            String hora=scanner.nextLine();
                            System.out.println("Ingrese detalles: ");
                            String detalles=scanner.nextLine();

                            membresia.registrarReserva(codigoMembresia,servicio,fecha,hora,detalles);
                            // se implementara la funcionalidad
                            break;
                        }
                        System.err.println("codigo de membresia no encontrado!!!");

                        break;
                    case 2:
                        System.out.println("Listar reservas...");
                        // se implementara la funcionalidad
                        membresia.listReserva().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Consultar reservas por cliente...");
                        // se implementara la funcionalidad
                        System.out.println("Ingrese codigo de Membresia: ");
                        String codigoMembresia2=scanner.nextLine();
                        boolean mem2= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresia2));
                        if (mem2){
                            System.out.println(membresia.consultarReserva(codigoMembresia2));
                            break;

                        }
                        System.err.println("codMembresia no encontrada!!!");
                        break;

                    case 4:
                        System.out.println("Actualización de reserva...");
                        // se implementara la funcionalidad
                        System.out.println("Ingrese codigo de Membresia: ");
                        String codigoMembresiaupdate=scanner.nextLine();
                        boolean memUpdate= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresiaupdate));
                        if (memUpdate){

                            System.out.println("Ingrese servicio: ");
                            String servicio=scanner.nextLine();
                            System.out.println("Ingrese fecha: ");
                            String fecha=scanner.nextLine();
                            System.out.println("Ingrese hora: ");
                            String hora=scanner.nextLine();
                            System.out.println("Ingrese detalles: ");
                            String detalles=scanner.nextLine();
                            membresia.ActualizarReserva(fecha,hora,servicio,detalles);
                            break;

                        }
                        System.err.println("codMembresia no encontrada!!!");

                        break;
                    case 5:
                        System.out.println("Eliminación de reserva...");
                        // se implementara la funcionalidad
                        System.out.println("Ingrese codigo de Membresia: ");
                        String codigoMembresiaDelete=scanner.nextLine();
                        boolean memDelete= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresiaDelete));
                        if (memDelete){
                            System.out.println("Ingrese el servicio de la reserva a eliminar: ");
                            String servicio=scanner.nextLine();
                            membresia.eliminarReserva(servicio);
                            break;
                        }else {
                            System.err.println("codMembresia no encontrada!!!");
                        }

                        break;
                    case 6:
                        // Regresar al menú principal

                        mR=false;
                        mostrarMenuPrincipal();
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
        }
    }


    private static void mostrarMenuPago() {

        boolean mR=true;
        while (mR){
            System.out.println("\n*** PAGOS ***");
            System.out.println("1. Registrar pago membresía");
            System.out.println("2. Consultar pagos");
            System.out.println("3. Actualizar pagos");
            System.out.println("4. Eliminar pagos");
            System.out.println("5. Regresar");
            System.out.print("Seleccione una opción: ");


            int opcion ;
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar
                    break; // Salir del bucle si la entrada es correcta
                } catch (InputMismatchException e) {
                    System.err.println("Entrada no válida. Por favor, ingrese un número válido:");
                    scanner.nextLine(); // Limpiar
                }
            }

            switch (opcion) {
                case 1:
                    System.out.println("Registro de pago...");
                    // se implementara la funcionalidad
                    System.out.println("Ingrese codigo de Membresia: ");
                    String codigoMembresia=scanner.nextLine();

                    boolean mem= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresia));
                    if (mem){
                        System.out.println("Ingrese monto: ");
                        double monto=scanner.nextDouble();
                        membresia.registrarPago(codigoMembresia,monto);
                        // se implementara la funcionalidad
                        club.membresiaActive(codigoMembresia);
                        System.out.println("Pago Registrado");
                        break;
                    }
                    System.out.println("codigo de membresia no encontrado!!!");
                    break;
                case 2:
                    System.out.println("Consulta de pagos...");
                    // se implementara la funcionalidad
                    System.out.println("Consultar cliente por Membresia...");
                    // se implementara la funcionalidad
                    System.out.println("Ingrese codigo de Membresia: ");
                    String codMembresia= scanner.nextLine();
                    boolean memPay= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codMembresia));
                    if (memPay) {
                        List<Pago> pagos = membresia.consultarPagoCliente(codMembresia);
                        if (!pagos.isEmpty()) {
                            pagos.forEach(System.out::println);
                        } else {
                            System.out.println("No hay pagos registrados");
                        }
                    }else {
                        System.err.println("codMembresia no encontrada!!!");
                    }
                    break;
                case 3:
                    System.out.println("Actualización de pagos...");
                    // se implementara la funcionalidad

                    System.out.println("Ingrese codigo de Membresia: ");
                    String codigoMembresiaupdate=scanner.nextLine();
                    boolean memUpdate= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresiaupdate));
                    if (memUpdate){

                        System.out.println("Ingrese Codigo de Pago: ");
                        String codPago=scanner.nextLine();
                        System.out.println("Ingrese monto: ");
                        double monto=scanner.nextDouble();
                        membresia.ActualizarPago(codPago,codigoMembresiaupdate,monto);
                        break;

                    }else {
                        System.err.println("codMembresia no encontrada!!!");
                    }


                    break;
                case 4:
                    System.out.println("Ingrese codigo de Membresia: ");
                    String codigoMembresiaDelete=scanner.nextLine();
                    boolean memDelete= club.getClientes().stream().anyMatch(x->x.getCodigoMiembro().equals(codigoMembresiaDelete));
                    if (memDelete){
                        System.out.println("Ingrese el Codigo de Pago  a eliminar: ");
                        String pago=scanner.nextLine();
                        membresia.eliminarPago(pago);
                        break;
                    }else {
                        System.err.println("codMembresia no encontrada!!!");
                    }
                    break;
                case 5:
                    // Regresar al menú principal
                    mR=false;
                    mostrarMenuPrincipal();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
