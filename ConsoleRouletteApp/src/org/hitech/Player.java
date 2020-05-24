package org.hitech;

public class Player {

	private String name;
	
	private double betAmount;
	
	private String betNumber;
	
	private double winAmount;
	
	private String result;

	public double getWinAmount() {
		return winAmount;
	}

	public void setWinAmount(double winAmount) {
		this.winAmount = winAmount;
	}

	public String getBetNumber() {
		return betNumber;
	}

	public void setBetNumber(String betNumber) {
		this.betNumber = betNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", betAmount=" + betAmount + ", betNumber=" + betNumber + ", winAmount="
				+ winAmount + ", result=" + result + "]";
	}
	
}
