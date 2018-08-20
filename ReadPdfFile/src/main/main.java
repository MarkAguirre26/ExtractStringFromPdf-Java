/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.*;

/**
 *
 * @author AGUIRREMR
 */
public class main {

    public static void main(String[] args) {
        try (PDDocument document = PDDocument.load(new File("C:\\Users\\AguirreMR\\Downloads\\Dummy 3.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
//                System.out.println("Text:" + pdfFileInText);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\s+");
                for (String line : lines) {
                    if (line.contains("#")) {
                        System.out.println(line);
                    }

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
