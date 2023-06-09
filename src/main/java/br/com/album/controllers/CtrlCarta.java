package br.com.album.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.album.configs.SwaggerConfig;
import br.com.album.models.Carta;
import br.com.album.services.SrvCarta;
import io.swagger.annotations.Api;

@Api(tags = { SwaggerConfig.ALBUM_TAG })
@RestController
@RequestMapping({ "/album" })
public class CtrlCarta {

    final SrvCarta srvCarta;

    public CtrlCarta(SrvCarta srvCarta) {
        this.srvCarta = srvCarta;
    }

    // CREATE
    @PostMapping(path = "/create")
    public ResponseEntity<Carta> saveCarta(@RequestBody Carta carta) {
        return ResponseEntity.ok().body(srvCarta.save(carta));
    }

    // LIST
    @GetMapping(path = "/list")
    public ResponseEntity<List<Carta>> listCarta() {
        return ResponseEntity.ok().body(srvCarta.findAll());
    }

    // FINDBYID
    @GetMapping(path = "/find/{id}")
    public ResponseEntity<Carta> findCarta(@PathVariable Long id) {
        return srvCarta.findById(id)
        .map(m -> ResponseEntity.ok().body(m))
        .orElse(ResponseEntity.notFound().build());
    }

}
