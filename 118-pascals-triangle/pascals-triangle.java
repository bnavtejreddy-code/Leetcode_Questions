class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result=new ArrayList<>();
        for(int row=0;row<numRows;row++){
            ArrayList<Integer> list=new ArrayList<>();
            long val=1;
            for(int col=0;col<=row;col++){

                list.add((int)val);
                val=val*(row-col)/(col+1);

            }
            result.add(list);
        }
        return result;
    }
}