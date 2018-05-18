package me.Vamsi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRespository extends JpaRepository<Contact, String> {

    // custom query to search to contact post by email or name
    @Query("SELECT * FROM Contact c where c.email = ?1 and c.name = ?2")
    List<Contact> findByEmailAndName(String email, String name);

}
