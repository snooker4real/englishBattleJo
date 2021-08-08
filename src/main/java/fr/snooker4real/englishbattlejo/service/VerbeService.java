package fr.snooker4real.englishbattlejo.service;

import fr.snooker4real.englishbattlejo.business.Partie;
import fr.snooker4real.englishbattlejo.business.Verbe;
import fr.snooker4real.englishbattlejo.exceptions.AucunVerbeException;

import java.util.List;

public interface VerbeService {
    Verbe ajouterVerbe(String baseVerbale, String preterit, String participePasse, String traduction);
    Verbe ajouterVerbe(Verbe verbe);
    List<Verbe> recupererVerbes();
    Verbe recupererVerbe(Long id);
    Verbe recupererVerbeAleatoire();
    Verbe recupererVerbeAleatoire(Partie partie) throws AucunVerbeException;
    Verbe modifierVerbe(Long idVerbe, String baseVerbale, String preterit, String participePasse, String traduction);
    boolean supprimerVerbe(Long id);
    boolean importerVerbes();
    int recupererNbVerbes();
}
