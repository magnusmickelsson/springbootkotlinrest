package rest;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class BlogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private String headline;

    @Basic
    private String text;

    @Basic
    private String author;

    // Needed by JPA
    protected BlogEntry() {
    }

    public BlogEntry(String headline, String text, String author) {
        this.headline = headline;
        this.text = text;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlogEntry)) return false;
        BlogEntry blogEntry = (BlogEntry) o;
        return Objects.equals(id, blogEntry.id) &&
                Objects.equals(headline, blogEntry.headline) &&
                Objects.equals(text, blogEntry.text) &&
                Objects.equals(author, blogEntry.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, headline, text, author);
    }

    @Override
    public String toString() {
        return "BlogEntry{" +
                "id=" + id +
                ", headline='" + headline + '\'' +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
