import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by erez on 06/08/2016.
 */
public class TestMain {
    public static void main(String[] args) {

//        texFileHandler f = new texFileHandler();
//        BufferedReader chatTextFile = f.openChatTextFile();
//        String Line = f.readOneLine(chatTextFile);
//        System.out.println("Current line is:\n\n" + Line);
//        System.out.println("The date in the line is: "+f.extractDate(Line));
//        System.out.println("The time in the line is: "+f.extractTime(Line));

        createPDF newPDF = new createPDF();
        try {
            newPDF.createPDF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
