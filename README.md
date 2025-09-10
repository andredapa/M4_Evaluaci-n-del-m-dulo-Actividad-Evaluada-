# Inventario de Tienda (Consola, Java 17)

Aplicación de consola para gestionar un inventario sencillo: agregar, buscar, listar, eliminar; además calcula stock total y valor total del inventario.

## Requisitos
- Java 17+
- Maven 3.9+

## Compilación y ejecución

```bash
# Desde la carpeta del proyecto
mvn clean package

# Ejecutar (jar empacado con dependencias mediante Shade)
java -jar target/inventario-1.0-SNAPSHOT-shaded.jar
```

## Pruebas (JUnit 5)
```bash
mvn test
```

## Ejemplo de sesión (transcripción)
```
=== Sistema de Inventario - Tienda ===
------------------------------
1) Agregar producto
2) Buscar producto por nombre
3) Listar todos los productos
4) Eliminar producto por ID
5) Stock total y valor inventario
0) Salir
Selecciona una opción: 1
Nombre: Café en grano
Precio (ej: 1990.5): 4500
Cantidad: 2
Producto agregado: Producto{id=1, nombre='Café en grano', precio=4500.0, cantidad=2}

Selecciona una opción: 5
Stock total: 2
Valor total inventario: 9000.00

Selecciona una opción: 0
Saliendo... ¡Hasta luego!
```

## Estructura
```
src/
  main/java/com/example/inventario/
    Main.java
    Inventario.java
    Producto.java
  test/java/com/example/inventario/
    InventarioTest.java
pom.xml
```

## Notas de diseño
- **POO**: `Producto` (entidad), `Inventario` (servicio), `Main` (capa de interfaz por consola).
- **Encapsulamiento**: atributos privados y getters/setters validados.
- **IDs**: generados automáticamente con `AtomicInteger`.
- **Colecciones**: `LinkedHashMap` para mantener orden de inserción y búsqueda por ID en O(1).
- **Buenas prácticas**: nombres significativos, validaciones de entrada, mensajes claros, control de errores.

