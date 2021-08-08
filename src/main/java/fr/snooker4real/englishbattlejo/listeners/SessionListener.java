package fr.snooker4real.englishbattlejo.listeners;

import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.service.JoueurService;
import fr.snooker4real.englishbattlejo.service.impl.JoueurServiceImpl;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.Date;

public class SessionListener implements HttpSessionListener {
    private JoueurService joueurService = new JoueurServiceImpl();

    @Override
    public void sessionCreated(HttpSessionEvent evenement) {
    }

    /**
     * Patron Observateur/Observé
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent evenement) {
        System.out.println(new Date() + " : dans sessionDestroyed");
        Partie partie = (Partie) evenement.getSession().getAttribute("partie");
        if (partie != null) {
            Joueur joueur = partie.getJoueur();
            joueur.setEstEnLigne(false);
            joueurService.mettreAJourJoueur(joueur.getId(), joueur.getEmail(), joueur.getNom(), joueur.getPrenom(), joueur.getMotDePasse(), joueur.getVille(), joueur.getNiveau(), false);
            System.out.println("Déconnexion de " + partie.getJoueur().getPrenom());
        }
    }
}
