
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SingletonForOneRun {
	//318383973
	final static String SINGLETON_FILE_NAME = "singletonTTT.dat";
	final static String SINGLETON_FILE_MODE = "rw";
	final static String SINGLETON_MESSAGE = "Only one stage can run. close the running stage\n"
			+ "by clicking on x (not the red square button).";
	private static RandomAccessFile randomSingletonTTT;
	private static File fileSingletonTTT = new File(SINGLETON_FILE_NAME);

	public static int getInstance() throws IOException {
		// -- wrong design for empty file
		int number=0;

		randomSingletonTTT = new RandomAccessFile(fileSingletonTTT, SINGLETON_FILE_MODE);
		if(randomSingletonTTT.length()>0)
		number = randomSingletonTTT.readInt();

		if (number == 0) {
			randomSingletonTTT.setLength(0);
			randomSingletonTTT.writeInt(1);
			return 0; 
		} else
			return 1;
		

	}

	public static void resetInstance() throws IOException {
		randomSingletonTTT = new RandomAccessFile(fileSingletonTTT, SINGLETON_FILE_MODE);
		randomSingletonTTT.setLength(0);
		randomSingletonTTT.writeInt(0);
		
	}
}