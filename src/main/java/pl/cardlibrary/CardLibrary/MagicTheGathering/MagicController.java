package pl.cardlibrary.CardLibrary.MagicTheGathering;

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

    @GetMapping("/set")
    public List<MagicCard> getAllSet(){return mRepo.getAllSet();}
    @GetMapping("/set/{setId}")
    public List<MagicCard> getSet(@PathVariable("setId")String setId){return mRepo.getSet(setId);}

    @PostMapping("/save")
    public String saveCard(@RequestBody List<MagicCard> Ms){
        return mRepo.saveCard(Ms);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") int id){
        return mRepo.delete(id);
    }
}
