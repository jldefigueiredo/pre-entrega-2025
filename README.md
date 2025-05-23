# Sistema de Gestión de Artículos

Este es un sistema de gestión de artículos desarrollado en Java que permite realizar operaciones básicas de mantenimiento sobre un inventario de artículos.

## Características Principales

- Crear nuevos artículos con validaciones
- Listar artículos en formato tabular
- Modificar artículos existentes
- Eliminar artículos
- Validaciones completas de datos
- Interfaz de usuario por consola

## Estructura del Proyecto

El proyecto consta de dos clases principales:

### Clase Articulo

Representa un artículo individual en el sistema con los siguientes atributos:

- id (int): Identificador único del artículo
- nombre (String): Nombre del artículo
- precio (double): Precio del artículo

#### Validaciones de Artículo

- **ID**: Debe ser un número positivo
- **Nombre**: No puede estar vacío ni ser null
- **Precio**: No puede ser negativo

#### Métodos Principales

- Constructor: Crea un nuevo artículo con validaciones
- getId(): Obtiene el ID del artículo
- getNombre(): Obtiene el nombre del artículo
- setNombre(): Modifica el nombre con validaciones
- setPrecio(): Modifica el precio con validaciones
- equals(): Compara artículos por ID o nombre
- hashCode(): Genera un código hash basado en el ID
- mostrar(): Muestra la información en formato tabular

### Clase Main

Implementa la interfaz de usuario y la lógica de gestión con las siguientes funcionalidades:

#### Menú Principal

--- Menú de Artículos ---
1. Crear artículo
2. Listar artículos
3. Modificar artículo
4. Eliminar artículo
5. Salir


#### Funcionalidades Detalladas

1. **Crear Artículo**
   - Solicita ID, nombre y precio
   - Valida que el ID sea único y positivo
   - Valida que el nombre no esté duplicado
   - Valida que el precio sea positivo
   - Maneja errores de entrada

2. **Listar Artículos**
   - Muestra una tabla formateada con todos los artículos
   - Incluye ID, nombre y precio con formato de moneda
   - Muestra el total de artículos
   - Maneja el caso de lista vacía

3. **Modificar Artículo**
   - Busca el artículo por ID
   - Permite mantener valores actuales
   - Valida nuevos valores
   - Maneja errores de entrada

4. **Eliminar Artículo**
   - Elimina por ID
   - Confirma la eliminación
   - Maneja el caso de artículo no encontrado

## Formato de Presentación

Los artículos se muestran en una tabla con el siguiente formato:

┌─────┬────────────────────────────────┬──────────────┐
│ ID  │ Nombre                         │ Precio       │
├─────┼────────────────────────────────┼──────────────┤
│ 1   │ Ejemplo                        │    $100.00   │
└─────┴────────────────────────────────┴──────────────┘
Total de artículos: 1


## Manejo de Errores

El sistema incluye manejo robusto de errores para:
- Entradas inválidas
- Valores duplicados
- Valores negativos
- Campos vacíos
- Errores de formato

## Validaciones Específicas

### Para Crear/Modificar Artículos
- **ID**: Debe ser positivo y único
- **Nombre**: 
  - No puede estar vacío
  - No puede estar duplicado
  - Se eliminan espacios extra
  - No distingue entre mayúsculas y minúsculas
- **Precio**: 
  - No puede ser negativo
  - Acepta decimales (usando coma o punto)
  - Se muestra con formato de moneda

## Buenas Prácticas Implementadas

1. **Encapsulamiento**
   - Atributos privados
   - Métodos de acceso controlado
   - Validaciones en setters

2. **Manejo de Excepciones**
   - Try-catch para entradas de usuario
   - Excepciones específicas para validaciones
   - Mensajes de error descriptivos

3. **Formato y Presentación**
   - Tabla formateada
   - Alineación de columnas
   - Formato de moneda
   - Mensajes claros al usuario

4. **Comparación de Objetos**
   - Implementación personalizada de equals()
   - Implementación consistente de hashCode()
   - Comparación case-insensitive de nombres