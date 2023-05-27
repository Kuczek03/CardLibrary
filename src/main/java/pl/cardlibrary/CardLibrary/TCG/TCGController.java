package pl.cardlibrary.CardLibrary.TCG;

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

    @PostMapping("/delete")
    public String delCard(@RequestBody List<TCG> TCGs){return tcgRepo.delCard(TCGs);}
}
