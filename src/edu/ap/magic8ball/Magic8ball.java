package edu.ap.magic8ball;

import java.util.Random;

public class Magic8ball {

	private State noAnswerState;
	private State positiveState;
	private State negativeState;
	private State neutralState;
	
	private State currentState;
	private int lastResponse;
	
	//Singleton
	private static Magic8ball magic8ball = new Magic8ball();
	private Magic8ball(){
		noAnswerState = new NoAnswer(this);
		positiveState = new Positive(this);
		negativeState = new Negative(this);
		neutralState = new Neutral(this);
		currentState = noAnswerState;
	};
	
	public static Magic8ball getInstance( ) {
      return magic8ball;
	}
	
	private State pickCurrentState(){
		Random rnd = new Random();
		int currentStateValue = rnd.nextInt(2);
		switch (currentStateValue) {
		case 0:
			return Magic8ball.getInstance().positiveState;
		case 1:
			return Magic8ball.getInstance().negativeState;
		case 2:
			return Magic8ball.getInstance().neutralState;
		default:
			return Magic8ball.getInstance().currentState;
		}
	}


	public int getLastResponse() {
		return lastResponse;
	}

	public void setLastResponse(int lastResponse) {
		this.lastResponse = lastResponse;
	}
	
	
}
