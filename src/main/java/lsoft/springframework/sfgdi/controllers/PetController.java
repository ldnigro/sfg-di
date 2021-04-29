package lsoft.springframework.sfgdi.controllers;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import lsoft.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichPetIsTheBest(){
        return petService.getPetType();
    }
}
