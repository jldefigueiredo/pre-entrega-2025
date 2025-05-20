import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal para gestionar artículos.
 * Desde acá el usuario puede crear, listar, modificar o eliminar artículos a través de un menú.
 */
public class Main {
    // Lista donde vamos a guardar los artículos
    static ArrayList<Articulos> lista = new ArrayList<>();
    // Scanner para leer lo que escribe el usuario
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            // Menú principal
            System.out.println("\n--- Menú de Artículos ---");
            System.out.println("1. Crear artículo");
            System.out.println("2. Listar artículos");
            System.out.println("3. Modificar artículo");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiamos el buffer para evitar problemas con nextLine()

            // Ejecutamos según lo que elija el usuario
            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> listarArticulos();
                case 3 -> modificarArticulo();
                case 4 -> eliminarArticulo();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        sc.close(); // Cerramos el scanner antes de salir
    }

    /**
     * Pide los datos del nuevo artículo y lo agrega a la lista si todo está bien.
     * Se valida que el ID sea único y positivo, que el nombre no esté vacío ni repetido,
     * y que el precio sea un número válido.
     */
    public static void crearArticulo() {
        try {
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            if (id <= 0) {
                System.out.println("Error: El ID debe ser mayor que cero.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            if (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío.");
                return;
            }

            // Revisamos si ya existe un artículo con ese ID o nombre
            boolean existe = lista.stream().anyMatch(a -> 
                a.getId() == id || a.getNombre().trim().equalsIgnoreCase(nombre.trim())
            );

            if (existe) {
                System.out.println("Error: Ya hay un artículo con ese ID o nombre.");
                return;
            }

            // Pedimos el precio (se reemplaza la coma por punto por si el usuario usa coma decimal)
            System.out.print("Precio (use coma decimal, ej: 25,47): ");
            String precioStr = sc.next().replace(',', '.');
            double precio;

            try {
                precio = Double.parseDouble(precioStr);
                if (precio < 0) {
                    System.out.println("Error: El precio no puede ser negativo.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Precio inválido. Ejemplo válido: 25,47");
                return;
            }

            // Creamos el artículo y lo agregamos a la lista
            try {
                Articulos nuevo = new Articulos(id, nombre, precio);
                lista.add(nuevo);
                System.out.println("Artículo agregado correctamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Entrada no válida.");
            sc.nextLine(); // Limpiar buffer
        }
    }

    /**
     * Muestra la lista de artículos.
     * Si no hay ninguno, se lo informa. Si hay, se listan con formato de tabla.
     */
    public static void listarArticulos() {
        if (lista.isEmpty()) {
            System.out.println("No hay artículos cargados.");
        } else {
            System.out.println("┌─────┬────────────────────────────────┬──────────────┐");
            System.out.println("│ ID  │ Nombre                         │ Precio       │");
            System.out.println("├─────┼────────────────────────────────┼──────────────┤");

            for (Articulos a : lista) {
                a.mostrar();
            }

            System.out.println("└─────┴────────────────────────────────┴──────────────┘");
            System.out.println("Total de artículos: " + lista.size());
        }
    }

    /**
     * Permite modificar el nombre o el precio de un artículo según su ID.
     * Se puede mantener el valor actual si el usuario presiona Enter o pone -1.
     */
    public static void modificarArticulo() {
        try {
            System.out.print("ID del artículo a modificar: ");
            int id = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            for (Articulos a : lista) {
                if (a.getId() == id) {
                    try {
                        System.out.print("Nuevo nombre (Enter para dejar el mismo): ");
                        String nombre = sc.nextLine();
                        if (!nombre.trim().isEmpty()) {
                            a.setNombre(nombre);
                        }

                        System.out.print("Nuevo precio (coma decimal, ej: 25,47 o -1 para no cambiar): ");
                        String precioStr = sc.next().replace(',', '.');
                        double precio = Double.parseDouble(precioStr);
                        if (precio >= 0) {
                            a.setPrecio(precio);
                        }

                        System.out.println("Artículo actualizado correctamente.");
                        return;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Ingresá un precio válido.");
                        return;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                        return;
                    }
                }
            }

            System.out.println("No se encontró ningún artículo con ese ID.");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Entrada no válida.");
            sc.nextLine(); // Limpiar buffer
        }
    }

    /**
     * Elimina un artículo por ID.
     * Si el artículo existe, se borra de la lista. Si no, se informa al usuario.
     */
    public static void eliminarArticulo() {
        System.out.print("ID del artículo a eliminar: ");
        int id = sc.nextInt();
        boolean eliminado = lista.removeIf(a -> a.getId() == id);

        if (eliminado) {
            System.out.println("Artículo eliminado.");
        } else {
            System.out.println("No se encontró el artículo con ese ID.");
        }
    }
}
