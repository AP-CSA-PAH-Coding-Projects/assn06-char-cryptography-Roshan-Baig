package apcsa.githubtrack;

// Implement your main application logic here
public void rotate(CString[] arr, int d){
    CString[] copy=arr; // duplicate array to hold values
    for(int i=0; i<arr.length;i++) {
        if(i-d<0){ // if a value falls off the left side, wrap it around to the right side
            int indx=arr.length+(i-d);
            arr[indx]=copy[i];
        }
        else{ //otherwise, shift it left by d spaces
            arr[i-d]=copy[i];
        }
    }
}

public static void main(String[] args)
{
    //scan in the file -- use an array list for easy manipulation
    ArrayList<CString> arr = new ArrayList<CString>;
    File myFile = new File("secretMessage.txt");
    Scanner scan = new Scanner(myFile);
    while (scan.hasNext()) // repeat while there are lines in the text file
    {
        String[] line = scan.nextLine().split(" "); // separate the different parts based on whitespace
        for (String s : line)
        {
            arr.add(new CString(s)); // add each string individually to the ArrayList
        }
    }
    scan.close();

    //decrypt each CString in the array
    for (int i = 0; i < arr.size(); i++)
    {
        arr.set(i, decrypt(arr.get(i)));
    }

    // move back to a regular array of CStrings for the next part
    CString[] output = new CString[arr.size()];
    for (int i = 0; i < arr.size(); i++)
    {
        output[i] = arr.get(i);
    }
    
    // find the CString with the largest ASCII value to find the amount to rotate by
    int maxVal = 0;
    for (CString o : output)
    {
        String[] str = o.getCString();
        int[] numericals = toNumerical(str);
        for (int i = 0; i < numericals.length; i++)
        {
            if (numericals[i] > maxVal)
            {
                maxVal = numericals[i];
            }
        }
    }
    int d = maxVal - 60;
    // having found the amount to rotate by, rotate by that amount and print the result. 
    rotate(output, d);
    System.out.println(output);
}