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
    @JsonProperty("id-okres")
    int idPeriod;
    @JsonProperty("wartosc")
    int value;

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getIdVar() {
        return idVar;
    }

    public void setIdVar(int idVar) {
        this.idVar = idVar;
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public int getIdDimension1() {
        return idDimension1;
    }

    public void setIdDimension1(int idDimension1) {
        this.idDimension1 = idDimension1;
    }

    public int getIdPosition1() {
        return idPosition1;
    }

    public void setIdPosition1(int idPosition1) {
        this.idPosition1 = idPosition1;
    }

    public int getIdDimension2() {
        return idDimension2;
    }

    public void setIdDimension2(int idDimension2) {
        this.idDimension2 = idDimension2;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIdPosition2() {
        return idPosition2;
    }

    public void setIdPosition2(int idPosition2) {
        this.idPosition2 = idPosition2;
    }

    public int getIdDimension3() {
        return idDimension3;
    }

    public void setIdDimension3(int idDimension3) {
        this.idDimension3 = idDimension3;
    }

    public int getIdPosition3() {
        return idPosition3;
    }

    public void setIdPosition3(int idPosition3) {
        this.idPosition3 = idPosition3;
    }

    public int getIdPeriod() {
        return idPeriod;
    }

    public void setIdPeriod(int idPeriod) {
        this.idPeriod = idPeriod;
    }
}
