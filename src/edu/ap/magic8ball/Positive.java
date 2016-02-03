package edu.ap.magic8ball;

import java.util.Random;

public class Positive implements State{

	private Magic8ball magic8ball;
	public Positive(Magic8ball m) {
		this.magic8ball = m;
	}
	
	@Override
	public void roll() {
		Random r = new Random();

		int choice = r.nextInt(10 - 1 + 1) + 1;
		String response = "";
		
		switch (choice) {
		case 1:
			response = "It is certain";
			break;
		case 2:
			response = "It is decidedly so";
			break;
		case 3:
			response = "Without a doubt";
			break;
		case 4:
			response = "Yes, definitely";
			break;
		case 5:
			response = "You may rely on it";
			break;
		case 6:
			response = "As I see it, yes";
			break;
		case 7:
			response = "Outlook good";
			break;
		case 8:
			response = "Most likely";
			break;
		case 9:
			response = "Yes";
			break;
		case 10:
			response = "Signs point to yes";
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
