package tmp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdf {
	public static void main(String[] args) throws IOException {
		File file = new File("C:\\t\\22405397_8790.pdf");
		FileInputStream fis = new FileInputStream(file);
		PDFParser parser = new PDFParser((RandomAccessRead) fis);
		parser.parse();
		
		COSDocument cosDoc = parser.getDocument();
		PDDocument pdDoc = new PDDocument(cosDoc);
		
		PDFTextStripper strip = new PDFTextStripper();
		
		String data = strip.getText(pdDoc);
		
		System.out.println(data);
	}
}
