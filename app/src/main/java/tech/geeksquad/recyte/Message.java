package tech.geeksquad.recyte;

import android.util.Base64;

public class Message {
    private String author;
    private String message;
    private int isImage;
    private String data;

    public Message(String author, String message) {
        this.author = author;
        this.message = message;
        isImage = 0;
        data = "none";
    }

    public Message(String author, byte[] data, boolean isImage) {
        this.author = author;
        this.isImage = 1;
        this.data = Base64.encodeToString(data, Base64.DEFAULT);
        message = "none";
    }

    public Message() {

    }

    public int getIsImage() {
        return isImage;
    }

    public String getData() {
        return data;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
