package edu.ntnu.iir.bidata;
/**
 * The main starting point of your application. Let this class create the
 * instance of your main-class that starts your application.
 */
public class Main {
  public static void main(String[] args)
  {
    Dagbok dagbok = new Dagbok();
    dagbok.addPost("Jørgen", "My Sunday", "It was a bad day sadly", "12.10.2025");
    dagbok.addPost("Jørgen", "My Saturday", "It was a bad day sadly", "11.10.2025");

    dagbok.start();
  }
}