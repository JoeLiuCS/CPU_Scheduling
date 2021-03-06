package cpuSchedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Lottery class
 * @author shuoqiaoliu
 *
 */
public class Lottery {
	
	private final int swapUnit = 3;
	private int timeQuantum;
	private List<Data> info;
	private ResultGroup result;
	private int Max_priority;
	private int average;
	
	public Lottery(String fileDir,int timeQuantum){
		this.timeQuantum = timeQuantum;
		DataGroup test1 = new DataGroup(fileDir);
		result = new ResultGroup();
		info = new ArrayList<Data>(test1.getSortted());
		getMaxpriority();
		cpuRunning();
		getAverageCT();
	}
	
	private void cpuRunning(){
		int cpuTime = 0;
		int completion_Time = 0;
		int last_proc = -1;
		
		List<Data> temp_info = new ArrayList<>(info);
		int total_priority = Max_priority;
		
		while(!temp_info.isEmpty()){
			int getRandom = getRandomNumber(total_priority);
			// initialize
			int in = checkUse(getRandom,temp_info);
			Data cpuIn = temp_info.get(in);
			int burst_time = cpuIn.getBurst_time();
			int endBurst_Time = burst_time - timeQuantum;
			
			// if endBurst_Time <= 0 , reset equal to zero
			if(endBurst_Time<=0){
				endBurst_Time = 0;
			}
			else{
				temp_info.get(in).setBurst_time(endBurst_Time);
			}
			//pro
			if(last_proc != cpuIn.getPid()){
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
			
			//store result
			ResultCreator re = new ResultCreator(cpuTime,cpuIn.getPid(),burst_time,endBurst_Time,completion_Time);
			result.add(re);
			
			//update
			if(completion_Time ==0){
				cpuTime += timeQuantum;
				
			}
			else{
				cpuTime = completion_Time;
			}
			
			// update last proc for next run checking
			last_proc = cpuIn.getPid();
			
			//delete
			if(endBurst_Time <=0){
				total_priority -=temp_info.remove(in).getPriority();
			}
		}
		
	}
	
	private void getAverageCT(){
		for(ResultCreator r :result.getResultGroup()){
			average += r.getCompletionTime();
		}
		average = average / info.size();
	}
	
	public void createResultFile(int testfileNumber) throws FileNotFoundException{
		result.createResultFile("Lottery"+String.valueOf(timeQuantum),testfileNumber,average);
	}
	/**
	 * Get specific PID
	 * @param num random number
	 * @param l	  Data list
	 * @return decide which processor going to use
	 */
	private int checkUse(int num,List<Data> l){
		int result = 0;
		int count = 0;
		for(Data d:l){
			count += d.getPriority();
			if(num<=count){
				result = l.indexOf(d);
				break;
			}
		}
		return result;
	}
	/**
	 * Sum all priority
	 */
	private void getMaxpriority(){
		Max_priority = 0;
		for(Data d : info){
			Max_priority += d.getPriority();
		}
	}
	/**
	 * Get random number
	 * @param max
	 * @return num
	 */
	private int getRandomNumber(int max){
		Random r = new Random();
		return r.nextInt((max - 1) +1) +1;
	}
}
