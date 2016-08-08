import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class texFileHandler {

     /* Open the conversation file in the local workspace and return its bufferReader*/
    BufferedReader openChatTextFile() {
        Charset charset = Charset.forName("UTF-8");

        Path conversationFile = Paths.get(System.getProperty("user.dir"), "conversation.txt");

        BufferedReader chatFile = null;
        try {
            chatFile = Files.newBufferedReader(conversationFile, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return chatFile;

    }

    /* read one line from the conversation file. if no more line the return EOF string*/
    String readOneLine(BufferedReader chatFile) {
        String Line = null;
        try {
            if (chatFile.readLine() != null) {
                Line = chatFile.readLine();
            }else {

                Line = "EOF";
            }

        } catch (IOException ie) {
            //TODO change the print to the appropriate output
            System.out.println(ie);
        }
        return Line;
    }


    /* close the conversation file*/
    void closeChatTextFile(BufferedReader chatFile){
        try {
            chatFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*extract the date from the line*/
    String extractDate(String Line){
        final String dateREGEX = "\\d\\d[/]\\d\\d[/]\\d\\d";
        Pattern pattern = Pattern.compile(dateREGEX);
        Matcher matcher = pattern.matcher(Line);
        if (matcher.find()){
            return matcher.group();
        }else {
            return null;
        }
    }

    /*extract the time(hours:minutes) from the line*/
    String extractTime(String Line){
        //TODO Extract the time from the line
        final String dateREGEX = "\\d\\d[:]\\d\\d";
        Pattern pattern = Pattern.compile(dateREGEX);
        Matcher matcher = pattern.matcher(Line);
        if (matcher.find()){
            return matcher.group();
        }else {
            return null;
        }
    }

    /*parse the line for text or attachment. if it is an attachment
    * image = 1
    * video = 2
    * if a string return 0
    * */
    int parseLine(){
        //TODO analyze the line with regular expression
        //TODO should be scalable for other attachments
        return 0;
    }


    /*Extract the name or number of the sender
    * if sent by me check for indication*/
    String extractName(String Line){
        //TODO Extract the name of the sender or number of the sender
        //TODO Check what is there if the message is sent and not received, Decide on an indication suitable for the pdf
        return null;
    }


    /* check if it is a text line
    * if so return the text
    * if an attachment rerun null*/
    String extarctText(String Line){
        //TODO Check if it is a text line
        //TODO Extract the text from the line
        return null;
    }


}


