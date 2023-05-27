package pl.cardlibrary.CardLibrary.OnePiece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.cardlibrary.CardLibrary.TCG.TCG;
import pl.cardlibrary.CardLibrary.TCG.TCGRepository;

import java.util.List;

@RestController
@RequestMapping("/op")
public class OPController {
    @Autowired
    OPRepository opRepo;

    @GetMapping("/test")
    public int test(){
        return 2137;
    }

    @GetMapping("/all")
    public List<OPCard> getAll(){
        return opRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public OPCard getID(@PathVariable("id")int idOP){
        return opRepo.getID(idOP);
    }

    @GetMapping("/set/{set}")
    public OPCard getSet(@PathVariable("set") String set){return  opRepo.getSet(set);}

    @PostMapping("")
    public int save(@RequestBody List<OPCard> OPs){
        return opRepo.save(OPs);
    }

}
