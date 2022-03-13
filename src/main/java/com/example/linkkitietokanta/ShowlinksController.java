package com.example.linkkitietokanta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ShowlinksController {

  @Autowired
private LinksRepository linksrepository;

  @GetMapping("/showlinks")
  public String list(Model model){

    model.addAttribute("links", linksrepository.findAll());
     
    return "showlinks";
  }
    
  @GetMapping("/home1")

  public String home(){
      return "home";
  }

  @GetMapping("/addlinks1")

  public String addlinks(){
      return "addlinks";
  }

//update_links

  @GetMapping("/showFormForUpdate/{id}")
  public String showFormForUpdate(@PathVariable Long id , Model model){
         System.out.println("----------------------------------");
         Links link = linksrepository.getById(id);

         model.addAttribute("link", link); 
         
         return "updatelinks";
  }

@PostMapping("/updatelink/{id}") 
public String update(@RequestParam String heading,@RequestParam String description,@RequestParam String link,@RequestParam String keyword ,@PathVariable Long id){
 

       Links existingLink = linksrepository.getById(id);
 
       existingLink.setDescription(description);
       existingLink.setHeading(heading);
       existingLink.setKeyword(keyword);
       existingLink.setLink(link);


      linksrepository.save(existingLink); 

        return "redirect:/showlinks";
     
}

// Delete_links


@GetMapping("/deletelink/{id}")
public String deleteLink(@PathVariable Long id){
  linksrepository.deleteById(id);
  return "redirect:/showlinks";
}
}   