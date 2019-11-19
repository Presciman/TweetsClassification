package cs.ucr.edu.baixi.utils;

import cs.ucr.edu.baixi.models.DataModel;

import java.util.ArrayList;

public class Converter {
    //TODO use the dataString line and model template to convert json to model(POJO)
    public ArrayList<DataModel> convert(ArrayList<String[]> content){
        ArrayList<DataModel> outputList= new ArrayList<DataModel>();
        for(String[] s_array : content)
        {
            for(String s : s_array)
            {
                if(s.contains("full_text") && s.split(":").length < 2)
                {
                    System.out.println("xxxfulltext # "+s.split(":")[1]);
                }
                if(s.contains("id"))
                {
                    //System.out.println("xxxid # "+s.split(":")[1]);
                }
                if(s.contains("friends_count"))
                {
                    //System.out.println("xxxfcount # "+s.split(":")[1]);
                }
                if(s.contains("source"))
                {
                    System.out.println("xxxsource # "+s.split("=")[1]);
                }
                if(s.contains("statuses_count"))
                {
                    //System.out.println("xxxstatuses # "+s.split(":")[1]);
                }
            }
            System.out.println("************************");
        }
        return outputList;
    }
}
