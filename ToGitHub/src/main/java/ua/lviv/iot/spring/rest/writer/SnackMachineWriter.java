package ua.lviv.iot.spring.rest.writer;

import com.opencsv.CSVWriter;
import lombok.Getter;
import lombok.Setter;
import ua.lviv.iot.spring.rest.model.SnackMachine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class SnackMachineWriter extends SnackMachine {

    public static String mapToString(Map<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(": ")
                    .append(entry.getValue())
                    .append(", ");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.setLength(stringBuilder.length() - 2); // Видаляємо останню кому та пробіли
        }
        return stringBuilder.toString();
    }
    public void writeAllObjectsToCSV(Map<Integer, SnackMachine> SnackMachines, String folderpath) throws IOException {
        DateTimeFormatter formatterForFileNaming = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate currentDate = LocalDate.now();

        String headers = "id, address, menu, exsistingMarks, exsistingSnacks, soldedSnacks";

        for (SnackMachine snackMachine : SnackMachines.values()) {
            String filename = snackMachine.getId() + "-" + currentDate.format(formatterForFileNaming) + ".csv";
            String filepath = folderpath + "/" + filename;
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

            int id = snackMachine.getId();
            String address = snackMachine.getAddress();
            List<String> menu = snackMachine.getMenu();
            List<String> exsistingMarks = snackMachine.getExistingTrademarkOfSnacks();
            Map<String, Integer> exsistingSnacks = snackMachine.getExistingSnacks();
            Map<String, Integer> soldedSnacks = snackMachine.getSoldedSnacks();

            String line = id + "," + address+ "," + menu + "," + exsistingMarks + "," + exsistingSnacks + "," + soldedSnacks + ",";

            writer.write("Snack Machine");
            writer.newLine();
            writer.write(headers);
            writer.newLine();
            writer.write(line);
            writer.newLine();

            writer.close();
        }
    }
}
