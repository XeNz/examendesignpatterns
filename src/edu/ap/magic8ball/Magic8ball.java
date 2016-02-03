package edu.ap.magic8ball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Magic8ball {

	private State noAnswerState;
	private State positiveState;
	private State negativeState;
	private State neutralState;
	
	private State currentState;
	private ArrayList<Integer> lastResponses;
	
	//Singleton
	private static Magic8ball magic8ball = new Magic8ball();
	private Magic8ball(){
		noAnswerState = new NoAnswer(this);
		positiveState = new Positive(this);
		negativeState = new Negative(this);
		neutralState = new Neutral(this);
		currentState = noAnswerState;
		
		lastResponses = new ArrayList<Integer>();
	};
	
	public static Magic8ball getInstance( ) {
      return magic8ball;
	}
	
	private State pickCurrentState(){
		Random rnd = new Random();
		//fixed to include neutral :)
		int currentStateValue = rnd.nextInt(3);
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
	
	public void askOneQuestion(){
		System.out.println("Give me a question and I will answer");	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String question = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Magic8ball.getInstance().currentState = pickCurrentState();
		Magic8ball.getInstance().currentState.roll();
	}
	public void askQuestions(){
		Boolean again = true;
		while (again) {
			askOneQuestion();
			System.out.println(">Again Y or N?");	
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			try {
				String againOrNot = br2.readLine();
				if(againOrNot.equalsIgnoreCase("n")){
					again = false;
					System.out.println("No more questions for you mister!");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void addLastResponse(Integer choice){
		getLastResponses().add(choice);
	}

	public ArrayList<Integer> getLastResponses() {
		return lastResponses;
	}



	
	
}
