package edu.ntnu.iir.bidata.diary;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * Author Registry
 *
 * @author Jørgen
 * @see HashMap
 * @see Diary
 * @see Collection
 */
public class AuthorRegister
{
  private final HashMap<String, Diary>  authorsDiary;

  /**
   * Constructor.
   */
  public AuthorRegister() {
    this.authorsDiary = new HashMap<>();
  }

  /**
   * Add a diary post to a author diary.
   *
   *
   * @param post Add the post
   */
  public void addDiaryPost(Post post){
    if (this.authorsDiary.containsKey(post.getAuthor())) {
      this.authorsDiary.get(post.getAuthor()).addPost(post);
    }
    else {
      Diary diary = new Diary();
      diary.addPost(post);
      this.authorsDiary.put(post.getAuthor(),diary);
    }
  }

  /**
   * Gets a diary with the author.
   *
   *
   * @param author Author name.
   * @return The diary 
   */
  public Diary getDiary(String author){
    if (this.authorsDiary.containsKey(author)) {
      return this.authorsDiary.get(author);
    }
    return null;
  }

  public Collection<Diary> getAllDiary(){
    return this.authorsDiary.values();
  }

  public Set<String> getAuthors(){

    return this.authorsDiary.keySet();
  }
}
