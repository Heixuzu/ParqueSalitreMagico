package modelo;

/**
 *
 * @author Heidy
 */
public class Atraccion {
    // Atributos
    private int id;
    private String nombre;  // Nuevo atributo
    private String descripcion;
    private String clasificacion; // Ej.: "Familiar", "Adrenalina", "Infantil", etc.
    private String condicionesUso; // Ej.: "No apto para personas con problemas de corazón."
    private String estado; // Ej.: "Habilitada", "Daño", "Mantenimiento"
    private double alturaMinima; // En metros

    
    // Constructor para insertar
    public Atraccion(String nombre, String descripcion, String clasificacion, String condicionesUso, String estado, double alturaMinima) {
        this.nombre = nombre; // Asignar el nombre
        this.descripcion = descripcion;
        setClasificacion(clasificacion); // Validar clasificación
        this.condicionesUso = condicionesUso;
        setEstado(estado); // Validar estado
        this.alturaMinima = alturaMinima;
    }    
    
    // Constructor para leer, actualizar y eiminar
    public Atraccion(int id, String nombre, String descripcion, String clasificacion, String condicionesUso, String estado, double alturaMinima) {
        this.id = id;
        this.nombre = nombre; // Asignar el nombre
        this.descripcion = descripcion;
        setClasificacion(clasificacion); // Validar clasificación
        this.condicionesUso = condicionesUso;
        setEstado(estado); // Validar estado
        this.alturaMinima = alturaMinima;
    }
    
    public Atraccion(){
        
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre; // Obtener el nombre
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public String getCondicionesUso() {
        return condicionesUso;
    }

    public String getEstado() {
        return estado;
    }

    public double getAlturaMinima() {
        return alturaMinima;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // Asignar el nombre
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setClasificacion(String clasificacion) {
        // Validar que la clasificación sea una de las permitidas
        if (clasificacion.equalsIgnoreCase("Familiar") || 
            clasificacion.equalsIgnoreCase("Adrenalina") || 
            clasificacion.equalsIgnoreCase("Infantil")) {
            this.clasificacion = clasificacion;
        } else {
            throw new IllegalArgumentException("Clasificación no válida: " + clasificacion);
        }
    }

    public void setCondicionesUso(String condicionesUso) {
        this.condicionesUso = condicionesUso;
    }

    public void setEstado(String estado) {
        // Validar que el estado sea uno de los permitidos
        if (estado.equalsIgnoreCase("Habilitada") || 
            estado.equalsIgnoreCase("Daño") || 
            estado.equalsIgnoreCase("Mantenimiento")) {
            this.estado = estado;
        } else {
            throw new IllegalArgumentException("Estado no válido: " + estado);
        }
    }

    public void setAlturaMinima(double alturaMinima) {
        if (alturaMinima >= 0) { // Altura mínima no puede ser negativa
            this.alturaMinima = alturaMinima;
        } else {
            throw new IllegalArgumentException("Altura mínima no puede ser negativa.");
        }
    }

    // Método para mostrar información de la atracción
    @Override
    public String toString() {
        return "Atraccion{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +  // Mostrar nombre
               ", descripcion='" + descripcion + '\'' +
               ", clasificacion='" + clasificacion + '\'' +
               ", condicionesUso='" + condicionesUso + '\'' +
               ", estado='" + estado + '\'' +
               ", alturaMinima=" + alturaMinima +
               '}';
    }
}
