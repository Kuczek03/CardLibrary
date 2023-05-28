package pl.cardlibrary.CardLibrary.YuGiOh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cardlibrary.CardLibrary.Pokemon.PkmnCard;

import java.util.List;

@RestController
@RequestMapping("/ygo")
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

    @GetMapping("/set")
    public List<YGOCard> getAllSet(){return ygoRepo.getAllSet();}

    @GetMapping("/set/{setId}")
    public List<YGOCard> getSet(@PathVariable("setId")String setId){return ygoRepo.getSet(setId);}

    @PostMapping("/save")
    public String save(@RequestBody List<YGOCard> YGOs){
        return ygoRepo.save(YGOs);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") int id){
        return ygoRepo.delete(id);
    }
}
