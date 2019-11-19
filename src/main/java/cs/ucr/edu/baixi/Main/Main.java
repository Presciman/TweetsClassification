package cs.ucr.edu.baixi.Main;

import cs.ucr.edu.baixi.models.DataModel;
import cs.ucr.edu.baixi.operations.Categorizer;
import cs.ucr.edu.baixi.operations.Train;
import cs.ucr.edu.baixi.utils.Converter;
import cs.ucr.edu.baixi.utils.DatasetReader;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.util.ObjectStream;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        DatasetReader datasetReader = new DatasetReader();
        Converter converter = new Converter();
        String path = "/Users/ericsun/IdeaProjects/opennlptest/data/data";
        ArrayList<DataModel> content = datasetReader.read(path);
        for(DataModel dm : content)
        {
            System.out.println(dm.getFulltext());
        }
        //TODO use the content to train
        Train train = new Train();
        DoccatModel doccatModel = train.trainTest(path);
        //TODO categorize
        Categorizer categorizer = new Categorizer();
        categorizer.categorize(doccatModel, content);



    }
}
