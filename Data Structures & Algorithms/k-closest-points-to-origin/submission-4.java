class Point implements Comparable<Point>
{
    int x = 0;
    int y = 0;

    Point(int[] pt)
    {
        this.x = pt[0];
        this.y = pt[1];
    }

    public double computeDistanceFromOrigin()
    {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int compareTo(Point p)
    {
        double currDist = this.computeDistanceFromOrigin();
        double proposedDist = p.computeDistanceFromOrigin();

        return Double.compare(currDist, proposedDist);       
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Point> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < points.length; i++)
        {
            if(pq.size() < k)
            {
                Point p = new Point(points[i]);
                pq.add(p);
            }
            else
            {
                Point p = new Point(points[i]);
                double currDistance = pq.peek().computeDistanceFromOrigin();
                double proposedDistance = p.computeDistanceFromOrigin();

                if(proposedDistance < currDistance)
                {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        int[][] result = new int[k][2];
        int i  = 0;

        for(Point p : pq)
        {
            int[] r = {p.x, p.y};
            result[i++] = r;
        }

        return result;
    }
}
