package com.eja.prestamo.Service.ServiceImpl;


import com.eja.prestamo.Entity.Prestamo;
import com.eja.prestamo.Feign.LibroFeign;
import com.eja.prestamo.Feign.UsuarioFeign;
import com.eja.prestamo.Repository.PrestamoRepositorio;
import com.eja.prestamo.Service.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrestamoServicioImpl implements PrestamoServicio {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private LibroFeign libroFeign;

    @Autowired
    private UsuarioFeign usuarioFeign;

    @Override
    public List<Prestamo> Listar() {
        return prestamoRepositorio.findAll().stream()
                .map(prestamo -> {
                    prestamo.setLibro(libroFeign.buscarLibro(prestamo.getLibroId()).getBody());
                    prestamo.setUsuario(usuarioFeign.buscarUsuario(prestamo.getUsuarioId()).getBody());
                    return prestamo;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Prestamo Buscar(Long id) {
        Optional<Prestamo> prestamoOptional = prestamoRepositorio.findById(id);
        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();
            prestamo.setLibro(libroFeign.buscarLibro(prestamo.getLibroId()).getBody());
            prestamo.setUsuario(usuarioFeign.buscarUsuario(prestamo.getUsuarioId()).getBody());
            return prestamo;
        }
        return null;
    }

    @Override
    public Prestamo Guardar(Prestamo prestamo) {
        Prestamo prestamoGuardado = prestamoRepositorio.save(prestamo);
        prestamoGuardado.setLibro(libroFeign.buscarLibro(prestamoGuardado.getLibroId()).getBody());
        prestamoGuardado.setUsuario(usuarioFeign.buscarUsuario(prestamoGuardado.getUsuarioId()).getBody());
        return prestamoGuardado;
    }

    @Override
    public Prestamo Actualizar(Prestamo prestamo) {
        Prestamo actualizado = prestamoRepositorio.save(prestamo);
        actualizado.setLibro(libroFeign.buscarLibro(actualizado.getLibroId()).getBody());
        actualizado.setUsuario(usuarioFeign.buscarUsuario(actualizado.getUsuarioId()).getBody());
        return actualizado;
    }

    @Override
    public Prestamo Eliminar(Prestamo prestamo) {
        prestamoRepositorio.delete(prestamo);
        return prestamo;
    }

}