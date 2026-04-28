/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution 
{
    HashMap<Integer, Node> nodeMapping = new HashMap<>();
    HashMap<Integer, List<Node>> graph = new HashMap<>();
    public Node cloneGraph(Node node) 
    {
        if(node == null)
            return null;
        
        if(node.neighbors.size() == 0)
            return (new Node());
        
        //fn to make clone of all nodes
        HashSet<Node> hs = new HashSet<>();
        makeAllNodes(node, hs);

        //make connections
        makeAllConnections();
        return nodeMapping.get(node.val);
    }

    public void makeAllNodes(Node node, HashSet<Node> hs)
    {
        Stack<Node> st = new Stack<>();
        st.push(node);

        while(st.size() > 0)
        {
            Node curr = st.pop();
            if(!hs.contains(curr))
            {
                Node cloneNode = new Node(curr.val);
                nodeMapping.put(curr.val, cloneNode);

                hs.add(curr);
                List<Node> nodeNeighbors = curr.neighbors;
                graph.put(curr.val, nodeNeighbors);

                for(Node c : nodeNeighbors)
                {
                    st.push(c);
                }
            }
        }
    } 

    public void makeAllConnections()
    {
        for (Map.Entry<Integer, List<Node>> mapElement : graph.entrySet()) 
        {
            int parentNode = mapElement.getKey();
            List<Node> child = mapElement.getValue();
        
            Node parentCopy = nodeMapping.get(parentNode);
            List<Node> copyChild = new ArrayList<>();
            for(Node c : child)
            {
                Node copyC = nodeMapping.get(c.val);
                copyChild.add(copyC);
            }
            parentCopy.neighbors = copyChild;
        }
    }

}