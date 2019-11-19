package cs.ucr.edu.baixi.operations;

import com.sun.codemodel.internal.JForEach;
import com.sun.tools.javac.util.Assert;
import cs.ucr.edu.baixi.models.DataModel;
import opennlp.tools.doccat.*;
import opennlp.tools.util.*;

import java.io.*;
import java.util.ArrayList;

public class Train {
    public void simpleTrain(ArrayList<DataModel> list) throws IOException {
        ObjectStream<DocumentSample> samples = ObjectStreamUtils.createObjectStream(
                new DocumentSample("1", new String[]{"a", "b", "c"}),
                new DocumentSample("1", new String[]{"a", "b", "c", "1", "2"}),
                new DocumentSample("1", new String[]{"a", "b", "c", "3", "4"}),
                new DocumentSample("0", new String[]{"x", "y", "z"}),
                new DocumentSample("0", new String[]{"x", "y", "z", "5", "6"}),
                new DocumentSample("0", new String[]{"x", "y", "z", "7", "8"})
        );
        TrainingParameters params = new TrainingParameters();
        params.put(TrainingParameters.ITERATIONS_PARAM, 100);
        params.put(TrainingParameters.CUTOFF_PARAM, 0);

        DoccatModel model = DocumentCategorizerME.train("x-unspecified", samples,
                params, new DoccatFactory());

        DocumentCategorizer doccat = new DocumentCategorizerME(model);

        double[] aProbs = doccat.categorize(new String[]{"a"});
        //Assert.assertEquals("1", doccat.getBestCategory(aProbs));

        double[] bProbs = doccat.categorize(new String[]{"x"});
        //Assert.assertEquals("0", doccat.getBestCategory(bProbs));

    }

    public DoccatModel trainTest(String path){
        DoccatModel model = null;
        InputStreamFactory dataIn = null;
        try {
            dataIn = new MarkableFileInputStreamFactory(new File(path));
            ObjectStream<String> lineStream = new PlainTextByLineStream(dataIn,"UTF-8");
            ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);
            TrainingParameters params = new TrainingParameters();
            params.put(TrainingParameters.ITERATIONS_PARAM, 100);
            params.put(TrainingParameters.CUTOFF_PARAM, 0);
            model = DocumentCategorizerME.train("en", sampleStream,params, new DoccatFactory());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return model;
    }

}
