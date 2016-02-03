package edu.ap.magic8ball;

import edu.ap.magic8ball.State;

public class NoAnswer implements State {

    private Magic8ball magic8ball ;
	
    public NoAnswer(Magic8ball m) {
        magic8ball = m;
    }



//    public void work() {
//        System.out.println("Normal State");
//        patient.lowerProzacLevel();
//        if(patient.getProzacLevel() < 10) {
//            patient.setState(patient.getDepression());
//        }
//        if(patient.getProzacLevel() >= 15) {
//            patient.setState(patient.getManic());
//        }
//    }



	@Override
	public void roll() {
		System.out.println("");
		
	}
}
