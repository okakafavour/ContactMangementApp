package com.codewithfavour.services;


import com.codewithfavour.data.model.Contact;
import com.codewithfavour.data.model.User;
import com.codewithfavour.data.repository.ContactRepository;
import com.codewithfavour.data.repository.UserRepository;
import com.codewithfavour.dto.request.*;
import com.codewithfavour.dto.response.*;
import com.codewithfavour.exception.ContactNotFoundException;
import com.codewithfavour.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    Mapper mapper;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        User user = mapper.mapToRequest(userRegisterRequest);
        User savedUser = userRepository.save(user);
        return mapper.mapToRegisterResponse(savedUser);
    }

    @Override
    public UserLoginResponse login(UserLoginRequest userLoginRequest) {
        return mapper.mapToLogin(userLoginRequest);
    }

    @Override
    public AddContactResponse addContact(AddContactRequest addContactRequest) {
        Contact contact = mapper.addContact(addContactRequest);
        Contact savedContact = contactRepository.save(contact);
        return mapper.mapToAddContact(savedContact);
    }

    @Override
    public String deleteContact(DeleteContactRequest request) {
        Contact contact = mapper.mapToDeleteContact(request);
         contactRepository.delete(contact);
        return "Contact Delete Successfully";
    }
    @Override
    public UpdateContactResponse updateContact(UpdateContactRequest request) {
        Optional<Contact> optionalContact = contactRepository.findById(request.getContactId());

        if (optionalContact.isEmpty()) throw new ContactNotFoundException("Contact not found");
        Contact contact = optionalContact.get();

        boolean isInvalidFirstName = request.getContactName() != null && !request.getContactName().isEmpty();
        boolean  isInvalidPhoneNumber = request.getPhoneNumber() != null && !request.getPhoneNumber().isEmpty();
        boolean isInvalidEmail = request.getEmail() != null && !request.getEmail().isEmpty();

        if (isInvalidFirstName) contact.setContactName(request.getContactName());
        if (isInvalidPhoneNumber) contact.setPhoneNumber(request.getPhoneNumber());
        if (isInvalidEmail) contact.setEmail(request.getEmail());

        Contact updatedContact = contactRepository.save(contact);
        return mapper.mapToUpdateContactResponse(updatedContact);
    }


}
