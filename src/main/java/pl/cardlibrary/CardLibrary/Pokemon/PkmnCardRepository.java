package pl.cardlibrary.CardLibrary.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class PkmnCardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<PkmnCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM PkmnCards;",
                BeanPropertyRowMapper.newInstance(PkmnCard.class));
    }

    public PkmnCard getID(int idPKMN) {
        return jdbcTemplate.queryForObject("SELECT * FROM PkmnCards WHERE id=?;",
                BeanPropertyRowMapper.newInstance(PkmnCard.class), idPKMN);
    }

    public int save(@org.jetbrains.annotations.NotNull List<PkmnCard> PKMNs) {
        PKMNs.forEach(PkmnCard -> jdbcTemplate.update("INSERT INTO PkmnCards(pokemon, typ, setName, numberInSet, price) VALUES(?,?,?,?,?)",
                PkmnCard.getPokemon(), PkmnCard.getTyp(), PkmnCard.getSetName(), PkmnCard.getNumberInSet(), PkmnCard.getPrice()));
        return 1;
    }
}
