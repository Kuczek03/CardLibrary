package pl.cardlibrary.CardLibrary.OnePiece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardlibrary.CardLibrary.Pokemon.PkmnCard;

import java.util.List;

@Repository
public class OPRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<OPCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM OnePiece;",
                BeanPropertyRowMapper.newInstance(OPCard.class));
    }

    public OPCard getID(int idOP) {
        return jdbcTemplate.queryForObject("SELECT * FROM OnePiece WHERE idOP=?;",
                BeanPropertyRowMapper.newInstance(OPCard.class), idOP);
    }

    public int save(@org.jetbrains.annotations.NotNull List<OPCard> OPs) {
        OPs.forEach(OP -> jdbcTemplate.update("INSERT INTO OnePiece(name,typ,setId,numbInSet,price) VALUES(?,?,?,?,?)",
                OP.getName(),OP.getTyp(),OP.getSetId(),OP.getNumbInSet(),OP.getPrice()));
        return 1;
    }

    public OPCard getSet(String setId){
        return jdbcTemplate.queryForObject("SELECT * FROM OnePiece WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(OPCard.class), setId);
    }

}
