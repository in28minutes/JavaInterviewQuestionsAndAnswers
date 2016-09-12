package com.in28minutes.java.oops.encapsulation;

class CricketScorer {
	private int score = 0;

	public int getScore() {
		return score;
	}

	public void addRuns(int score) {
		this.score = this.score + score;
	}

	public void six() {
		addRuns(6);
	}

	public void four() {
		addRuns(4);
	}

	public void single() {
		addRuns(1);
	}

	public void printScore() {
		System.out.println("Score : " + score);
	}

}

public class EncapsulationExample {
	public static void main(String[] args) {
		CricketScorer scorer = new CricketScorer();
		scorer.four();
		scorer.four();
		scorer.single();
		scorer.six();
		scorer.six();
		scorer.six();
		scorer.printScore();
	}
}