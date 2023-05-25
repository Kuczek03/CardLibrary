package pl.cardlibrary.CardLibrary.YuGiOh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ygo")
public class YGOController {
    @Autowired
    YGORepository ygoRepo;

    @GetMapping("/test")
    public int test(){
        return 2137;
    }

    @GetMapping("/all")
    public List<YGOCard> getAll(){
        return ygoRepo.getAll();
    }

    @GetMapping("/{id}")
    public YGOCard getID(@PathVariable("id")int idYGO){
        return ygoRepo.getID(idYGO);
    }

    @PostMapping("")
    public int save(@RequestBody List<YGOCard> YGOs){
        return ygoRepo.save(YGOs);
    }

}
