package br.com.album.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.album.models.Carta;
import br.com.album.repositories.RepoCarta;

@Service
public class SrvCarta {

    final RepoCarta repoCarta;

    public SrvCarta(RepoCarta repoCarta) {
        this.repoCarta = repoCarta;
    }

    @Transactional
    public Carta save(Carta carta) {
        return repoCarta.save(carta);
    }

    public List<Carta> findAll() {
        return repoCarta.findAll();
    }

    public Optional<Carta> findById(Long id) {
        return repoCarta.findById(id);
    }

}
