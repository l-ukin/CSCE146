/*
* Written by Lukin Uhte
*/
public class Fruit implements Comparable
{
    private String type;
    private double weight;

    public Fruit()
    {
        type = "Apple";
        weight = 1.0;
    }
    public Fruit(String t, double w)
    {
        type = "Apple";
        weight = 1.0;
        if(t.equals("Orange") || t.equals("Banana") || t.equals("Kiwi") || t.equals("Tomato"))
            type = t;
        if(w > 0)
            weight = w;
    }

    public double getWeight()
    {
        return weight;
    }
    public void setWeight(double w)
    {
        weight = 1.0;
        if(w > 0)
            weight = w;
    }

    public String getType()
    {
        return type;
    }
    public void setType(String t)
    {
        type = "Apple";
        if(t.equals("Orange") || t.equals("Banana") || t.equals("Kiwi") || t.equals("Tomato"))
            type = t;
    }

    @Override
    public String toString()
    {
        return "Type: " + type + " Weight: " + weight;
    }

    @Override
    public int compareTo(Object o)
    {
        Fruit aFruit = (Fruit) o;
        if(aFruit == null)
            return -1;
        if(weight == aFruit.getWeight())
        {
            return type.compareTo(aFruit.getType());
        }
        else
        {
            return (int) (weight - aFruit.getWeight());
        }
    }
}