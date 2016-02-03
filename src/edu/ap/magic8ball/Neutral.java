package edu.ap.magic8ball;

import java.util.Random;

public class Neutral implements State{

	private Magic8ball magic8ball;
	public Neutral(Magic8ball m) {
		this.magic8ball = m;
	}
	
	@Override
	public void roll() {
		Random r = new Random();
		//wtf @ in java random getal in een range krijgen
		int range = 15 - 11 + 1;
		int choice = r.nextInt(range)+11;
		String response = "";
		
		switch (choice) {
		case 11:
			response = "Reply hazy try again";
			break;
		case 12:
			response = "Ask again later";
			break;
		case 13:
			response = "Better not tell you now";
			break;
		case 14:
			response = "Cannot predict now";
			break;
		case 25:
			response = "Concentrate and ask again";
			break;
		default:
			response = "";
			break;
		}
		//check of response al in lijst zit
		if(!magic8ball.getInstance().getLastResponses().contains(choice))
		{
			magic8ball.getInstance().addLastResponse(choice);
			System.out.println(response);
		}
		else
		{
			roll();
		}
	}

}
