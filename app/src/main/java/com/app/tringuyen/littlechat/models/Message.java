package com.app.tringuyen.littlechat.models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tri Nguyen on 9/2/2016.
 */
public class Message {
    private boolean createdByMe;
    private String author;
    private String message;
    private Date date;

    public Message (boolean createdByMe , String author, String message, Date date)
    {
        this.createdByMe = createdByMe;
        this.author = author;
        this.message = message;
        this.date = date;
    }


    public boolean isCreatedByMe() {
        return createdByMe;
    }

    public void setCreatedByMe(boolean createdByMe) {
        this.createdByMe = createdByMe;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        return dateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime()
    {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(date);
    }
}
