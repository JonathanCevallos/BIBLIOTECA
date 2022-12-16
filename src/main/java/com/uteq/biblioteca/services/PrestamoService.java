package com.uteq.biblioteca.services;

import com.uteq.biblioteca.entities.Prestamo;
import com.uteq.biblioteca.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    //Este metodo permite listar todos los registro de la entidad.
    public List<Prestamo> findAll() throws Exception {
        try {
            return prestamoRepository.findAll();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    //Este metodo permite: Actualizar un registro mediante su ID.
    public Prestamo findById(Integer id) throws Exception {
        try {
            Optional<Prestamo> entityOptional = prestamoRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: guardar
    public Prestamo save(Prestamo entity) throws Exception {
        try {
            entity = prestamoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Actualizar mediante ID
    public Prestamo update(Integer id, Prestamo entity) throws Exception {
        try {
            Optional<Prestamo> entityOptional = prestamoRepository.findById(id);
            Prestamo prestamo = entityOptional.get();
            prestamo = prestamoRepository.save(entity);
            return prestamo;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //Este metodo permite: Eliminar mediante su ID.
    public boolean delete(Integer id) throws Exception {
        try {
            if (prestamoRepository.existsById(id)) {
                prestamoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
