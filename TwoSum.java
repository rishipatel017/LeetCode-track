import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Implement this function
    public static int[] solve(int[] nums, int target) {

        int complement=0;
        Map <Integer,Integer>hash=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            complement=target-nums[i];
            if(hash.containsKey(complement))
                return new int[]{hash.get(complement),i};
            hash.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void runTest(int[] nums, int target, int[] expected) {
        int[] result = solve(nums, target);

        System.out.println("Input: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("Output:   " + Arrays.toString(result));
        System.out.println("Expected: " + Arrays.toString(expected));

        if (Arrays.equals(result, expected)) {
            System.out.println("✅ PASS");
        } else {
            System.out.println("❌ FAIL");
        }

        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {

        // Test Case 1
        runTest(
                new int[]{2, 7, 11, 15},
                9,
                new int[]{0, 1}
        );

        // Test Case 2
        runTest(
                new int[]{3, 2, 4},
                6,
                new int[]{1, 2}
        );

        // Test Case 3
        runTest(
                new int[]{3, 3},
                6,
                new int[]{0, 1}
        );

        // Test Case 4
        runTest(
                new int[]{1, 2, 3, 4, 5},
                9,
                new int[]{3, 4}
        );

        // Test Case 5 (No Solution)
        runTest(
                new int[]{1, 2, 3},
                10,
                new int[]{-1, -1}
        );
    }
}