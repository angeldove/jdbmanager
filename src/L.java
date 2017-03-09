/*
*  WeaveBytes Logger
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