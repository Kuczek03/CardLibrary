package pl.cardlibrary.CardLibrary.Magic;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/magic")
public class MagicController {
    @Autowired
    MagicRepository mRepo;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("/all")
    public List<MagicCard> getAll(){
        return mRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public MagicCard getID(@PathVariable("id")int id){
        return mRepo.getID(id);
    }

    @GetMapping("/set/{setId}")
    public List<MagicCard> getSet(@PathVariable("setId")String setId){return mRepo.getSet(setId);}

    @PostMapping("/save")
    public String saveCard(@RequestBody List<MagicCard> Ms){
        return mRepo.saveCard(Ms);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        return mRepo.deleteCard(id);
    }

    @PutMapping("/up/{id}")
    public String updateCard(@PathVariable("id") int id, @RequestBody @NotNull MagicCard updatedCard){
        MagicCard m = mRepo.getID(id);
        m.setName(updatedCard.getName());
        m.setTyp(updatedCard.getTyp());
        m.setSetId(updatedCard.getSetId());
        m.setNumbInSet(updatedCard.getNumbInSet());
        m.setPrice(updatedCard.getPrice());
        mRepo.updateCard(m);
        return "Put";
    }

    @PatchMapping("/pup/{id}")
    public String partiallyCard(@PathVariable("id") int id, @RequestBody @NotNull MagicCard updatedCard){
        MagicCard m = mRepo.getID(id);
        if(updatedCard.getName()!= null) m.setName(updatedCard.getName());
        if(updatedCard.getTyp()!= null) m.setTyp(updatedCard.getTyp());
        if(updatedCard.getSetId()!= null) m.setSetId(updatedCard.getSetId());
        if(updatedCard.getNumbInSet()!= null) m.setNumbInSet(updatedCard.getNumbInSet());
        if(updatedCard.getPrice()!= 0) m.setPrice(updatedCard.getPrice());
        mRepo.updateCard(m);
        return "Patched";
    }
}
