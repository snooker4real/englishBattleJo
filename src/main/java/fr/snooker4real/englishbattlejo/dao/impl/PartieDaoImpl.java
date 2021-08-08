package fr.snooker4real.englishbattlejo.dao.impl;


import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.dao.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PartieDaoImpl implements PartieDao {

    private static Connection connexion;
    private JoueurDao joueurDao;

    // Connexion à la BDD
    public PartieDaoImpl() {
        try {
            connexion = ConnexionBdd.getConnection();
            joueurDao = new JoueurDaoImpl();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    // Création d'une partie
    public Partie create(Partie partie) throws SQLException {
        PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_PARTIE, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, partie.getJoueur().getId());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        partie.setId(rs.getLong(1));
        return partie;
    }

    @Override
    // Recupération d'une partie unique en fonction de son ID
    public Partie findOne(Long id) throws SQLException {
        PreparedStatement ps = connexion.prepareStatement(Requetes.PARTIE_PAR_ID);

        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Partie partie = new Partie(joueurDao.findOne(rs.getLong("joueur_id")));
            partie.setId(rs.getLong("id"));
            return partie;
        }
        return null;
    }

    @Override
    public List<Partie> findByJoueur(Joueur joueur) throws SQLException {
        List<Partie> parties = new ArrayList<>();

        PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_PARTIES_DU_JOUEUR);
        ps.setLong(1, joueur.getId());
        ResultSet rs = ps.executeQuery();
        QuestionDao questionDao = new QuestionDaoImpl();
        while (rs.next()) {
            Partie partie = new Partie(joueur);
            partie.setId(rs.getLong("id"));
            partie.setQuestions(questionDao.findByPartie(partie));
            parties.add(partie);
        }
        return parties;
    }

    @Override
    public List<Partie> findAll() throws SQLException {
        List<Partie> parties = new ArrayList<>();

        PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_PARTIES);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Partie partie = new Partie(joueurDao.findOne(rs.getLong("joueur_id")));
            partie.setId(rs.getLong("id"));
            parties.add(partie);
        }
        return parties;
    }

    @Override
    public boolean update(Long id, Joueur joueur) throws SQLException {
        Partie partie = findOne(id);
        if (partie == null) {
            return false;
        }
        PreparedStatement ps = connexion.prepareStatement(Requetes.UPDATE_PARTIE);
        ps.setLong(2, id);
        ps.executeUpdate();

        return true;
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        Partie partie = findOne(id);
        if (partie == null) {
            return false;
        }
        PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_PARTIE);
        ps.setLong(1, id);
        ps.executeUpdate();
        return true;
    }

}