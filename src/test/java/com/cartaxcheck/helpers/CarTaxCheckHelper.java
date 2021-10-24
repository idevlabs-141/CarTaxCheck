package com.cartaxcheck.helpers;

import com.cartaxcheck.model.VehicleIdentity;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CarTaxCheckHelper {
    private static final String REG_PATTERN = "[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}";

    public static List<String> extractRegNumbersFromFile(final String inputFile){
        List<String> regNumbers = new ArrayList<String>();

        try {
            String content = Files.lines(Paths.get(inputFile)).collect(Collectors.joining("\n"));
            final Pattern carRegPattern = Pattern.compile(REG_PATTERN);
            Matcher regmatcher = carRegPattern.matcher(content);
            while(regmatcher.find()) {
                regNumbers.add(regmatcher.group(0).replace(" ",""));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return regNumbers;
    }

    public static Map<String,VehicleIdentity> getCarRegDirectory(final String outputFile){
        try {
             return Files.lines(Paths.get(outputFile)).skip(1)
                            .map((line) -> line.split(","))
                            .collect(HashMap::new, (map, x) -> map.put(x[0], new VehicleIdentity(x[0],x[1],x[2],x[3],x[4])),
                                    Map::putAll);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }
}
