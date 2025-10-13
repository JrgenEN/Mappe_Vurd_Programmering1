package edu.ntnu.iir.bidata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Dagbok
{
  private HashMap<String,Posts> posts;
  private boolean started;

  public Dagbok()
  {
    this.posts = new HashMap<>();
  }

  public void start()
  {
    started = true;
    System.out.println("Hello, welcome to the diary!");
    while(started)
    {
      System.out.println("To add a paragraf write: Add");
      System.out.println("To print all posts write: All");
      System.out.println("To print posts write: Print");
      System.out.println("To quit write: Quit");

      HashSet<String> words = Input.getInputSet();
      Iterator<String> iterator = words.iterator();

      while (iterator.hasNext())
      {
        String w = iterator.next();

        if (w.equals("add"))
        {
          this.addPosts();
        }
        else if (w.equals("print"))
        {
          System.out.println("Write date of written post");
          String date = Input.getInput();

          if(this.getPosts(date) != null)
          {
            this.getPosts(date).printPosts();
          }
          else
          {
            System.out.println("No posts found");
          }
        }
        else if (w.equals("quit"))
        {
          started = false;
        }
        else if (w.equals("all")){
          this.printAll();
        }
      }
    }
  }

  public void addPosts()
  {
    System.out.println("What is your name?");
    String author = Input.getInput();
    System.out.println("Add title: ");
    String title = Input.getInput();
    System.out.println("Add description: ");
    String description = Input.getInput();
    Posts post = new Posts(author,title,description);
    this.posts.put(post.getDate(), post);
    System.out.flush();
  }
  public Posts getPosts(String date)
  {
    return this.posts.get(date);
  }
  public void printAll()
  {
    for (Posts p : this.posts.values()){
      p.printPosts();
    }
  }

}
