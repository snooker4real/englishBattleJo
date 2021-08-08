package fr.snooker4real.englishbattlejo.dao;

import fr.snooker4real.englishbattlejo.business.Verbe;

import java.sql.SQLException;
import java.util.List;

public interface VerbeDao {
    Verbe create(Verbe verbe) throws SQLException;
    List<Verbe> findAll() throws SQLException;
    Verbe findOne(Long id) throws SQLException;
    Verbe findAleatoire() throws SQLException;
    Verbe update(Verbe verbe) throws SQLException;
    boolean delete(Long id) throws SQLException;
    int count() throws SQLException;
}
