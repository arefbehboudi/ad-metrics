package org.aref.service;


import org.aref.model.Click;
import org.aref.model.Impression;
import org.aref.model.Report;

import java.util.*;
import java.util.stream.Collectors;

public class DataProcessor {

    public static List<Report> generateReports(List<Impression> impressions, List<Click> clicks) {
        Map<String, List<Impression>> groupedImpressions = impressions
                .parallelStream()
                .collect(Collectors.groupingBy(i -> i.getAppId() + "_" + i.getCountryCode()));

        Map<String, Double> revenueMap = clicks.parallelStream()
                .collect(Collectors.groupingBy(Click::getImpressionId, Collectors.summingDouble(Click::getRevenue)));

        List<Report> reports = new ArrayList<>();

        for (String key : groupedImpressions.keySet()) {
            String[] parts = key.split("_");
            int appId = Integer.parseInt(parts[0]);
            String countryCode = parts[1];

            List<Impression> appImpressions = groupedImpressions.get(key);
            int totalImpressions = appImpressions.size();
            int totalClicks = (int) appImpressions.stream().filter(i -> revenueMap.containsKey(i.getId())).count();
            double totalRevenue = appImpressions.stream()
                    .mapToDouble(i -> revenueMap.getOrDefault(i.getId(), 0.0))
                    .sum();

            Map<Integer, Double> advertiserRevenue = appImpressions.stream()
                    .collect(Collectors.groupingBy(Impression::getAdvertiserId,
                            Collectors.summingDouble(i -> revenueMap.getOrDefault(i.getId(), 0.0))));

            List<Integer> topAdvertisers = advertiserRevenue.entrySet().stream()
                    .sorted((a, b) -> Double.compare(b.getValue() / totalImpressions, a.getValue() / totalImpressions))
                    .limit(5)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            reports.add(new Report(appId, countryCode, totalImpressions, totalClicks, totalRevenue, topAdvertisers));
        }

        return reports;
    }
}