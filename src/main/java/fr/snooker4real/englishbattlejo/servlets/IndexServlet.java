package fr.snooker4real.englishbattlejo.servlets;

import fr.snooker4real.englishbattlejo.business.Joueur;
import fr.snooker4real.englishbattlejo.service.JoueurService;
import fr.snooker4real.englishbattlejo.service.VerbeService;
import fr.snooker4real.englishbattlejo.service.impl.JoueurServiceImpl;
import fr.snooker4real.englishbattlejo.service.impl.VerbeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Servlt implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private JoueurService joueurService = null;
    private VerbeService verbeService = null;

    /**
     * Default constructor.
     */
    public IndexServlet(){
        joueurService = new JoueurServiceImpl();
        verbeService = new VerbeServiceImpl();
        verbeService.importerVerbes();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("nbVerbes", verbeService.recupererNbVerbes());
        // Récupère tous les joueurs et les envoie à la JSP
        List<Joueur> joueurs = joueurService.recupererJoueursDuHallOfFame();
        req.setAttribute("joueurs", joueurs);
        req.getRequestDispatcher("WEB-INF/index;jsp").include(req, resp);
    }
}
