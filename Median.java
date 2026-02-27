public class Median {

     public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] merged_array = new int[nums1.length + nums2.length];
        int i,j,k, merged_array_len = nums1.length + nums2.length;
        double median;

        i = j = k = 0;
        while(k < merged_array_len) {
            if(i == nums1.length) {
                for(; j < nums2.length;) {
                    merged_array[k++] = nums2[j++];
                }
            } else if (j == nums2.length) {
                for(; i < nums1.length;) {
                    merged_array[k++] = nums1[i++];
                }
            } else {
                if(nums1[i] < nums2[j]) {
                    merged_array[k++] = nums1[i++];
                    
                } else {
                    merged_array[k++] = nums2[j++];
                }
            }
            
        }
        if(merged_array_len % 2 == 1) {
            median = merged_array[merged_array_len/2];
        } else {
            median = (merged_array[merged_array_len/2] + merged_array[merged_array_len/2 - 1])/2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1,3,8,10}, new int[] {4,5,8,9}));    
    }
}