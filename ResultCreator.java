package cpuSchedule;
/**
 * The class for store the result
 * @author shuoqiaoliu
 *
 */
public class ResultCreator {
		private int CpuTime;
		private int PID;
		private int StartingBurstTime;
		private int EndingBurstTime;
		private int CompletionTime;
		
		public ResultCreator(int CpuTime,int PID,int StartingBurstTime,
				int EndingBurstTime,int CompletionTime){
			this.CpuTime = CpuTime;
			this.PID = PID;
			this.StartingBurstTime = StartingBurstTime;
			this.EndingBurstTime = EndingBurstTime;
			this.CompletionTime = CompletionTime;
		}
		/**
		 * Get Cpu time
		 * @return Cpu time
		 */
		public int getCpuTime() {
			return CpuTime;
		}
		/**
		 * Get PID
		 * @return PID number
		 */
		public int getPID() {
			return PID;
		}
		/**
		 * Get start burst time
		 * @return start burst time
		 */
		public int getStartingBurstTime() {
			return StartingBurstTime;
		}
		/**
		 * Get ending burst time
		 * @return ending burst time
		 */
		public int getEndingBurstTime() {
			return EndingBurstTime;
		}
		/**
		 * Get completion time 
		 * @return completion time 
		 */
		public int getCompletionTime() {
			return CompletionTime;
		}
		/**
		 * reset the CPU time
		 * @param CpuTime
		 */
		public void setCpuTime(int CpuTime){
			this.CpuTime = CpuTime;
		}
		
		
}
