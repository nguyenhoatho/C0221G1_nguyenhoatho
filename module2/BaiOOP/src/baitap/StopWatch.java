package baitap1;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime=System.currentTimeMillis();
        ;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime() {
        this.startTime = System.currentTimeMillis();
    }

    public long getEndTime() {
        return this.endTime=System.currentTimeMillis();
    }

    public void setEndTime() {
        this.endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime-this.startTime;

    }
}
class Main2{
    public static void main(String[] args) {
        StopWatch Tr=new StopWatch();
        System.out.println(Tr.getStartTime());
        System.out.println(Tr.getEndTime());
        System.out.println(Tr.getElapsedTime());
    }


}

