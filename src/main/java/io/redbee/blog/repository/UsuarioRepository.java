package io.redbee.blog.repository;

import io.redbee.blog.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
}