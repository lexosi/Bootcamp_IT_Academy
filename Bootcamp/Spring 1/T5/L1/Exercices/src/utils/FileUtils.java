package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import handler.EFileType;

public class FileUtils {

    public static String listFiles(File directory) {
        try {
            String result = "\n\tDirectory: " + directory.getCanonicalPath() + "\n";

            final List<File> FILES = Arrays.asList(directory.listFiles()).stream()
                    .sorted((a, b) -> {
                        if (a.isDirectory() && b.isFile()) {
                            return -1;
                        }
                        if (a.isFile() && b.isDirectory()) {
                            return 1;
                        }
                        return a.getName().compareToIgnoreCase(b.getName());
                    })
                    .toList();

            for (final File FILE : FILES) {
                final EFileType FILE_TYPE = FILE.isDirectory() ? EFileType.DIRECTORY : EFileType.FILE;

                final long LAST_MODIFIED_TIME = FILE.lastModified();
                final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
                final String TIME = DATE_FORMAT.format(LAST_MODIFIED_TIME);

                result += "\t" + FILE_TYPE.getParsedType() + "\t" + TIME + "\t" + FILE.getName() + "\n";
            }

            result += "\n";
            return result;
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

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
}