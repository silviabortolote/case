package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SlotListOffer extends SlotList {

	public List<Slot> getOverallOffer() {

		List<Slot> overallOfferList = null;

		Set<Integer> list = getEndStartAll();

		if (!list.isEmpty()) {
			overallOfferList = new ArrayList<Slot>();
			int[] array = list.stream().mapToInt(Integer::intValue).toArray();

			for (int index = 0; index < array.length - 1; index++) {

				int start = array[index];
				int end = array[index + 1];

				// there is no slot that starts with the value
				// and is not in the middle of any quantity in the slot
				while (!isSlotStartValue(array[index + 1]) && isBetweenAmount(array[index + 1])) {
					++index;
					end = array[index + 1];
				}

				Slot slot = new Slot(start, end);
				overallOfferList.add(slot);

			}

		}

		setAmount(overallOfferList);

		return overallOfferList;

	}

	private List<Slot> setAmount(List<Slot> list) {

		for (Slot slot : list) {

			for (List<Slot> listSlots : this.getList()) {
				for (Slot slot2 : listSlots) {
					if (slot.getStart() == slot2.getStart()
							|| (slot2.getStart() >= slot.getStart() && slot2.getStart() < slot.getEnd())) {
						slot.setQuantity(slot.getQuantity() + slot2.getQuantity());
					}
				}
			}

		}

		return null;
	}

	private Set<Integer> getEndStartAll() {

		Set<Integer> list = new TreeSet<Integer>();

		for (List<Slot> listSlots : this.getList()) {
			for (Slot slot : listSlots) {
				list.add(slot.getStart());
				list.add(slot.getEnd());
			}
		}

		return list;
	}

	// checks if it is a slot start value
	private boolean isSlotStartValue(int value) {

		for (List<Slot> slotList : this.getList()) {
			for (Slot slot : slotList) {
				if (slot.getStart() == value) {
					return true;
				}
			}

		}

		return false;
	}

	// the value is between some amount of some slot
	private boolean isBetweenAmount(int value) {

		for (List<Slot> slotList : this.getList()) {
			for (Slot slot : slotList) {
				if (slot.getStart() < value && slot.getEnd() > value) {
					return true;
				}
			}

		}

		return false;
	}

}
