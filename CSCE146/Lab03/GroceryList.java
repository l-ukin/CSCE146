/*
/ Written by Lukin Uhte
*/
public class GroceryList{

    private class ListNode
    {
        private GroceryItem data;
        private ListNode link;

        private ListNode()
        {
            data = null;
            link = null;
        }

        private ListNode(GroceryItem d, ListNode l)
        {
            data = d;
            link = l;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GroceryList()
    {
        head = null;
        current = head;
        previous = head;
    }

    public void gotoNext()
    {
        if(current != null) //If current is not at the end of the list
        { 
            previous = current; //Moves previous forward
            current = current.link; //Move current to next node 
        }
    }

    public GroceryItem getCurrent() //Retrieves current data
    {
        if(current == null)
            return null;
        else
            return current.data;
    }

    public void setCurrent(GroceryItem g) //Sets current data
    {
        if(current == null)
            return;
        current.data = g;
    }

    public void addItem(GroceryItem g)
    {
        ListNode newNode = new ListNode(g, null);//link == null because we are at the end of the list
        if(head == null)//Empty list
        {
            head = current = newNode;
            return;
        }
        //Not an empty list
        ListNode temp = head;
        while(temp.link != null) //While temp is not at the end of the list
            temp = temp.link; //Move temp to next node in the list
        temp.link = newNode; //Adds to end of list
    }

    public void addItemAfterCurrent(GroceryItem g)
    {
        if(current == null)
            return;
        ListNode newNode = new ListNode(g, current.link); //New node is created and linked to next node
        current.link = newNode; //Current is linked to new node
    }

    public void removeCurrent()
    {
        if(current != null && previous == null) //Current exists, previous does not: current == head
        {
            head = head.link;
            current = head;
        }
        else if(current != null && previous != null) //Current exists, previous exists, somewhere in the middle of the list
        {
            previous.link = current.link;
            current = current.link;
        }
    }

    public void showList()
    {
        ListNode temp = head;
        while(temp != null) //While temp is not at the end of the list
        {
            System.out.println(temp.data); //Print the data in temp
            temp = temp.link; //Move temp to next node
        }
    }

    public boolean contains(GroceryItem g)
    {
        ListNode temp = head;
        while(temp != null) //While temp is not at the end of the list
        {
            if(temp.data.equals(g))
            {
                return true;
            }
            temp = temp.link; //Move temp to next node
        }
        return false;
    }

    public double totalCost()
    {
        ListNode temp = head;
        double total = 0;
        while(temp != null) //While temp is not at the end of the list
        {
            total += temp.data.getValue(); //Adds the value (cost) of the grocery item at temp
            temp = temp.link; //Move temp to next node
        }
        return total;
    }
}