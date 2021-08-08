package fr.snooker4real.englishbattlejo.service.impl;

import fr.snooker4real.englishbattlejo.business.Niveau;
import fr.snooker4real.englishbattlejo.dao.NiveauDao;
import fr.snooker4real.englishbattlejo.dao.impl.NiveauDaoImpl;
import fr.snooker4real.englishbattlejo.service.NiveauService;

import java.sql.SQLException;
import java.util.List;

public class NiveauServiceImpl implements NiveauService {
    private NiveauDao niveauDao = new NiveauDaoImpl();

    @Override
    public Niveau ajouterNiveau(String nom) {
        Niveau niveau = new Niveau(nom);
        try {
            niveauDao.create(niveau);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return niveau;
    }

    @Override
    public Niveau recupererNiveau(Long id) {
        try {
            return niveauDao.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Niveau> recupererNiveaux() {
        try {
            return niveauDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
