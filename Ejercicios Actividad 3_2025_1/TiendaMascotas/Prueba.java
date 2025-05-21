public class Prueba {
    public static void main(String[] args) {
        PerrosPequeños yorkie = new PerrosPequeños("Max", 3, "Marrón", 5.5, false);
        GatoPeloLargo angora = new GatoPeloLargo("Luna", 2, "Blanco", 0.8, 2.0);

        System.out.println("Información del Perro:");
        yorkie.mostrarInformacion();
        Perro.sonido();

        System.out.println("\nInformación del Gato:");
        angora.mostrarInformacion();
        Gato.sonido();
    }
}
