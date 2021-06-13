package sample;

import javafx.scene.layout.Pane;
import java.util.*;
import java.io.*;
import java.text.*;

public class Database implements Serializable{
    private static final long serialVersionUID=42L;
    private static Database db;
    private ArrayList<DataTable> databaseFiles;
    public Database() {
        databaseFiles = new ArrayList<DataTable>();
    }
    public ArrayList<DataTable> getDatabaseFiles() {
        return databaseFiles;
    }
    public void addData(DataTable d) {
        databaseFiles.add(d);
    }
    public void removeData(DataTable d) {
        if (databaseFiles.contains(d)) {
            databaseFiles.remove(d);
        }
    }
    public static void deleteAllProgress() {
        db = new Database();
    }
}
