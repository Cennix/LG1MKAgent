package LG1MKAgent.Extensions;


/**
 * Created by Varuna on 12/11/2014.
 * Updated by Daniel Hopkins on 17/11/2014
 */
public class StringArray
{
    public static int[] toIntArray(String[] inputArray) throws NumberFormatException
    {
        if (inputArray == null)
        {
            return null;
        }
        if (inputArray.length == 0)
        {
            return new int[]{};
        }
        int[] outputArray = new int[inputArray.length];
        for (int counter = 0; counter < inputArray.length; counter++)
        {
            outputArray[counter] = Integer.parseInt(inputArray[counter]);
        }
        return outputArray;
    }
}