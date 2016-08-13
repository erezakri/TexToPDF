import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

//import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.*;
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

        PDPageContentStream content = new PDPageContentStream(doc, page);
        try {
            BufferedImage awtImage = ImageIO.read(new File("simley.png"));
            PDImageXObject ximage = PDImageXObject.createFromFile("simley.png",doc);

            float scale = 1.0f; // alter this value to set the image size
            content.drawXObject(ximage,100,400,
                    (ximage.getWidth()*scale),(ximage.getHeight()*scale));
            content.setStrokingColor(Color.red);
            content.addRect(100-3, 400-3, ximage.getWidth()*scale+6, ximage.getHeight()*scale+6);
            content.closeAndStroke();
            content.close();

//            document.save(file);
//            document.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

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
