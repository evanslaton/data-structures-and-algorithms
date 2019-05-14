package labs;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    private File inputFile;
    private File outputFile;
    private BufferedImage bufferedImage;

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
    
    public void flipVertically() {
        for (int i = 0; i < this.bufferedImage.getHeight(); i++) {
            for (int j = 0; j < this.bufferedImage.getWidth() / 2; j++) {
                int temporaryData = this.bufferedImage.getRGB(i, j);
                this.bufferedImage.setRGB(i, j, this.bufferedImage.getRGB(i, this.bufferedImage.getWidth() - j - 1));
                this.bufferedImage.setRGB(i, this.bufferedImage.getWidth() - j - 1, temporaryData);
            }
        }

        this.writeBufferedImage();
    }

    public void writeBufferedImage() {
        try {
            ImageIO.write(this.bufferedImage, "BMP", this.outputFile);
        } catch (IOException error) {
            System.out.println(error);
        }
    }
}
