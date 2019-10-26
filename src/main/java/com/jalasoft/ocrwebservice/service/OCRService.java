package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.exception.ConvertException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.model.Criteria;
import com.jalasoft.ocrwebservice.model.CriteriaText;
import com.jalasoft.ocrwebservice.model.OCRConvert;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static com.jalasoft.ocrwebservice.util.Constant.RESOURCE_DIR;

public class OCRService {
    private FileStorageService fileStorageService;

    public Response convert(MultipartFile file, String lang) throws ParameterInvalidException, ConvertException {
        fileStorageService = new FileStorageService();
        Response<String> response = new Response<>();
        List<String> list= new ArrayList<String>();
        try {

            String fileName = fileStorageService.storeFile(file);
            System.out.println("2" + fileName);
            Criteria image = new CriteriaText(fileName, lang);
            image.validate();
            OCRConvert test = new OCRConvert();
            String textResult = test.Convert(image);
            list.add(textResult);
            response
                    .setHttpStatus(HttpStatus.OK)
                    .getBody()
                    .setTextMessage("converted succesfully")
                    .setData(list);
            return response;
        } catch (ConvertException e) {
            throw new ConvertException("Error occurred in conversion", e);
        }
    }
}