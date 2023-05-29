package pl.cardlibrary.CardLibrary.YuGiOh;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/yugioh")
public class YGOController {
    @Autowired
    YGORepository ygoRepo;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("/all")
    public List<YGOCard> getAll(){
        return ygoRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public YGOCard getID(@PathVariable("id")int id){
        return ygoRepo.getID(id);
    }

    @GetMapping("/set/{setId}")
    public List<YGOCard> getSet(@PathVariable("setId")String setId){return ygoRepo.getSet(setId);}

    @PostMapping("/save")
    public String saveCard(@RequestBody List<YGOCard> YGOs){
        return ygoRepo.saveCard(YGOs);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCard(@PathVariable("id") int id){
        return ygoRepo.deleteCard(id);
    }
    @PutMapping("/up/{id}")
    public String updateCard(@PathVariable("id") int id, @RequestBody YGOCard updatedCard){
        YGOCard ygo = ygoRepo.getID(id);
        ygo.setName(updatedCard.getName());
        ygo.setTyp(updatedCard.getTyp());
        ygo.setSetId(updatedCard.getSetId());
        ygo.setNumbInSet(updatedCard.getNumbInSet());
        ygo.setPrice(updatedCard.getPrice());
        ygoRepo.updateCard(ygo);
        return "Put";
    }

    @PatchMapping("/pup/{id}")
    public String partiallyCard(@PathVariable("id") int id, @RequestBody @NotNull YGOCard updatedCard){
        YGOCard ygo = ygoRepo.getID(id);
        if(updatedCard.getName()!= null) ygo.setName(updatedCard.getName());
        if(updatedCard.getTyp()!= null) ygo.setTyp(updatedCard.getTyp());
        if(updatedCard.getSetId()!= null) ygo.setSetId(updatedCard.getSetId());
        if(updatedCard.getNumbInSet()!= null) ygo.setNumbInSet(updatedCard.getNumbInSet());
        if(updatedCard.getPrice()!= 0) ygo.setPrice(updatedCard.getPrice());
        ygoRepo.updateCard(ygo);
        return "Patched";
    }
}
