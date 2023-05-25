package pl.cardlibrary.CardLibrary.YuGiOh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class YGORepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<YGOCard> getAll() {
        return jdbcTemplate.query("SELECT * FROM TCG; ",
                BeanPropertyRowMapper.newInstance(YGOCard.class));
    }

    public YGOCard getID(int idYGO) {
        return jdbcTemplate.queryForObject("SELECT * FROM TCG WHERE idTCG=?;",
                BeanPropertyRowMapper.newInstance(YGOCard.class), idYGO);
    }

    public int save(@org.jetbrains.annotations.NotNull List<YGOCard> YGOs) {
        YGOs.forEach(YGO -> jdbcTemplate.update("INSERT INTO TCG(nameTCG) VALUES(?)",
                YGO.getNameTCG()));
        return 1;
    }

}
