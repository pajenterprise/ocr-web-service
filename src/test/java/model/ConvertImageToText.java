package model;
import java.io.File;
import net.sourceforge.tess4j.*;

public class ConvertImageToText {

	public static void main(String[] args) {
		File imageFile = new File("thirdParty/Tess4J/test/resources/test-data/eurotext.tif");
		   ITesseract instance = new Tesseract();  // JNA Interface Mapping
     //    ITesseract instance = new Tesseract1(); // JNA Direct Mapping
        instance.setDatapath("thirdParty/Tess4J/tessdata"); // path to tessdata directory

        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
	}

}
