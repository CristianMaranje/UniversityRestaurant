package ec.edu.espe.filemanager.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void save(String fileName, String data) {

        List<String> lineInformation = retrieveList(fileName);
        try {
            File file = new File(fileName);
            lineInformation.add(data);

            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter printer = new PrintWriter(new FileWriter(file, false));

            for (String object : lineInformation) {
                printer.println(object);

            }
            printer.close();

        } catch (IOException ex) {
            System.err.println("Error saving product..");

        }

        System.out.println("SAVED :)");

    }

    public static List<String> find(String fileName, String dataToFind) {
        List<String> dataList;
        dataList = retrieveList(fileName);
        List<String> found = new ArrayList<String>();
        for (String line : dataList) {

            String words[] = line.split(",");
            
            for (String word : words) {
                String split[] = word.split(":");
                
                for (int i = 0; i < split.length; i++) {
                    
                    if (split[i].contains(dataToFind) == true) {
                        found.add(line);
                    }
                }
            }
        }
        return found;
    }

    public static List<String> findAll(String fileName) {

        List<String> linesFile = retrieveList(fileName);
        return linesFile;
    }

    public static boolean update(String fileName, String dataToFind, String datatoUpdate) {

        boolean updated = true;
        System.out.println("updated");
        return updated;

    }

    public static boolean delete(String fileName, String[] datatodelete) {

        boolean deleted = true;
        System.out.println("deleted");
        return deleted;

    }

    public static List<String> retrieveList(String fileName) {

        ArrayList<String> information = new ArrayList<>();
        try {
            FileReader f = new FileReader(fileName);
            BufferedReader b = new BufferedReader(f);

            String lineFile;

            while ((lineFile = b.readLine()) != null) {
                information.add(lineFile);
            }

        } catch (IOException exception) {
            System.out.println("no existe el archivo");
        }
        return information;

    }
}