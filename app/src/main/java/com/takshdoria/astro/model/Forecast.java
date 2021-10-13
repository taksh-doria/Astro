package com.takshdoria.astro.model;

public class Forecast {
    public String current_date;
    public String description;
    public String compatibility;
    public String mood;
    public String color;
    public String lucky_number;
    public String lucky_time;

    public String getCurrent_date() {
        return current_date;
    }

    public void setCurrent_date(String current_date) {
        this.current_date = current_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompatibility() {
        return compatibility;
    }

    public void setCompatibility(String compatibility) {
        this.compatibility = compatibility;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLucky_number() {
        return lucky_number;
    }

    public void setLucky_number(String lucky_number) {
        this.lucky_number = lucky_number;
    }

    public String getLucky_time() {
        return lucky_time;
    }

    public void setLucky_time(String lucky_time) {
        this.lucky_time = lucky_time;
    }
}
