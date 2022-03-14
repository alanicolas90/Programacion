package modelo;


public class PersonaAdministrativo extends Persona implements Cotizable<PersonaAdministrativo>{

    private double sueldo;
    private String tarea;

    public PersonaAdministrativo(String dni, String nombre, double sueldo, String tarea) {
        super(dni, nombre);
        this.sueldo = sueldo;
        this.tarea = tarea;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    @Override
    public PersonaAdministrativo cotizable() {
        return new PersonaAdministrativo(this.getDni(),this.getNombre(),this.sueldo,this.tarea);
    }

    @Override
    public String toString() {
        return "PersonaAdministrativo{" +
                "sueldo=" + sueldo +
                ", tarea='" + tarea + '\'' +
                '}';
    }
}

