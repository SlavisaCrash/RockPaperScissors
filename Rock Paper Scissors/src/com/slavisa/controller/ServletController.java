package com.slavisa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slavisa.model.RockPaperScissors;


/**
 * Servlet implementation class ServletController
 */
@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RockPaperScissors game;
	private String message;
	private int userRoundScore = 0;
	private int cpuRoundScore = 0;;
	private int userGameScore = 0;
	private int cpuGameScore = 0;
	private String userSymbol;
	private String cpuSymbol;
	private String result;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletController() {
       
		game = new RockPaperScissors();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		if(request.getParameter("symbol") != null){
			   			  
			   //user played	
			   game.setUserSymbol(request.getParameter("symbol"));
			   //cpu played
			   game.playComputer();
			   
			   userSymbol = game.getUserSymbol();
			   cpuSymbol = game.getComputerSymbol();
			   result = game.play();
			   
			   switch(result){
			   		case "tie":
			   			message = "Tie";
			   			break;
			   		case "you won":
			   			message = "You Won";
			   			userRoundScore++;
			   			if(userRoundScore == 2)
			   				userGameScore++;
			   			break;
			   		case "you lose":
			   			message = "You Lose";
			   			cpuRoundScore++;
			   			if(cpuRoundScore == 2)
			   				cpuGameScore++;
			   			break;
			   }
			  
		}		
		request.setAttribute("message", message);
		request.setAttribute("userSymbol", userSymbol);
		request.setAttribute("cpuSymbol", cpuSymbol);
		request.setAttribute("userRoundScore", userRoundScore);
		request.setAttribute("cpuRoundScore", cpuRoundScore);
		request.setAttribute("userGameScore", userGameScore);
		request.setAttribute("cpuGameScore", cpuGameScore);
		
		if(userRoundScore == 2){
			userRoundScore = 0;
			cpuRoundScore = 0;
		}else if(cpuRoundScore == 2){
			cpuRoundScore = 0;
			userRoundScore = 0;
		}
			  		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/game.jsp");
		rd.forward(request, response);		
	}
			
}
