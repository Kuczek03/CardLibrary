package pl.cardlibrary.CardLibrary.TCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tcg")
public class TCGController {
    @Autowired
    TCGRepository tcgRepo;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

    @GetMapping("/all")
    public List<TCG> getAll(){
        return tcgRepo.getAll();
    }

    @GetMapping("/{id}")
    public TCG getID(@PathVariable("id")int idTCG){
        return tcgRepo.getID(idTCG);
    }

    @PostMapping("/save")
    public String saveCard(@RequestBody List<TCG> TCGs){
        return tcgRepo.saveCard(TCGs);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteCard(@PathVariable("id") int id){
        return tcgRepo.deleteCard(id);
    }

    @PutMapping("/up{id}")
    public int updateCard(@PathVariable("id") int id, @RequestBody @NotNull TCG updatedCard){
        TCG tcg = tcgRepo.getID(id);
        tcg.setNameTCG(updatedCard.getNameTCG());
        tcgRepo.updateCard(tcg);
        return  1;
    }
    @PutMapping("/pup/{id}")
    public int pariatllyCard(@PathVariable("id") int id, @RequestBody @NotNull TCG updatedCard){
        TCG tcg = tcgRepo.getID(id);
        if(updatedCard.getNameTCG()!=null) tcg.setNameTCG(updatedCard.getNameTCG());
        tcgRepo.updateCard(tcg);
        return  1;
    }
}
