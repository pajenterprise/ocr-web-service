package com.jalasoft.ocrwebservice.model;

import com.jalasoft.ocrwebservice.exception.ConvertException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import org.junit.Before;
import org.junit.Test;

import static com.jalasoft.ocrwebservice.util.Constant.RESOURCE_DIR;
import static org.junit.Assert.*;

public class ConvertImageToTextTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test (expected = ParameterInvalidException.class)
    public void returnErrorWhenConvertEmptyFile() throws ConvertException, ParameterInvalidException {
        Criteria image = new CriteriaText(RESOURCE_DIR, null, "eng");
        String textResult = "";
        image.validate();
        OCRConvert test = new OCRConvert();
        textResult = test.Convert(image);
    }
    @Test (expected = ConvertException.class)
    public void returnErrorWhenLanguageInvalid() throws ParameterInvalidException, ConvertException {
        Criteria image = new CriteriaText(RESOURCE_DIR, "", "hin");
        String textResult = "";
        image.validate();
        OCRConvert test = new OCRConvert();
        textResult = test.Convert(image);

    }
}