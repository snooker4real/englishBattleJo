package fr.snooker4real.englishbattlejo.util;

import fr.snooker4real.englishbattlejo.business.Joueur;

import java.util.Comparator;

public class ComparateurDeJoueurSurScore implements Comparator<Joueur> {
    @Override
    public int compare(Joueur j1, Joueur j2) {
        if (j1.getMeilleurScore()==j2.getMeilleurScore()) { return 0; }
        else if (j1.getMeilleurScore()>j2.getMeilleurScore()) {return -1;}
        else return 1;
    }

}
