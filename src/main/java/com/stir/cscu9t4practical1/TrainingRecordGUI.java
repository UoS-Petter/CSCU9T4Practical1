// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

	private JTextField name = new JTextField(27);
	private JTextField day = new JTextField(2);
	private JTextField month = new JTextField(2);
	private JTextField year = new JTextField(4);
	private JTextField hours = new JTextField(2);
	private JTextField mins = new JTextField(2);
	private JTextField secs = new JTextField(2);
	private JTextField dist = new JTextField(4);
//	private JTextField type = new JTextField(4);
	private JTextField laps = new JTextField(4);
	private JTextField pause = new JTextField(4);
	private JTextField terrain = new JTextField(4);
	private JTextField tempo = new JTextField(4);
	private JTextField swimtype = new JTextField(7);

	private JLabel labn = new JLabel(" Name:");
	private JLabel labd = new JLabel(" Day:");
	private JLabel labm = new JLabel(" Month:");
	private JLabel laby = new JLabel(" Year:");
	private JLabel labh = new JLabel(" Hours:");
	private JLabel labmm = new JLabel(" Mins:");
	private JLabel labs = new JLabel(" Secs:");
	private JLabel labdist = new JLabel(" Distance (km):");
	private JLabel typelabel = new JLabel(" Type:");
	private JLabel lapslabel = new JLabel(" Laps:");
	private JLabel pauselabel = new JLabel(" Recovery (min):");
	private JLabel terrainlabel = new JLabel(" Terrain:");
	private JLabel tempolabel = new JLabel(" Tempo:");
	private JLabel swimtypelabel = new JLabel(" Swim Type:");

	private JButton addR = new JButton("Add");
	private JButton lookupbydate = new JButton("Look Up");
	private JButton findallbydate = new JButton("Look Up All");
	private JButton removebutton = new JButton("Remove Entry");

	final String RUNNING = "Run";
	final String SPRINTING = "Sprint";
	final String SWIMMING = "Swim";
	final String CYCLING = "Cycle";

	String[] sports = { RUNNING, SPRINTING, SWIMMING, CYCLING };
	private JComboBox<String> typeList = new JComboBox<String>(sports);

	private TrainingRecord myAthletes = new TrainingRecord();

	private JTextArea outputArea = new JTextArea(5, 65);
	JScrollPane scrollArea = new JScrollPane (outputArea);

	public static void main(String[] args) {
		TrainingRecordGUI applic = new TrainingRecordGUI();
	} // main

	// set up the GUI
	public TrainingRecordGUI() {
		super("Training Record");
		setLayout(new FlowLayout());
		add(labn);
		add(name);
		name.setEditable(true);

		// add(typelabel);
		// add(type);
		// type.setEditable(true);

		add(typelabel);
		add(typeList);
		typeList.addActionListener(this);
		// type.setEditable(true);

		add(labd);
		add(day);
		day.setEditable(true);
		add(labm);
		add(month);
		month.setEditable(true);
		add(laby);
		add(year);
		year.setEditable(true);
		add(labh);
		add(hours);
		hours.setEditable(true);
		add(labmm);
		add(mins);
		mins.setEditable(true);
		add(labs);
		add(secs);
		secs.setEditable(true);
		add(labdist);
		add(dist);
		dist.setEditable(true);

		add(lapslabel);
		add(laps);
		laps.setEditable(true);

		add(pauselabel);
		add(pause);
		pauselabel.setVisible(false);
		pause.setVisible(false);

		add(terrainlabel);
		add(terrain);
		terrainlabel.setVisible(false);
		terrain.setVisible(false);

		add(tempolabel);
		add(tempo);
		tempolabel.setVisible(false);
		tempo.setVisible(false);

		add(swimtypelabel);
		add(swimtype);
		swimtypelabel.setVisible(false);
		swimtype.setVisible(false);

		//add(outputArea);
		outputArea.setEditable(false);
		add(scrollArea);
		//scrollArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		add(addR);
		addR.addActionListener(this);
		add(lookupbydate);
		lookupbydate.addActionListener(this);
		add(findallbydate);
		findallbydate.addActionListener(this);
		add(removebutton);
		removebutton.addActionListener(this);

		toggleButtons();

		setSize(830, 210);
		setVisible(true);
		blankDisplay();

		// To save typing in new entries while testing, uncomment
		// the following lines (or add your own test cases)

	} // constructor

	// listen for and respond to GUI events
	public void actionPerformed(ActionEvent event) {
		String message = "";
		if (event.getSource() == addR) {
			message = addEntry("generic");
		}
		if (event.getSource() == lookupbydate) {
			message = lookupEntry(false);
		}
		if (event.getSource() == findallbydate) {
			message = lookupEntry(true);
		}
		if (event.getSource() == typeList) {
			String typeOf = (String) typeList.getSelectedItem();
			if (typeOf.equals(RUNNING)) {
				setupRunning();
			} else if (typeOf.equals(SPRINTING)) {
				setupSprinting();
			} else if (typeOf.equals(SWIMMING)) {
				setupSwimming();
			} else if (typeOf.equals(CYCLING)) {
				setupCycling();
			}
			return;
		}
		if (event.getSource() == removebutton) {
			message = removeEntry();
		}

		outputArea.setText(message);
		blankDisplay();
	} // actionPerformed

	public String addEntry(String what) {

		String typeOf = (String) typeList.getSelectedItem();

		String message = "Record added\n";
		System.out.println("Adding " + what + " entry to the records");
		String n = name.getText();
		int m = tryParse(month.getText());
		int d = tryParse(day.getText());
		int y = tryParse(year.getText());

		// valid input here is required
		if (m == -1 || d == -1 || y == -1 || n.isEmpty()) {
			return "Failed: invalid input";
		}
		
		float km = tryParseFloat(dist.getText());
		int h = tryParse(hours.getText(), 0);
		int mm = tryParse(mins.getText(), 0);
		int s = tryParse(secs.getText(), 0);

		// No kilometer value added, or no time entered
		if (km == -1 || h + mm + s == 0) {
			return "Failed: invalid input";
		}

		Entry e;

		if (typeOf.equals(RUNNING)) {
			int lapsText = tryParse(laps.getText(), 1);
			e = new RunEntry(n, d, m, y, h, mm, s, km, lapsText);
		}

		else if (typeOf.equals(SPRINTING)) {
			int lapsText = tryParse(laps.getText(), 1);
			int recoveryText = tryParse(pause.getText(), 0);
			e = new SprintEntry(n, d, m, y, h, mm, s, km, lapsText, recoveryText);
		}

		else if (typeOf.equals(SWIMMING)) {
			String swimTypeText = swimtype.getText();
			if (swimTypeText.isEmpty()) {
				swimTypeText = "indoors";
			}
			e = new SwimEntry(n, d, m, y, h, mm, s, km, swimTypeText);
		}

		else if (typeOf.equals(CYCLING)) {
			String terrainText = terrain.getText();
			if (terrainText.isEmpty()) {
				terrainText = "(Not specified)";
			}
			String tempoText = tempo.getText();
			if (tempoText.isEmpty()) {
				tempoText = "(Not specified)";
			}
			e = new CycleEntry(n, d, m, y, h, mm, s, km, terrainText, tempoText);
		} else {
			e = new Entry(n, d, m, y, h, mm, s, km); // this should never happen, but Java made me :(
		}

		if (!myAthletes.addEntry(e)) {
			return "Failed: record already exists";
		}

		toggleButtons();
		return message;
	}

	public String removeEntry() {

		String message;

		String n = name.getText();
		int m = tryParse(month.getText());
		int d = tryParse(day.getText());
		int y = tryParse(year.getText());

		// valid input here is required
		if (m == -1 || d == -1 || y == -1 || n.isEmpty()) {
			return "Failed: invalid input";
		}

		if (myAthletes.removeEntry(d, m, y, n)) {
			message = "Entry removed successfully";
			toggleButtons();
		} else {
			message = "Entry not found";
		}

		return message;
	}

	public String lookupEntry(boolean all) {

		int m = tryParse(month.getText());
		int d = tryParse(day.getText());
		int y = tryParse(year.getText());

		// valid input here is required
		if (m == -1 || d == -1 || y == -1) {
			return "Failed: invalid input";
		}

		outputArea.setText("looking up record ...");
		String message;
		if (!all) {
			message = myAthletes.lookupEntry(d, m, y);
		} else {
			message = myAthletes.lookupAllEntries(d, m, y);
		}
		return message;
	}

	public void blankDisplay() {
		name.setText("");
		day.setText("");
		month.setText("");
		year.setText("");
		hours.setText("");
		mins.setText("");
		secs.setText("");
		dist.setText("");

		// addons
		laps.setText("");
		pause.setText("");
		terrain.setText("");
		tempo.setText("");
		swimtype.setText("");
		typeList.setSelectedIndex(0);

	}// blankDisplay

	public void setupExtras(boolean showLaps, boolean showRecovery, boolean showTerrain, boolean showTempo,
			boolean showSwimType, boolean useMeters) {

		laps.setVisible(showLaps);
		lapslabel.setVisible(showLaps);
		pause.setVisible(showRecovery);
		pauselabel.setVisible(showRecovery);
		terrain.setVisible(showTerrain);
		terrainlabel.setVisible(showTerrain);
		tempo.setVisible(showTempo);
		tempolabel.setVisible(showTempo);
		swimtype.setVisible(showSwimType);
		swimtypelabel.setVisible(showSwimType);

		if (useMeters) {
			labdist.setText(" Distance (m):");
		} else {
			labdist.setText(" Distance (km):");

		}

	}

	public void setupRunning() {

		setupExtras(true, false, false, false, false, false);

	}

	public void setupSprinting() {

		setupExtras(true, true, false, false, false, true);

	}

	public void setupSwimming() {
		setupExtras(true, false, false, false, true, true);
	}

	public void setupCycling() {

		setupExtras(false, false, true, true, false, false);

	}

	public int tryParse(String input, int defaultValue) {

		int returnValue;

		if (input.isEmpty()) {
			return defaultValue;
		}

		try {
			returnValue = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			returnValue = defaultValue;
		}

		return returnValue;

	}

	public int tryParse(String input) {

		if (!input.isEmpty()) {
			try {
				int returnValue = Integer.parseInt(input);
				return Math.abs(returnValue);
			} catch (NumberFormatException e) {
			}
		}

		return -1;
	}

	public float tryParseFloat(String input) {

		if (!input.isEmpty()) {
			try {
				float returnValue = java.lang.Float.parseFloat(input);
				return Math.abs(returnValue);
			} catch (NumberFormatException e) {
			}
		}

		return -1;
	}

	public void toggleButtons() {
		if (myAthletes.getNumberOfEntries() == 0) {
			removebutton.setEnabled(false);
			lookupbydate.setEnabled(false);
			findallbydate.setEnabled(false);
		} else {
			removebutton.setEnabled(true);
			lookupbydate.setEnabled(true);
			findallbydate.setEnabled(true);
		}
	}

	// Fills the input fields on the display for testing purposes only
	public void fillDisplay(Entry ent) {
		name.setText(ent.getName());
		day.setText(String.valueOf(ent.getDay()));
		month.setText(String.valueOf(ent.getMonth()));
		year.setText(String.valueOf(ent.getYear()));
		hours.setText(String.valueOf(ent.getHour()));
		mins.setText(String.valueOf(ent.getMin()));
		secs.setText(String.valueOf(ent.getSec()));
		dist.setText(String.valueOf(ent.getDistance()));
	}

} // TrainingRecordGUI
