package fr.snooker4real.englishbattlejo.servlets;

import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.service.JoueurService;
import fr.snooker4real.englishbattlejo.service.PartieService;
import fr.snooker4real.englishbattlejo.service.VerbeService;
import fr.snooker4real.englishbattlejo.service.impl.JoueurServiceImpl;
import fr.snooker4real.englishbattlejo.service.impl.PartieServiceImpl;
import fr.snooker4real.englishbattlejo.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * The doPost method will handle this connexion into the form of index.jsp
 */
@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    private  static final Long serialVersionUID = 1L;

    private JoueurService joueurService = null;
    private PartieService partieService = null;
    private VerbeService verbeService = null;

    /**
     * Default constructor.
     */
    public ConnexionServlet() {
        joueurService = new JoueurServiceImpl();
        partieService = new PartieServiceImpl();
        verbeService = new VerbeServiceImpl();
        verbeService.importerVerbes();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (verbeService.recupererNbVerbes()==0){
            req.setAttribute("erreur", "il n'est pas possible de jouer, la base de verbes irréguliers est vide");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

        //On récupère les données saisies sur le formulaire de connexion
        String email = req.getParameter("Email");
        String motDePasse = req.getParameter("MOT_DE_PASSE");

        //On essaie de récuérer un joueur avec ces données
        Joueur joueur = joueurService.recupererJoueurParEmailEtMotDePasse(email, motDePasse);

        if (joueur != null){
            // Le joueur a saisie le bon email + mdp = Le joueur existe
            joueur.setEstEnLigne(true);
            System.out.println("Connexion de (nom) : " + joueur.getNom());
            System.out.println("Connexion de (prenom) : " + joueur.getPrenom());
            joueurService.mettreAJourJoueur(joueur.getId(), joueur.getEmail(), joueur.getNom(), joueur.getPrenom(), joueur.getMotDePasse(), joueur.getVille(), joueur.getNiveau(), true);
            // Ajout d'une partie et mise en session de cette partie
            req.getSession().setAttribute("partie", partieService.ajouterPartie(joueur));
            // On redirige vers l'url qui est prise en charge par la servlet QuestionServlet = Début de jeu
            resp.sendRedirect("jeu");
        } else {
            req.setAttribute("erreur","email et/ou mot de passe incorrect");
            req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
        }
    }
}
