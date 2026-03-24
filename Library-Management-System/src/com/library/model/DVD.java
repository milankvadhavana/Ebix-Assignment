package com.library.model;

public class DVD extends LibraryItem {
	private int duration;
	public DVD (int itemId,String title,String author,int duration) {
		super(itemId,title,author);
		this.duration = duration;
	}
	@Override
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Duration :" + duration + "minutes");
		System.out.println("-----------------------------------");
		
	}
}
