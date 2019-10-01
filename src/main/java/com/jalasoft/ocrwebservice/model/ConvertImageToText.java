package com.jalasoft.ocrwebservice.model;

/*
 * IConvert
 * Version 1
 * Date 09/23/2019
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

import com.jalasoft.ocrwebservice.util.Constant;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static com.jalasoft.ocrwebservice.util.Constant.RESOURCE_DIR;

/**
 * The ConvertImageToText class provides make a new result.txt file in the project folder
 * given an Object Criteria that contains a path of a image file.
 */
public class ConvertImageToText implements IConvert{

    @Override
    public String Convert(Criteria cri) {
        ITesseract instance = new Tesseract();
        // path to tessdata directory
        instance.setDatapath("thirdParty/Tess4J/tessdata");
        instance.setLanguage(cri.getAttribute());

        try {
            String result = instance.doOCR(cri.getFile());
            String filePath = RESOURCE_DIR + "output.txt";
            File output = new File(filePath);
            PrintWriter writer = new PrintWriter(output.getPath(), "UTF-8");
            writer.println(result);
            writer.close();

        } catch (TesseractException e) {

            return(e.getMessage());

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        return ("result.txt");
    }
}
