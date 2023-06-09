package br.com.album.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.album.models.Carta;

public interface RepoCarta extends JpaRepository<Carta, Long> {

    // FINDBY EDICAO
    Optional<List<Carta>> findByEdicao(String edicao);

    // FINDBY RARIDADE
    Optional<List<Carta>> findByRaridade(String raridade);

    // FINDBY PRECO MENOR QUE
    @Query("SELECT c FROM Carta c WHERE c.preco < :preco")
    Optional<List<Carta>> findByPrecoMenorQue(Double preco);

    // FINDBY PRECO MAIOR QUE
    @Query("SELECT c FROM Carta c WHERE c.preco > :preco")
    Optional<List<Carta>> findByPrecoMaiorQue(Double preco);

    // FINDBY PRECO ENTRE
    @Query("SELECT c FROM Carta c WHERE c.preco BETWEEN :precoMin AND :precoMax")
    Optional<List<Carta>> findByPrecoEntre(Double precoMin, Double precoMax);

}
