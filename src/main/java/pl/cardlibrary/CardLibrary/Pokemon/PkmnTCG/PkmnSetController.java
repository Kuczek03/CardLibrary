package pl.cardlibrary.CardLibrary.Pokemon.PkmnTCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PKMN/set")
public class PkmnSetController {
    @Autowired
    PkmnSetRepository pkmnSetRepo;

    @GetMapping("/all")
    public List<PkmnSet> getAll(){
        return pkmnSetRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public PkmnSet getID(@PathVariable("id")String id){
        return pkmnSetRepo.getID(id);
    }
    @PostMapping("/save")
    public String saveCard(@RequestBody List<PkmnSet> PKMNs){
        return pkmnSetRepo.saveCard(PKMNs);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCard(@PathVariable("id") String id){
        return pkmnSetRepo.deleteCard(id);
    }

    @PutMapping("/up/{id}")
    public String updateCard(@PathVariable("id") String setId, @RequestBody @NotNull PkmnSet updatedCard){
        PkmnSet pkmn = pkmnSetRepo.getID(setId);
        pkmn.setSetName(updatedCard.getSetName());
        pkmnSetRepo.updateCard(pkmn);
        return "Put";
    }

    @PatchMapping("/pup/{id}")
    public String partiallyCard(@PathVariable("id") String setId, @RequestBody @NotNull PkmnSet updatedCard){
        PkmnSet pkmn = pkmnSetRepo.getID(setId);
        if(updatedCard.getSetName()!= null) pkmn.setSetName(updatedCard.getSetName());
        pkmnSetRepo.updateCard(pkmn);
        return "Patched";
    }
}
