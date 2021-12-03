package com.amazona.store.controller;

import com.amazona.store.ProductosService;
import com.amazona.store.model.productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    private final ProductosService productosService;
    @Autowired

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }




    @GetMapping
    public List<productos>getAllProducts(){
        return productosService.getAllProductos();
    }
    @GetMapping(path = "{id}")
    public productos getProducts(@PathVariable("id") Long id){
        return productosService.getProductos(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProducts(@PathVariable("id") Long id){
        productosService.deleteProductos(id);
    }
    @PostMapping
    public void addProducts(@RequestBody productos producto){

        productosService.addProductos(producto);
    }

    @PutMapping(path ="{id}")
    public void updateProducts(@PathVariable("id") Long id,
                               @RequestParam(required = false) String descripcion,
                               @RequestParam(required = false) String imagenURL,
                               @RequestParam(required = false) double precio){
        productosService.updateProductos(id,descripcion,imagenURL,precio);
    }





}
