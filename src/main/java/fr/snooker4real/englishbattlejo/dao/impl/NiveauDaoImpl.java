package fr.snooker4real.englishbattlejo.dao.impl;


import fr.snooker4real.englishbattlejo.business.Niveau;
import fr.snooker4real.englishbattlejo.dao.ConnexionBdd;
import fr.snooker4real.englishbattlejo.dao.NiveauDao;
import fr.snooker4real.englishbattlejo.dao.Requetes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NiveauDaoImpl implements NiveauDao {

    private static Connection connection;

    public NiveauDaoImpl() {
        try {
            connection = ConnexionBdd.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Niveau create(Niveau niveau) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_NIVEAU, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, niveau.getNom());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            niveau.setId(rs.getLong(1));
        }
        return niveau;
    }

    @Override
    public List<Niveau> findAll() throws SQLException {
        List<Niveau> niveaux = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(Requetes.TOUS_LES_NIVEAUX);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Niveau niveau = new Niveau(rs.getString("nom"));
            niveau.setId(rs.getLong("id"));
            niveaux.add(niveau);
        }
        return niveaux;
    }

    @Override
    public Niveau findOne(Long id) throws SQLException {
        Niveau niveau = null;
        PreparedStatement ps = connection.prepareStatement(Requetes.NIVEAU_PAR_ID);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            niveau = new Niveau(rs.getString("nom"));
            niveau.setId(rs.getLong("id"));
        }
        return niveau;
    }

}
