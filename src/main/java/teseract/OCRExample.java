package teseract;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class OCRExample {
    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();

        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata");
        tesseract.setLanguage("rus+eng");

        try {
            File imageFile = new File("src/main/resources/text2.png");
//            File imageFile = new File("src/main/resources/Artem Makovskyi - Java Developer CV.pdf");

            String result = tesseract.doOCR(imageFile);

            System.out.println("Распознанный текст:\n" + result);
        } catch (TesseractException e) {
            System.err.println("Ошибка OCR: " + e.getMessage());
        }
    }
}
