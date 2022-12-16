package com.uteq.biblioteca.services;

import com.uteq.biblioteca.entities.Editorial;
import com.uteq.biblioteca.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Editorial> findAll() throws Exception {
        try {
            return editorialRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Editorial findById(Integer id) throws Exception {
        try {
            Optional<Editorial> entityOptional = editorialRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Editorial save(Editorial entity) throws Exception {
        try {
            entity = editorialRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Editorial update(Integer id, Editorial entity) throws Exception {
        try {
            Optional<Editorial> entityOptional = editorialRepository.findById(id);
            Editorial editorial = entityOptional.get();
            editorial = editorialRepository.save(entity);
            return editorial;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (editorialRepository.existsById(id)) {
                editorialRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
