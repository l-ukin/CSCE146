/*
* Written by Lukin Uhte
*/
public class ProcessScheduler{
    LLQueue<Process> processes;
    Process currentProcess;

    public ProcessScheduler()
    {
        processes = new LLQueue<Process>();
        currentProcess = null;
    }

    //Returns the current process
    public Process getCurrentProcess() {
        return currentProcess;
    }

    //Adds a process to the end of the queue, or sets it to the current process if there is no current process.
    public void addProcess(Process p)
    {
        if(currentProcess == null)
        {
            currentProcess = p;
        }else{
            processes.enqueue(p);
        }
    }

    //Sets the first process in the queue to current process and removes the first process from the queue.
    public void runNextProcess()
    {
        currentProcess = processes.dequeue();
    }

    //I was unsure on this one, but it felt like these two did the same thing in different words? The code seemed to have worked, so I'm not touching it.
    public void cancelCurrentProcess()
    {
        runNextProcess();
    }

    //Prints the processes queue.
    public void printProcessQueue()
    {
        processes.print();
    }
}