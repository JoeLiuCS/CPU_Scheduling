package cpuSchedule;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Store all the result creators
 * @author shuoqiaoliu
 *
 */
public class ResultGroup {
	
		private List<ResultCreator> resultGroup;
		

		public ResultGroup(){
			resultGroup = new ArrayList<>();
		}
		
		public Boolean add(ResultCreator r){
			return resultGroup.add(r);
		}
		/**
		 * Create csv file
		 * @param fileType
		 * @param testFile_Number
		 * @param averageCT
		 * @throws FileNotFoundException
		 */
		public void createResultFile(String fileType,int testFile_Number,int averageCT) throws FileNotFoundException{
			PrintWriter pw = new PrintWriter(
					new File("Scheduler_"+fileType+"-testfile_"+String.valueOf(testFile_Number)+".csv"));
	        StringBuilder sb = new StringBuilder();
	        sb.append("CpuTime");
	        sb.append(',');
	        sb.append("PID");
	        sb.append(',');
	        sb.append("StartingBurstTime");
	        sb.append(',');
	        sb.append("EndingBurstTime");
	        sb.append(',');
	        sb.append("CompletionTime");
	        sb.append('\n');

	        for(ResultCreator r:resultGroup){
	        	sb.append(String.valueOf(r.getCpuTime()));
		        sb.append(',');
		        sb.append(String.valueOf(r.getPID()));
		        sb.append(',');
		        sb.append(String.valueOf(r.getStartingBurstTime()));
		        sb.append(',');
		        sb.append(String.valueOf(r.getEndingBurstTime()));
		        sb.append(',');
		        sb.append(String.valueOf(r.getCompletionTime()));
		        sb.append('\n');
	        }
	        sb.append("Average CT:");
	        sb.append(',');
	        sb.append(String.valueOf(averageCT));
	        pw.write(sb.toString());
	        pw.close();
		}
		
		public List<ResultCreator> getResultGroup() {
			return resultGroup;
		}
		
}
