package com.library.model;

public class Magazine extends LibraryItem {
   private int issueNumber;
   public Magazine(int itemId, String title,String author,int issueNumber) {
	   super(itemId,title,author);
	   this.issueNumber = issueNumber;
   }
   @Override
   public void displayDetails() {
	   super.displayDetails(); 
	   System.out.println("Issue Number" + issueNumber);
	   System.out.println("---------------------------");
   }
   
   
}
