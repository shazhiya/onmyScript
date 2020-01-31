import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;

import java.io.File;
import java.util.Date;

public class imgTostr {


    @Test
    public void test() throws TesseractException {

        ITesseract instance = new Tesseract();
        instance.setDatapath("E:\\Tess4J\\tessdata");
        instance.setLanguage("chi_sim");
        File picture = new File("E:\\webapplication\\win3Pro\\src\\test.png");

        instance.doOCR(picture);
        System.out.println("----------------");
        Date start = new Date();
        System.out.println(instance.doOCR(picture));
        Date end = new Date();
        System.out.println(end.getTime()-start.getTime());

    }


}
