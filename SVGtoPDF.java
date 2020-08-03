package Example;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.svg.converter.SvgConverter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SVGtoPDF {

    public static final String DEST = "output_file_path/SVGOutput.pdf";
    public static final String SVG = "input_file_path/linearGradient.svg";

    public static void main(String[] args) throws IOException
    {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SVGtoPDF().createPdf();
    }

    public void createPdf() throws IOException
    {
        try (FileInputStream svg = new FileInputStream(SVG))
        {
            // This approach (commented below) directly converts from SVG to PDF.
            //SvgConverter.createPdf(new File(SVG), new File(DEST));

            // This approach (below) creates a PDF document, then adds SVG to that document.
            PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
            Document doc = new Document(pdf);
            Image converted = SvgConverter.convertToImage(svg, pdf);
            doc.add(converted);
            doc.close();
        }
    }
}