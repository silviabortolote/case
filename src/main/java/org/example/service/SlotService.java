package org.example.service;

import java.util.ArrayList;
import java.util.List;

import org.example.model.Slot;
import org.example.model.SlotList;
import org.example.model.SlotListDemand;
import org.example.model.SlotListOffer;
import org.example.model.SlotOffer;

public class SlotService {

	private SlotListOffer offers = new SlotListOffer();

	private SlotListDemand demands = new SlotListDemand();

	// add offers
	public void addAllOffers() {

		List<Slot> offer1 = new ArrayList<Slot>();
		Slot s11 = new SlotOffer(0, 4, 1);
		Slot s12 = new SlotOffer(6, 8, 2);
		offer1.add(s11);
		offer1.add(s12);

		offers.add(offer1);

		List<Slot> offer2 = new ArrayList<Slot>();
		Slot s21 = new SlotOffer(2, 6, 2);
		Slot s22 = new SlotOffer(10, 12, 3);
		offer2.add(s21);
		offer2.add(s22);

		offers.add(offer2);
	}

	// returns the global offer
	public List<Slot> getGlobalOffer() {
		return offers.getGlobalOffer();
	}

	// add demands
	public void addAllDemands() {

	}

	public SlotList getOffers() {
		return offers;
	}

	public SlotList getDemands() {
		return demands;
	}

}
