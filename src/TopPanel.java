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

public class TopPanel extends JPanel{
	/*Buttons*/
	JButton btnDesign 	= new JButton("Design");
	JButton btnManage 	= new JButton("Manage");
	JButton btnSQL 		= new JButton("SQL");
	JButton btnAnalyze 	= new JButton("Analyze");
	JButton btnVerify 	= new JButton("Verify");
	JButton btnOptimize = new JButton("Optimize");
	JButton btnChart 	= new JButton("Chart");
   
    TopPanel() {
		setLayout(new GridLayout(1,8));
		add(btnDesign);
		add(btnManage);
		add(btnSQL);
		add(btnAnalyze);
	    add(btnOptimize);
		add(btnChart);
        setVisible(true);
    }
}/*ToolBarGUI*/
