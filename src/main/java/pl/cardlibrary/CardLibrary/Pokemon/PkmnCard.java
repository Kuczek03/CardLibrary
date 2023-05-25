package pl.cardlibrary.CardLibrary.Pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PkmnCard{

    private int idPKMN;
    private String pokemon;
    private String typ;
    private String setName;
    private String numberInSet;
    private double price;

}