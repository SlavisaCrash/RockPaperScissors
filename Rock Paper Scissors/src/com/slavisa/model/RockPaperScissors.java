package com.slavisa.model;

import java.util.Random;

public class RockPaperScissors {

	private String userSymbol;
	private String computerSymbol;
	private String result;
	private Random random;
	private String[] symbol = {"rock","paper","scissors"};
	
	public String getUserSymbol() {
		return userSymbol;
	}

	public void setUserSymbol(String userSymbol) {
		this.userSymbol = userSymbol;
	}
	
	public String getComputerSymbol() {
		return computerSymbol;
	}

	public void setComputerSymbol(String computerSysmbol) {
		this.computerSymbol = computerSysmbol;
	}
	
	public void playComputer(){
		random = new Random();
		int index = random.nextInt(3);
		setComputerSymbol(symbol[index]);
	}


	public String play(){
				
		if(getComputerSymbol().equals("rock")){
			if(getUserSymbol().equals("rock")){
				result = "tie";
			}else if(getUserSymbol().equals("paper")){
				result = "you won";
			}else if(getUserSymbol().equals("scissors")){
				result  = "you lose";
			}
		}else if(getComputerSymbol().equals("paper")){
			if(getUserSymbol().equals("rock")){
				result  = "you lose";
			}else if(getUserSymbol().equals("paper")){
				result  = "tie";
			}else if(getUserSymbol().equals("scissors")){
				result  = "you won";
			}
		}else if(getComputerSymbol().equals("scissors")){
			if(getUserSymbol() == "rock"){
				result  = "you won";
			}else if(getUserSymbol().equals("paper")){
				result  = "you lose";
			}else if(getUserSymbol().equals("scissors")){
				result = "tie";
			}
		}
		return result;
	}

	
	
	


	
	
	
	
	
}
