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

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList<DatabaseRowDto> getData() {
        return data;
    }

    public void setData(ArrayList<DatabaseRowDto> data) {
        this.data = data;
    }
}
