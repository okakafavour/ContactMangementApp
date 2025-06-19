package com.codewithfavour.Controller;

import com.codewithfavour.dto.request.AddContactRequest;
import com.codewithfavour.dto.request.DeleteContactRequest;
import com.codewithfavour.dto.request.UpdateContactRequest;
import com.codewithfavour.dto.response.AddContactResponse;
import com.codewithfavour.dto.response.UpdateContactResponse;
import com.codewithfavour.services.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController("api/contact")
public class ContactController {

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/add-contact")
    public ResponseEntity<String> addContact(@RequestParam AddContactRequest addContactRequest) {
        try{
            AddContactResponse addContactResponse = contactService.addContact(addContactRequest);
            return ResponseEntity.ok(addContactResponse.toString());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/delete-contact")
    public ResponseEntity<String> deleteContact(@RequestParam DeleteContactRequest deleteContactRequest){
        try{
            String deleteContactResponse = contactService.deleteContact(deleteContactRequest);
            return ResponseEntity.ok(deleteContactResponse);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<String> updateContact(@RequestParam UpdateContactRequest updateContactRequest){
        try{
            UpdateContactResponse updateContactResponse = contactService.updateContact(updateContactRequest);
            return ResponseEntity.ok(updateContactResponse.toString());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
