package clientservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataaccess.SectionClient;
import dataaccess.TopicClient;
import dto.DatabaseRowDto;
import dto.ResponseDatabaseRowDto;
import dto.SectionDto;
import dto.TopicDto;
import model.DatabaseRow;

import java.io.IOException;
import java.util.ArrayList;

public abstract class ClientService {

    public static ArrayList<DatabaseRow> convertToModel(ArrayList<DatabaseRowDto> DatabaseRowDtosList) throws IOException, InterruptedException {

        ArrayList<DatabaseRow> databaseRowsList = new ArrayList<>();

        TopicClient topicClient = new TopicClient();
        ArrayList<TopicDto> topicsList = new ArrayList<>(topicClient.readTopic());
        SectionClient sectionClient = new SectionClient();
        ArrayList<SectionDto> sectionsList = new ArrayList<>(sectionClient.readSectionsTitles(DatabaseRowDtosList.getFirst().getIdSection()));

        for(DatabaseRowDto databaseRowDto : DatabaseRowDtosList) {
            int rowNumber = databaseRowDto.getRowNumber();
            int value = databaseRowDto.getValue();
            String nameVar = "";
            String nameSection = "";
            String nameDimension1 = "";
            String nameDimension2 = "";
            String nameDimension3 = "";
            String namePosition1 = "";
            String namePosition2 = "";
            String namePosition3 = "";

            for (TopicDto topicDto : topicsList) {
                if(topicDto.getIdVar() == databaseRowDto.getIdVar())
                    nameVar = topicDto.getNameVar();
            }
            for(SectionDto sectionDto : sectionsList) {
                if(sectionDto.getIdPosition()==databaseRowDto.getIdPosition1()) {
                    nameDimension1 = sectionDto.getNameDimension();
                    namePosition1 = sectionDto.getNamePosition();
                }
                if(sectionDto.getIdPosition()==databaseRowDto.getIdPosition2()) {
                    nameDimension2 = sectionDto.getNameDimension();
                    namePosition2 = sectionDto.getNamePosition();
                }
                if(sectionDto.getIdPosition()==databaseRowDto.getIdPosition3()) {
                    nameDimension3 = sectionDto.getNameDimension();
                    namePosition3 = sectionDto.getNamePosition();
                }
            }
            databaseRowsList.add(new DatabaseRow(rowNumber, nameVar, nameSection, nameDimension1, nameDimension2, nameDimension3, namePosition1, namePosition2, namePosition3, value));
        }

        return databaseRowsList;
    }

    public static ArrayList<DatabaseRowDto> dataDeserialization(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseDatabaseRowDto responseDatabaseRowDto = mapper.readValue(response, ResponseDatabaseRowDto.class);
        return responseDatabaseRowDto.getData();
    }

    public static ArrayList<SectionDto> sectionDeserialization(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, new TypeReference<>() {});
    }

    public static ArrayList<TopicDto> topicDeserialization(String response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response, new TypeReference<>() {});
    }
}
