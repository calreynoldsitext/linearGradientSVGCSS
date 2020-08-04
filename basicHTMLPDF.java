package Example;

import java.io.File;
import java.io.IOException;
import com.itextpdf.html2pdf.HtmlConverter;

public class CSStoPDF {

    public static final String DEST = "output_file_path/CSSOutput.pdf";
    public static final String SRC = "input_file_path/linearGradient.html";

    public static void main(String[] args) throws IOException
    {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CSStoPDF().createPdf(SRC, DEST);
    }

    public void createPdf(String src, String dest) throws IOException
    {
        HtmlConverter.convertToPdf(new File(src), new File(dest));
    }
}