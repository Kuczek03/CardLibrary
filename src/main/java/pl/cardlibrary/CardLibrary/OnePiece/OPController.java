package pl.cardlibrary.CardLibrary.OnePiece;


import org.jetbrains.annotations.NotNull;
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
        return opRepo.saveCard(OPs);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCard(@PathVariable("id") int id){
        return opRepo.deleteCard(id);
    }

    @PutMapping("/update/{id}")
    public int updateCard(@PathVariable("id") int id, @RequestBody @NotNull OPCard updatedCard){
        OPCard op = opRepo.getID(id);
        op.setName(updatedCard.getName());
        op.setTyp(updatedCard.getTyp());
        op.setSetId(updatedCard.getSetId());
        op.setNumbInSet(updatedCard.getNumbInSet());
        op.setPrice(updatedCard.getPrice());
        opRepo.updateCard(op);
        return  1;
    }

    @PatchMapping("/update/{id}")
    public int partiallyCard(@PathVariable("id") int id, @RequestBody @NotNull OPCard updatedCard){
        OPCard op = opRepo.getID(id);
        if(updatedCard.getName()!= null) op.setName(updatedCard.getName());
        if(updatedCard.getTyp()!= null) op.setTyp(updatedCard.getTyp());
        if(updatedCard.getSetId()!= null) op.setSetId(updatedCard.getSetId());
        if(updatedCard.getNumbInSet()!= null) op.setNumbInSet(updatedCard.getNumbInSet());
        if(updatedCard.getPrice()!= 0) op.setPrice(updatedCard.getPrice());
        opRepo.updateCard(op);
        return  1;
    }
}
