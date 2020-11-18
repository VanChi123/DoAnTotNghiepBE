package com.mta.shop.service.utils;

import com.mta.shop.configure.Constant;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class FileService {
    public String saveFile(String imgBase64, String fileName, String fileTail) throws IOException {
        makeDirectoryIfNotExist();

        Path filePath = Paths.get(Constant.IMAGES_DIR_DEFAULT,
                fileName.concat(".").concat(fileTail));
// nếu tên file trùng thì tự động nó sẽ thay thế nên ko phải gọi hàm xóa
//        deleteFileIfExist(filePath.toString());

        System.out.println("bats đầu vào hàm saveFile");
        System.out.println("file path: " + filePath);
        System.out.println("file Name: " + fileName);
        System.out.println("file tail: " + fileTail);
        //System.out.println("fie path: "+ imgBase64);
        try {
//            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//            FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);

            //byte[] decodedBytes = Base64.getDecoder().decode(imgBase64);
            byte[] decodedBytes = Base64.getMimeDecoder().decode(imgBase64);
            FileUtils.writeByteArrayToFile(new File(filePath.toString()), decodedBytes);

            System.out.println("file path: in saving:  " + filePath.toString());
            return filePath.toString();
        } catch (IOException e) {
//            LOGGER.info("Can not save img {}", filePath.toString());
            throw e;
        }
    }

    public String getFile(String filePath) throws IOException {
        try {
            File file = new File(filePath.replaceAll(" ", ""));
            //String imgBase64 = "";
//            if (file.canRead()) {

            byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
            String imgBase64 = Base64.getEncoder().encodeToString(fileContent);
//
//            }

            return imgBase64;
        } catch (IOException e) {
            return "";
            // throw e;
        }
    }

    public void makeDirectoryIfNotExist() {
        File directory = new File(Constant.IMAGES_DIR_DEFAULT);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public void deleteFileIfExist(String pathFile) {
        File file = new File(pathFile);

        file.delete();

        System.out.println("pass delete file if trùng");
    }
}
