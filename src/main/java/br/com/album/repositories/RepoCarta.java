package br.com.album.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.album.models.Carta;

public interface RepoCarta  extends JpaRepository<Carta, Long> {
    
}
