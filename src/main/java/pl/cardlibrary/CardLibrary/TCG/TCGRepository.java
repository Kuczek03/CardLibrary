package pl.cardlibrary.CardLibrary.TCG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.cardlibrary.CardLibrary.Pokemon.PkmnCard;

import java.util.List;

@Repository
public class TCGRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TCG> getAll() {
        return jdbcTemplate.query("SELECT * FROM TCG; ",
                BeanPropertyRowMapper.newInstance(TCG.class));
    }

    public TCG getID(int idTCG) {
        return jdbcTemplate.queryForObject("SELECT * FROM TCG WHERE idTCG=?;",
                BeanPropertyRowMapper.newInstance(TCG.class), idTCG);
    }

    public String saveCard(@org.jetbrains.annotations.NotNull List<TCG> Cards) {
        Cards.forEach(TCG -> jdbcTemplate.update("INSERT INTO TCG(nameTCG) VALUES(?)",
                TCG.getNameTCG()));
        return "Saved";
    }

    public int delete(int id){
        jdbcTemplate.update("DELETE FROM TCG WHERE idTCG=?" ,id);
        return 1;
    }
}
