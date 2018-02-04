package cpuSchedule;
/**
 * The data store pid, burst time and priority
 * @author shuoqiaoliu
 *
 */
public class Data {
	private int pid;
	private int burst_time;
	private int priority;
	
	public Data(int pid,int burst_time,int priority){
		this.pid = pid;
		this.burst_time = burst_time;
		this.priority = priority;
	}
	/**
	 * Print the details
	 */
	public void printData(){
		System.out.println("PID: "+pid);
		System.out.println("burst_time: "+burst_time);
		System.out.println("burst_time: "+priority);
	}
	/**
	 * Get PID
	 * @return
	 */
	public int getPid(){
		return pid;
	}
	/**
	 * Get burst time
	 * @return
	 */
	public int getBurst_time(){
		return burst_time;
	}
	/**
	 * Get Priority
	 * @return
	 */
	public int getPriority(){
		return priority;
	}
	/**
	 * 
	 * @param t the burst time want to reset
	 */
	public void setBurst_time(int t){
		burst_time = t;
	}
}
