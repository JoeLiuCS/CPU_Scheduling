package cpuSchedule;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ShortestJobFirst {
	private List<Data> info;
	private ResultGroup result;
	
	public ShortestJobFirst(String fileDir){
		DataGroup test1 = new DataGroup(fileDir);
		result = new ResultGroup();
		info = new ArrayList<Data>(test1.getSortted());
		cpuRunning();
		
	}
	private void cpuRunning(){
		int cpuTime = 0;
		int endBurst_Time = 0;
		int completion_Time = 0;
		int last_proc = -1;
		for(Data d:info){
			completion_Time = d.getBurst_time() + cpuTime;
			
			ResultCreator re = new ResultCreator(cpuTime,d.getPid(),d.getBurst_time(),endBurst_Time,completion_Time);
			result.add(re);
			
			if(last_proc != d.getPid()){
				cpuTime = completion_Time + 3;
			}
			
			last_proc = d.getPid();
		}
	}
	
	public void createResultFile(int testfileNumber) throws FileNotFoundException{
		result.createResultFile("SJF",testfileNumber);
	}
}
