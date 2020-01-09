package model;

import java.util.Observable;


public abstract class ImenovanaKolekcija extends Observable{
	
   protected String ime;
   protected boolean referenciranost;
   
   
   public void changedSet(){
	   setChanged();
   }
   public abstract ImenovanaKolekcija getChild(int index);
   public abstract int getChildCount();
   public abstract int getIndexOfChild(ImenovanaKolekcija kolekcija);
   
   public void promeniIme(String ime){
	   this.ime = ime;
	   setChanged();
	   notifyObservers();
   }
   
   public String getIme() {
	   return ime;
   }
   
   @Override
   public String toString(){
	   return ime;
   }

}