package labs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    private File inputFile;
    private File outputFile;
    private BufferedImage bufferedImage;

    // Constructor
    public Bitmap(String inputFilePath, String outputFilePath) {
        this.inputFile = new File(inputFilePath);
        this.outputFile = new File(outputFilePath);
        this.bufferedImage = this.getBufferedImage();
    }

    public BufferedImage getBufferedImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(inputFile);
        } catch (IOException error) {
            System.out.println(error);
        }
        return image;
    }

    public void writeBufferedImage() {
        try {
            ImageIO.write(this.bufferedImage, "BMP", this.outputFile);
        } catch (IOException error) {
            System.out.println(error);
        }
    }
}
