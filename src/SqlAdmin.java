/*
 * -----------------------------------
 * Java DB Manager
 * -----------------------------------
 *
 * This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 * Author: Roohi Verma <roohivermapb@gmail.com>
 * 
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class SqlAdmin extends JFrame implements ActionListener {
    private   ProbeDb   probe 				= new ProbeDb();
    private   TopPanel  pnlTop 				= new TopPanel();
    private   JPanel    pnlBottom			= new JPanel();
    private   JPanel    pnlLeft 			= new JPanel();
    private   JTextArea taContent 			= new JTextArea(); 	

    SqlAdmin() {
        super("SQLite Admin");
        setSize(800, 700);
        setLocation(100, 50);

        setLayout(new BorderLayout());

        /*top toolbar*/
        JButton btnClear = new JButton("Clear");
        btnClear. 	addActionListener(this);
        pnlBottom.	add(btnClear);
        add(pnlBottom, BorderLayout.SOUTH);
        add(pnlTop, BorderLayout.NORTH);

        add(pnlLeft, BorderLayout. WEST);
        add(taContent, BorderLayout. CENTER);

        /*add tables*/
        try {
            Vector tables = probe. 	getTables();
            pnlLeft.			   	setLayout(new GridLayout(tables.size() * 2, 1));
            for(int i = 0; i < tables. size(); i++) {
                String tableName = 		(String) tables. elementAt(i);
                JButton btnTableInfo = 	new JButton(tableName + " (info)");
                btnTableInfo. 			addActionListener(this);
                pnlLeft.  				add(btnTableInfo);
                JButton btnTableData = 	new JButton(tableName + " (data)");
                btnTableData.			addActionListener(this);
                pnlLeft.  				add(btnTableData);
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupMenus();
        setVisible(true);
    }

    private void setupMenus() {
        L.d("[SqlAdmin] :: setupMenus to be done");

        JMenuBar  		mbAdminSql  				=  	new JMenuBar();
        JMenu     		jmFile      				=  	new JMenu("File");
        JMenu     		jmEdit      				=  	new JMenu("Edit");
        JMenu     		jmDatabase      			=  	new JMenu("Database");
        JMenu     		jmView      				=  	new JMenu("View");
        JMenu     		jmScript     				=  	new JMenu("Script");
        JMenu     		jmWindow      				=  	new JMenu("Window");
        JMenu     		jmHelp      				=  	new JMenu("Help");
        //menuItems for File Menu
        JMenuItem  		miNewFile  					=   new JMenuItem("New");
        JMenuItem  		miOpenFile  				=   new JMenuItem("Open");
        JMenuItem  		miOpenRecentFile  			=   new JMenuItem("Open Recent");
        JMenuItem  		miConnectFile  				=   new JMenuItem("Connect");
        JMenuItem  		miCloseFile  				=   new JMenuItem("Close");
        JMenuItem  		miImportFile  				=   new JMenuItem("Import");
        JMenuItem  		miExportFile  				=   new JMenuItem("Export..");
        JMenuItem  		miConvertDBFile  			=   new JMenuItem("Convert Database");
        JMenuItem  		miCleanUpDBFile  			=   new JMenuItem("Clean up Database");
        JMenuItem  		miPrintFile  				=   new JMenuItem("Print ...");
        JMenuItem  		miGenrateReportFile 		=   new JMenuItem("Generate Report..");
        JMenuItem  		miExitFile  				=   new JMenuItem("Exit");
        JSeparator  	jsAfterCloseFile 			= 	new JSeparator();
        JSeparator      jsAfterConvertDBFile 		= 	new JSeparator();
        JSeparator  	jsAfterGenrateReport 		= 	new JSeparator();
        //MenuItems for Edit Menu
        JMenuItem  		miUndoEdit  				=   new JMenuItem("Undo");
        JMenuItem  		miCutEdit  					=   new JMenuItem("Cut");
        JMenuItem  		miCopyEdit  				=   new JMenuItem("Copy");
        JMenuItem  		miCopyRecordSet  			=   new JMenuItem("Copy  RecordSet");
        JMenuItem  		miPasteEdit      			=   new JMenuItem("Paste");
        JMenuItem  		miDeleteEdit  				=   new JMenuItem("Delete ");
        JMenuItem  		miSelectAllEdit  			=   new JMenuItem("Select All");
        JMenuItem  		miAlterEdit  				=   new JMenuItem("Alter");
        JMenuItem  		miDropEdit  				=   new JMenuItem("Drop");
        JMenuItem  		miPreferencesEdit  			=   new JMenuItem("Preferences");
        JSeparator  	jsAfterUndoEdit 			= 	new JSeparator();
        JSeparator  	jsAfterSelectAll 			= 	new JSeparator();
        JSeparator  	jsAfterDrop 				= 	new JSeparator();
        // MenuItems for Database menu
        JMenuItem  		miCreateTable  				=   new JMenuItem("Create table");
        JMenuItem  		miCreateView  				=   new JMenuItem("Create View");
        JMenuItem  		miCreateIndex 				=   new JMenuItem("Create Index");
        JMenuItem  		miCreateReport  			=   new JMenuItem("Create Report");
        JMenuItem  		miCreateTriggr  			=   new JMenuItem("Create trigger");
        JMenuItem  		miCreateSQL  				=   new JMenuItem("Create SQL");
        JMenuItem  		miCreateNote  				=   new JMenuItem("Create Note");
        JMenuItem  		miEncoding 				    =   new JMenuItem("Encoding");
        JMenuItem  		miEditTable  				=   new JMenuItem("Edit table");
        JMenuItem  		miVacumm  					=   new JMenuItem("Vacumm");
        JMenuItem  		miDetailedAnalyzer  		=   new JMenuItem("Detailed Analizer");
        JMenuItem  		miLocalExtension  			=   new JMenuItem("Local Extension");
        JMenuItem  		miSettings  				=   new JMenuItem("Settings");
        JSeparator  	jsAfterCreateNote 			= 	new JSeparator();
        JSeparator  	jsAfterVaccum 				= 	new JSeparator();
        //MenuItems for Script menu
        JMenuItem  		miManager  					=   new JMenuItem("Manager");
        //MenuItems for View menu
        JMenuItem  		miDesign  					=   new JMenuItem("Design");
        JMenuItem  		miManage  				    =   new JMenuItem("Manage");
        JMenuItem  		miSQL  						=   new JMenuItem("SQL");
        JMenuItem  		miAnalyze  					=   new JMenuItem("Analizer");
        JMenuItem  		miVerify  					=   new JMenuItem("Verify");
        JMenuItem  		miOptimize  				=   new JMenuItem("Optimize");
        JMenuItem  		miCharts  					=   new JMenuItem("Charts");
        //MenuItems for Window menu
        JMenuItem  		miMinimize  				=   new JMenuItem("Minimize");
        JMenuItem  		miZoom  					=   new JMenuItem("Zoom");
        JMenuItem  		miSqlHistory  				=   new JMenuItem("SQL History");
        JMenuItem  		miBLOBPreview  				=   new JMenuItem("BLOB Preview");
        JMenuItem  		miLogWindow  				=   new JMenuItem("Log Window ");
        JMenuItem  		miServerStatus  			=   new JMenuItem("Server Status");
        JMenuItem  		miBringAllFront  			=   new JMenuItem("Bring All to Front");
        JSeparator  	jsAfterZoom 				= 	new JSeparator();
        //menuItems for Help menu
        JMenuItem  		miCheckNewVersion  			=   new JMenuItem("Check For New Version");
        JMenuItem  		miReportBug  				=   new JMenuItem("Report a Bug to SQLabs");
        JMenuItem  		miSqlRefrences  			=   new JMenuItem("SQL Language Reffrences");
        JMenuItem  		miScriptLanguageReff  		=   new JMenuItem("Scripting Language Refferences");
        JMenuItem  		miSqlAdminHelp 				=   new JMenuItem("SqlAdmin Manager Help");
        JMenuItem  		miAbout  					=   new JMenuItem("About SqlAdmin");
        JSeparator  	jsAfterReportBug 			= 	new JSeparator();
        /*set Shortcuts*/
        miUndoEdit.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        miCutEdit.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        miCopyEdit.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        miPasteEdit.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        miSelectAllEdit.		setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        miAlterEdit.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        miPreferencesEdit.		setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        miCreateTable.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        miCreateView.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        miCreateIndex.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        miCreateReport.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        miCreateTriggr.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        miCreateSQL.			setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        miVacumm.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        miDesign.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_1, ActionEvent.CTRL_MASK));
        miManage.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_2, ActionEvent.CTRL_MASK));
        miSQL.					setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_3, ActionEvent.CTRL_MASK));
        miAnalyze.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_4, ActionEvent.CTRL_MASK));
        miVerify.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_5, ActionEvent.CTRL_MASK));
        miOptimize.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_6, ActionEvent.CTRL_MASK));
        miCharts.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_7, ActionEvent.CTRL_MASK));
        miMinimize.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        miManager.				setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

        //add menus
        mbAdminSql.add(jmFile);
        mbAdminSql.add(jmEdit);
        mbAdminSql.add(jmDatabase);
        mbAdminSql.add(jmView);
        mbAdminSql.add(jmScript);
        mbAdminSql.add(jmWindow);
        mbAdminSql.add(jmHelp);

        //add menuitems of File menu
        jmFile.add(miNewFile);
        jmFile.add(miOpenFile);
        jmFile.add(miOpenRecentFile);
        jmFile.add(miConnectFile);
        jmFile.add(miCloseFile);
        jmFile.add(jsAfterCloseFile);
        jmFile.add(miImportFile);
        jmFile.add(miExportFile);
        jmFile.add(miConvertDBFile);
        jmFile.add(jsAfterConvertDBFile);
        jmFile.add(miCleanUpDBFile);
        jmFile.add(miPrintFile);
        jmFile.add(miGenrateReportFile);
        jmFile.add(jsAfterGenrateReport);
        jmFile.add(miExitFile);
        //add MenuItems in Edit menu
        jmEdit.add(miUndoEdit);
        jmEdit.add(jsAfterUndoEdit);
        jmEdit.add(miCutEdit);
        jmEdit.add(miCopyEdit);
        jmEdit.add(miCopyRecordSet);
        jmEdit.add(miPasteEdit);
        jmEdit.add(miDeleteEdit);
        jmEdit.add(miSelectAllEdit);
        jmEdit.add(jsAfterSelectAll);
        jmEdit.add(miAlterEdit);
        jmEdit.add(miDropEdit);
        jmEdit.add(jsAfterDrop);
        jmEdit.add(miPreferencesEdit);

        //add MenuItems of DataBase menu
        jmDatabase.add(miCreateTable);
        jmDatabase.add(miCreateView);
        jmDatabase.add(miCreateIndex);
        jmDatabase.add(miCreateReport);
        jmDatabase.add(miCreateTriggr);
        jmDatabase.add(miCreateSQL);
        jmDatabase.add(miCreateNote );
        jmDatabase.add(jsAfterCreateNote);
        jmDatabase.add(miEncoding );
        jmDatabase.add(miVacumm);
        jmDatabase.add(miEditTable);
        jmDatabase.add(jsAfterVaccum);
        jmDatabase.add(miDetailedAnalyzer);
        jmDatabase.add(miLocalExtension);
        jmDatabase.add(miSettings);
        //add MenuItems of View menu
        jmView.add(miDesign);
        jmView.add(miManage);
        jmView.add(miSQL);
        jmView.add(miAnalyze);
        jmView.add(miVerify);
        jmView.add(miOptimize);
        jmView.add(miCharts);


        //add MenuItems of Script menu
        jmScript.add(miManager);
        //add MenuItems of Window menu
        jmWindow.add(miMinimize);
        jmWindow.add(miZoom);
        jmWindow.add(jsAfterZoom);
        jmWindow.add(miSqlHistory);
        jmWindow.add(miBLOBPreview);
        jmWindow.add(miServerStatus);
        jmWindow.add(miLogWindow);
        jmWindow.add(miBringAllFront);
        //add MenuItems of Help menu
        jmHelp.add(miCheckNewVersion);
        jmHelp.add(miReportBug);
        jmHelp.add(jsAfterReportBug);
        jmHelp.add(miSqlRefrences);
        jmHelp.add(miScriptLanguageReff);
        jmHelp.add(miSqlAdminHelp);
        jmHelp.add(miAbout);
        setJMenuBar(mbAdminSql);
    }

    public void actionPerformed(ActionEvent ae){
        String cmd = ae.getActionCommand();
        if(cmd.endsWith("(info)")) { showTableInfo(cmd.substring(0, cmd.length() - 6)); }
        if(cmd.endsWith("(data)")) { showTableData(cmd.substring(0, cmd.length() - 6)); }
        if(cmd.equals("Clear")) taContent.setText("");
    }

    private void showTableInfo(String tableName) {
        try {
            Vector fields = probe.getColumns(tableName);
            for(int i=0; i<fields.size(); i++) {
                TableField field = (TableField) fields.elementAt(i);
                addLine(field.name() + " : " + field.type());
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }

    private void showTableData(String tableName) {
        try {
            Vector data = probe.getTableData(tableName);
            for(int i=0; i<data.size(); i++) {
                Vector row = (Vector) data.elementAt(i);
                String line="";
                for(int j=0; j<row.size(); j++) {
                    line += (String) row.elementAt(j) + ", ";
                }
                addLine(line);
            }
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }

    private void addLine(String line) {
        taContent.setText(taContent.getText() + line + "\n");
    }

    public static void main(String[] args) throws Exception {
        new SqlAdmin();
    }
}
