class Point implements Comparable<Point>
{
    int x = 0, y = 0;
    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public double distanceFromOrigin()
    {
        return (Math.sqrt(Math.pow(x,2) + Math.pow(y,2)));
    }

    public int compareTo(Point point)
    {
        double currentPointDistanceFrmCntr = this.distanceFromOrigin();
        double otherPointDistanceFrmCntr = point.distanceFromOrigin();

        int result = 0;

        //return currentPointDistanceFrmCntr - otherPointDistanceFrmCntr;
        if(otherPointDistanceFrmCntr == currentPointDistanceFrmCntr)
            result = 0;
        else if(otherPointDistanceFrmCntr > currentPointDistanceFrmCntr)
            result = 1;
        else
            result = -1;

        return result;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> minPQ = new PriorityQueue<>();

        for(int[] p : points)
        {
            Point otherPoint = new Point(p[0],p[1]);
            if(minPQ.size() < k)
                minPQ.add(otherPoint);
            else
            {
                double currentDist = minPQ.peek().distanceFromOrigin();
                double otherDist = otherPoint.distanceFromOrigin();
                if(otherDist < currentDist)
                {
                    minPQ.poll();
                    minPQ.add(otherPoint);
                }
            }
        }

        //convert PQ to result array
        int[][] kClosestPoints = new int[minPQ.size()][2];
        int i = 0;

        for(Point p : minPQ)
        {
            int[] pt = {p.x, p.y};
            kClosestPoints[i++] = pt;
        }
        return kClosestPoints;
    }
}
