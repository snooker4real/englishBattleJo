package fr.snooker4real.englishbattlejo.dao;

import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.business.Question;

import java.sql.SQLException;
import java.util.List;

public interface QuestionDao {
    Question create(Question question) throws SQLException;
    List<Question> findAll() throws SQLException;
    Question findOne(Long id) throws SQLException;
    List<Question> findByPartie(Partie partie)  throws SQLException;

    /**
     *
     * @param id l'ID de la question à modifier
     * @param nouvelleQuestion: un objet Question avec les parametre de la nouvelle question
     * @return renvoie la nouvelle question avec son ID si l'ID est disponible dans la base. Retourne null si l'id nest pas disponible dans la base.
     * @throws SQLException
     */
    Question update(Long id, Question nouvelleQuestion) throws SQLException;

    boolean delete(Long id) throws SQLException;
}
