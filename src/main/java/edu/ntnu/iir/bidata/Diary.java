package edu.ntnu.iir.bidata;
import java.util.HashMap;
import java.util.Collection;
// Todo Add comments to class
public class Diary {
  private final HashMap<String,Post> posts;

  public Diary() {
    this.posts = new HashMap<>();
  }
  public void addPost(String author, String title, String text) {
    String date = new Time().getDate();
    this.posts.put(date, new Post(author, title, text));
    System.out.println("Post added successfully");
  }
  public void addPost(String author, String title, String text, String time, String date) {
    this.posts.put(date, new Post(author, title, text, time, date));
    System.out.println("Post added successfully");
  }
  public Post getPost(String date){
    if(this.posts.get(date) != null)
    {
      return this.posts.get(date);
    }
    return null;
  }
  public Collection<Post> getAllPosts(){
    return this.posts.values();
  }
  public void removePost(String date){
    this.posts.remove(date);
  }
}
