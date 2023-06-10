package br.com.album.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // FINDBY EDICAO
    @GetMapping(path = "/edicao/{edicao}")
    public ResponseEntity<List<Carta>> findCartaByEdicao(@PathVariable String edicao) {
        return srvCarta.findByEdicao(edicao)
                .map(m -> ResponseEntity.ok().body(m))
                .orElse(ResponseEntity.notFound().build());
    }

    // FINDBY RARIDADE
    @GetMapping(path = "/raridade/{raridade}")
    public ResponseEntity<List<Carta>> findCartaByRaridade(@PathVariable String raridade) {
        return srvCarta.findByRaridade(raridade)
                .map(m -> ResponseEntity.ok().body(m))
                .orElse(ResponseEntity.notFound().build());
    }

    // FINDBY PRECO MENOR QUE
    @GetMapping(path = "/precomenor/{preco}")
    public ResponseEntity<List<Carta>> findCartaByPrecoMenorQue(@PathVariable Double preco) {
        return srvCarta.findByPrecoMenorQue(preco)
                .map(m -> ResponseEntity.ok().body(m))
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Carta> updateCarta(@PathVariable Long id, @RequestBody Carta carta) {
        return srvCarta.findById(id).map(m -> {
            m.setNome(carta.getNome());
            m.setEdicao(carta.getEdicao());
            m.setPreco(carta.getPreco());
            m.setRaridade(carta.getRaridade());

            Carta udtCarta = srvCarta.save(carta);

            return ResponseEntity.ok().body(udtCarta);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> deleteCarta(@PathVariable Long id) {
        return srvCarta.findById(id)
                .map(m -> {
                    srvCarta.deleteById(id);
                    return ResponseEntity.ok().body("DELETADO COM SUCESSO!");
                }).orElse(ResponseEntity.notFound().build());
    }

}
