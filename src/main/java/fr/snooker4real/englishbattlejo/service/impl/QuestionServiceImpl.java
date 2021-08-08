package fr.snooker4real.englishbattlejo.service.impl;

import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.business.Question;
import fr.snooker4real.englishbattlejo.business.Verbe;
import fr.snooker4real.englishbattlejo.dao.QuestionDao;
import fr.snooker4real.englishbattlejo.dao.impl.QuestionDaoImpl;
import fr.snooker4real.englishbattlejo.service.QuestionService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao = new QuestionDaoImpl();

    @Override
    public Question ajouterQuestion(Partie partie, Verbe verbe) {
        Question question = new Question(partie, verbe);
        try {
            questionDao.create(question);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return question;
    }

    @Override
    public List<Question> recupererQuestions() {
        try {
            return questionDao.findAll();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public Question recupererQuestion(Long id) {
        try {
            return questionDao.findOne(id);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean supprimerQuestion(Long id) {
        try {
            return questionDao.delete(id);
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Question mettreAJourQuestion(Long id, String reponsePreterit, String reponseParticipePasse) {
        try {
            Question question = questionDao.findOne(id);
            if (question==null) {
                return null;
            }
            question.setReponsePreterit(reponsePreterit);
            question.setReponseParticipePasse(reponseParticipePasse);
            question.setDateReponse(new Date());
            question = questionDao.update(id, question);
            return question;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public boolean verifierReponse(Question question) {
        if(!question.getVerbe().getPreterit().equalsIgnoreCase(question.getReponsePreterit())) {
            return false;
        }
        if(!question.getVerbe().getParticipePasse().equalsIgnoreCase(question.getReponseParticipePasse())) {
            return false;
        }
        return true;
    }

}
