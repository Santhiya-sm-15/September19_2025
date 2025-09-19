# September19_2025
The problem that i solved today in leetcode

A spreadsheet is a grid with 26 columns (labeled from 'A' to 'Z') and a given number of rows. Each cell in the spreadsheet can hold an integer value between 0 and 105.

Implement the Spreadsheet class:

Spreadsheet(int rows) Initializes a spreadsheet with 26 columns (labeled 'A' to 'Z') and the specified number of rows. All cells are initially set to 0.
void setCell(String cell, int value) Sets the value of the specified cell. The cell reference is provided in the format "AX" (e.g., "A1", "B10"), where the letter represents the column (from 'A' to 'Z') and the number represents a 1-indexed row.
void resetCell(String cell) Resets the specified cell to 0.
int getValue(String formula) Evaluates a formula of the form "=X+Y", where X and Y are either cell references or non-negative integers, and returns the computed sum.
Note: If getValue references a cell that has not been explicitly set using setCell, its value is considered 0.

Code:
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

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
