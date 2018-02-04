package cpuSchedule;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/**
 * Store all the data from the given files
 * @author shuoqiaoliu
 *
 */
public class DataGroup {
		//Non sort data list
		private List<Data> nonSort;
		//Sorted data list base on burst time
		private List<Data> Sortted;
		
		public DataGroup(String fileDir){
			nonSort = new ArrayList<>();
			fillData(fileDir);
			sortData();
		}
		/**
		 * Fill the data to non sort collection
		 * @param fileDir
		 */
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
		/**
		 * Get sorted collection (Selection sort)
		 */
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
		/**
		 * Swap the data from the list
		 * @param l List
		 * @param pos1 position one
		 * @param pos2 position two
		 */
		private void swapList(List<Data> l,int pos1,int pos2){
			Collections.swap(l, pos1, pos2);
		}
		/**
		 * Get non sort list
		 * @return non Sort list
		 */
		public List<Data> getNonSort_list(){
			return nonSort;
		}
		/**
		 * Get sorted list
		 * @return
		 */
		public List<Data> getSortted(){
			return Sortted;
		}
}
