class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int j=cell.charAt(0)-'A';
        int i=Integer.parseInt(cell.substring(1,cell.length()))-1;
        sheet[i][j]=value;
    }
    
    public void resetCell(String cell) {
        int j=cell.charAt(0)-'A';
        int i=Integer.parseInt(cell.substring(1,cell.length()))-1;
        sheet[i][j]=0;
    }
    
    public int getValue(String formula) {
        String[] a=formula.split("\\+");
        String x=a[0].substring(1,a[0].length());
        String y=a[1];
        int n1=0,n2=0;
        if(x.charAt(0)>='0' && x.charAt(0)<='9')
            n1=Integer.parseInt(x);
        else
        {
            int j=x.charAt(0)-'A';
            int i=Integer.parseInt(x.substring(1,x.length()))-1;
            n1=sheet[i][j];
        }
        if(y.charAt(0)>='0' && y.charAt(0)<='9')
            n2=Integer.parseInt(y);
        else
        {
            int j=y.charAt(0)-'A';
            int i=Integer.parseInt(y.substring(1,y.length()))-1;
            n2=sheet[i][j];
        }
        return n1+n2;
    }
}