package com.inchessFitness.webApp.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public class InvoiceGenerator {






//    public static void main(String[] args) {
//        String fileName = "invoice.pdf";
//        try {
//            generateInvoice(fileName);
//            System.out.println("Invoice generated successfully.");
//        } catch (IOException | DocumentException e) {
//            System.err.println("Error generating invoice: " + e.getMessage());
//        }
//    }

    public static void generateInvoice(String fileName) throws IOException, DocumentException {



        // Construct the full file path
        String filePath =  fileName;

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Add content to the document
        addTitle(document, "Invoice");
        addLine(document);
        addText(document, "Invoice Number: 12345");
        addText(document, "Date: March 26, 2024");
        addLine(document);
        addText(document, "Bill To:");
        addText(document, "John Doe");
        addText(document, "123 Main Street");
        addText(document, "City, State, ZIP");
        addLine(document);
        addText(document, "Description\t\t\t\tQty\t\tUnit Price\t\tTotal");
        addLine(document);
        addItem(document, "Product 1", 2, 10.00);
        addItem(document, "Product 2", 1, 20.00);
        addLine(document);
        addTextRightAligned(document, "Total: $30.00");

        document.close();
    }

    private static void addTitle(Document document, String title) throws DocumentException {
        Paragraph paragraph = new Paragraph(title);
        paragraph.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph);
    }

    private static void addText(Document document, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(text);
        document.add(paragraph);
    }

    private static void addTextRightAligned(Document document, String text) throws DocumentException {
        Paragraph paragraph = new Paragraph(text);
        paragraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph);
    }

    private static void addLine(Document document) throws DocumentException {
        addText(document, "---------------------------------------------");
    }

    private static void addItem(Document document, String description, int quantity, double unitPrice) throws DocumentException {
        double total = quantity * unitPrice;
        addText(document, String.format("%s\t\t\t\t%d\t\t%.2f\t\t%.2f", description, quantity, unitPrice, total));
    }
}
