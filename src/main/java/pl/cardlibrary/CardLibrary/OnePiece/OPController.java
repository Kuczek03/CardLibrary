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
        return 1;
    }

    @GetMapping("/all")
    public List<OPCard> getAll(){
        return opRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public OPCard getID(@PathVariable("id")int idOP){
        return opRepo.getID(idOP);
    }

    @GetMapping("/set")
    public List<OPCard> getAllSet(){return opRepo.getAllSet();}

    @GetMapping("/set/{setId}")
    public List<OPCard> getSet(@PathVariable("setId") String setId){return opRepo.getSet(setId);}

    @PostMapping("/save")
    public String saveCard(@RequestBody List<OPCard> OPs){
        return opRepo.save(OPs);
    }

    @PostMapping("/delete")
    public String delCard(@RequestBody List<OPCard> OPs){return opRepo.delCard(OPs);}
}
