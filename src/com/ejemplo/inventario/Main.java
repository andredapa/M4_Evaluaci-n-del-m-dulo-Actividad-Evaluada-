package com.ejemplo.inventario;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        System.out.println("=== Sistema de Inventario - Tienda ===");
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            String opcion = scanner.nextLine().trim();
            switch (opcion) {
                case "1":
                    agregarProducto(inventario);
                    break;
                case "2":
                    buscarProducto(inventario);
                    break;
                case "3":
                    listarProductos(inventario);
                    break;
                case "4":
                    eliminarProducto(inventario);
                    break;
                case "5":
                    mostrarEstadisticas(inventario);
                    break;
                case "0":
                    continuar = false;
                    System.out.println("Saliendo... ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            System.out.println();
        }
    }

    private static void mostrarMenu() {
        String menu = ""
            + "------------------------------\n"
            + "1) Agregar producto\n"
            + "2) Buscar producto por nombre\n"
            + "3) Listar todos los productos\n"
            + "4) Eliminar producto por ID\n"
            + "5) Stock total y valor inventario\n"
            + "0) Salir\n"
            + "Selecciona una opción: ";
        System.out.print(menu);
    }

    private static void agregarProducto(Inventario inventario) {
        try {
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio (ej: 1990.5): ");
            double precio = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine().trim());
            Producto p = inventario.agregar(nombre, precio, cantidad);
            System.out.println("Producto agregado: " + p);
        } catch (NumberFormatException ex) {
            System.out.println("Entrada numérica inválida. Operación cancelada.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void buscarProducto(Inventario inventario) {
        System.out.print("Buscar por nombre: ");
        String q = scanner.nextLine();
        List<Producto> resultados = inventario.buscarPorNombre(q);
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron productos.");
        } else {
            for (Producto p : resultados) {
                System.out.println(p);
            }
        }
    }

    private static void listarProductos(Inventario inventario) {
        List<Producto> lista = inventario.listarTodos();
        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : lista) {
                System.out.println(p);
            }
        }
    }

    private static void eliminarProducto(Inventario inventario) {
        try {
            System.out.print("ID a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            boolean ok = inventario.eliminarPorId(id);
            System.out.println(ok ? "Producto eliminado." : "No existe un producto con ese ID.");
        } catch (NumberFormatException ex) {
            System.out.println("ID inválido.");
        }
    }

    private static void mostrarEstadisticas(Inventario inventario) {
        System.out.println("Stock total: " + inventario.stockTotal());
        System.out.printf("Valor total inventario: %.2f%n", inventario.valorTotalInventario());
    }
}
