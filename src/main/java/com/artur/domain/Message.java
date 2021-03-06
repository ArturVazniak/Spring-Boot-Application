package com.artur.domain;


import javax.persistence.*;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;

    private String filename;

    public void setAuthor(User author) {
        this.author = author;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;


    public Message( String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    public Message() {

    }

    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
