package Striver_SDE_Sheet.Arrays_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        todo https://leetcode.com/problems/merge-intervals/description/
//        int[][] intervals = {{1,3}, {2,6}, {8,9}, {9,11}, {8,10}, {2,4},
//                            {15,18}, {16,17}};
//        mergeIntervals(intervals);

//        todo https://leetcode.com/problems/merge-sorted-array/description/
//        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
//        int m = 3, n = 3;
//        merge(nums1, nums2, m, n);

//        todo https://www.interviewbit.com/problems/repeat-and-missing-number-array/
//        int[] arr = {3,1,2,5,3};
        int[] arr = {389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260};
        System.out.println(Arrays.toString(repeatMissingNumber(arr)));




    }

    private static int[] repeatMissingNumber(int[] arr) {
        int[] res = new int[2];

        //we'll use Cyclic sort
        int i = 0;
        while (i < arr.length){
            if (arr[i] != i+1 && arr[i] != arr[arr[i]-1])
                swap(i, arr[i]-1, arr);
            else
                i++;
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j+1) {
                res[0] = arr[j];
                res[1] = j+1;
                break;
            }
        }

        return res;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void merge(int[] nums1, int[] nums2, int m, int n) {
        int i = m-1, j = n-1, k = nums1.length-1;

        while (i >=0 && j >= 0){
            if (nums2[j] > nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            }else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        while (i >= 0){
            nums1[k] = nums1[i];
            i--; k--;
        }

        while (j >= 0){
            nums1[k] = nums2[j];
            j--; k--;
        }

    }

    private static int[][] mergeIntervals(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        if (intervals.length == 0) //empty
            return list.toArray(new int[0][0]);

        //sort the intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0])
                    return a1[1] - a2[1];
                return a1[0] - a2[0];
            }
        });

        int s = intervals[0][0], e = intervals[0][1];
        for (int[] arr: intervals){
            if (arr[0] <= e){ //interval hai
                e = Math.max(e, arr[1]);
            }else {
                list.add(new int[]{s,e});
                s = arr[0];
                e = arr[1];
            }
        }
        list.add(new int[]{s, e});

        return list.toArray(new int[0][]);
    }
}
