package app;

import dataaccess.MainDataClient;
import dto.DatabaseRowDto;
import model.DatabaseRow;
import service.DtoToModel;

import java.io.IOException;
import java.util.ArrayList;

public class Application extends DtoToModel {
    public static void main(String[] args) throws IOException, InterruptedException {
        MainDataClient client = new MainDataClient();
        ArrayList<DatabaseRowDto> databaseRowDtoArrayList = new ArrayList<>(client.readLibraryData(2023));
        ArrayList<DatabaseRow> databaseRowsList = new ArrayList<>(convertToModel(databaseRowDtoArrayList));
        System.out.println(databaseRowsList.get(1).getValue());


//        TopicClient topicClient = new TopicClient();
//        ArrayList<TopicDto> topicsList = new ArrayList<>(topicClient.readTopic());
//        System.out.println(topicsList);

//        TitlesClient titlesClient = new TitlesClient();
//        ArrayList<SectionDto> titlesList = new ArrayList<>(titlesClient.readSectionsTitles(541));
//        System.out.println(titlesList);
    }
}
