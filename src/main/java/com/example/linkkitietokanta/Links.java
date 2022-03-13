package com.example.linkkitietokanta;


import javax.persistence.Entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Links extends AbstractPersistable<Long> {

    
   
    private String heading;
    private String link;
    private String description;
    private  String keyword;

   

    

}
