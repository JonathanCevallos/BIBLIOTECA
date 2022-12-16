package com.uteq.biblioteca.services;

import com.uteq.biblioteca.entities.Bibliotecario;
import com.uteq.biblioteca.repositories.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class BibliotecarioService {

    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Bibliotecario> findAll() throws Exception {
        try {
            return bibliotecarioRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Bibliotecario findById(Integer id) throws Exception {
        try {
            Optional<Bibliotecario> entityOptional = bibliotecarioRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Bibliotecario save(Bibliotecario entity) throws Exception {
        try {
            entity = bibliotecarioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Bibliotecario update(Integer id, Bibliotecario entity) throws Exception {
        try {
            Optional<Bibliotecario> entityOptional = bibliotecarioRepository.findById(id);
            Bibliotecario bibliotecario = entityOptional.get();
            bibliotecario = bibliotecarioRepository.save(entity);
            return bibliotecario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (bibliotecarioRepository.existsById(id)) {
                bibliotecarioRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
