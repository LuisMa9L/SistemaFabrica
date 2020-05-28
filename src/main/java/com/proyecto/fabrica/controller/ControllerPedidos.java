package com.proyecto.fabrica.controller;



import com.proyecto.fabrica.interfaceService.IClienteService;
import com.proyecto.fabrica.interfaceService.IPedidosService;
import com.proyecto.fabrica.interfaceService.IProductosService;
import com.proyecto.fabrica.modelo.Clientes;
import com.proyecto.fabrica.modelo.Pedidos;
import com.proyecto.fabrica.modelo.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ControllerPedidos {

    @Autowired
    private IPedidosService service;
    @Autowired
    private IProductosService serviceRepuestos;
    @Autowired
    private IClienteService serviceClientes;

    @GetMapping("/pedidos")
    public String listar(Model model)
    {
        List<Pedidos> pedidos=service.listar();
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }
    
    @GetMapping("/pedidos/cliente/{id}")
    public String listarporcliente(@PathVariable String id,Model model)
    {
        List<Pedidos> pedidos=service.listar();
        for (int i = pedidos.size()-1; i >= 0; i--) {
            Pedidos pedido = pedidos.get(i);
            if (!id.equals(pedido.getClientes())) {
                pedidos.remove(pedido);
            } else {
                if (pedido.getVisto()==0) {
                    pedido.setVisto(1);
                    service.save(pedido);
                } else {
                    pedidos.remove(pedido);
                }
            }
        }
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("idcliente", id);
        return "pedidosporcliente";
    }

    @GetMapping("/pedidodetalle/{id}")
    public String listardetalle(@PathVariable String id, Model modelo)
    {
        Optional<Pedidos> pedidos=service.listarId(id);
        modelo.addAttribute("pedidos", pedidos);
        return "pedidodetalle";
    }

    @GetMapping("/pedidonuevo")
    public String agregar(Model modelo){
        modelo.addAttribute("pedidos", new Pedidos());
        List<Productos> productos=serviceRepuestos.listar();
        modelo.addAttribute("lrepuestos", productos);
        List<Clientes>clientes=serviceClientes.listar();
        modelo.addAttribute("lclientes", clientes);
        return "pedidonuevo";
    }

    @PostMapping("/savepedido")
    public String save(@Valid Pedidos pe, Model model){
        service.save(pe);
        return "redirect:/pedidos";

    }

    @GetMapping("/editarpedido/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Pedidos> pedidos=service.listarId(id);
        modelo.addAttribute("pedidos", pedidos);
        
        List<Productos> productos=serviceRepuestos.listar();
        modelo.addAttribute("lrepuestos", productos);
        List<Clientes>clientes=serviceClientes.listar();
        modelo.addAttribute("lclientes", clientes);
        return "pedidonuevo";
    }

    @GetMapping("/eliminarpedido/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/pedidos";
    }

}
