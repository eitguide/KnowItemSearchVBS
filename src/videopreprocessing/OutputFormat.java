package videopreprocessing;

/**
 * Created by nguyennghia on 2/15/17.
 */
public class OutputFormat {
    public static String getOutputFormat(String fileName, ImageExtension extension, int duration) {
        String result = String.format("name_%s##frame_%s##duration_%d", fileName, "%03d", duration);
        switch (extension) {
            case BMP:
                result += ".bmp";
                break;
            case JPG:
                result += ".jpg";
                break;
            case PNG:
                result += ".png";
                break;
            case PGM:
                result += ".pgm";
            default:
        }
        return result;
    }
}
