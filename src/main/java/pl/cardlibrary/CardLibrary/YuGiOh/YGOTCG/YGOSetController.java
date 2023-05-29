package pl.cardlibrary.CardLibrary.YuGiOh.YGOTCG;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/YGO/set")
public class YGOSetController {
    @Autowired
    YGOSetRepository ygoSetRepo;

    @GetMapping("/all")
    public List<YGOSet> getAll(){
        return ygoSetRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public YGOSet getID(@PathVariable("id")String id){
        return ygoSetRepo.getID(id);
    }
    @PostMapping("/save")
    public String saveCard(@RequestBody List<YGOSet> YGOs){
        return ygoSetRepo.saveCard(YGOs);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCard(@PathVariable("id") String id){
        return ygoSetRepo.deleteCard(id);
    }

    @PutMapping("/up/{id}")
    public String updateCard(@PathVariable("id") String setId, @RequestBody @NotNull YGOSet updatedCard){
        YGOSet ygo = ygoSetRepo.getID(setId);
        ygo.setSetName(updatedCard.getSetName());
        ygoSetRepo.updateCard(ygo);
        return "Put";
    }

    @PatchMapping("/pup/{id}")
    public String partiallyCard(@PathVariable("id") String setId, @RequestBody @NotNull YGOSet updatedCard){
        YGOSet ygo = ygoSetRepo.getID(setId);
        if(updatedCard.getSetName()!= null) ygo.setSetName(updatedCard.getSetName());
        ygoSetRepo.updateCard(ygo);
        return "Patched";
    }
}
