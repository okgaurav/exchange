package com.exchange.model.entity;

public class Crypto {

    private String message;
    private ContactDetails contactDetails;

    public String getMessage() {
        return message;
    }

    public Crypto setMessage(String message) {
        this.message = message;
        return this;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public Crypto setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
        return this;
    }
}
