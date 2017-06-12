package com.mihai.licenta.Controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by mihai on 16.05.2017.
 */
@RestController
@RequestMapping("/api/resource")
public class ResourceController {

    private static String UPLOADED_FOLDER = "/home/mihai/Documents/Licenta/Server/Resources/Images/User/";


    @RequestMapping(value = "/image/user/{id}", method = RequestMethod.GET)
    public void getUserImage(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        Path path = Paths.get(UPLOADED_FOLDER + id + "");
        InputStream in = new FileInputStream(path.toString());
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
}

