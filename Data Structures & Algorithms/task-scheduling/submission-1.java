class Quantity implements Comparable<Quantity>
{
    char name;
    int quantity;

    Quantity(char name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public int compareTo(Quantity quant)
    {
        return this.quantity - quant.quantity;
    }
}

class TimeStamp implements Comparable<TimeStamp>
{
    char name;
    int timeStamp;
    int quantity;

    TimeStamp(char name,int timeStamp, int quantity)
    {
        this.name = name;
        this.timeStamp = timeStamp;
        this.quantity = quantity;
    }

    public int compareTo(TimeStamp ts)
    {
        return this.timeStamp - ts.timeStamp;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        PriorityQueue<Quantity> pqQuant = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        PriorityQueue<TimeStamp> pqts = new PriorityQueue<>();

        int[] charCount = new int[26];

        //convert IP array to frequency array
        for(char c : tasks)
        {
            charCount[c - 'A']++;
        }

        for(int i = 0; i < charCount.length; i++)
        {
            char c = (char)('A' - i);
            if(charCount[i] > 0) {
                Quantity q = new Quantity(c, charCount[i]);
                pqQuant.add(q);    
            }
        }

        int timer = 0;
        while(pqQuant.size() > 0 || pqts.size() > 0) {
            // task read to execute
            while(pqts.size() > 0 && pqts.peek().timeStamp <= timer) {
                TimeStamp time = pqts.poll();
                pqQuant.add(new Quantity(time.name, time.quantity));
            }

            if (pqQuant.size() > 0){
                Quantity quant = pqQuant.poll();
                if (quant.quantity > 1) {
                    pqts.add(new TimeStamp(
                        quant.name, 
                        timer + n + 1,
                        quant.quantity - 1 
                    ));
                }
            }

            timer++;
        }

        return timer;
    }
}
