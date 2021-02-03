// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
	private List<Entry> tr;

	public TrainingRecord() {
		tr = new ArrayList<Entry>();
	} // constructor

	// add a record to the list
	public boolean addEntry(Entry e) {

		if (exists(e)) {
			return false;
		}

		tr.add(e);
		return true;

	} // addClass

	// look up the entry of a given day and month
	public String lookupEntry(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "No entries found";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				result = current.getEntry();
		}
		return result;
	} // lookupEntry

	// look up all entries of a given day and month
	public String lookupAllEntries(int d, int m, int y) {
		ListIterator<Entry> iter = tr.listIterator();
		String result = "";
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				result += current.getEntry();
		}
		if (result.isEmpty()) {
			result = "No entries found";
		}
		return result;
	}

	// check if an entry is a would-be duplicate
	public boolean exists(Entry e) {
		ListIterator<Entry> iter = tr.listIterator();
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == e.getDay() && current.getMonth() == e.getMonth() && current.getYear() == e.getYear())
				if (current.getName().equalsIgnoreCase(e.getName())) {
					return true;
				}

		}

		return false;
	}

	// find and remove entry, return false if no match
	public boolean removeEntry(int d, int m, int y, String name) {
		ListIterator<Entry> iter = tr.listIterator();
		while (iter.hasNext()) {
			Entry current = iter.next();
			if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
				if (current.getName().equalsIgnoreCase(name)) {
					tr.remove(current);
					return true;
				}

		}

		return false;
	}

	// Count the number of entries
	public int getNumberOfEntries() {
		return tr.size();
	}

	// Clear all entries
	public void clearAllEntries() {
		tr.clear();
	}

} // TrainingRecord