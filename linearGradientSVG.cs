using System;
using System.IO;
using iText.Kernel.Pdf;
using iText.Layout;
using iText.Layout.Element;
using iText.Svg.Converter;

namespace Example
{
    public class SVGtoPDF
    {
      
        public const String DEST = "output_file_path/SVGOutput.pdf";
        public const String SVG = "input_file_path/linearGradient.svg";

        public static void Main(String[] args)
        {
            FileInfo file = new FileInfo(DEST);
            file.Directory.Create();
            new SVGtoPDF().CreatePdf(DEST);
        }

        public virtual void CreatePdf(String dest)
        {
            using (FileStream svg = File.Open(SVG, FileMode.Open))
            {
                // This approach (commented below) directly converts from SVG to PDF.
                //SvgConverter.CreatePdf(new FileInfo(SVG), new FileInfo(DEST));

                // This approach (below) creates a PDF document, then adds SVG to that document.
                PdfDocument pdf = new PdfDocument(new PdfWriter(DEST));
                Document doc = new Document(pdf);
                Image converted = SvgConverter.ConvertToImage(svg, pdf);
                doc.Add(converted);
                doc.Close();
            }
        }
    }
}
