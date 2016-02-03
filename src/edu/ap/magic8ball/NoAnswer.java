package edu.ap.magic8ball;

import edu.ap.magic8ball.State;

public class NoAnswer implements State {

    private Magic8ball magic8ball ;
	
    public NoAnswer(Magic8ball m) {
        magic8ball = m;
    }


	@Override
	public void roll() {
		System.out.println("");
		
	}
}
