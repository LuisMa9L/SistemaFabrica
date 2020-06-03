package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.modelo.Pedidos;
import com.proyecto.fabrica.modelo.Recibidos;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/pedidosapi")
public class RestPedidos {


    @Autowired
    private IPedidosService service;

    /**
     *
     * @return
     */

    @GetMapping
    public ArrayList<Recibidos> listar(){
        Recibidos re = new Recibidos();
        re.setNombre_producto("Hola mundo XD");
        //List<Recibidos> res = new List<Recibidos>();
        ArrayList<Recibidos> res = new ArrayList<>();
        res.add(re);
        return res;
    }

    /**
     *
     * @param pro
     */

    @PostMapping
    public void insertar(@RequestBody Pedidos pro){
        service.save(pro);
    }

    /**
     *
     * @param pro
     */

    @PutMapping
    public void modificar(Pedidos pro){
        service.save(pro);
    }

    /**
     *
     * @param id
     */

    @DeleteMapping(value = "/{id}")
    public void eliminar (@PathVariable("id") String id){
        service.delete(id);
    }
}
