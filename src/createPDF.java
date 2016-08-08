import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.awt.*;
import java.io.IOException;

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

        PDPageContentStream content = new PDPageContentStream(doc, page);
        content.beginText();
        content.setFont( font, 12 );
        content.moveTextPositionByAmount( 100, 700 );
        content.drawString("Hello from www.printmyfolders.com");


        content.endText();
        content.close();
        doc.save("PDFWithText.pdf");
        try {
            doc.save("Empty PDF.pdf");
            doc.close();
        } catch (Exception io) {
            System.out.println(io);
        }


    }


}
