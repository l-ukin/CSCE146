public class Process
{
    private String name;
    private double time;

    public Process()
    {
        name = "none";
        time = 0.0;
    }

    public Process(String n, double t)
    {
        name = n;
        time = t;
    }

    public double getCompletionTime() {
        return time;
    }
    
    public void setCompletionTime(double t) {
        if(t >= 0.0)
            time = t;
        else
            time = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String toString()
    {
        return "Process Name: " + name + " Completion Time: " + time;
    }
}