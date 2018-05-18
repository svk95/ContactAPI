package me.Vamsi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ContactController {

    @Autowired
    ContactRespository contactRespository;

    @RequestMapping("/index")
    public String index() {
        return "Index";
    }

    @GetMapping("/contact/{email}")
    public Contact show(@PathVariable String email){
        return contactRespository.findOne(email);
    }

    @PostMapping("/contact/search")
    public List<Contact> search(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String name = body.get("name");
        return contactRespository.findByEmailAndName(email, name);
    }

    @PostMapping("/contact")
    public Contact create(@RequestBody Map<String, String> body){
        String email = body.get("email");
        String name = body.get("name");
        String phoneNumber = body.get("phoneNumber");
        return contactRespository.save(new Contact(email, name, phoneNumber));
    }

    @PutMapping("/contact/{email}")
    public Contact update(@PathVariable String email, @RequestBody Map<String, String> body){
        // getting blog
        Contact contact = contactRespository.findOne(email);
        contact.setName(body.get("name"));
        contact.setPhoneNumber(body.get("phoneNumber"));
        return contactRespository.save(contact);
    }

    @DeleteMapping("contact/{email}")
    public boolean delete(@PathVariable String email){
        contactRespository.delete(email);
        return true;
    }

}
