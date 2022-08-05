package com.example.yjp_capstone.domain;

public class ReservationDomain {
    private String title;
    private String date;
    private String people;
    private String charge;

    public ReservationDomain(String title, String date, String people, String charge) {
        this.title = title;
        this.date = date;
        this.people = people;
        this.charge = charge;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}
