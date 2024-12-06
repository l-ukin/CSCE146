public class StringLL{
    public class ListNode
    {
        private String data;
        private ListNode link;

        public ListNode(String aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }
    private ListNode head;

    public void setup()
    {
        head = new ListNode("Abc", null);
        head.link = new ListNode("efG", null);
        head.link.link = new ListNode("HIJ", null);
        head.link.link.link = new ListNode("kLm", null);
        head.link.link.link.link = new ListNode("noP", null);
    }

    public void print()
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    public String getLongestString()
    {
        if(head == null || head.data == null)
            return null;
        String ret = head.data;
        ListNode t = head;
        while(t != null)
        {
            if(t.data == null)
                continue;
            else if(t.data.length()>ret.length())
                ret = t.data;
            t = t.link;
        }
        return ret;
    }

    public void replaceAll(String target, String rValue)
    {
        if(head == null || head.data == null)
            return;
        ListNode temp = head;
        while(temp != null)
        {
            if(temp.data == null)
                continue;
            else if(temp.data.equals(target))
            {
                temp.data = rValue;
                break;
            }
            head = head.link;
        }
    }

    public void removeFirst5()
    {
        ListNode temp = head;
        for(int i=0;i<5;i++)
        {
            temp = temp.link;
        }
        head = temp;
    }
}