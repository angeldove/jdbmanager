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

public class L{

	/*print convenience method*/
	public static void p(String msg){
		System.out.println(msg);
		}

	/*debug*/
	public static void d(String msg){
		if(Config.LOG_LEVEL <= Config.LOG_DEBUG) { 
		  p(msg);
		}
	}

    /*info*/
	public static void i(String msg){
		if(Config.LOG_LEVEL <= Config.LOG_INFO) { 
		  p(msg);
		}
	}

    /*warning*/
	public static void w(String msg){
		if(Config.LOG_LEVEL <= Config.LOG_WARNING) { 
		  p(msg);
		}
	}

    /*critical*/
	public static void c(String msg){
		if(Config.LOG_LEVEL <= Config.LOG_CRITICAL) { 
		  p(msg);
		}
	}

    /*error*/
	public static void e(String msg){
		if(Config.LOG_LEVEL <= Config.LOG_ERROR) { 
		  p(msg);
		}
	}
}