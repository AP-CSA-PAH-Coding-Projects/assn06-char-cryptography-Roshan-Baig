package apcsa.githubtrack;

import java.util.ArrayList;

// Implement your CStringUtil class here
public class CStringUtil {
    public static boolean isPalindrome(CString str)
    {
        String out = "";
        ArrayList<String> arr = new ArrayList<String>;
        for (int i = 0; i < arr.length; i++) // process the CString so all letters are lowercase and all spaces are removed
        {
            arr.add(str[i].toLowerCase());
            if(arr.get(i).equals(" "))
            {
                arr.remove(i);
            }
        }
        for (String s : arr) 
        {
            out += s; // sets our output string
        }
        CString cstr = new CString(out); // turns output string to a CString to reverse it easily
        return (cstr == cstr.reverse()); // returns whether the two are palindromes or not
    }

    public static int[] toNumerical(CString str, int offset) {
        String[] arr = str.getCString();
        int[] output = new int[arr.size()];
        for (int i = 0; i < arr.length; i++) // loop through arr
        {
            int ascii = (int) arr[i]; // use typecasting to get ascii values
            output[i] = ascii + offset; // offset the values by the given amount
        }
        return output;
    }

    public static int maxMirror(CString str) {
        String[] array = str.getCString();
        int[] arr;
        int count = 0;
        int max = 0;

        for (int i = 0; i < array.length; i++) { // convert to a list of integers instead of strings
            arr[i] = String.valueOf(array[i]);
        }

        for (int i = 0; i < arr.length; i++) { // loop forward through arr
            for (int j = arr.length - 1; j >= 0; j--) { // loop backwards through arr simultaneously
                count = 0;
                int a = i;
                int b = j;
                while (a < arr.length && b > a && arr[a] == arr[b]) { // for each iteration of j, the program goes
                                                                      // through to count the length of a sequence
                                                                      // exists in both the first and second half
                    count++;
                    a++;
                    b--; // doesn't change the for loop variables so they continue working as normal
                }

                if (count > max) { // sets max if a higher value has been found
                    max = count;
                }
            }
        }

        return max;
    }

    public static int maxMirror(int[] arr) { // same as earlier except we skip the steps of converting to an array of
                                             // integers
        int count = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= 0; j--) {
                count = 0;
                int a = i;
                int b = j;
                while (a < arr.length && b > a && arr[a] == arr[b]) {
                    count++;
                    a++;
                    b--;
                }

                if (count > max) {
                    max = count;
                }
            }
        }
    }

    public static int[] memeifyArray(int[] nums) {
        int[] out = nums;

        for (int i = 0; i < out.length; i++) { // loop through our list
            if (out[i] == 6) {
                int j = 0;
                while (out[j] != 7 && j < out.length) { // when out[i] == 6, loop through the list until we find a 7.
                                                        // Then, swap the 7 with the number at index i+1
                    j++;
                }
                if (out[j] == 7) {
                    int temp = out[i + 1];
                    out[i + 1] = out[j];
                    out[j] = temp;
                }
            }
        }
    }

    public static boolean nestedSequence(CString outer, CString inner) {
        outer.sortAscending();
        inner.sortAscending(); // sort the CStrings
        String[] outStr = outer.getCString();
        String[] inStr = outer.getCString();
        int[] out;
        int[] in;
        int count;
        boolean output = true;
        // convert to lists of integers
        for (int i = 0; i < outStr.length; i++) {
            out[i] = String.valueOf(outStr[i]);
        }
        for (int i = 0; i < inStr.length; i++) {
            in[i] = String.valueOf(inStr[i]);
        }

        for (int i = 0; i < in.length; i++) {
            for (int j = 0; j < out.length; j++) {
                if (out[j] == in[i]) {
                    count++; // once this element of in is found, increment count
                }
            }
            if (count != 0) {
                output = false; // if it is still 0 then in[i] is not in out, meaning that out does not have all
                                // values of in
            }
        }

        return output;
    }

    public static CString decrypt(CString str) {
        int[] arr = toNumerical(str, 0); // get the numerical of our CString
        int clumpCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                clumpCount++; // increment the counts of clump when two elements or more of the same value
                while (arr[i] == arr[i + 1]) { // then, as long as the clump continues, increment i to avoid counting
                                               // the same clump multiple times
                    i++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - clumpCount; // offset everything by clumpCount
        }

        String word = "";
        for (int i = 0; i < arr.length; i++) {
            word += (char) arr[i]; // convert each ascii value to a char/string using typecasting
        }
        CString out = new CString(word);
        out.reverse(); // reverse our final word
        return out;
    }

}