package com.eja.prestamo.Repository;


import com.eja.prestamo.Entity.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrestamoRepositorio extends JpaRepository<Prestamo, Long> {
}
