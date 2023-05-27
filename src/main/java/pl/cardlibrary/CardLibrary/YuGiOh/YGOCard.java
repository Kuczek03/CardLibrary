package pl.cardlibrary.CardLibrary.YuGiOh;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YGOCard {

    private int idYGO;
    private String name;
    private String typ;
    private String setId;
    private String numbInSet;
    private double price;

}
