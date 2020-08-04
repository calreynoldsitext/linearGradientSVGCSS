using System;
using System.IO;
using iText.Html2Pdf;

namespace Example
{
    public class CSSToPDF
    {

        public const String DEST = "output_file_path/CSSOutput.pdf";
        public const String HTML = "input_file_path/linearGradient.html";

        public static void Main(String[] args)
        {
            FileInfo file = new FileInfo(DEST);
            file.Directory().Create();
            new CSSToPDF().CreatePdf();
        }

        public virtual void CreatePdf()
        {
            HtmlConverter.ConvertToPdf(new FileStream(HTML, FileMode.Open), new FileStream(DEST, FileMode.Create));
        }
    }
}
