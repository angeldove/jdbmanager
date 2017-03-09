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


import java.sql.*;
import java.util.Vector;

class TableField {
    private String name;
    private String type;

    public TableField(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String name() { return name; }
    public String type() { return type; }


}/*TableField*/

public class ProbeDb {

    private Connection conn;
    private Statement  stat;

    public ProbeDb() {
        conn = Db.con();
        try {
            stat = conn.createStatement();
        }catch(Exception exp) {
            exp.printStackTrace();
            //we cant continue without stat
            System.exit(1);
        }
    }

    public Vector getColumns(String tableName) throws SQLException {
        ResultSet         rs = stat. executeQuery("SELECT * from " + tableName + ";");
        ResultSetMetaData rm = rs. getMetaData();
        Vector fields = new Vector();
        for (int i = 1; i <= rm. getColumnCount(); i++) {
            String name = rm. getColumnName(i);
            String type = rm. getColumnTypeName(i);
            //L.d(name + " : " + type + " : " + rm. getColumnType(i));
            fields. addElement(new TableField(name, type));
        }
        return fields;
    }

	public Vector getRows(String query) {
		Vector            v      = new Vector();
		try {
			ResultSet         rs     = stat. executeQuery(query. trim());
			ResultSetMetaData rm     = rs. getMetaData();
			int               colCnt = rm. getColumnCount();
			while (rs.next()) {
				Vector row = new Vector();
				for(int i=1; i<= colCnt; i++) {
					row. addElement(rs. getString(i));
				}
				v. addElement(row);
			}
		}catch(Exception e) {
			e. printStackTrace();
		}
        return v;
	}

    public Vector getTableData(String tableName) throws SQLException {
        Vector            v      = new Vector();
        ResultSet         rs     = stat. executeQuery("SELECT * from " + tableName + ";");
        ResultSetMetaData rm     = rs. getMetaData();
        int               colCnt = rm. getColumnCount();
        while (rs.next()) {
            Vector row = new Vector();
            for(int i=1; i<= colCnt; i++) {
                row. addElement(rs. getString(i));
            }
            v. addElement(row);
        }
        return v;
    }

    public Vector getTables() throws SQLException {
        Vector tables = new Vector();
        String q = "SELECT name FROM sqlite_master WHERE type='table' ORDER BY name;";
        ResultSet rs = stat.executeQuery(q);
        while (rs.next()) {
            tables.addElement(rs.getString(1));
        }
        rs.close();

        return tables;
    }

    /*test functions */
    public void showColumns(String tableName) throws SQLException{
        Vector fields = getColumns(tableName);
        for(int i=0; i<fields.size(); i++) {
            TableField field = (TableField) fields.elementAt(i);
            L.d(field.name() + " : " + field.type());
        }
    }

    public static void main(String[] args) throws Exception {
        ProbeDb probe = new ProbeDb();

        //list all tables
        Vector tables = probe.getTables();
        for(int i=0; i<tables.size(); i++) {
            String tableName = (String) tables.elementAt(i);
            L.d("------- " + tableName + " ---------");
            probe.showColumns(tableName);

        }
    }
}/*ProbeDb*/
