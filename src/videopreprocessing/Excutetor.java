package videopreprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nguyennghia on 2/15/17.
 */
public class Excutetor {
    public static Process exec(String command) throws IOException {
       return Runtime.getRuntime().exec(command);
    }

    public static String execWithMessage(String command) throws IOException {

//         BufferedReader errorBufferReader = new BufferedReader(new InputStreamReader(exec(command).getErrorStream()));
//         Logger.e(errorBufferReader.readLine());


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec(command).getInputStream()));
        String line  = null;
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null){
            stringBuffer.append(line + "\n");
        }

        return  stringBuffer.toString().trim();
    }
}
