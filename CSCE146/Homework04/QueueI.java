/*
* Written by Lukin Uhte, with help from JJ Shepherd's lecture
*/
public interface QueueI <T>
{
    public void enqueue(T aData);
    public T dequeue();
    public T peek();
    public void print();
}