/**
 * Clase que representa un artículo en el sistema de inventario.
 * Contiene información básica como ID, nombre y precio.
 */
public class Articulos {
    private final int id;        // Identificador único del artículo
    private String nombre;       // Nombre del artículo
    private double precio;       // Precio del artículo

    /**
     * Constructor que crea un nuevo artículo con validaciones.
     * @param id Identificador único del artículo (debe ser positivo)
     * @param nombre Nombre del artículo (no puede estar vacío)
     * @param precio Precio del artículo (no puede ser negativo)
     * @throws IllegalArgumentException si algún parámetro no cumple las validaciones
     */
    public Articulos(int id, String nombre, double precio) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser un número positivo");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.nombre = nombre.trim();
        this.precio = precio;
    }

    /**
     * Obtiene el ID del artículo.
     * @return el ID único del artículo
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre del artículo.
     * @return el nombre del artículo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del artículo con validaciones.
     * @param nombre nuevo nombre para el artículo (no puede estar vacío)
     * @throws IllegalArgumentException si el nombre está vacío o es null
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    /**
     * Modifica el precio del artículo con validaciones.
     * @param precio nuevo precio para el artículo (no puede ser negativo)
     * @throws IllegalArgumentException si el precio es negativo
     */
    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    /**
     * Compara este artículo con otro objeto para determinar si son iguales.
     * Dos artículos se consideran iguales si tienen el mismo ID o el mismo nombre
     * (ignorando mayúsculas/minúsculas y espacios).
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Articulos other = (Articulos) obj;
        return id == other.id || nombre.trim().equalsIgnoreCase(other.nombre.trim());
    }

    /**
     * Genera un código hash para el artículo basado en su ID.
     * Este método es necesario para mantener el contrato con equals().
     * @return el código hash del artículo
     * sobreescribe el método hashCode() de la clase Object
     */
    @Override
    public int hashCode() {
        return id;
    }   
     
    /**
     * Muestra la información del artículo en formato tabular.
     * Incluye ID, nombre y precio con formato de moneda.
     * id = decimal, 3 espacios alineado a la izquierda
     * nombre = string, 30 espacios alineado a la izquierda
     * precio = decimal, 10 espacios alineado a la derecha
     * 
     */
    public void mostrar() {
        System.out.printf("│ %-3d │ %-30s │ $%,10.2f  │%n", id, nombre, precio);
    }
}