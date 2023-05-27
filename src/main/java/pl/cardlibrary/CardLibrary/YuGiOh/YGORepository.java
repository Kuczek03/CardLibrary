package pl.cardlibrary.CardLibrary.YuGiOh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardlibrary.CardLibrary.Pokemon.PkmnCard;


import java.util.List;

@Repository
public class YGORepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<YGOCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM YuGiOh; ",
                BeanPropertyRowMapper.newInstance(YGOCard.class));
    }

    public YGOCard getID(int idYGO) {
        return jdbcTemplate.queryForObject("SELECT * FROM YuGiOh WHERE idYGO=?;",
                BeanPropertyRowMapper.newInstance(YGOCard.class), idYGO);
    }

    public List<YGOCard> getSet(String setId){
        return jdbcTemplate.query("SELECT * FROM YuGiOh WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(YGOCard.class), setId);
    }

    public List<YGOCard> getAllSet(){
        return jdbcTemplate.query("SELECT * FROM YuGiOhTCG;",
                BeanPropertyRowMapper.newInstance(YGOCard.class));
    }

    public String save(@org.jetbrains.annotations.NotNull List<YGOCard> YGOs) {
        YGOs.forEach(YGO -> jdbcTemplate.update("INSERT INTO YuGiOh(name,typ,setId,numbInSet,price) VALUES(?,?,?,?,?)",
                YGO.getName(),YGO.getTyp(),YGO.getNumbInSet(),YGO.getPrice()));
        return "Saved";
    }

    public String delCard(@org.jetbrains.annotations.NotNull List<YGOCard> YGOs) {
        YGOs.forEach(YGOCard -> jdbcTemplate.update("DELETE FROM YuGiOh WHERE id=?;"));
        return "Deleted";
    }
}
