package com.library.model;

public class Book extends LibraryItem {
	
	private int numberofPages;
		public Book(int itemId, String title , String author,int numberofPages) {
			super(itemId,title,author);
			this.numberofPages = numberofPages;
		}
		@Override
		public void displayDetails() {
			super.displayDetails();
			System.out.println("Page : " + numberofPages);
			System.out.println("------------------------");
			
		}
}
