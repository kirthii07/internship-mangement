package com.kirthika.internship_management.controller;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.kirthika.internship_management.model.Intern;
import com.kirthika.internship_management.repository.InternRepository;

@RestController
public class CertificateController {

    @Autowired
    private InternRepository internRepository;

    @GetMapping("/api/certificate/{id}")
    public ResponseEntity<byte[]> generateCertificate(
            @PathVariable Long id) {

        try {

            Intern intern =
                    internRepository.findById(id)
                            .orElseThrow();

            ByteArrayOutputStream baos =
                    new ByteArrayOutputStream();

            Document document = new Document();

            PdfWriter.getInstance(document, baos);

            document.open();

            Font companyFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            24,
                            BaseColor.BLUE);

            Font titleFont =
                    FontFactory.getFont(
                            FontFactory.TIMES_BOLD,
                            22,
                            BaseColor.BLACK);

            Font nameFont =
                    FontFactory.getFont(
                            FontFactory.TIMES_BOLD,
                            28,
                            BaseColor.MAGENTA);

            Font normalFont =
                    FontFactory.getFont(
                            FontFactory.TIMES_ROMAN,
                            14,
                            BaseColor.BLACK);

            Font signFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            14,
                            BaseColor.DARK_GRAY);

            Rectangle border =
                    new Rectangle(
                            20,
                            20,
                            575,
                            822);

            border.setBorder(Rectangle.BOX);
            border.setBorderWidth(5);
            border.setBorderColor(BaseColor.ORANGE);

            document.add(new Paragraph(" "));

            Paragraph company =
                    new Paragraph(
                            "ABC TECHNOLOGIES",
                            companyFont);

            company.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(company);

            Paragraph subtitle =
                    new Paragraph(
                            "Internship Completion Certificate",
                            normalFont);

            subtitle.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(subtitle);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph heading =
                    new Paragraph(
                            "CERTIFICATE OF COMPLETION",
                            titleFont);

            heading.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(heading);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph p1 =
                    new Paragraph(
                            "This certificate is proudly presented to",
                            normalFont);

            p1.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p1);

            document.add(new Paragraph(" "));

            Paragraph name =
                    new Paragraph(
                            intern.getName(),
                            nameFont);

            name.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(name);

            document.add(new Paragraph(" "));

            Paragraph p2 =
                    new Paragraph(
                            "from " + intern.getCollege(),
                            normalFont);

            p2.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p2);

            document.add(new Paragraph(" "));

            Paragraph p3 =
                    new Paragraph(
                            "for successfully completing the internship as "
                                    + intern.getRole(),
                            normalFont);

            p3.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p3);

            document.add(new Paragraph(" "));

            Paragraph p4 =
                    new Paragraph(
                            "during the period "
                                    + intern.getStartDate()
                                    + " to "
                                    + intern.getEndDate(),
                            normalFont);

            p4.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p4);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph p5 =
                    new Paragraph(
                            "We appreciate your dedication, commitment and valuable contribution during the internship period.",
                            normalFont);

            p5.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(p5);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph sign =
                    new Paragraph(
                            "________________________",
                            signFont);

            sign.setAlignment(Paragraph.ALIGN_RIGHT);

            document.add(sign);

            Paragraph hr =
                    new Paragraph(
                            "HR Manager",
                            signFont);

            hr.setAlignment(Paragraph.ALIGN_RIGHT);

            document.add(hr);

            Paragraph companyName =
                    new Paragraph(
                            "ABC Technologies",
                            normalFont);

            companyName.setAlignment(Paragraph.ALIGN_RIGHT);

            document.add(companyName);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph footer =
                    new Paragraph(
                            "Awarded On : "
                                    + LocalDate.now(),
                            normalFont);

            footer.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(footer);

            document.close();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=Certificate_"
                                    + intern.getName()
                                    + ".pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(baos.toByteArray());

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity.internalServerError()
                    .build();
        }
    }
}