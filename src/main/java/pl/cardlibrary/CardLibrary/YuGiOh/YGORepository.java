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
        return jdbcTemplate.query("SELECT * FROM YuGiOh; ",
                BeanPropertyRowMapper.newInstance(YGOCard.class));
    }

    public YGOCard getID(int idYGO) {
        return jdbcTemplate.queryForObject("SELECT * FROM YuGiOh WHERE idYGO=?;",
                BeanPropertyRowMapper.newInstance(YGOCard.class), idYGO);
    }

    public int save(@org.jetbrains.annotations.NotNull List<YGOCard> YGOs) {
        YGOs.forEach(YGO -> jdbcTemplate.update("INSERT INTO YuGiOh(name,typ,setId,numbInSet,price) VALUES(?,?,?,?,?)",
                YGO.getName(),YGO.getTyp(),YGO.getNumbInSet(),YGO.getPrice()));
        return 1;
    }

}
