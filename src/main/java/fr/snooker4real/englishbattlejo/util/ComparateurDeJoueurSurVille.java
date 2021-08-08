package fr.snooker4real.englishbattlejo.util;

import fr.snooker4real.englishbattlejo.business.Joueur;

import java.util.Comparator;

public class ComparateurDeJoueurSurVille implements Comparator<Joueur> {
    @Override
    public int compare(Joueur joueur1, Joueur joueur2) {
        return joueur1.getVille().getNom().compareTo(joueur2.getVille().getNom());
    }
}
