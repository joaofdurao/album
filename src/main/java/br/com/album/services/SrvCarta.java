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

    // CREATE
    @Transactional
    public Carta save(Carta carta) {
        return repoCarta.save(carta);
    }

    // LIST
    public List<Carta> findAll() {
        return repoCarta.findAll();
    }

    // FINDBY ID
    public Optional<Carta> findById(Long id) {
        return repoCarta.findById(id);
    }

    // FINDBY EDICAO
    public Optional<List<Carta>> findByEdicao(String edicao) {
        return repoCarta.findByEdicao(edicao);
    }

    // FINDBY RARIDADE
    public Optional<List<Carta>> findByRaridade(String raridade) {
        return repoCarta.findByRaridade(raridade);
    }

    // FINDBY PRECO MENOR QUE
    public Optional<List<Carta>> findByPrecoMenorQue(Double preco) {
        return repoCarta.findByPrecoMenorQue(preco);
    }

    // DELETE
    @Transactional
    public void deleteById(Long id) {
        repoCarta.deleteById(id);
    }

}
