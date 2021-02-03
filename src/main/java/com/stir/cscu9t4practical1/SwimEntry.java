package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry {

	private String type;

	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String type) {
		super(n, d, m, y, h, min, s, dist);
		this.type = type;
	}


	public String getType() {
		return this.type;
	}

	public String getEntry() {
		String result = getName() + " swam " + getDistance() + " m " + getType() + " in " + getHour()
				+ ":" + getMin() + ":" + getSec() + " on " + getDay() + "/" + getMonth() + "/" + getYear() + "\n";

		return result;
	}

}
