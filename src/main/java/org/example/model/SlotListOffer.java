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

				Slot slot = new Slot(start, end);
				overallOfferList.add(slot);

			}

		}

		setAmount(overallOfferList);

		return overallOfferList;

	}

	private void setAmount(List<Slot> overallOfferList) {

		for (Slot indexesSlot : overallOfferList) {

			for (List<Slot> slotList : this.getList()) {
				for (Slot slot : slotList) {

					// Verifica se indexesSlot estao entre os slots
					if (indexesSlot.getStart() >= slot.getStart() && indexesSlot.getEnd() <= slot.getEnd()) {
						System.out.println(slot);
						System.out.println(indexesSlot);
						System.out.println();
					}

				}

			}
		}

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


}
