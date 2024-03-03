package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SlotListOffer extends SlotList {

	// returns the global offer
	public List<Slot> getGlobalOffer() {

		List<Slot> overallOfferList = null;

		Set<Integer> list = getEndStartAll();

		if (!list.isEmpty()) {
			overallOfferList = new ArrayList<Slot>();
			int[] array = list.stream().mapToInt(Integer::intValue).toArray();

			for (int index = 0; index < array.length - 1; index++) {

				int start = array[index];
				int end = array[index + 1];

				Slot slot = new Slot(start, end);
				overallOfferList.add(slot);

			}
		}

		// the quantity in the slots
		setAmount(overallOfferList);

		// remove slot without quantities
		overallOfferList.removeIf(value -> value.getQuantity() == 0);

		return joinSameAmount(overallOfferList);

	}

	// set the quantity in the slots
	private void setAmount(List<Slot> overallOfferList) {

		for (Slot indexesSlot : overallOfferList) {

			for (List<Slot> slotList : this.getList()) {
				for (Slot slot : slotList) {

					// Checks if indexesSlot are between slots
					if (indexesSlot.getStart() >= slot.getStart() && indexesSlot.getEnd() <= slot.getEnd()) {
						indexesSlot.setQuantity(indexesSlot.getQuantity() + slot.getQuantity());
					}

				}

			}
		}

	}

	// join slots with the same quantities
	private List<Slot> joinSameAmount(List<Slot> overallOfferList) {

		Slot[] slots = overallOfferList.toArray(new Slot[overallOfferList.size()]);

		List<Slot> overallOfferListFinal = new ArrayList<Slot>();

		for (int i = 0; i < slots.length; i++) {

			Integer start = slots[i].getStart();
			Integer end = slots[i].getEnd();

			// checks if the next slot in the list has the same amount
			while ((i + 1 < slots.length) && slots[i + 1].getQuantity() == slots[i].getQuantity()) {
				end = slots[i + 1].getEnd();
				i++;
			}

			Slot slotResult = new Slot(start, end, slots[i].getQuantity());
			System.out.print(slotResult);
			overallOfferListFinal.add(slotResult);

		}
		return overallOfferListFinal;

	}

	// returns a list of non-repeating elements with all start and end indexes of
	// all slots
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

}
