package cpuSchedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * First come First serve
 * @author shuoqiaoliu
 *
 */
public class FirstComeFristServe {

	private List<Data> info;
	private ResultGroup result;
	private int average;
	private final int swapUnit = 3;
	
	public FirstComeFristServe(String fileDir){
		DataGroup test1 = new DataGroup(fileDir);
		result = new ResultGroup();
		info = new ArrayList<Data>(test1.getNonSort_list());
		cpuRunning();
		getAverageCT();
	}
	/**
	 * Get results
	 */
	private void cpuRunning(){
		int cpuTime = 0;
		int endBurst_Time = 0;
		int completion_Time = 0;
		int last_proc = -1;
		// run each input data
		for(Data d:info){
			completion_Time = d.getBurst_time() + cpuTime;
			//store the data
			ResultCreator re = new ResultCreator(cpuTime,d.getPid(),d.getBurst_time(),endBurst_Time,completion_Time);
			result.add(re);
			//update CPU time
			if(last_proc != d.getPid()){
				cpuTime = completion_Time + swapUnit;
			}
			
			last_proc = d.getPid();
		}
	}
	
	/**
	 * Get Average completion time
	 */
	private void getAverageCT(){
		for(ResultCreator r :result.getResultGroup()){
			average += r.getCompletionTime();
		}
		average = average / info.size();
	}
	/**
	 * Create result csv file
	 * @param testfileNumber
	 * @throws FileNotFoundException
	 */
	public void createResultFile(int testfileNumber) throws FileNotFoundException{
		result.createResultFile("FCFS",testfileNumber,average);
	}
	
	
}
