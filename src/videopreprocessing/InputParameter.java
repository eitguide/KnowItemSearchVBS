package videopreprocessing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by nguyennghia on 2/15/17.
 */
public class InputParameter {
    private String folderSourceVideoInput;
    private String folderDestinationFrame;
    private int x;
    private int y;

    public InputParameter() {
    }

    public InputParameter(String folderSourceVideoInput, String folderDestinationFrame, int x, int y) {
        this.folderSourceVideoInput = folderSourceVideoInput;
        this.folderDestinationFrame = folderDestinationFrame;
        this.x = x;
        this.y = y;
    }

    public String getFolderSourceVideoInput() {
        return folderSourceVideoInput;
    }

    public String getFolderDestinationFrame() {
        return folderDestinationFrame;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void readingInputParameterFromFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        folderSourceVideoInput = bufferedReader.readLine();
        folderDestinationFrame = bufferedReader.readLine();
        x = Integer.valueOf(bufferedReader.readLine());
        y = Integer.valueOf(bufferedReader.readLine());
    }
}
