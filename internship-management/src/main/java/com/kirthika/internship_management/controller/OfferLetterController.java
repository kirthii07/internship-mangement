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
import com.itextpdf.text.pdf.PdfWriter;
import com.kirthika.internship_management.model.Intern;
import com.kirthika.internship_management.repository.InternRepository;

@RestController
public class OfferLetterController {

    @Autowired
    private InternRepository internRepository;

    @GetMapping("/api/offerletter/{id}")
    public ResponseEntity<byte[]> generateOfferLetter(
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

            // Fonts
            Font companyFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            22,
                            BaseColor.BLUE);

            Font titleFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            18,
                            BaseColor.BLACK);

            Font headingFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            14,
                            BaseColor.DARK_GRAY);

            Font normalFont =
                    FontFactory.getFont(
                            FontFactory.HELVETICA,
                            12,
                            BaseColor.BLACK);

            // Company Name
            Paragraph company =
                    new Paragraph(
                            "ABC TECHNOLOGIES",
                            companyFont);

            company.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(company);

            Paragraph address =
                    new Paragraph(
                            "Chennai, Tamil Nadu | www.abctecnologies.com",
                            normalFont);

            address.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(address);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "=============================================================="));

            document.add(new Paragraph(" "));

            // Title
            Paragraph title =
                    new Paragraph(
                            "INTERNSHIP OFFER LETTER",
                            titleFont);

            title.setAlignment(Paragraph.ALIGN_CENTER);

            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "Date : " + LocalDate.now(),
                    normalFont));

            document.add(new Paragraph(" "));

            // Candidate Details
            Paragraph detailsHeading =
                    new Paragraph(
                            "CANDIDATE DETAILS",
                            headingFont);

            document.add(detailsHeading);

            document.add(new Paragraph(
                    "--------------------------------------------------"));

            document.add(new Paragraph(
                    "Name        : " + intern.getName(),
                    normalFont));

            document.add(new Paragraph(
                    "College     : " + intern.getCollege(),
                    normalFont));

            document.add(new Paragraph(
                    "Department  : " + intern.getDepartment(),
                    normalFont));

            document.add(new Paragraph(
                    "Email       : " + intern.getEmail(),
                    normalFont));

            document.add(new Paragraph(
                    "Role        : " + intern.getRole(),
                    normalFont));

            document.add(new Paragraph(
                    "Duration    : " + intern.getDuration(),
                    normalFont));

            document.add(new Paragraph(
                    "Start Date  : " + intern.getStartDate(),
                    normalFont));

            document.add(new Paragraph(
                    "End Date    : " + intern.getEndDate(),
                    normalFont));

            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "Dear " + intern.getName() + ",",
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "We are pleased to offer you the position of "
                            + intern.getRole()
                            + " at ABC Technologies.",
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "During your internship, you will gain practical "
                            + "industry experience, work on real-world "
                            + "projects, and collaborate with our "
                            + "technical team.",
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Internship Duration : "
                            + intern.getDuration(),
                    normalFont));

            document.add(new Paragraph(
                    "Internship Period : "
                            + intern.getStartDate()
                            + " to "
                            + intern.getEndDate(),
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "We believe your skills, dedication, and enthusiasm "
                            + "will make a valuable contribution to our "
                            + "organization.",
                    normalFont));

            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Congratulations and welcome to ABC Technologies.",
                    normalFont));

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            document.add(new Paragraph(
                    "Authorized Signature",
                    headingFont));

            document.add(new Paragraph(
                    "HR Manager",
                    normalFont));

            document.add(new Paragraph(
                    "ABC Technologies",
                    normalFont));

            document.add(new Paragraph(" "));
            document.add(new Paragraph(
                    "=============================================================="));

          
            document.close();

            return ResponseEntity.ok()
                    .header(
                            HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=OfferLetter_"
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