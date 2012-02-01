package net.therap.lab.ee6.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author jahangir
 * @since 2/1/12 10:38 AM
 */
@WebServlet(name = "FileUploadServlet", urlPatterns = "/fileUpload")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024, maxFileSize = 1024 * 1024, maxRequestSize = 1024 * 1024 * 2)
public class FileUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Uploaded any file? " + (request.getParts().isEmpty() ? "No" : "Yes"));

        if (!request.getParts().isEmpty()) {
            System.out.println(request.getParts().size() + " file(s) uploaded");
            for (Part part : request.getParts()) {
                System.out.println(part.getName() + " " + part.getContentType() + " " + part.getSize());
            }
            response.getWriter().println("Successfully uploaded!");
        } else {
            response.getWriter().println("Nothing to upload.");
        }

        response.getWriter().flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(
                "<html>" +
                "<head>" +
                "<title>File Uploader</title>" +
                "<body>" +
                "<form method='post' enctype=\"multipart/form-data\">" +
                "<input type='file' name='file1'/>" +
                "<input type='submit' value='Upload'/>" +
                "</form>" +
                "</body>" +
                "</head>" +
                "</html");
    }
}
