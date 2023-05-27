package pl.cardlibrary.CardLibrary.MagicTheGathering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class MagicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MagicCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM CardLibrary.Magic; ",
                BeanPropertyRowMapper.newInstance(MagicCard.class));
    }

    public MagicCard getID(int idM) {
        return jdbcTemplate.queryForObject("SELECT * FROM CardLibrary.Magic WHERE idM=?;",
                BeanPropertyRowMapper.newInstance(MagicCard.class), idM);
    }

    public List<MagicCard> getAllSet(){
        return jdbcTemplate.query("SELECT * FROM MagicTCG;",
                BeanPropertyRowMapper.newInstance(MagicCard.class));
    }

    public List<MagicCard> getSet(String setId) {
        return jdbcTemplate.query("SELECT * FROM Magic WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(MagicCard.class), setId);
    }

    public String saveCard(@org.jetbrains.annotations.NotNull List<MagicCard> Ms) {
        Ms.forEach(Magic -> jdbcTemplate.update("INSERT INTO CardLibrary.Magic(name,typ,setId,numbInSet,price) VALUES(?,?,?,?,?)",
                Magic.getName(),Magic.getTyp(),Magic.getSetId(),Magic.getNumbInSet(),Magic.getPrice()));
        return "Saved";
    }

    public String delCard(@org.jetbrains.annotations.NotNull List<MagicCard> Ms) {
        Ms.forEach(MagicCard -> jdbcTemplate.update("DELETE FROM Magic WHERE idM=?;"));
        return "Deleted";
    }
}
