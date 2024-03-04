package org.example.model;

public class SlotOffer extends Slot {

	public SlotOffer(Integer start, Integer end) {
		super(start, end);
	}

	public SlotOffer(Integer start, Integer end, Integer quantity) {
		super(start, end, quantity);
	}

	// this == slot
	// this there is intercession slot -> 1
	// this there is no intercession slot -> -1
	@Override
	public int compareTo(Slot slot) {
		// this == slot
		if (this.getStart() == slot.getStart() && this.getEnd() == slot.getEnd()) {
			return 0;
		} else
		// compare two slots to know if there is intercession
		if (this.getStart() >= slot.getStart() && this.getEnd() <= slot.getEnd()) {
			return 1;
		}
		// no intersection between slots
		return -1;
	}

}
