package pl.cardlibrary.CardLibrary.OnePiece.OnePieceTCG;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OPSetRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OPSet> getAll() {
        return jdbcTemplate.query("SELECT * FROM OnePieceTCG;",
                BeanPropertyRowMapper.newInstance(OPSet.class));
    }

    public OPSet getID(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM OnePieceTCG WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(OPSet.class), id);
    }
    public String saveCard(@org.jetbrains.annotations.NotNull List<OPSet> OPs) {
        OPs.forEach(OP -> jdbcTemplate.update("INSERT INTO OnePieceTCG(setId,setName) VALUES(?,?);",
                OP.getSetId(),OP.getSetName()));
        return "Saved";
    }

    public String deleteCard(String id){
        jdbcTemplate.update("DELETE FROM OnePieceTCG WHERE setId=?;" ,id);
        return "Deleted";
    }

    public int updateCard(@NotNull OPSet op){
        return jdbcTemplate.update("UPDATE OnePieceTCG SET setName=? WHERE setId=?;",
                op.getSetName(),op.getSetId());
    }
}
