package pl.cardlibrary.CardLibrary.Magic.MagicTCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MagicSetRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MagicSet> getAll() {
        return jdbcTemplate.query("SELECT * FROM MagicTCG;",
                BeanPropertyRowMapper.newInstance(MagicSet.class));
    }

    public MagicSet getID(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM MagicTCG WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(MagicSet.class), id);
    }
    public String saveCard(@NotNull List<MagicSet> Ms) {
        Ms.forEach(M -> jdbcTemplate.update("INSERT INTO MagicTCG(setId,setName) VALUES(?,?);",
                M.getSetId(),M.getSetName()));
        return "Saved";
    }

    public String deleteCard(String id){
        jdbcTemplate.update("DELETE FROM MagicTCG WHERE setId=?;" ,id);
        return "Deleted";
    }

    public int updateCard(@NotNull MagicSet m){
        return jdbcTemplate.update("UPDATE MagicTCG SET setName=? WHERE setId=?;",
                m.getSetName(),m.getSetId());
    }
}
