package pl.cardlibrary.CardLibrary.Magic.MagicTCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/M/set")
public class MagicSetController {
    @Autowired
    MagicSetRepository mSetRepo;

    @GetMapping("/all")
    public List<MagicSet> getAll(){
        return mSetRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public MagicSet getID(@PathVariable("id")String id){
        return mSetRepo.getID(id);
    }
    @PostMapping("/save")
    public String saveCard(@RequestBody List<MagicSet> Ms){
        return mSetRepo.saveCard(Ms);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCard(@PathVariable("id") String id){
        return mSetRepo.deleteCard(id);
    }

    @PutMapping("/up/{id}")
    public String updateCard(@PathVariable("id") String setId, @RequestBody @NotNull MagicSet updatedCard){
        MagicSet m = mSetRepo.getID(setId);
        m.setSetName(updatedCard.getSetName());
        mSetRepo.updateCard(m);
        return "Put";
    }

    @PatchMapping("/pup/{id}")
    public String partiallyCard(@PathVariable("id") String setId, @RequestBody @NotNull MagicSet updatedCard){
        MagicSet m = mSetRepo.getID(setId);
        if(updatedCard.getSetName()!= null) m.setSetName(updatedCard.getSetName());
        mSetRepo.updateCard(m);
        return "Patched";
    }
}
