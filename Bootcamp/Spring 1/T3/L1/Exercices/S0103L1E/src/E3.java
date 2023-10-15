import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import utils.GameCache;
import utils.Input;

public class E3 {
    private static final Map<String, String> COUNTRIES = new HashMap<>();
    private static final Map<String, Integer> POINTS = new HashMap<>();

    private static List<Entry<String, String>> loadGameData() {
        E3.COUNTRIES.putAll(GameCache.getCountriesFromFile());
        E3.POINTS.putAll(GameCache.getPointsFromFile());

        final List<Entry<String, String>> GAME = E3.COUNTRIES.entrySet().stream()
                .collect(Collectors.toList());
        Collections.shuffle(GAME);
        return GAME;
    }

    private static boolean performQuestion(int index, Entry<String, String> question) {
        Input.clearConsole();

        final String RAW_ANSWER = Input.readString("Dime la capital de " + question.getKey());

        String EXPECTED_STRING;
        String ANSWER;
        try {
            EXPECTED_STRING = Input.normalizeString(question.getValue());
            ANSWER = Input.normalizeString(RAW_ANSWER);
        } catch (UnsupportedEncodingException e) {
            return false;
        }

        final boolean CORRECT = ANSWER.equalsIgnoreCase(EXPECTED_STRING);

        System.out.println("Respuesta " + (CORRECT ? "correcta" : "incorrecta") + "!");
        if (!CORRECT) {
            System.out.println("La respuesta correcta es: " + question.getValue() + " (" + EXPECTED_STRING + ")");
        }

        Input.waitUserInput();

        return CORRECT;
    }

    public static void main(String[] args) {

        /*
         * Todos los errores están capturados dónde corresponde, a la hora de crear un
         * proyecto te coloca de forma automática el "throws Exception" y por eso estaba
         * en este main
         */

        System.setProperty("console.encoding", "UTF-8");

        final List<Entry<String, String>> QUESTIONS = E3.loadGameData();
        Input.clearConsole();

        int score = 0;
        final String USERNAME = Input.readString("Ingrese su nombre de usuario:");

        for (int i = 0; i < Math.min(10, QUESTIONS.size()); i++) {
            final Entry<String, String> QUESTION = QUESTIONS.get(i);
            if (E3.performQuestion(i, QUESTION)) {
                score++;
            }
        }

        Input.clearConsole();

        final int BEST_MARK = E3.POINTS.getOrDefault(USERNAME, 0);
        if (E3.POINTS.containsKey(USERNAME)) {
            System.out.println("Has conseguido " + score + " puntos. Tu mejor puntaje era de: " + BEST_MARK);
        } else {
            System.out.println("Bienvenido, has conseguido " + score + " puntos.");
        }

        if (score > BEST_MARK) {
            E3.POINTS.put(USERNAME, score);
            GameCache.savePointsToFile(E3.POINTS);
        }
    }
}
