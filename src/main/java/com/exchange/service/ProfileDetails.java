package com.exchange.service;

import com.exchange.model.entity.ContactDetails;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("profile-details.crypto")
public class ProfileDetails {
    private String message;
    private ContactDetails contactDetails;

    public String getMessage() {
        return message;
    }

    public ProfileDetails setMessage(String message) {
        this.message = message;
        return this;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public ProfileDetails setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
        return this;
    }
}
