package cpuSchedule;

import java.io.FileNotFoundException;
/**
 * For Running program class
 * @author shuoqiaoliu
 *
 */
public class play {
	
	final static String dir = "/Users/shuoqiaoliu/Documents/workspace/CPUschedulingAlgorithm/src/cpuSchedule/";
	
	public static void main(String[] args) throws FileNotFoundException {
		
		runProgram(1,dir + "testdata1.txt");
		runProgram(2,dir + "testdata2.txt");
		runProgram(3,dir + "testdata3.txt");
		runProgram(4,dir + "testdata4.txt");
	}
	
	public static void runProgram(int fileNumber,String fileName) throws FileNotFoundException {
		
		FirstComeFristServe fcfs = new FirstComeFristServe(fileName);
		fcfs.createResultFile(fileNumber);
		
		ShortestJobFirst sjf = new ShortestJobFirst(fileName);
		sjf.createResultFile(fileNumber);
		
		RoundRobin rr1 = new RoundRobin(fileName,25);
		rr1.createResultFile(fileNumber);
		
		RoundRobin rr2 = new RoundRobin(fileName,50);
		rr2.createResultFile(fileNumber);

		Lottery lr = new Lottery(fileName,50);
		lr.createResultFile(fileNumber);
		
	}

}
