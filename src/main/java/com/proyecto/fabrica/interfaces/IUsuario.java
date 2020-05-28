package com.proyecto.fabrica.interfaces;

import com.proyecto.fabrica.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario extends CrudRepository<Usuario, String> {

}
