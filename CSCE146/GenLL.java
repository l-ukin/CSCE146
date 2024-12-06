

/*
* Lukin Uhte
*/
public class GenLL <T>{
    private class ListNode
    {
        T data;
        ListNode link;
        public ListNode(T aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }

    private ListNode head;//Reference to first element
    private ListNode current;//Current node of interest
    private ListNode previous;//One node behind current

    public GenLL()
    {
        head = current = previous = null;
    }

    public void add(T aData)
    {
        ListNode newNode = new ListNode(aData, null);//link == null because we are at the end of the list
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

    public void print()
    {
        ListNode temp = head;
        while(temp != null) //While temp is not at the end of the list
        {
            System.out.println(temp.data); //Print the data in temp
            temp = temp.link; //Move temp to next node
        }
    }

    public void goToNext()
    {
        if(current != null) //If current is not at the end of the list
        { 
            previous = current; //Moves previous forward
            current = current.link; //Move current to next node 
        }
    }

    public void reset(){ //Resets current to head node
        current = head;
        previous = null;
    }

    public T getCurrent() //Retrieves current data
    {
        if(current == null)
            return null;
        else
            return current.data;
    }

    public void setCurrent(T aData) //Sets current data
    {
        if(current == null)
            return;
        current.data = aData;
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

    public void addAfterCurrent(T aData)
    {
        if(current == null)
            return;
        ListNode newNode = new ListNode(aData, current.link); //New node is created and linked to next node
        current.link = newNode; //Current is linked to new node
    }
}