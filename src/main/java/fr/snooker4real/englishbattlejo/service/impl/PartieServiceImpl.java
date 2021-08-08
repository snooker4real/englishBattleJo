package fr.snooker4real.englishbattlejo.service.impl;

import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.business.Question;
import fr.snooker4real.englishbattlejo.business.Verbe;
import fr.snooker4real.englishbattlejo.dao.PartieDao;
import fr.snooker4real.englishbattlejo.dao.impl.PartieDaoImpl;
import fr.snooker4real.englishbattlejo.service.PartieService;

import java.sql.SQLException;
import java.util.List;

public class PartieServiceImpl implements PartieService {

    private PartieDao partieDao = new PartieDaoImpl();

    @Override
    public Partie ajouterPartie(Joueur joueur) {
        try {
            return partieDao.create(new Partie(joueur));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Partie recupererPartie(Long id) {
        Partie partie = null;
        try {
            partie = partieDao.findOne(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partie;
    }

    @Override
    public List<Partie> recupererParties() {
        try {
            return partieDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean estPresent(Partie partie, Verbe verbe) {

        for (Question question : partie.getQuestions()) {
            if (question.getVerbe().getBaseVerbale().equals(verbe.getBaseVerbale())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean supprimerPartie(Long id) {
        try {
            return partieDao.delete(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

}
