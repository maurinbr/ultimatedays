package com.openclassroom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.openclassroom.beans.Coyote;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
    	/* Création et initialisation du message. */
    	String paramAuteur = request.getParameter( "auteur" );
    	String message = "Transmission de variables : OK ! " + paramAuteur;
    		
    	/* Création du bean et initialisation de ses propriétés */
    	Coyote premierBean = new Coyote();
    	premierBean.setNom( "Coyote" );
    	premierBean.setPrenom( "Wile E." );
    		
    	/* Création de la liste et insertion de quatre éléments */
    	List<Integer> premiereListe = new ArrayList<Integer>();
    	premiereListe.add( 27 );
    	premiereListe.add( 12 );
    	premiereListe.add( 138 );
    	premiereListe.add( 6 );
    		
    	/* Stockage du message, du bean et de la liste dans l'objet request */
    	request.setAttribute( "test", message );
    	request.setAttribute( "coyote", premierBean );
    	request.setAttribute( "liste", premiereListe );
    		
    	/* Transmission de la paire d'objets request/response à notre JSP */
    	this.getServletContext().getRequestDispatcher( "/WEB-INF/test.jsp" ).forward( request, response );
    }
}
