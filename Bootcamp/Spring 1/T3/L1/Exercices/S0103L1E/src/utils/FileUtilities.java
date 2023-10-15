package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileUtilities {

    public static void saveFile(String fileName, String value) {

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(fileName));

            final byte[] bytes = value.getBytes();
            outputStream.write(bytes);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readFile(String fileName) {

        BufferedReader bufferedReader = null;
        String result = "";

        /*
         * Usar varios return en un método mejora la claridad, mantenibilidad y
         * eficiencia del código en muchos casos. Aunque debe usarse de forma controlada
         * y sin abusarlo excesivamente. Además de mejorar la legibilidad haciendo que
         * cada return refleje una salida temprana basada en condiciones específicas
         * facilitando así seguir el flujo del programa, puede incluso reducir las
         * anidaciones innecesarias y excesivas de estructuras de control. A pesar de
         * ello tiene una función clave en la depuración, ya que ayuda a identificar
         * errores más fácilmente, siendo así más claro cuál return se ejecutó. Otras
         * mejoras al código que ofrece usar múltiples returns es que promueve la
         * cohesión, por lo que cada return se asocia con una tarea específica,
         * aumentando la cohesión del método.
         * 
         * Incluso, en programación existe un concepto llamado programación defensiva,
         * que lo utiliza de forma correcta, consta de manejar casos excepcionales antes
         * de continuar con la lógica principal, y pudiendo mejorar el rendimiento al
         * evitar evaluaciones innecesarias de condiciones una vez que se encuentra un
         * resultado válido. No Obstante he cambiado el método para que solo tenga una
         * devolución.
         */

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8));
            StringBuilder string = new StringBuilder();

            /*
             * final StringBuilder STRING = new StringBuilder();
             * 
             * Declarar variables locales de forma final o constante, ayuda en primer lugar
             * a la legibilidad y seguridad del código, no obstante,
             * tiene otras funciones, algunas de ellas, las cuales más importantes son que
             * ayuda al compilador para que haga algunas optimizaciones haciendo su trabajo
             * de forma más eficiente, y la otra, es que al ser declarada dentro de un
             * ambito local o dentro de un método, hace que el Garbage Collector de Java
             * reutilice el espacio en cache eliminando anticipadamente la variable. No
             * obstante he realizado los cambios que me has pedido.
             */

            String line = bufferedReader.readLine();
            while (line != null) {
                string.append(line);
                string.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }

            result = string.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
