package com.agnes.ScrapeIt.model;

import com.opencsv.bean.CsvBindByName;

public class CSVModel {
    @CsvBindByName(column = "LICENSE_NUMBER")
    private String licenseNumber;
    @CsvBindByName(column = "LAST_NAME")
    private String lastName;
    @CsvBindByName(column = "FIRST_NAME")
    private String firstName;
    @CsvBindByName(column = "MIDDLE_NAME")
    private String middleName;
    @CsvBindByName(column = "CITY")
    private String city;
    @CsvBindByName(column = "STATE")
    private String state;
    @CsvBindByName(column = "STATUS")
    private String status;
    @CsvBindByName(column = "ISSUE_DATE")
    private String issueDate;
    @CsvBindByName(column = "EXPIRATION_DATE")
    private String expirationDate;
    @CsvBindByName(column = "BOARD_ACTION")
    private String boardAction;

    public CSVModel(String licenseNumber, String lastName, String firstName, String middleName, String city, String state, String status, String issueDate, String expirationDate, String boardAction) {
        this.licenseNumber = licenseNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.city = city;
        this.state = state;
        this.status = status;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.boardAction = boardAction;
    }
}
