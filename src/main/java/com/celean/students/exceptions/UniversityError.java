package com.celean.students.exceptions;

import java.util.Date;

public class UniversityError {
    private String message;
    private Date date;

    public UniversityError(String message) {
        this.message = message;
        this.date = new Date();
    }

}
