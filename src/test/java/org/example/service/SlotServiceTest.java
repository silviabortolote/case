package org.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SlotServiceTest {

	private SlotService slotService = new SlotService();

	@Test
	public void addAllOffersTest() {
		slotService.addAllOffers();
		assertEquals(slotService.getOffers().getList().size(), 2);
	}

	@Test
	public void overallOfferListTest() {
		slotService.addAllOffers();
		assertNotNull(slotService.overallOffer());
	}

}
