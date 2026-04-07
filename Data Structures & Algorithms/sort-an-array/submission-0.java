class Solution {
    public int[] sortArray(int[] nums) 
    {
        mergeSort(nums,0,nums.length-1);
        return nums;
        
    }

    public void mergeSort(int[] ar, int l, int r)
    {
        if(l>=r) return;
        int m = (l+r)/2;
        mergeSort(ar,l,m);
        mergeSort(ar,m+1,r);
        merge(ar,l,m,r);
    }

    public void merge(int[] ar, int l, int m, int r)
    {
        ArrayList<Integer> lst = new ArrayList<>();

        int i = l;
        int j = m+1;

        while(i<=m && j<=r)
        {
            if(ar[i] <= ar[j])
            {
                lst.add(ar[i]);
                i++;
            }
            else
            {
                lst.add(ar[j]);
                j++;
            }
        }

        while(i <= m)
        {
            lst.add(ar[i]);
            i++;
        }
       
        while(j <= r)
        {
            lst.add(ar[j]);
            j++;
        }
        
        //int c = 0;
        for(i = l; i <= r; i++)
        {
            System.out.println("val = " + lst.get(i - l));
            ar[i] = lst.get(i - l); 
        }
        System.out.println("-----");
        
    }
}