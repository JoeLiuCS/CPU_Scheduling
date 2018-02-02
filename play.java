package cpuSchedule;

import java.io.FileNotFoundException;

public class play {
	
	final static String dir = "/Users/shuoqiaoliu/Documents/workspace/CPUschedulingAlgorithm/src/cpuSchedule/";
	
	public static void main(String[] args) throws FileNotFoundException {
		
//		runProgram(1,"testdata1.txt");
//		FirstComeFristServe fcfs = new FirstComeFristServe(dir + "testdata1.txt");
//		fcfs.createResultFile(1);
		
		RoundRobin rr = new RoundRobin(dir + "testdata5.txt",4);
		rr.createResultFile(5);
		Lottery lr = new Lottery(dir + "testdata6.txt",4);
		lr.createResultFile(6);
	}
	
	public static void runProgram(int fileNumber,String fileName) {
		
		
		ShortestJobFirst sjf = new ShortestJobFirst(dir + fileName);
		
		
		try {
			
			sjf.createResultFile(fileNumber);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
