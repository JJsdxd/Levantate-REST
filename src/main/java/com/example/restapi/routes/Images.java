package com.example.restapi.routes;


import com.example.restapi.entities.User;
import com.example.restapi.pojos.ImageUpload;
import com.example.restapi.repositories.UserRepository;
import com.example.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerResponse;


import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
public class Images {


    @Autowired
    UserService userService;

    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }


    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }



    @PostMapping("/upload")
    public ResponseEntity.BodyBuilder uplaodImage(HttpServletRequest request, @RequestParam("imageFile") MultipartFile file) throws IOException {
        int token_user_id = (Integer) request.getAttribute("userId");
        ImageUpload imgupload = new ImageUpload();
        imgupload.userid = token_user_id;
        imgupload.imagebytes = compressBytes(file.getBytes());
        userService.UpdateProfile(imgupload);
        return ResponseEntity.status(HttpStatus.OK);


    }

    @GetMapping(path = {"/profileimage"})
    public byte[] getImage(HttpServletRequest request) throws IOException {
        int token_user_id = (Integer) request.getAttribute("userId");
        byte[] imgbyte = userService.findImage(token_user_id);
        byte[] newbyte = decompressBytes(imgbyte);
        return newbyte;

    }
}
