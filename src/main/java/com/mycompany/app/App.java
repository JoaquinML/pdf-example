package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws DocumentException, FileNotFoundException, IOException
    {
        File newPdf = File.createTempFile("test", ".pdf");
        FileOutputStream os = new FileOutputStream(newPdf);

        Document document = new Document();
        PdfWriter.getInstance(document, os);
 
        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
        Chunk title = new Chunk("Print your format", font);
        document.add(title);
        document.close();

        
        for(byte b : Files.readAllBytes(Paths.get(newPdf.getAbsolutePath()))){
            System.out.print(b);
        }

        File newf = new File("test.pdf");
        FileOutputStream os2 = new FileOutputStream(newf);
        os2.write(Files.readAllBytes(Paths.get(newPdf.getAbsolutePath())));
        os2.close();
        
    }
}
