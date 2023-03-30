import java.io.File;
import java.io.InputStream;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class ImageFactory {
    int width;
    int height;
    int newHeight;
    String text;

    public void create(String text, InputStream inputStream) throws Exception {
        BufferedImage image = ImageIO.read(inputStream);

        width = image.getWidth();
        height = image.getHeight();
        newHeight = height + 200;
        this.text = text;

        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(image, null, 0, 0);

        // Configuração da fonte
        var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setFont(font);
            
        FontMetrics fm = graphics.getFontMetrics();

        // Colocando o texto na imagem
        graphics.drawString(text, getCenterWidthText(fm, graphics), getCenterHeightText(fm, graphics));
            
        // filtro do endereço e do nome do arquivo
        String url = "images/" + text.replace(":", "") + ".png";
        ImageIO.write(newImage, "png", new File(url));
    }
    
    public float getCenterWidthText(FontMetrics fm, Graphics2D graphics) {
        return (width - fm.stringWidth(text)) / 2;
    }

    public float getCenterHeightText(FontMetrics fm, Graphics2D graphics) {
        return ((200 - fm.getHeight()) / 2 + fm.getAscent()) + height;
    }
}
