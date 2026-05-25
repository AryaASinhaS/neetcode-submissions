/**
create 2 PQ of type Quantity and Timestamp --> Create classes of these 2 types
create a frequency array to to store quantity of all tasks
update QuantPQ with data of this frequency array for quantity > 0
now we will compute time using below approach -
 - we will at each iteration check if the timestamp of any item in timestampPQ == timer, 
   if yes then that will be polled and QuantPQ will be updated, as in that item will be added there
- for each timer, a poll from QuantPQ will happen, if the quantity > 1, 
   we will add it to timeStmpPQ denoting next execution of task at designated timestamp
**/
class Quantity implements Comparable<Quantity>
{
    char name;
    int quantity;

    Quantity(char name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public int compareTo(Quantity q)
    {
        return this.quantity - q.quantity;
    }
}
class TimeStamp implements Comparable<TimeStamp>
{
    char name;
    int quantity;
    int timestamp;

    TimeStamp(char name, int quantity, int timestamp)
    {
        this.name = name;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public int compareTo(TimeStamp t)
    {
        return this.timestamp - t.timestamp;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) 
    {
        //creation of 2 PQs
        PriorityQueue<Quantity> quantPQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<TimeStamp> tsPQ = new PriorityQueue<>();

        //create frequency array
        int[] freqArray = new int[26];
        for(char c : tasks)
        {
            int index = (int)(c - 'A');
            freqArray[index]++;
        }

        //convert frequencyArray to quantPQ
        for(int i = 0; i < 26; i++)
        {
            if(freqArray[i] > 0)
            {
                char c = (char)(i + 'A');
                Quantity q = new Quantity(c, freqArray[i]);
                quantPQ.add(q);
            }
        }

        //calculate timer
        int timer = 0;

        while(quantPQ.size() > 0 || tsPQ.size() > 0)
        {
            

            //check if the timestamp of any item in timestampPQ == timer
            while(tsPQ.size() > 0 && tsPQ.peek().timestamp == timer)
            {
                //poll the task and update quantPQ
                TimeStamp t = tsPQ.poll();
                quantPQ.add(new Quantity(t.name, t.quantity));
            }

            if(quantPQ.size() > 0)
            {
                Quantity q = quantPQ.poll();
                if(q.quantity > 1)
                {
                    //add it to timeStmpPQ denoting next execution of task at designated timestamp
                    TimeStamp t  = new TimeStamp(q.name, q.quantity - 1, timer + n + 1);
                    tsPQ.add(t);
                }
            }
            timer++;
        }

        return timer;
    }
}
