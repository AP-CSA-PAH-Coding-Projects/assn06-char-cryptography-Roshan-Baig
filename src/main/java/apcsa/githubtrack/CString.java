package apcsa.githubtrack;

// Implement your CString class here
public class CString {
    private String[] CStringArray;

    public CString(String word) {
        // loop through word and add each character to the array to initialize it
        for (int i = 0; i < word.length(); i++) {
            CStringArray[i] = word.substring(i, i + 1);
        }
    }

    // accessor method
    public String[] getCString() {
        return this.CStringArray;
    }

    public void reverse()
    {
        String[] new = CStringArray; // placeholder list
        for(int i = new.length - 1; i >= 0; i--)
        {
            int index = (new.length-1) - i; //finds the opposite index of the current index
            CStringArray[index] = new[i]; // sets the opposite index of CStringArray to be equal to this index of placeholder array
        }
    }

    public void sortAscending() {
        // use a standard SelectionSort method to sort the list in an ascending way
        for (int i = 0; i < CStringArray.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < CStringArray.length; j++) {
                if (CStringArray[j] < CStringArray[min]) {
                    min = j;
                }
            }

            String temp = CStringArray[i];
            CStringArray[i] = CStringArray[min];
            CStringArray[min] = temp;
        }
    }

    public void sortDescending() {
        // use a standard InsertionSort to sort the list in descending order
        for (int i = 1; i < CStringArray.length; i++) {
            String temp = CStringArray[i];
            int indx = i;
            while (indx > 0 && temp > CStringArray[indx - 1]) {
                CStringArray[indx] = CStringArray[indx - 1];
                indx--;
            }
            CStringArray[indx] = temp;
        }
    }
}