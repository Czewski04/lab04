package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDatabaseRowDto {
    @JsonProperty("page-number")
    private int pageNumber;

    @JsonProperty("page-size")
    private int pageSize;

    @JsonProperty("page-count")
    private int pageCount;

    @JsonProperty("data")
    private ArrayList<DatabaseRowDto> data;

    public ArrayList<DatabaseRowDto> getData() {
        return data;
    }
}
