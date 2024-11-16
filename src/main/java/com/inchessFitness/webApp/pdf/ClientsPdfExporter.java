package com.inchessFitness.webApp.pdf;

import com.inchessFitness.webApp.model.Clients;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.util.List;
import java.io.IOException;

import static java.lang.Double.parseDouble;

public class ClientsPdfExporter {
        private List<Clients> listClients;

        public ClientsPdfExporter(List<Clients> listClients) {
            this.listClients = listClients;
        }

        private void writeTableHeader(PdfPTable table) {
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(Color.BLUE);
            cell.setPadding(5);

            Font font = FontFactory.getFont(FontFactory.HELVETICA);
            font.setColor(Color.WHITE);

            cell.setPhrase(new Phrase("User ID", font));

            table.addCell(cell);

            cell.setPhrase(new Phrase("E-mail", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Full Name", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Roles", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("Enabled", font));
            table.addCell(cell);
        }

        private void writeTableData(PdfPTable table) {
                    for (Clients clients : listClients) {
                table.addCell(String.valueOf(clients.getClientsId()));
                table.addCell(clients.getEmail());
                table.addCell(clients.getName());
            }
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

        public void export(HttpServletResponse response) throws DocumentException, IOException {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, response.getOutputStream());

            document.open();
//            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
//            font.setSize(18);
//            font.setColor(Color.BLUE);
//
//            Paragraph p = new Paragraph("Inchess Fitness Invoice", font);
//            p.setAlignment(Paragraph.ALIGN_CENTER);
//
//            document.add(p);
//
//            PdfPTable table = new PdfPTable(5);
//            table.setWidthPercentage(100f);
//            table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
//            table.setSpacingBefore(10);
//
//            writeTableHeader(table);
//            writeTableData(table);
//
//            document.add(table);
//
//            document.close();




            // Add content to the document
            for (Clients clients : listClients) {
                addTitle(document, "Inchess Fitness Invoice");
                addLine(document);
                addText(document, "Invoice Number: 001"+clients.getClientsId());
                addText(document, "Date: March 26, 2024");
                addLine(document);
                addText(document, "Bill To:");
                addText(document, clients.getName());
                addText(document,clients.getEmail());
                addText(document, clients.getMobileNumber());
                addLine(document);
                addText(document, "Description\t\tTotal");
                addLine(document);
                addItem(document, clients.getGoal(), 1 , parseDouble(clients.getFees()));
                addLine(document);

                document.close();

            }

        }
    }

