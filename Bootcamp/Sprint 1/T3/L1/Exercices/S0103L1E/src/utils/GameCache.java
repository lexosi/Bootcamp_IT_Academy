package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameCache {

    public static void savePointsToFile(Map<String, Integer> pointsMap) {
        String value = pointsMap.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        FileUtilities.saveFile("S0103L1E/src/points.txt", value);
    }

    public static Map<String, Integer> getPointsFromFile() {
        Map<String, Integer> points = new HashMap<String, Integer>();

        try {
            String reader = FileUtilities.readFile("S0103L1E/src/points.txt");

            String[] pointsArray = reader.split(System.lineSeparator());
            for (String point : pointsArray) {
                point = point.trim();

                try {
                    if (point.isBlank()) {
                        continue;
                    }

                    String[] components = point.split(":");
                    points.put(components[0].trim(), Integer.parseInt(components[1].trim()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return points;
    }

    public static Map<String, String> getCountriesFromFile() {
        Map<String, String> countries = new HashMap<String, String>();

        try {
            String reader = FileUtilities.readFile("S0103L1E/src/countries.txt");
            // Esto obtiene el contenido del archivo

            String[] countriesArray = reader.split(System.lineSeparator());
            // Separo el contenido en saltos de linea

            for (String country : countriesArray) {
                country = country.trim(); // trim() quita los espacios finales e iniciales si los hay
                // Esto me da cada pais con su capital sin espacios

                try {

                    String[] components = country.split(":");
                    // Divido el pais por el : para sacar el pais y la capital
                    // Por ejemplo: España: Madrid -> [España, Madrid]

                    countries.put(components[0].trim(), components[1].trim());
                    // Añado el pais y la capital al map

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }
}