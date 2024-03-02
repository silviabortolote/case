package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class SlotList {
	
	private List<List<Slot>> list = new ArrayList<List<Slot>>();
	
	public void add(List<Slot> slots) {
		list.add(slots);
	}

	public List<List<Slot>> getList() {
		return list;
	}		

}
