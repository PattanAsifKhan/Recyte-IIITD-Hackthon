package tech.geeksquad.recyte;

public class Message {
    private String author;
    private String message;
    private boolean isImage;
    private byte[] image;

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
        isImage = false;
    }

    public Message(String author, byte[] image) {
        this.author = author;
        this.image = image;
        isImage = true;
    }

    public Message() {

    }

    public boolean isImage() {
        return isImage;
    }

    public byte[] getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
