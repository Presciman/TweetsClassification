package cs.ucr.edu.baixi.operations;

import cs.ucr.edu.baixi.models.DataModel;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;

import java.io.InputStream;
import java.util.ArrayList;

public class Categorizer {
    public String categorize(DoccatModel m, ArrayList<DataModel> dmList){
        String category = null;
        //for(DataModel dm : dmList)
        //{
            String inputText = "Flushes the in-memory cache of user information, including credentials and roles.";
            String[] inputTextArray = inputText.split(" ");
            DocumentCategorizerME myCategorizer = new DocumentCategorizerME(m);
            double[] outcomes = myCategorizer.categorize(inputTextArray);
            category = myCategorizer.getBestCategory(outcomes);
            //We hereby regard the outcome array value on the index as the distance between train data line and test data line
            for(double d : outcomes)
            {
                System.out.println("distance: "+d);
            }
            System.out.println("Suggested category: "+category);
            //第一个字段category，设计category种类并设计数据进行分类
        //}
        return category;
    }
}
