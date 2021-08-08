package fr.snooker4real.englishbattlejo.service;

import fr.snooker4real.englishbattlejo.business.Niveau;

import java.util.List;

public interface NiveauService {

    Niveau ajouterNiveau(String nom);

    Niveau recupererNiveau(Long id);

    List<Niveau> recupererNiveaux();
}
