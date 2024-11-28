package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TopicDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("nazwa")
    private String nameTopic;
    @JsonProperty("id-zmienna")
    private int idVar;
    @JsonProperty("nazwa-zmienna")
    private String nameVar;

    public int getId() {
        return id;
    }

    public String getNameTopic() {
        return nameTopic;
    }

    public int getIdVar() {
        return idVar;
    }

    public String getNameVar() {
        return nameVar;
    }
}
