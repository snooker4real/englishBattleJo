package fr.snooker4real.englishbattlejo.dao;

import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.business.Partie;

import java.sql.SQLException;
import java.util.List;

public interface PartieDao {
    Partie create(Partie partie) throws SQLException;

    Partie findOne(Long id) throws SQLException;

    List<Partie> findByJoueur(Joueur joueur) throws SQLException;

    List<Partie> findAll() throws SQLException;

    boolean delete(Long id) throws SQLException;

    boolean update(Long id, Joueur joueur) throws SQLException;
}
