package org.example.fileupload;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload2.core.DiskFileItem;
import org.apache.commons.fileupload2.core.DiskFileItemFactory;
import org.apache.commons.fileupload2.jakarta.servlet6.JakartaServletDiskFileUpload;

@WebServlet("/upload")
public class FileUpload extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
        JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload(factory);

        List<DiskFileItem> multifiles = upload.parseRequest(request);
        
        for(DiskFileItem item: multifiles)
        {
            Path path = Path.of("D:\\Learning_Java\\FileUpload" + item.getName());
            item.write(path);
        }
        System.out.println("Files uploaded.");


    }
}