package fr.snooker4real.englishbattlejo.dao;

import fr.snooker4real.englishbattlejo.business.Joueur;

import java.sql.SQLException;
import java.util.List;

public interface JoueurDao {
    Joueur create(Joueur joueur) throws SQLException;
    Joueur findOne(Long id) throws SQLException;
    List<Joueur> findAll() throws SQLException;
    boolean delete(Long id) throws SQLException;
    boolean update(Long id, Joueur joueur) throws SQLException;
}
