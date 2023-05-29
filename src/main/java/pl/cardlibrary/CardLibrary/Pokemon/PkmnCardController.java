package pl.cardlibrary.CardLibrary.Pokemon;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pkmn")
public class PkmnCardController {

    @Autowired
    PkmnCardRepository pkmnRepo;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    //Wszystkie karty
    @GetMapping("/all")
    public List<PkmnCard> getAll(){
        return pkmnRepo.getAll();
    }

    //Karty po numerze id
    @GetMapping("/id/{id}")
    public PkmnCard getID(@PathVariable("id")int id){
        return pkmnRepo.getID(id);
    }

    @GetMapping("/set")
    public List<PkmnCard> getAllSet(){return pkmnRepo.getAllSet();}

    @GetMapping("/set/{setId}")
    public List<PkmnCard> getSet(@PathVariable("setId")String setId){return pkmnRepo.getSet(setId);}

    @PostMapping("/save")
    public String saveCard(@RequestBody List<PkmnCard> PKMNs){
        return pkmnRepo.saveCard(PKMNs);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCard(@PathVariable("id") int id){
        return pkmnRepo.deleteCard(id);
    }
    @PutMapping("/update/{id}")
    public int updateCard(@PathVariable("id") int id, @RequestBody @NotNull PkmnCard updatedCard){
        PkmnCard pkmn = pkmnRepo.getID(id);
        pkmn.setName(updatedCard.getName());
        pkmn.setTyp(updatedCard.getTyp());
        pkmn.setSetId(updatedCard.getSetId());
        pkmn.setNumbInSet(updatedCard.getNumbInSet());
        pkmn.setPrice(updatedCard.getPrice());
        pkmnRepo.updateCard(pkmn);
        return  1;
    }

    @PatchMapping("/update/{id}")
    public int partiallyCard(@PathVariable("id") int id, @RequestBody @NotNull PkmnCard updatedCard){
        PkmnCard pkmn = pkmnRepo.getID(id);
        if(updatedCard.getName()!= null) pkmn.setName(updatedCard.getName());
        if(updatedCard.getTyp()!= null) pkmn.setTyp(updatedCard.getTyp());
        if(updatedCard.getSetId()!= null) pkmn.setSetId(updatedCard.getSetId());
        if(updatedCard.getNumbInSet()!= null) pkmn.setNumbInSet(updatedCard.getNumbInSet());
        if(updatedCard.getPrice()!= 0) pkmn.setPrice(updatedCard.getPrice());
        pkmnRepo.updateCard(pkmn);
        return  1;
    }
}