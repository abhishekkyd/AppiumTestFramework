package com.automation.mobile.dataproviders;

import com.opencsv.CSVReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class CsvDataProvider {

    @DataProvider(name = "CsvDataProvider")
    public static Object[][] getDataFromCsv(final Method testMethod) {
        CsvFileParameters parameters = testMethod.getAnnotation(CsvFileParameters.class);
        if (parameters == null) {
            throw new RuntimeException("@CsvFileParameters annotation is missing from method: " + testMethod.getName());
        }

        Object[][] csvData = loadDataFromCsv(parameters);
        validateCsvData(csvData);
        return csvData;
    }

    private static Object[][] loadDataFromCsv(CsvFileParameters csvFileParameters) {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(getAbsoluteFilePath(csvFileParameters.path())), csvFileParameters.separator());
            List<String[]> csvLines = csvReader.readAll();
            List<String[]> csvLinesWithData = csvLines.subList(1, csvLines.size());
            String[][] csvData = new String[csvLinesWithData.size()][];
            return csvLinesWithData.toArray(csvData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void validateCsvData(Object[][] data) {
        if (data == null || data.length == 0 || data[0] == null) {
            throw new RuntimeException("Empty CSV data");
        }

        int colLength = data[0].length;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null || data[i].length != colLength) {
                throw new RuntimeException("Missing data in CSV row:" + i);
            }
        }
    }

    private static String getAbsoluteFilePath(String relativePath) {
        String absoluteFilePath = new File("").getAbsolutePath() + "/src/test/resources/" + relativePath;
        return absoluteFilePath;
    }
}
