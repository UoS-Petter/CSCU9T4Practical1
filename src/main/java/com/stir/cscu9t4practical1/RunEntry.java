package com.stir.cscu9t4practical1;

public class RunEntry extends Entry {

	private int laps;

	public RunEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int laps) {
		super(n, d, m, y, h, min, s, dist);
		this.laps = laps;
	}

	public int getLaps() {
		return this.laps;
	}

	public String getEntry() {

		String result = getName() + " ran " + getLaps() + "x " + getDistance() + " km in " + getHour() + ":" + getMin()
				+ ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";

		return result;
	}

}
