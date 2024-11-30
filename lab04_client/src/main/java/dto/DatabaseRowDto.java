package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatabaseRowDto {
    @JsonProperty("rownumber")
    int rowNumber;
    @JsonProperty("id-zmienna")
    int idVar;
    @JsonProperty("id-przekroj")
    int idSection;
    @JsonProperty("id-wymiar-1")
    int idDimension1;
    @JsonProperty("id-pozycja-1")
    int idPosition1;
    @JsonProperty("id-wymiar-2")
    int idDimension2;
    @JsonProperty("id-pozycja-2")
    int idPosition2;
    @JsonProperty("id-wymiar-3")
    int idDimension3;
    @JsonProperty("id-pozycja-3")
    int idPosition3;
    @JsonProperty("wartosc")
    int value;

    public int getRowNumber() {
        return rowNumber;
    }

    public int getIdVar() {
        return idVar;
    }

    public int getIdSection() {
        return idSection;
    }

    public int getIdPosition1() {
        return idPosition1;
    }

    public int getValue() {
        return value;
    }

    public int getIdPosition2() {
        return idPosition2;
    }

    public int getIdPosition3() {
        return idPosition3;
    }
}
