package pl.cardlibrary.CardLibrary.Pokemon.PkmnTCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PkmnSetRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PkmnSet> getAll() {
        return jdbcTemplate.query("SELECT * FROM PkmnTCG;",
                BeanPropertyRowMapper.newInstance(PkmnSet.class));
    }

    public PkmnSet getID(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM PkmnTCG WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(PkmnSet.class), id);
    }
    public String saveCard(@NotNull List<PkmnSet> PKMNs) {
        PKMNs.forEach(PKMN -> jdbcTemplate.update("INSERT INTO PkmnTCG(setId,setName) VALUES(?,?);",
                PKMN.getSetId(),PKMN.getSetName()));
        return "Saved";
    }

    public String deleteCard(String id){
        jdbcTemplate.update("DELETE FROM PkmnTCG WHERE setId=?;" ,id);
        return "Deleted";
    }

    public int updateCard(@NotNull PkmnSet op){
        return jdbcTemplate.update("UPDATE PkmnTCG SET setName=? WHERE setId=?;",
                op.getSetName(),op.getSetId());
    }
}
