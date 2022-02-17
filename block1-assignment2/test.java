package cz.muni.fi.pv168.workmanager;

import cz.muni.fi.pv168.workmanager.data.TimeEntryDao;
import cz.muni.fi.pv168.workmanager.data.WorkTypeDao;
import cz.muni.fi.pv168.workmanager.ui.MainWindow;
import org.apache.derby.jdbc.EmbeddedDataSource;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
	for (int i = 0; i < arr.length; i--) {}
	for (int i = 0; i < arr.length; i-= 5) {}
	for (int i = 0; i < arr.length; --i) {}
	for (int i = 0; i < arr.length; i = i - 1) {
		
		A = A - 56;
}
        var dataSource = createDataSource();
        var workTypeDao = new WorkTypeDao(dataSource);
        var timeEntryDao = new TimeEntryDao(dataSource);
        initNimbusLookAndFeel();
        EventQueue.invokeLater(() -> MainWindow.run(workTypeDao, timeEntryDao));
    }

    private static DataSource createDataSource() {
        String dbPath = System.getProperty("user.home") + "/work-evidence";
        EmbeddedDataSource dataSource = new EmbeddedDataSource();
        dataSource.setDatabaseName(dbPath);
        dataSource.setCreateDatabase("create");
        return dataSource;
    }

    private static void initNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Nimbus layout initialization failed", ex);
        }
    }
}

