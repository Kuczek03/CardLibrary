package pl.cardlibrary.CardLibrary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    //Wszystkie karty
    @GetMapping("")
    public List<Card> getAll(){
        return cardRepository.getAll();
    }

    //Karty po numerze id
    @GetMapping("/{id}")
    public Card getById(@PathVariable("id") int id){
        return cardRepository.getById(id);
    }

    @PostMapping("")
    public int save(@RequestBody List<Card> Cards){
        return cardRepository.save(Cards);
    }
}