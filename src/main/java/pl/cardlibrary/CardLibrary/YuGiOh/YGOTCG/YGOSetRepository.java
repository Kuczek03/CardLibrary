package pl.cardlibrary.CardLibrary.YuGiOh.YGOTCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YGOSetRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<YGOSet> getAll() {
        return jdbcTemplate.query("SELECT * FROM YuGiOhTCG;",
                BeanPropertyRowMapper.newInstance(YGOSet.class));
    }

    public YGOSet getID(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM YuGiOhTCG WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(YGOSet.class), id);
    }
    public String saveCard(@NotNull List<YGOSet> YGOs) {
        YGOs.forEach(YGO -> jdbcTemplate.update("INSERT INTO YuGiOhTCG(setId,setName) VALUES(?,?);",
                YGO.getSetId(),YGO.getSetName()));
        return "Saved";
    }

    public String deleteCard(String id){
        jdbcTemplate.update("DELETE FROM YuGiOhTCG WHERE setId=?;" ,id);
        return "Deleted";
    }

    public int updateCard(@NotNull YGOSet op){
        return jdbcTemplate.update("UPDATE YuGiOhTCG SET setName=? WHERE setId=?;",
                op.getSetName(),op.getSetId());
    }
}
