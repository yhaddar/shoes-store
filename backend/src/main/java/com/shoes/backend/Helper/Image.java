package com.shoes.backend.Helper;

import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@NoArgsConstructor
public class Image {
    private Date date = new Date();

    public String uploadImage(MultipartFile file, String filePath) throws IOException {

        String file_name = this.date.getTime() + "_" + file.getOriginalFilename();
        Path path = Paths.get("public", filePath);

        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        Path uploadImage = path.resolve(file_name);

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, uploadImage, StandardCopyOption.REPLACE_EXISTING);
        }

        return file_name;
    }

    public Object updateImage(MultipartFile file, String filePath, String fileExists) throws IOException {
        Path path = Paths.get("backend/public", filePath + "/" + fileExists);

        if(Files.exists(path)){

            Files.delete(path);
            String fileName = this.uploadImage(file, filePath);
            this.deleteImage(filePath, fileExists);

            return fileName;
        }else {
            return false;
        }

    }

    public void deleteImage(String filePath, String fileExists) throws IOException {
        Path path = Paths.get("backend/public", filePath + "/" + fileExists);

        if(Files.exists(path)){
            Files.delete(path);
        }

    }

}
