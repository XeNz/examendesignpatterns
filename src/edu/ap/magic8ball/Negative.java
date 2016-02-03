package edu.ap.magic8ball;

import java.util.Random;

public class Negative implements State{

	private Magic8ball magic8ball;
	public Negative(Magic8ball m) {
		this.magic8ball = m;
	}
	
	@Override
	public void roll() {
		Random r = new Random();
		//wtf @ in java random getal in een range krijgen
		int range = 20 - 16 + 1;
		int choice = r.nextInt(range)+16;
		String response = "";
		
		switch (choice) {
		case 16:
			response = "Don't count on it";
			break;
		case 17:
			response = "My reply is no";
			break;
		case 18:
			response = "My sources say no";
			break;
		case 19:
			response = "Outlook not so good";
			break;
		case 20:
			response = "Very doubtful";
			break;
		default:
			response = "";
			break;
		}
		//check of response al in lijst zit
		if(!magic8ball.getInstance().getLastResponses().contains(choice))
		{
			if(magic8ball.getInstance().getLastResponses().size() == 10){
				magic8ball.getInstance().getLastResponses().remove(0);
			}
			magic8ball.getInstance().addLastResponse(choice);
			System.out.println(response);
		}
		else
		{
			roll();
		}
	}

}
