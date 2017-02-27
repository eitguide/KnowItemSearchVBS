package videopreprocessing;

/**
 * Created by nguyennghia on 2/15/17.
 */
public class FfmpegCommand {
    public static String convert_file(String inputFile, String outputFile){
        return String.format("ffmpeg -i \"%s\" \"%s\"", inputFile, outputFile);
    }

    public static String extract_frame(String inputFile, String outputFile, int x, int y){
        return String.format("ffmpeg -i \"%s\" \"%s\"", inputFile, outputFile, x, y);
    }

    public static String extract_frame(String inputFile, String outputFile, int x, int y, String size){
        return String.format("ffmpeg -i \"%s\" \"%s\" %d %d \"%s\"", inputFile, outputFile, x, y, size);
    }

    public static String extract_frame_fps(String inputFile, String outputFile, int numberFramePerSencondTake){
        return String.format("ffmpeg -i %s -vf fps=1/%d %s", inputFile, numberFramePerSencondTake, outputFile);
    }

    public static String get_video_duration(String inputFile){
        return String.format("ffmpeg -i %s", inputFile);
    }
}
