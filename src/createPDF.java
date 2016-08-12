import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.*;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

//import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by erez on 06/08/2016.
 */
public class createPDF {
    public void createPDF() throws IOException {
        PDDocument doc = null;
        doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDFont font = PDType1Font.HELVETICA_BOLD;

//        InputStream in = new FileInputStream(new File("simley.png"));
//        PDXObject img = new PDImageXObject(doc);

        BufferedImage bufferedImage = ImageIO.read(new CalloutBorder());
        PDPageContentStream content = new PDPageContentStream(doc, page);

        content.drawImage((PDImageXObject) img, 100, 700);

        content.close();

        try {
            doc.save("Empty PDF.pdf");
            doc.close();
        } catch (Exception io) {
            System.out.println(io);
        }


    }

//    void addImageToPDF(PDDocument document , File file){
//
//        PDJpeg f = new PDJpeg;
//
//    }

}
