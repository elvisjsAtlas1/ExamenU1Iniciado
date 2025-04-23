package com.eja.prestamo.Feign;



import com.eja.prestamo.Dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "eja-libro-service", path = "/libro")
public interface LibroFeign {

    @GetMapping("/{id}")
    ResponseEntity<LibroDto> buscarLibro(@PathVariable Long id);
}