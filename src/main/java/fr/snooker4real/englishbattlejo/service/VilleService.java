package fr.snooker4real.englishbattlejo.service;

import fr.snooker4real.englishbattlejo.business.Ville;

import java.util.List;

public interface VilleService {
    Ville ajouterVille(String nom);

    List<Ville> recupererVilles();

    Ville recupererVille(Long id);

    boolean supprimerVille(Long id);
}
