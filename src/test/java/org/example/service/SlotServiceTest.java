package org.example.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SlotServiceTest {

	private SlotService slotService = new SlotService();

	@Test
	public void addAllOffersTest() {
		slotService.addAllOffers();
		assertEquals(slotService.getOffers().getList().size(), 2);
	}

	@Test
	public void globalOfferListTest() {
		slotService.addAllOffers();
		assertEquals(slotService.globalOffer().size(), 4);
	}

}
