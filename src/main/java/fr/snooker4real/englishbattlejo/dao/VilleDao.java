package fr.snooker4real.englishbattlejo.dao;

import fr.snooker4real.englishbattlejo.business.Ville;

import java.sql.SQLException;
import java.util.List;

public interface VilleDao {
    Ville create(Ville ville) throws SQLException;

    List<Ville> findAll() throws SQLException;
    Ville findOne(Long id) throws SQLException;

    boolean delete(Long id) throws SQLException;
}
