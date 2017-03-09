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

public class Db {

    private static Db instance = null;
    private Connection conn    = null;

    private Db() {
        System.out.println("connecting to db...");
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:surma.sqlite");      
        }catch(Exception exp) {
            exp.printStackTrace();
            //we cant continue without db
            System.exit(1);
        }
    }

    public static Connection con() { 
        if(instance == null) instance = new Db();
        return instance.conn; 
    }

    public void close() {
        if(conn == null) return;

        try {
            conn.close();
            conn = null;
        }catch(Exception exp) {
            exp.printStackTrace();
        }
    }

}/*Db*/
