package fr.snooker4real.englishbattlejo.service;

import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.business.Question;
import fr.snooker4real.englishbattlejo.business.Verbe;

import java.util.List;

public interface QuestionService {
    Question ajouterQuestion(Partie partie, Verbe verbe);

    List<Question> recupererQuestions();

    Question recupererQuestion(Long id);

    boolean supprimerQuestion(Long id);

    /**
     *
     * @param id
     * @param String reponsePreterit
     * @param String reponseParticipePasse
     * @return la question mise à jour
     */
    Question mettreAJourQuestion(Long id, String reponsePreterit, String reponseParticipePasse);


    /**
     *
     * @param question: un question comprenant un verbe et les réponse prétérit et participe
     * @return true si le prétérit et le participe correspondent au verbe
     */
    boolean verifierReponse(Question question);
}
