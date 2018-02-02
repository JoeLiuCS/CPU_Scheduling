package cpuSchedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DataGroup {
	
		private List<Data> nonSort;
		private List<Data> Sortted;
		
		public DataGroup(String fileDir){
			nonSort = new ArrayList<>();
			fillData(fileDir);
			sortData();
		}
		
		private void fillData(String fileDir){
			File file = new File(fileDir);
			try {
				Scanner in = new Scanner(file);
				while(in.hasNextLine()){
					int pid = Integer.parseInt(in.nextLine());
					int burst_time = Integer.parseInt(in.nextLine());
					int priority = Integer.parseInt(in.nextLine());
					
					Data newData = new Data(pid,burst_time,priority);
					nonSort.add(newData);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		private void sortData(){
			Sortted = new ArrayList<>(nonSort);
			for(int i=0;i<Sortted.size();i++){
				int burst_Time_temp = Sortted.get(i).getBurst_time();
				for(int j=i+1;j<Sortted.size();j++){
					if(burst_Time_temp >= Sortted.get(j).getBurst_time()){
						burst_Time_temp = Sortted.get(j).getBurst_time();
						swapList(Sortted,i,j);
					}
				}
				
			}
		}
		
		private void swapList(List<Data> l,int pos1,int pos2){
			Collections.swap(l, pos1, pos2);
		}
		
		public List<Data> getNonSort_list(){
			return nonSort;
		}
		public List<Data> getSortted(){
			return Sortted;
		}
}
