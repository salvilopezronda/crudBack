package com.example.crud;

import com.example.crud.domain.Producto;
import com.example.crud.repository.ProductoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CrudApplication {

    @Autowired
    ProductoRepository productoRepository;

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @PostConstruct
    public void init() {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        Producto producto1 = Producto.builder().nombre("Bolígrafo").descripcion("Bolígrafo de tinta negra").precio(1.99).build();
        listaProductos.add(producto1);

        Producto producto2 = Producto.builder().nombre("Libreta").descripcion("Libreta de tapa dura con rayas").precio(5.99).build();
        listaProductos.add(producto2);

        Producto producto3 = Producto.builder().nombre("Mochila").descripcion("Mochila escolar de color rojo").precio(29.99).build();
        listaProductos.add(producto3);

        Producto producto4 = Producto.builder().nombre("Gafas de sol").descripcion("Gafas de sol con montura de metal").precio(14.99).build();
        listaProductos.add(producto4);

        Producto producto5 = Producto.builder().nombre("Calcetines deportivos").descripcion("Calcetines de deporte para hombre").precio(7.99).build();
        listaProductos.add(producto5);

        Producto producto6 = Producto.builder().nombre("Botella de agua").descripcion("Botella de agua reutilizable de plástico").precio(4.99).build();
        listaProductos.add(producto6);

        Producto producto7 = Producto.builder().nombre("Cargador portátil").descripcion("Cargador portátil para teléfonos móviles").precio(19.99).build();
        listaProductos.add(producto7);

        Producto producto8 = Producto.builder().nombre("Paquete de papel de regalo").descripcion("Paquete de 10 hojas de papel de regalo").precio(3.99).build();
        listaProductos.add(producto8);

        Producto producto9 = Producto.builder().nombre("Auriculares con cable").descripcion("Auriculares con cable para escuchar música").precio(9.99).build();
        listaProductos.add(producto9);

        Producto producto10 = Producto.builder().nombre("Teclado inalámbrico").descripcion("Teclado inalámbrico para computadoras").precio(29.99).build();
        listaProductos.add(producto10);

        Producto producto11 = Producto.builder().nombre("Mouse inalámbrico").descripcion("Mouse inalámbrico para computadoras").precio(19.99).build();
        listaProductos.add(producto11);

        Producto producto12 = Producto.builder().nombre("Cable HDMI").descripcion("Cable HDMI de 6 pies de largo").precio(8.99).build();
        listaProductos.add(producto12);

        Producto producto13 = Producto.builder().nombre("Pelota de fútbol").descripcion("Pelota de fútbol tamaño 5").precio(14.99).build();
        listaProductos.add(producto13);

        Producto producto14 = Producto.builder().nombre("Set de tazas de café").descripcion("Set de 4 tazas de café con platos").precio(19.99).build();
        listaProductos.add(producto14);

        Producto producto15 = Producto.builder().nombre("Ratón de juguete para gato").descripcion("Ratón de peluche para que los gatos jueguen").precio(2.99).build();
        listaProductos.add(producto15);

        Producto producto16 = Producto.builder().nombre("Juego de mesa Monopoly").descripcion("Juego de mesa Monopoly para 2 a 6 jugadores").precio(24.99).build();
        listaProductos.add(producto16);

        productoRepository.saveAll(listaProductos);
    }
}
