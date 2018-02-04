package cpuSchedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * Shortest job first
 * @author shuoqiaoliu
 *
 */
public class ShortestJobFirst {
	
	private final int swapUnit = 3;
	private List<Data> info;
	private ResultGroup result;
	private int average;
	
	public ShortestJobFirst(String fileDir){
		DataGroup test1 = new DataGroup(fileDir);
		result = new ResultGroup();
		info = new ArrayList<Data>(test1.getSortted());
		cpuRunning();
		getAverageCT();
	}
	private void cpuRunning(){
		int cpuTime = 0;
		int endBurst_Time = 0;
		int completion_Time = 0;
		int last_proc = -1;
		for(Data d:info){
			completion_Time = d.getBurst_time() + cpuTime;
			//store results
			ResultCreator re = new ResultCreator(cpuTime,d.getPid(),d.getBurst_time(),endBurst_Time,completion_Time);
			result.add(re);
			// swap unit 
			if(last_proc != d.getPid()){
				cpuTime = completion_Time + swapUnit;
			}
			//update last proc
			last_proc = d.getPid();
		}
	}
	/**
	 * Get average completion time
	 */
	private void getAverageCT(){
		for(ResultCreator r :result.getResultGroup()){
			average += r.getCompletionTime();
		}
		average = average / info.size();
	}
	/**
	 * Create result file
	 * @param testfileNumber
	 * @throws FileNotFoundException
	 */
	public void createResultFile(int testfileNumber) throws FileNotFoundException{
		result.createResultFile("SJF",testfileNumber,average);
	}
}
