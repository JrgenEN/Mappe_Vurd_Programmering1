package edu.ntnu.iir.bidata.diary.entry;

/**
 * Class for authors.
 *
 * <p>Example: {@code Author author = new Author("firstname lastname")}.
 *
 * </p>
 *
 * @author jorgen
 * @version 1.0
 * @see String
 * @since 1.0
 */
public class Author {
  private String name;

  /**
   * Constructor for author.
   *
   *
   * @param name Name of author.
   */
  public Author(String name) {
    this.setName(name);
  }

  /**
   * Gets the name.
   *
   *
   * @return this.name Returns name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Formats the name to be in the format "Firstname Lastname".
   *
   * @param name Name of the author.
   * @return Formated string.
   */
  public static String formatName(final String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("Name is empty");
    }
    String[] names = name.split(" ");
    String returnString = "";
    for (String s : names) {
      char[] c = s.toCharArray();
      c[0] = Character.toUpperCase(c[0]);
      for (int i = 1; i < c.length; i++) {
        c[i] = Character.toLowerCase(c[i]);
      }
      if (!returnString.isEmpty()) {
        returnString = returnString.concat(" ");
      }
      returnString = returnString.concat(new String(c));
    }
    return returnString;
  }

  //  Setter for name.

  private void setName(String name) {
    this.name = formatName(name);
  }
}
