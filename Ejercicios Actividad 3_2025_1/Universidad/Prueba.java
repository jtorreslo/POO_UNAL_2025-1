public class Prueba {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Ana", "Calle 123", "Ingeniería", 3);
        Profesor profesor = new Profesor("Dr. Luis", "Avenida 45", "Matemáticas", "Titular");

        System.out.println("Estudiante: " + estudiante.getNombre() + ", Carrera: " + estudiante.getCarrera() + ", Semestre: " + estudiante.getSemestre());
        System.out.println("Profesor: " + profesor.getNombre() + ", Departamento: " + profesor.getDepartamento() + ", Categoría: " + profesor.getCategoria());
    }
}
