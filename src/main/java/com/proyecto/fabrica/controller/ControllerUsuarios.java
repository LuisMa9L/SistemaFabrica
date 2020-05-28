package com.proyecto.fabrica.controller;

import com.proyecto.fabrica.interfaceService.IUsuarioService;
import com.proyecto.fabrica.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class ControllerUsuarios {

    @Autowired
    private IUsuarioService service;

    @GetMapping("/listausuarios")
    public String listar(Model model)
    {
        List<Usuario>usuarios=service.listar();
        model.addAttribute("lusuarios", usuarios);
        return "usuarios";
    }

    @GetMapping("/nuevousuario")
    public String agregar(Model modelo){
        modelo.addAttribute("usuarios", new Usuario());
        return "usuariosnuevo";
    }

    @PostMapping("/guardarusuario")
    public String save(@Valid Usuario c, Model model){
        service.save(c);
        return "redirect:/listausuarios";
    }

    @GetMapping("/editarusuario/{id}")
    public String editar(@PathVariable String id, Model modelo)
    {
        Optional<Usuario>usuario=service.listarId(id);
        modelo.addAttribute("usuarios", usuario);
        return "usuariosnuevo";
    }

    @GetMapping("/eliminarusuario/{id}")
    public String delete(Model modelo, @PathVariable String id)
    {
        service.delete(id);
        return "redirect:/listausuarios";
    }
}
