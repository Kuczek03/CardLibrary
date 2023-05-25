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
        return jdbcTemplate.query("SELECT * FROM TCG; ",
                BeanPropertyRowMapper.newInstance(MagicCard.class));
    }

    public MagicCard getID(int idM) {
        return jdbcTemplate.queryForObject("SELECT * FROM TCG WHERE idTCG=?;",
                BeanPropertyRowMapper.newInstance(MagicCard.class), idM);
    }

    public int save(@org.jetbrains.annotations.NotNull List<MagicCard> Ms) {
        Ms.forEach(Magic -> jdbcTemplate.update("INSERT INTO TCG(nameTCG) VALUES(?)",
                Magic.getNameTCG()));
        return 1;
    }

}
