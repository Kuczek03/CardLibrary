package pl.cardlibrary.CardLibrary.OnePiece;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/op")
public class OPController {
    //@Autowired
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
    public OPCard getID(@PathVariable("id")int id){
        return opRepo.getID(id);
    }

    @GetMapping("/set")
    public List<OPCard> getAllSet(){return opRepo.getAllSet();}



    @GetMapping("/set/{setId}")
    public List<OPCard> getSet(@PathVariable("setId") String setId){return opRepo.getSet(setId);}

    @PostMapping("/save")
    public String saveCard(@RequestBody List<OPCard> OPs){
        return opRepo.save(OPs);
    }

    @DeleteMapping("/delete/{id}")
    public int delete(@PathVariable("id") int id){
        return opRepo.delete(id);
    }

}
