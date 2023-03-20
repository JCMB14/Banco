
import javax.swing.JOptionPane;

public class Main {

    static Cliente cliente[] = new Cliente[9];
    static int tope = 0;

    public static void main(String[] args) {
        char op = 0;
        do {
            op = JOptionPane.showInputDialog(null, "Seleccione Opcion: \n"
                    + "\n1. Ingresar Cliente"
                    + "\n2. Consultar Cliente"
                    + "\n3. Modificar Cliente"
                    + "\n4. Desactivar/Activar Cuenta"
                    + "\n5. Retirar Dinero"
                    + "\n6. Consignar Dinero"
                    + "\n7. Listar todos los clientes."
                    + "\n8. Salir").charAt(0);
            switch (op) {
                case '1': {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Cedula: "));
                    Cliente temp = buscarCliente(cedula);
                    if (temp != null) {
                        JOptionPane.showMessageDialog(null, "El cliente ya existe");
                    } else {
                        String nombre = JOptionPane.showInputDialog(null, "Digite Nombre: ");
                        String genero = JOptionPane.showInputDialog(null, "Digite Genero (F/M/B): ");
                        double dinero = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el monto del Dinero: "));
                        ingresarCliente(cedula, nombre, genero, dinero);
                    }
                }
                break;
                case '2': {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Cedula: "));
                    Cliente temp = buscarCliente(cedula);
                    if (temp != null) {
                        JOptionPane.showMessageDialog(null, temp.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                    }
                }
                break;
                case '3': {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Cedula: "));
                    Cliente temp = buscarCliente(cedula);
                    if (temp != null) {
                        modificarCliente(temp);
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                    }
                }
                break;
                case '4': {
                    //Eliminar
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Cedula: "));
                    Cliente temp = buscarCliente(cedula);
                    if (temp != null) {
                        int op1 = Integer.parseInt(JOptionPane.showInputDialog("1. Desactivar \n2. Activar"));
                        if (op1 == 1) {
                            temp.desactivar();
                        } else {
                            temp.activar();
                        }
                        JOptionPane.showMessageDialog(null, temp.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe");
                    }
                }
                break;
                case '5': {
                    //Retirar
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Cedula: "));
                    Cliente temp = buscarCliente(cedula);
                    if (temp != null) {
                        //retiro.
                        double monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el monto a retirar: "));
                        temp.retirar(monto);
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe.");
                    }
                }
                break;
                case '6': {
                    //Consignar
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite Cedula: "));
                    Cliente temp = buscarCliente(cedula);
                    if (temp != null) {
                        //retiro.
                        double monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el monto a consignar: "));
                        temp.consignar(monto);
                    } else {
                        JOptionPane.showMessageDialog(null, "El cliente no existe.");
                    }
                }
                break;
                case '7':
                    listar();
                    break;
                case '8':
                    JOptionPane.showMessageDialog(null, "Salida Exitosa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion Invalida");
                    break;
            }
        } while (op != '8');
    }

    private static void ingresarCliente(int cedula, String nombre, String genero, double dinero) {
        cliente[tope] = new Cliente(cedula, nombre, genero, dinero);
        JOptionPane.showMessageDialog(null, "Cliente creado.\n" + cliente[tope].toString());
        tope++;
    }

    private static Cliente buscarCliente(int cedula) {
        for (int i = 0; i < tope; i++) {
            if (cliente[i].getCedula() == cedula) {
                return cliente[i];
            }
        }
        return null;
    }

    private static void modificarCliente(Cliente temp) {
        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el campo a modificar:"
                    + "\n1. Nombre"
                    + "\n2. Genero"
                    + "\n3. Salir"));
            switch (op) {
                case 1:
                    temp.setNombre(JOptionPane.showInputDialog("Nombre:"));
                    JOptionPane.showMessageDialog(null, "Modificación exitosa.");
                    break;
                case 2:
                    temp.setGenero(JOptionPane.showInputDialog("Digite Genero (F/M/B):"));
                    JOptionPane.showMessageDialog(null, "Modificación exitosa.");
                    break;
            }
        } while (op != 3);
        JOptionPane.showMessageDialog(null, temp.toString());
    }

    private static void listar() {
        for (int i = 0; i < tope; i++) {
            JOptionPane.showMessageDialog(null, cliente[i].toString());
        }
    }

}
