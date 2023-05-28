package pl.cardlibrary.CardLibrary.Pokemon;
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
    public int delete(@PathVariable("id") int id){
        return pkmnRepo.delete(id);
    }
}