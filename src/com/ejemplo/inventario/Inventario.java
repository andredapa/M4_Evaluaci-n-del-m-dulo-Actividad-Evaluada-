package com.ejemplo.inventario;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private final List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public Producto agregar(String nombre, double precio, int cantidad) {
        Producto p = new Producto(nombre, precio, cantidad);
        productos.add(p);
        return p;
    }

    public List<Producto> listarTodos() {
        return new ArrayList<>(productos);
    }

    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public boolean eliminarPorId(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }

    public int stockTotal() {
        int total = 0;
        for (Producto p : productos) {
            total += p.getCantidad();
        }
        return total;
    }

    public double valorTotalInventario() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }
        return total;
    }
}

