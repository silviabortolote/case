package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SlotListOffer extends SlotList {

	// returns the global offer
	public List<Slot> getGlobalOffer() {

		List<Slot> globalOfferList = null;

		Set<Integer> list = getEndStartAll();

		if (!list.isEmpty()) {
			globalOfferList = new ArrayList<Slot>();
			int[] array = list.stream().mapToInt(Integer::intValue).toArray();

			for (int index = 0; index < array.length - 1; index++) {

				int start = array[index];
				int end = array[index + 1];

				Slot slot = new SlotOffer(start, end);
				globalOfferList.add(slot);

			}
		}

		// the quantity in the slots
		setQuantity(globalOfferList);

		System.out.println(globalOfferList);

		// remove slot without quantities
		globalOfferList.removeIf(value -> value.getQuantity() == 0);

		// join slots with the same quantities
		return joinSameQuantity(globalOfferList);

	}

	// set the quantity in the slots
	private void setQuantity(List<Slot> overallOfferList) {

		for (Slot indexesSlot : overallOfferList) {

			for (List<Slot> slotList : this.getList()) {
				for (Slot slot : slotList) {

					if (indexesSlot.compareTo(slot) >= 0) {
						indexesSlot.setQuantity(indexesSlot.getQuantity() + slot.getQuantity());
					}

				}

			}
		}

	}

	// join slots with the same quantities
	private List<Slot> joinSameQuantity(List<Slot> overallOfferList) {

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

			Slot slotResult = new SlotOffer(start, end, slots[i].getQuantity());
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
