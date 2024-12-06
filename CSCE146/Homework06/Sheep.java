public class Sheep implements Comparable<Sheep>
{
    private String name;
    private int sheerTime;
    private int arrivalTime;

    public Sheep(String n, int s, int a)
    {
        name = n;
        sheerTime = s;
        arrivalTime = a;
    }

    public String getName()
    {
        return name;
    }
    public int getSheerTime()
    {
        return sheerTime;
    }
    public int getArrivalTime()
    {
        return arrivalTime;
    }

    public int compareTo(Sheep compSheep)
    {
        if(this.arrivalTime == 0)
            return -10000; //Really big number, to put it in the front
        if(compSheep.getArrivalTime() == 0)
            return 10000; //Really big number, to put it in the front
        if(this.sheerTime != compSheep.getSheerTime())
            return this.sheerTime - compSheep.getSheerTime();
        return this.name.compareTo(compSheep.getName());
    }

    public String toString() //For the output later, when printing the schedule
    {
        return "Name: " + name + ", Shear Time: " + sheerTime + ", Arrival Time: " + arrivalTime;
    }
}