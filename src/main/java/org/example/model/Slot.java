package org.example.model;

public class Slot {

	private Integer start;

	private Integer end;

	private Integer quantity = 0;

	public Slot(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	public Slot(Integer start, Integer end, Integer quantity) {
		this.start = start;
		this.end = end;
		this.quantity = quantity;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Slot [start=" + start + ", end=" + end + ", quantity=" + quantity + "]";
	}

}
