package cpuSchedule;

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

		public int getCpuTime() {
			return CpuTime;
		}

		public int getPID() {
			return PID;
		}

		public int getStartingBurstTime() {
			return StartingBurstTime;
		}

		public int getEndingBurstTime() {
			return EndingBurstTime;
		}

		public int getCompletionTime() {
			return CompletionTime;
		}
		public void setCpuTime(int CpuTime){
			this.CpuTime = CpuTime;
		}
		
		
}
