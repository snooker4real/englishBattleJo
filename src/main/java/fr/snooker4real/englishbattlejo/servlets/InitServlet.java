package fr.snooker4real.englishbattlejo.servlets;

import fr.snooker4real.englishbattlejo.service.NiveauService;
import fr.snooker4real.englishbattlejo.service.VerbeService;
import fr.snooker4real.englishbattlejo.service.VilleService;
import fr.snooker4real.englishbattlejo.service.impl.NiveauServiceImpl;
import fr.snooker4real.englishbattlejo.service.impl.VerbeServiceImpl;
import fr.snooker4real.englishbattlejo.service.impl.VilleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.util.Date;

@WebServlet(urlPatterns = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    /**
     *
     */
    private static  final long serialVersionUID = 1L;
    private VerbeService verbeService = new VerbeServiceImpl();
    private NiveauService niveauService = new NiveauServiceImpl();
    private VilleService villeService = new VilleServiceImpl();

    public InitServlet() {
        System.out.println(new Date() + " constructeur InitServlet");
    }

    public void init() throws ServletException {
        verbeService.importerVerbes();
        if(villeService.recupererVilles().isEmpty()){
            villeService.ajouterVille("Lyon");
            villeService.ajouterVille("Paris");
            villeService.ajouterVille("Lille");
        }

        if (niveauService.recupererNiveaux().isEmpty()){
            niveauService.ajouterNiveau("Débutant");
            niveauService.ajouterNiveau("Intermédiaire");
            niveauService.ajouterNiveau("Expert");
        }
    }
}
