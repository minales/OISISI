package model;
/***********************************************************************
 * Module:  AktivniRadniProstor.java
 * Author:  ljuca
 * Purpose: Defines the Class AktivniRadniProstor
 ***********************************************************************/

import java.util.*;

public class AktivniRadniProstor extends Observable  {
  
   public  RadniProstor radniProstor;
   public Student s;
   
   public AktivniRadniProstor(String naziv){
	   radniProstor = new RadniProstor(naziv);

   }
   
   public void promeniRadniProstor(RadniProstor radniProstor) {
	   this.radniProstor = radniProstor;
	   setChanged();
	   notifyObservers();
   }

}