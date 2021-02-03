package com.stir.cscu9t4practical1;

public class SprintEntry extends RunEntry {

	private int recovery;

	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int laps, int recovery) {
		super(n, d, m, y, h, min, s, dist, laps);
		this.recovery = recovery;

	}

	public int getRecoveryTime() {
		return this.recovery;
	}

	public String getEntry() {

		String result = getName() + " sprinted " + getLaps() + "x " + getDistance() + " m in " + getHour() + ":"
				+ getMin() + ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear()
				+ ". Recovery time: " + getRecoveryTime() + "m\n";

		return result;
	}

}
