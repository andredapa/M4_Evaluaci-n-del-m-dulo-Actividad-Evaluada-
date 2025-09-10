package com.ejemplo.inventario;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InventarioTest {
   private Inventario inventario;

   InventarioTest() {
   }

   @BeforeEach
   void setUp() {
      this.inventario = new Inventario();
   }

   @Test
   void agregarDebeCrearIdsIncrementales() {
      Producto p1 = this.inventario.agregar("Manzana", 500.0, 10);
      Producto p2 = this.inventario.agregar("Pera", 600.0, 5);
      Assertions.assertEquals(1, p1.getId());
      Assertions.assertEquals(2, p2.getId());
   }

   @Test
   void eliminarPorIdDebeRetornarTrueSiExiste() {
      Producto p = this.inventario.agregar("Leche", 1200.0, 3);
      boolean eliminado = this.inventario.eliminarPorId(p.getId());
      Assertions.assertTrue(eliminado);
      Assertions.assertTrue(this.inventario.listarTodos().isEmpty());
   }

   @Test
   void buscarPorNombreDebeSerCaseInsensitive() {
      this.inventario.agregar("Café en grano", 4500.0, 2);
      this.inventario.agregar("CAFETERA", 25000.0, 1);
      List<Producto> r = this.inventario.buscarPorNombre("cafe");
      Assertions.assertEquals(2, r.size());
   }

   @Test
   void estadisticasDebenSerCorrectas() {
      this.inventario.agregar("Pan", 1500.0, 4);
      this.inventario.agregar("Queso", 3000.0, 2);
      Assertions.assertEquals(6, this.inventario.stockTotal());
      Assertions.assertEquals(12000.0, this.inventario.valorTotalInventario(), 1.0E-4);
   }
}
