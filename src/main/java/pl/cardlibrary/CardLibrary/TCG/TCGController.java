package pl.cardlibrary.CardLibrary.TCG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TCGController {
    @Autowired
    TCGRepository tcgRepo;

    @GetMapping("/test")
    public int test(){
        return 2137;
    }

    @GetMapping("/all")
    public List<TCG> getAll(){
        return tcgRepo.getAll();
    }

    @GetMapping("/{id}")
    public TCG getID(@PathVariable("id")int idTCG){
        return tcgRepo.getID(idTCG);
    }

    @PostMapping("")
    public int save(@RequestBody List<TCG> TCGs){
        return tcgRepo.save(TCGs);
    }

}
