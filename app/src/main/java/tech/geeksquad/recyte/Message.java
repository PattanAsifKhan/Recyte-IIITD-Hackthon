package tech.geeksquad.recyte;

public class Message {
    private String author;
    private String message;

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public Message() {

    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
