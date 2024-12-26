package modelo;

/**
 *
 * @author Heidy
 */
public class Cliente extends Persona {
    // Atributos específicos
    private double estatura;
    private int edad;
    private Integer contacto;
    
    // Constructor para insertar
    public Cliente(int cedula, String nombre, int telefono, String email, double estatura, int edad, Integer contacto) {
        super(cedula, nombre, telefono, email); // Llama al constructor de Persona
        this.estatura = estatura;
        this.edad = edad;
        if (edad < 18) {
            if (contacto == null) {
                throw new IllegalArgumentException("Se requiere un número de contacto para clientes menores de 18 años.");
            }
            this.contacto = contacto;
        } else {
            this.contacto = contacto; // Los mayores de 18 años pueden tener contacto o no
        }
    }
    
    // Constructor para leer, actualizar y eiminar
    public Cliente(int id, int cedula, String nombre, int telefono, String email, double estatura, int edad, Integer contacto) {
        super(id, cedula, nombre, telefono, email); // Llama al constructor de Persona
        this.estatura = estatura;
        this.edad = edad;
        if (edad < 18) {
            if (contacto == null) {
                throw new IllegalArgumentException("Se requiere un número de contacto para clientes menores de 18 años.");
            }
            this.contacto = contacto;
        } else {
            this.contacto = contacto; // Los mayores de 18 años pueden tener contacto o no
        }
    }

    public Cliente() {
    }

    // Getters y setters específicos
    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
        if (edad < 18 && this.contacto == null) {
            throw new IllegalArgumentException("Se requiere un número de contacto para clientes menores de 18 años.");
        }
    }

    public Integer getContacto() {
        return contacto;
    }

    public void setContacto(Integer contacto) {
        if (this.edad < 18 && contacto == null) {
            throw new IllegalArgumentException("Se requiere un número de contacto para clientes menores de 18 años.");
        }
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cliente{" +
               "estatura=" + estatura +
               ", edad=" + edad +
               ", contacto=" + (contacto != null ? contacto : "No aplica") +
               '}';
    }
}
