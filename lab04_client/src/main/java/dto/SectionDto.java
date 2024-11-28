package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SectionDto {
    @JsonProperty("id-przekroj")
    private int idSection;
    @JsonProperty("id-wymiar")
    private int idDimension;
    @JsonProperty("nazwa-wymiar")
    private String nameDimension;
    @JsonProperty("id-pozycja")
    private int idPosition;
    @JsonProperty("nazwa-pozycja")
    private String namePosition;

    public int getIdSection() {
        return idSection;
    }

    public int getIdDimension() {
        return idDimension;
    }

    public String getNameDimension() {
        return nameDimension;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public int getIdPosition() {
        return idPosition;
    }
}
