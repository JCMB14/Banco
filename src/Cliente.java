
import javax.swing.JOptionPane;

public class Cliente {

    private int cedula;
    private String nombre;
    private String genero;
    private double saldo;
    private boolean activo;

    public Cliente(int cedula, String nombre, String genero, double saldo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.saldo = saldo;
        this.activo = true;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", genero=" + genero + ", saldo=" + saldo + ", activo=" + activo + '}';
    }

    public void retirar(double monto) {
        if (activo) {
            monto = Math.abs(monto);
            if (saldo >= monto) {
                saldo = saldo - monto;
                JOptionPane.showMessageDialog(null, "Retiro exitoso.");
            } else {
                JOptionPane.showMessageDialog(null, "Fondo insuficiente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no esta activo.");
        }
    }

    public void consignar(double monto) {
        if (activo) {
            saldo = saldo + Math.abs(monto);
            JOptionPane.showMessageDialog(null, "Consignación exitosa.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no esta activo.");
        }
    }

    public void desactivar() {
        this.activo = false;
        JOptionPane.showMessageDialog(null, "Eliminación exitosa.");
    }

    public void activar() {
        this.activo = true;
        JOptionPane.showMessageDialog(null, "Activación exitosa.");
    }
}
