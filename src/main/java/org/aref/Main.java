package org.aref;

import org.aref.model.Click;
import org.aref.model.Impression;
import org.aref.model.Report;
import org.aref.service.DataProcessor;
import org.aref.util.FileReaderUtil;
import org.aref.util.JsonUtils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            String impressionsFile = "impressions.json";
            String clicksFile = "clicks.json";

            List<Impression> impressions = FileReaderUtil.readImpressions(impressionsFile);
            List<Click> clicks = FileReaderUtil.readClicks(clicksFile);

            List<Report> reports = DataProcessor.generateReports(impressions, clicks);

            JsonUtils.writeToJsonFile("output.json", reports);
            System.out.println("Report generated successfully!");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}