package cs.ucr.edu.baixi.utils;

import cs.ucr.edu.baixi.models.DataModel;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DatasetReader {
    public ArrayList<DataModel> read(String path){
        File inData = new File(path);
        ArrayList<DataModel> list = new ArrayList<DataModel>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(inData));
            String currLine = null;
            int lineNum = 1;
            while((currLine = reader.readLine()) != null)
            {
                DataModel dataModel = new DataModel();
                String[] s_array = currLine.split(";");
                if(s_array.length == 2)
                {
                    dataModel.setUsername(s_array[0]);
                    dataModel.setFulltext(s_array[1]);
                    list.add(dataModel);
                    lineNum ++;
                }
            }
            System.out.println("total amount of data line00: "+lineNum);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
