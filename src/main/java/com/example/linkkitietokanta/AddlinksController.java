package com.example.linkkitietokanta;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AddlinksController {


 

  @Autowired
  private LinksRepository linksrepository;
  
    @GetMapping("/addlinks")
  public String list(){
     
    return "addlinks";
  }

  @GetMapping("/home")

  public String home(){
      return "home";
  }

  @GetMapping("/showlinks1")

  public String showlinks(){

      return "redirect:/showlinks";
  }


  @PostMapping("/addlinks")
  public String add(@RequestParam String heading,@RequestParam String description,@RequestParam String link,@RequestParam String keyword){
    if(!(heading.isEmpty()) && !(description.isEmpty()) && !(link.isEmpty()) && !(keyword.isEmpty())){
       
      Links l = new Links();
      l.setHeading(heading);
      l.setLink(link);
      l.setDescription(description);
      l.setKeyword(keyword);
      linksrepository.save(l);
    }
 

    return "redirect:/showlinks";
  }
    
}
