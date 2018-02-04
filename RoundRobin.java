package cpuSchedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Round Robin class
 * @author shuoqiaoliu
 *
 */
public class RoundRobin {
	
	private final int swapUnit = 3;
	private int timeQuantum;
	private List<Data> info;
	private ResultGroup result;
	private int average;
	
	public RoundRobin(String fileDir,int timeQuantum){
		this.timeQuantum = timeQuantum;
		DataGroup test1 = new DataGroup(fileDir);
		result = new ResultGroup();
		info = new ArrayList<Data>(test1.getSortted());
		cpuRunning();
		getAverageCT();
	}
	
	private void cpuRunning(){
		
		int cpuTime = 0;
		int completion_Time = 0;
		int last_proc = -1;
		// create queue to initialize all the data
		Queue<Data> q_temp = new LinkedList<>();
		
		for(Data d:info){
			q_temp.add(d);
		}
		// keep running by order
		while(!q_temp.isEmpty()){

			Data d = q_temp.poll();
			int burst_time = d.getBurst_time();
			int endBurst_Time = burst_time - timeQuantum;
			// if endBurst_Time <= 0 , reset equal to zero
			if(endBurst_Time<=0){
				endBurst_Time = 0;
			}
			
			if(last_proc != d.getPid()){
				if(last_proc!=-1)
					cpuTime += swapUnit;	
			}
			//if endBurst time <= 0 
			if(endBurst_Time == 0){
				completion_Time = cpuTime + burst_time;
			}
			else{
				completion_Time = 0;
			}
			
			
			//get Result
			ResultCreator re = new ResultCreator(cpuTime,d.getPid(),burst_time,endBurst_Time,completion_Time);
			result.add(re);
			
			//create/update new data
			if(completion_Time==0){
				cpuTime += timeQuantum;
				
			}
			else{
				cpuTime = completion_Time;
			}
			
			last_proc = d.getPid();
			//delete if the burst time equal to zero
			if(endBurst_Time > 0){
				Data newData = new Data(d.getPid(),endBurst_Time,d.getPriority());
				q_temp.add(newData);
			}
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
		result.createResultFile("RoundRobin"+String.valueOf(timeQuantum),testfileNumber,average);
	}
}
