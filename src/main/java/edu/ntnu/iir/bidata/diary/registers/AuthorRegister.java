package edu.ntnu.iir.bidata.diary.registers;

import edu.ntnu.iir.bidata.diary.entry.Author;
import edu.ntnu.iir.bidata.diary.entry.Post;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Class to make an author register of all authors and creates a diary for each new author.
 *
 * @author Jørgen
 * @see Author
 * @see Diary
 * @see HashSet
 * @see HashMap
 * @version 1.0
 */
public class AuthorRegister {
  private final HashMap<Author, Diary>  authorsDiary;

  /**
   * Constructor.
   */
  public AuthorRegister() {
    this.authorsDiary = new HashMap<>();
  }

  /**
   * Gets an {@code Map} of the stats of each {@code Author}.
   *
   *
   * @return {@code Map<String, Integer>}
   */
  public Map<String, Integer> getStatistics() {
    Map<String, Integer> statistics = new HashMap<>();

    for (Map.Entry<Author, Diary> entry : authorsDiary.entrySet()) {
      statistics.put(entry.getKey().getName(), entry.getValue().getAllPosts().size());
    }
    return statistics;
  }

  /**
   * Add a diary post to an {@code Author} {@code Diary}.
   *
   *
   * @param post Add the {@code Post} to the {@code Diary}.
   */
  public boolean addDiaryPost(Post post) {
    try {
      Author author = this.getAuthorByName(post.getAuthor().getName());
      if (this.authorsDiary.containsKey(author)) {
        return this.authorsDiary.get(author).addPost(post);
      }
    } catch (Exception e) {
      Diary diary = new Diary();
      boolean ret = diary.addPost(post);
      this.authorsDiary.put(post.getAuthor(), diary);
      return ret;
    }
    return false;
  }

  /**
   * Gets a {@code Diary} with the {@code Author}.
   *
   *
   * @param name {@code Author} name.
   * @return The {@code Diary}
   */
  public Diary getDiary(String name) {
    for (Map.Entry<Author, Diary> author : this.authorsDiary.entrySet()) {
      if (author.getKey().getName().equals(name)) {
        return author.getValue();
      }
    }
    throw new IllegalArgumentException("No diary for " + name);
  }

  /**
   * Gets a {@code Collection<>()} of all diary's.
   *
   *
   * @return Returns a {@code Collection<>()} of Diary's.
   */
  public Collection<Diary> getAllDiary() {
    if (!this.authorsDiary.isEmpty()) {
      return this.authorsDiary.values();
    }
    throw new IllegalArgumentException("No authors in the register");
  }

  /**
   * Gets a {@code Set<>} of names to Authors.
   *
   *
   * @return Returns a {@code Set<>} of names to Authors.
   */
  public Set<String> getAuthorsName() {
    Set<String> names = new HashSet<>();
    for (Author author : this.authorsDiary.keySet()) {
      names.add(author.getName());
    }
    return names;
  }

  /**
   * Gets the {@code Author} by {@code String} name.
   * Private, so it's not available to the public.
   *
   *
   * @param name Name for {@code Author} as {@code String}.
   * @return {@code Author} if name is valid or {@code null} if not valid.
   */
  private Author getAuthorByName(String name) {
    String formattedName = new Author(name).getName();
    for (Map.Entry<Author, Diary> author : this.authorsDiary.entrySet()) {
      if (author.getKey().getName().equals(formattedName)) {
        return author.getKey();
      }
    }
    throw new IllegalArgumentException("No author with that name");
  }
}
