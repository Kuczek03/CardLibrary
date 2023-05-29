package pl.cardlibrary.CardLibrary.OnePiece;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class OPRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OPCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM OnePiece;",
                BeanPropertyRowMapper.newInstance(OPCard.class));
    }

    public OPCard getID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM OnePiece WHERE id=?;",
                BeanPropertyRowMapper.newInstance(OPCard.class), id);
    }

    public List<OPCard> getAllSet(){
        return jdbcTemplate.query("SELECT * FROM OnePieceTCG;",
                BeanPropertyRowMapper.newInstance(OPCard.class));
    }
    public List<OPCard> getSet(String setId){
        return jdbcTemplate.query("SELECT * FROM OnePiece WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(OPCard.class), setId);
    }

    public String saveCard(@org.jetbrains.annotations.NotNull List<OPCard> OPs) {
        OPs.forEach(OP -> jdbcTemplate.update("INSERT INTO OnePiece(name,typ,setId,numbInSet,price) VALUES(?,?,?,?,?);",
                OP.getName(),OP.getTyp(),OP.getSetId(),OP.getNumbInSet(),OP.getPrice()));
        return "Saved";
    }

     public int deleteCard(int id){
         jdbcTemplate.update("DELETE FROM OnePiece WHERE id=?;" ,id);
         return 1;
     }

    public int updateCard(@NotNull OPCard op){
        return jdbcTemplate.update("UPDATE OnePiece SET name=?,typ=?,setId=?,numbInSet=?,price=? WHERE id=?;",
                op.getId(),op.getName(),op.getTyp(),op.getSetId(),op.getNumbInSet(),op.getPrice());
    }
}
