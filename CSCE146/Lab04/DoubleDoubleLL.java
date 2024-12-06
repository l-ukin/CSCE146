

/*
* Lukin Uhte
*/
public class DoubleDoubleLL{
    private class ListNode
    {
        double data;
        ListNode link;
        ListNode prev;
        public ListNode(double aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
            prev = null;
        }
    }

    private ListNode head;//Reference to first element
    private ListNode current;//Current node of interest

    public DoubleDoubleLL()
    {
        head = current = null;
    }

    public void add(double aData)
    {
        ListNode newNode = new ListNode(aData, null);//link == null because we are at the end of the list
        if(head == null)//Empty list
        {
            head = current = newNode;
            newNode.prev = null;
            return;
        }
        //Not an empty list
        ListNode temp = head;
        while(temp.link != null) //While temp is not at the end of the list
            temp = temp.link; //Move temp to next node in the list
        newNode.prev = temp;
        newNode.prev.link = newNode;
    }

    public void print()
    {
        ListNode temp = head;
        while(temp != null) //While temp is not at the end of the list
        {
            System.out.println(temp.data); //Print the data in temp
            temp = temp.link; //Move temp to next node
        }
    }

    public void gotoNext()
    {
        if(current != null) //If current is not at the end of the list
        { 
            current = current.link; //Move current to next node 
        }
    }

    public void gotoPrev()
    {
        if(current != null && current.prev != null)
        {
            current = current.prev;
        }
    }

    public void gotoEnd()
    {
        current = head;
        while(current.link != null)
        {
            current = current.link;
        }
    }

    public Boolean hasMore()
    {
        return (current != null);
    }

    public void reset(){ //Resets current to head node
        current = head;
    }

    public Double getCurrent() //Retrieves current data
    {
        if(current == null)
            return null;
        else
            return current.data;
    }

    public void setCurrent(double aData) //Sets current data
    {
        if(current == null)
            return;
        current.data = aData;
    }

    public void remove()
    {
        ListNode temp = current;
        while(current.link != null)
        {
            current = current.link;
        }
        current.prev.link = null;
        current.prev = null;
        current = temp;
    }

    public void removeCurrent()
    {
        if(current != null && current.prev == null) //Current exists, previous does not: current == head
        {
            head = head.link;
            head.prev = null;
            current = head;
        }
        else if(current != null && current.prev != null && current.link != null) //Current exists, previous exists, somewhere in the middle of the list
        {
            current.link.prev = current.prev;
            current.prev.link = current.link;
            current = current.link;
        }else //Current is at the end
        {
            remove();
        }
    }

    public void addAfterCurrent(double aData)
    {
        if(current == null)
            return;
        ListNode newNode = new ListNode(aData, current.link); //New node is created and linked to next node
        current.link = newNode; //Current is linked to new node
        current.link.prev = current;
    }

    public Boolean contains(double aData)
    {
        ListNode temp = head;
        Boolean check = false;
        while(temp != null)
        {
            if(temp.data == aData)
                check = true;
            temp = temp.link;
        }
        return check;
    }
}