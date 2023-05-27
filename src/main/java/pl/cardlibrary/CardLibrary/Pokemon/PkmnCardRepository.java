package pl.cardlibrary.CardLibrary.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardlibrary.CardLibrary.TCG.TCG;

import java.util.List;

@Repository
public class PkmnCardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PkmnCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM Pkmn;",
                BeanPropertyRowMapper.newInstance(PkmnCard.class));
    }

    public PkmnCard getID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Pkmn WHERE Pkmn.id=?;",
                BeanPropertyRowMapper.newInstance(PkmnCard.class), id);
    }

    public List<PkmnCard> getAllSet(){
        return jdbcTemplate.query("SELECT * FROM PkmnTCG;",
                BeanPropertyRowMapper.newInstance(PkmnCard.class));
    }

    public List<PkmnCard> getSet(String setId) {
        return jdbcTemplate.query("SELECT * FROM Pkmn WHERE setId=?;",
                BeanPropertyRowMapper.newInstance(PkmnCard.class), setId);
    }

    public String saveCard(@org.jetbrains.annotations.NotNull List<PkmnCard> PKMNs) {
        PKMNs.forEach(PkmnCard -> jdbcTemplate.update("INSERT INTO Pkmn(name, typ, setId, numbInSet, price) VALUES(?,?,?,?,?)",
                PkmnCard.getName(), PkmnCard.getTyp(), PkmnCard.getSetId(), PkmnCard.getNumbInSet(), PkmnCard.getPrice()));
        return "Saved";
    }

   public String delCard(@org.jetbrains.annotations.NotNull List<PkmnCard> PKMNs) {
       PKMNs.forEach(PkmnCard -> jdbcTemplate.update("DELETE FROM Pkmn WHERE id=?;"));
       return "Deleted";
   }

}
