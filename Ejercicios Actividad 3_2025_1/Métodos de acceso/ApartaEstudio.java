public class ApartaEstudio extends Apartamento{
   protected static double valorArea = 1500000;
   public ApartaEstudio(int identificadorInmobiliario, int área, String dirección, int númeroHabitaciones, int númeroBaños) {
        super(identificadorInmobiliario, área, dirección, 1, 1);
 }
    void imprimir() {
        super.imprimir(); // Invoca al método imprimir de la clase padre
        System.out.println();
 }
}
