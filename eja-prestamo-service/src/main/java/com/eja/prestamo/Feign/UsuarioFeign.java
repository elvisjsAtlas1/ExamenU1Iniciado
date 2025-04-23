package com.eja.prestamo.Feign;


import com.eja.prestamo.Dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eja-usuario-service", path = "/usuario")
public interface UsuarioFeign {

    @GetMapping("/{id}")
    ResponseEntity<UsuarioDto> buscarUsuario(@PathVariable Long id);
}