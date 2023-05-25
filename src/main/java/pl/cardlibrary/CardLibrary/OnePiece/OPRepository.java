package pl.cardlibrary.CardLibrary.OnePiece;

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
        return jdbcTemplate.query("SELECT * FROM OP; ",
                BeanPropertyRowMapper.newInstance(OPCard.class));
    }

    public OPCard getID(int idOP) {
        return jdbcTemplate.queryForObject("SELECT * FROM OP WHERE idOP=?;",
                BeanPropertyRowMapper.newInstance(OPCard.class), idOP);
    }

    public int save(@org.jetbrains.annotations.NotNull List<OPCard> Cards) {
        Cards.forEach(OP -> jdbcTemplate.update("INSERT INTO OP(nameTCG) VALUES(?)",
                OP.getNameTCG()));
        return 1;
    }

}
