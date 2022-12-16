package com.uteq.biblioteca.services;

import com.uteq.biblioteca.entities.Categoria;
import com.uteq.biblioteca.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Categoria> findAll() throws Exception {
        try {
            return categoriaRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Categoria findById(Integer id) throws Exception {
        try {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Categoria save(Categoria entity) throws Exception {
        try {
            entity = categoriaRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Categoria update(Integer id, Categoria entity) throws Exception {
        try {
            Optional<Categoria> entityOptional = categoriaRepository.findById(id);
            Categoria categoria = entityOptional.get();
            categoria = categoriaRepository.save(entity);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (categoriaRepository.existsById(id)) {
                categoriaRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
