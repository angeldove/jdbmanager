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


import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class PnlSQL extends JPanel implements ActionListener {

    private ProbeDb        probe;
    private Vector         vctResult;
    private JPanel         pnlUpper, pnlLower;
    private MyTableModel   tm;
    private JTable         tblResult;
	private MyTableModel   tmTableModel;
    private JScrollPane    spTaCommand;
    private int            selectableRow = -1;
    private JComboBox      cmbTables;
    private JLabel         lblSQLQuery;
	private JToolBar	   tbTop;
	private JButton    	   btnExecute;
	private JTextArea	   taCommand;
	
	private int yOffset = 10;
    /**
     * Constructor of SQLiteAdmin
     **/
    PnlSQL() {
        
		//setLayout(new GridLayout(2,1));
		setLayout(null);
		
		probe      = new ProbeDb();		
		vctResult  = new Vector();
		
		pnlUpper = new JPanel();
		pnlUpper. setSize(1200, 220);
		pnlUpper. setLocation(0, 0);
		pnlUpper. setBorder(BorderFactory. createLineBorder(Color.RED));
		pnlUpper. setLayout(null);
		
		lblSQLQuery = new JLabel(Config. APP_LBL_SQL_QUERY);
		lblSQLQuery. setSize(150, 30);
		lblSQLQuery. setLocation(100, yOffset);		
		
		btnExecute = new JButton(Config. APP_BTN_SQL);
        btnExecute. addActionListener(this);
		btnExecute. setActionCommand(Config. APP_BTN_SQL_ACTION_COMMAND);
		btnExecute. setSize(120, 30);
		btnExecute. setLocation(540, yOffset + 170);
		
		taCommand = new JTextArea();
		
		spTaCommand = new JScrollPane(taCommand);
		spTaCommand. setSize(1000,120);
		spTaCommand. setLocation(100,yOffset + 30);
		
		pnlUpper. add(spTaCommand);
		pnlUpper. add(btnExecute);
				
		pnlLower = new JPanel();
		pnlLower. setSize(1200, 310);
		pnlLower. setLocation(0, yOffset + 220);
		pnlLower. setBorder(BorderFactory. createLineBorder(Color.GREEN));
		pnlLower. setLayout(null);
		
		add(lblSQLQuery);
		add(pnlUpper);
		add(pnlLower);
    }

    /**
     * Function to handle events of buttons, menus etc.
     **/
    public void actionPerformed(ActionEvent ae){
        String cmd = ae.getActionCommand();

        if(cmd.equals(Config. APP_BTN_SQL_ACTION_COMMAND)) {
			// if(1 == identifyQuery(query)) {
				
				//tmTableModel = new MyTableModel();
				//tblResult = new JTable();
			// }
        }
    }
	
	 /**
     * Function to identify queries coming from user
     **/
	public int identifyQuery(String query) {
		return 1;
	}
	
	// public Vector getQueryExecuted() {
		// try {
			// vctResult = probe. getRows();
			// ResultSetMetaData rm     = rs. getMetaData();
			// return vctResult;
		// } catch(Exception e) {
			// e.printStackTrace();
		// }
		// return vctResult;
	// }
	
    /************************************************************
        Inner class for creating custom table model
     ************************************************************/
    class MyTableModel extends DefaultTableModel {		

        MyTableModel(Vector data, Vector heading) {
            super(data, heading);
            fireTableDataChanged();
        }

        public boolean isCellEditable(int row, int col) {
            if(selectableRow == row && col < 4 && col > 1) { return true; } 
            else                                           { return false; }
        }

        public Class getColumnClass(int column) {
            return getValueAt(0, column). getClass();
        }

        /*public void setValueAt(Object value, int row, int col) {
          String newValue = (String)value;
          Vector vctRow = (Vector)vctUser.elementAt(row);
          vctRow.set(col,newValue);

        //make row selectable false
        selectableRow = -1;

        //notify table
        fireTableCellUpdated(row, col);
        }
         */
    }/*MyTableModel*/
}/*PnlSQL*/
