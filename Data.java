package cpuSchedule;

public class Data {
	private int pid;
	private int burst_time;
	private int priority;
	
	public Data(int pid,int burst_time,int priority){
		this.pid = pid;
		this.burst_time = burst_time;
		this.priority = priority;
	}
	
	public void printData(){
		System.out.println("PID: "+pid);
		System.out.println("burst_time: "+burst_time);
		System.out.println("burst_time: "+priority);
	}
	public int getPid(){
		return pid;
	}
	public int getBurst_time(){
		return burst_time;
	}
	public int getPriority(){
		return priority;
	}
	public void setBurst_time(int t){
		burst_time = t;
	}
}
