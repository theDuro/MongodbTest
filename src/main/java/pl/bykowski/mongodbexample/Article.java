package pl.bykowski.mongodbexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


public class Article {

    private String eid;

    private String author;

    private String title;

    private List<Comment> commentList;

    public String getId() {
        return eid;
    }

    public void setId(String id) {
        this.eid = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + eid + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
