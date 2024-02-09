package com.example.assignment;

public class Notes {

    private long id;
    private  String title;
    private String notes;


    public Notes(long id, String title, String notes){
        this.id = id;
        this.title = title;
        this.notes = notes;
    }



    public long getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getNotes() {

        return notes;
    }

}
