package pl.cardlibrary.CardLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CardRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Card> getAll(){
        return jdbcTemplate.query("SELECT * FROM Cards",
                BeanPropertyRowMapper.newInstance(Card.class));
    }
    public Card getById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM Cards WHERE id=?",
                BeanPropertyRowMapper.newInstance(Card.class), id);
    }

    public int save(List<Card> Cards) {
        Cards.forEach(Card -> jdbcTemplate.update("INSERT INTO Cards(pokemon, typ, setName, numberInSet, price VALUES (?,?,?,?,?)",
                Card.getPokemon(),Card.getTyp(), Card.getSetName(), Card.getNumberInSet(),Card.getPrice()
                ));
        return 1;
    }
}
