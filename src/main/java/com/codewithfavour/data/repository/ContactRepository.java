package com.codewithfavour.data.repository;

import com.codewithfavour.data.model.Contact;
import com.codewithfavour.dto.request.DeleteContactRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findByUserId(String userId);
    DeleteContactRequest deleteContactByContactNameAndPhoneNumber(String contactName, String phoneNumber);
}
