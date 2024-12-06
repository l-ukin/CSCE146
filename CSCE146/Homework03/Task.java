public class Task{
    private int priority;
    private String action;

    public Task(int p, String t)
    {
        priority = p;
        action = t;
    }
    public Task()
    {
        priority = 4;
        action = "none";
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int p) {
        priority = p;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String t) {
        action = t;
    }

    @Override
    public String toString()
    {
        return "[Task] Priority: " + priority + " Task: " + action + "\n";
    }
}