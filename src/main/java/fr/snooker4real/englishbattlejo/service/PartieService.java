package fr.snooker4real.englishbattlejo.service;

import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.business.Verbe;

import java.util.List;

public interface PartieService {
    Partie ajouterPartie(Joueur joueur);

    Partie recupererPartie(Long id);

    List<Partie> recupererParties();

    public boolean estPresent(Partie partie, Verbe verbe);

    public boolean supprimerPartie(Long id);
}
