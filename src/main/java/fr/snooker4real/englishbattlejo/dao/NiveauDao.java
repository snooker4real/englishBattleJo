package fr.snooker4real.englishbattlejo.dao;

import fr.snooker4real.englishbattlejo.business.Niveau;

import java.sql.SQLException;
import java.util.List;

public interface NiveauDao {
    Niveau create(Niveau niveau) throws SQLException;
    List<Niveau> findAll() throws SQLException;
    Niveau findOne(Long id) throws SQLException;
}
