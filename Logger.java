import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Logger {
    // get menu requests
    // orders and costs
    // text file
    static File myObj = new File("Log.txt");
	private static Logger instance;

	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	private Logger() {

	}

    public void Log(String order, double cost){
        try{
            FileWriter fw = new FileWriter("Log.txt", true);
            fw.write(order + " -$" + cost + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void Log(String restaurant){
        try{
            FileWriter fw = new FileWriter("Log.txt", true);
            fw.write(restaurant + "'s menu was opened.\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
