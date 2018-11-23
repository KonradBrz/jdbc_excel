import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class jdbc extends abstractClass{

    jdbc() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            SYS = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "konrad", "konrad");
            statement = SYS.createStatement();

            File file = new File("zapis.txt");
            Scanner in = new Scanner(file);
            String zapytanieSql = in.nextLine();
            System.out.println(zapytanieSql);

            //sql = "select p.id, p.nazwa, m.nazwa miasto\n" +
            //        "from panstwa p\n" +
            //        " inner join miasta m on p.id=m.idpanstwa\n" +
            //        "where m.id <> p.stolica";

            rs = statement.executeQuery(zapytanieSql);
            row = 1;
            int i=1;
            while (rs.next()) {
                //System.out.println(rs.getInt(1) + " " + rs.getString(2));// + " " + rs.getString(3));
                while (true){
                    int found = zapytanieSql.indexOf("id");
                    if (found!=-1) {
                        id = rs.getInt(i);
                        break;
                    }
                    if (found == -1) {
                        System.out.println("brak kolumny id");
                        break;
                    }
                }
                while (true){
                    int found = zapytanieSql.indexOf("nazwa");
                    if (found!=-1) {
                        i++;
                        nazwa = rs.getString(i);
                        break;
                    }
                    if (found == -1) {
                        System.out.println("brak kolumny nazwa");
                        break;
                    }
                }
                while (true){
                    int found = zapytanieSql.indexOf("miasto");
                    if (found!=-1) {
                        miasto = rs.getString(i++);
                        break;
                    }
                    if (found == -1) {
                        System.out.println("brak kolumny miasto");
                        break;
                    }
                }

                //id = rs.getInt(1);
                //nazwa = rs.getString(2);
                //miasto = rs.getString(3);

                Row dataRow = sheet.createRow(row);

                Cell dataIdCell = dataRow.createCell(0);
                dataIdCell.setCellValue(id);

                Cell dataNazwaCell = dataRow.createCell(1);
                dataNazwaCell.setCellValue(nazwa);

                Cell dataMiastoCell = dataRow.createCell(2);
                dataMiastoCell.setCellValue(miasto);

                headerRow.createCell(0).setCellValue("ID");
                headerRow.createCell(1).setCellValue("Nazwa");
                headerRow.createCell(2).setCellValue("Miasto");

                row = row + 1;
            }
            //final JOptionPane optionPane=new JOptionPane("Chcesz zapisać zapytanie w excelu?",JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_OPTION);
            JOptionPane.showMessageDialog(null, "Tabela zostanie zapisana w formacie xls na dysku C");

            String output = "C:/Tab.xls";
            FileOutputStream fileOut = new FileOutputStream(output);
            wb.write(fileOut);
            fileOut.close();
            SYS.close();
        } catch (SQLException | ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

