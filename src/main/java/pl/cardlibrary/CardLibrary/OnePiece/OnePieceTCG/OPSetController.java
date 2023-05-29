package pl.cardlibrary.CardLibrary.OnePiece.OnePieceTCG;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OP/set")
public class OPSetController {
    @Autowired
    OPSetRepository opSetRepo;

    @GetMapping("/all")
    public List<OPSet> getAll(){
        return opSetRepo.getAll();
    }

    @GetMapping("/id/{id}")
    public OPSet getID(@PathVariable("id")String id){
        return opSetRepo.getID(id);
    }
    @PostMapping("/save")
    public String saveCard(@RequestBody List<OPSet> OPs){
        return opSetRepo.saveCard(OPs);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCard(@PathVariable("id") String id){
        return opSetRepo.deleteCard(id);
    }

    @PutMapping("/up/{id}")
    public String updateCard(@PathVariable("id") String setId, @RequestBody @NotNull OPSet updatedCard){
        OPSet ops = opSetRepo.getID(setId);
        ops.setSetName(updatedCard.getSetName());
        opSetRepo.updateCard(ops);
        return "Put";
    }

    @PatchMapping("/pup/{id}")
    public String partiallyCard(@PathVariable("id") String setId, @RequestBody @NotNull OPSet updatedCard){
        OPSet op = opSetRepo.getID(setId);
        if(updatedCard.getSetName()!= null) op.setSetName(updatedCard.getSetName());
        opSetRepo.updateCard(op);
        return "Patched";
    }
}
