package pl.cardlibrary.CardLibrary.OnePiece;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OPCard {

    private int id;
    private String name;
    private String typ;
    private String setId;
    private String numbInSet;
    private double price;

}
