public class Prueba_cuenta {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Cuenta corriente");
        System.out.println("Ingrese saldo inicial= $");
        float saldoInicialCorriente = input.nextFloat(); 
       System.out.print("Ingrese tasa de interés= ");
        float tasaAhorros = input.nextFloat();
        CuentaAhorros cuenta1 = new 
       CuentaAhorros(saldoInicialCorriente, tasaAhorros);
        System.out.print("Ingresar cantidad a consignar: $");
        float cantidadDepositar = input.nextFloat();
        cuenta1.consignar(cantidadDepositar);
        System.out.print("Ingresar cantidad a retirar: $");
        float cantidadRetirar = input.nextFloat();
        cuenta1.retirar(cantidadRetirar);
        cuenta1.extractoMensual();
        cuenta1.imprimir();}}
