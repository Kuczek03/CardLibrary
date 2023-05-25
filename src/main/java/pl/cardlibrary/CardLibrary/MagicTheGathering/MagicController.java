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
        return 2137;
    }

    @GetMapping("/all")
    public List<MagicCard> getAll(){
        return mRepo.getAll();
    }

    @GetMapping("/{id}")
    public MagicCard getID(@PathVariable("id")int idM){
        return mRepo.getID(idM);
    }

    @PostMapping("")
    public int save(@RequestBody List<MagicCard> Ms){
        return mRepo.save(Ms);
    }

}
