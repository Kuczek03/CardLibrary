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

    @GetMapping("/set/{idS}")
    public PkmnCard getSet(@PathVariable("idS")String setId){return pkmnRepo.getSet(setId);}


    @PostMapping("")
    public int save(@RequestBody List<PkmnCard> PKMNs){
        return pkmnRepo.save(PKMNs);
    }
}