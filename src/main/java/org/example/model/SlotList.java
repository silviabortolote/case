package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class SlotList {

	private List<List<Slot>> list = new ArrayList<List<Slot>>();

	// add slot list
	public void add(List<Slot> slots) {
		list.add(slots);
	}

	// returns list of slots
	public List<List<Slot>> getList() {
		return list;
	}

}
