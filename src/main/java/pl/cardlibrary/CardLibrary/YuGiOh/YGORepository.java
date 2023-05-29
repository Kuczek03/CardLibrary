package pl.cardlibrary.CardLibrary.YuGiOh;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class YGORepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<YGOCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM YuGiOh; ",
                BeanPropertyRowMapper.newInstance(YGOCard.class));
    }

    public YGOCard getID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM YuGiOh WHERE id=?;",
                BeanPropertyRowMapper.newInstance(YGOCard.class), id);
    }

    public List<YGOCard> getSet(String setId){
        return jdbcTemplate.query("SELECT * FROM YuGiOh WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(YGOCard.class), setId);
    }

    public List<YGOCard> getAllSet(){
        return jdbcTemplate.query("SELECT * FROM YuGiOhTCG;",
                BeanPropertyRowMapper.newInstance(YGOCard.class));
    }

    public String saveCard(@org.jetbrains.annotations.NotNull List<YGOCard> YGOs) {
        YGOs.forEach(YGO -> jdbcTemplate.update("INSERT INTO YuGiOh(name,typ,setId,numbInSet,price) VALUES(?,?,?,?,?);",
                YGO.getName(),YGO.getTyp(),YGO.getNumbInSet(),YGO.getPrice()));
        return "Saved";
    }

    public int deleteCard(int id){
        jdbcTemplate.update("DELETE FROM YuGiOh WHERE id=?;" ,id);
        return 1;
    }

    public int updateCard(@NotNull YGOCard ygo){
        return jdbcTemplate.update("UPDATE YuGiOh SET name=?,typ=?,setId=?,numbInSet=?,price=? WHERE id=?;",
                ygo.getName(),ygo.getTyp(),ygo.getSetId(),ygo.getNumbInSet(),ygo.getPrice(),ygo.getId());
    }
}
