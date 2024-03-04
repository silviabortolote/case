package org.example.model;

public class SlotDemand extends Slot {

	public SlotDemand(Integer start, Integer end) {
		super(start, end);
	}

	public SlotDemand(Integer start, Integer end, Integer quantity) {
		super(start, end, quantity);
	}

	
	// make the comparison, taking into account the quantity
	@Override
	public int compareTo(Slot slot) {
		// TODO Auto-generated method stub
		return 0;
	}
}
