import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

abstract public class abstractClass {

    //for jdbc class

    String sql;
    Statement statement;
    Connection SYS;
    ResultSet rs;

    //for excel class

    Workbook wb=new HSSFWorkbook();
    Sheet sheet=wb.createSheet("Data");
    Row headerRow= sheet.createRow(0);

    //zmienne dla wywołanej tabeli (3 kolumny)

    int row;

    int id;
    String nazwa;
    String miasto;

    JTextArea jta = new JTextArea();
    JButton button = new JButton("Wyślij zapytanie sql");
    JButton button1 = new JButton("Zatwierdź");
}
