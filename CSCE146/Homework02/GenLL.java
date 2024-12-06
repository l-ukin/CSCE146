
/*
/ Written by Lukin Uhte (with assistance from JJ Shepherd's GenLL class [used to check if I'm doing it right])
*/
public class GenLL <T>{
    private class ListNode
    {
        T data;
        ListNode link;
        public ListNode(T inData, ListNode inLink)
        {
            data = inData;
            link = inLink;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;

    public GenLL()
    {
        head = current = previous = null;
    }
    public void add(T inData)
    {
        ListNode node = new ListNode(inData, null);
        if(head == null) //If the list is empty
        {
            head = current = node;
            return;
        }
        ListNode temp = head;
        while(temp.link != null)
        {
            temp = temp.link;
        }
        temp.link = node;
    }

    public void addAfterCurrent(T inData)
    {
        if(current == null)
        {
            return;
        }
        ListNode node = new ListNode(inData, current.link);
        current.link = node;
    }

    public T getCurrent()
    {
        if(current == null)
        {
            return null;
        }
        return current.data;
    }

    public void setCurrent(T inData)
    {
        if(current == null)
        {
            return;
        }
        current.data = inData;
    }

    public void goToNext()
    {
        if(current != null)
        {
            previous = current;
            current = current.link;
        }
    }

    public void reset()
    {
        current = head;
        previous = null;
    }

    public void removeCurrent()
    {
        if(current == head)
        {
            head = head.link;
            current = head;
        }
        else
        {
            previous.link = current.link;
            current = current.link;
        }
    }

    public boolean hasMore()
    {
        return current != null;
    }
}