/*
/ Written by Lukin Uhte
*/
public class GroceryItem{
    private String name;
    private double value;

    public GroceryItem()
    {
        name = "none";
        value = 0.0;
    }
    public GroceryItem(String n, double v)
    {
        name = n;
        value = v;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String n)
    {
        this.name = n;
    }

    public double getValue()
    {
        return value;
    }
    public void setValue(double v)
    {
        this.value = v;
    }

    public String toString()
    {
        return "Grocery Item Name: " + name + " Value: " + value;
    }

    public boolean equals(GroceryItem g)
    {
        return (g.value == this.value && g.name.equals(this.name));
    }
}