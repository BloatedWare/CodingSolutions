public class ZigZag{
    
    public String convert(String s, int numRows) {
        int strLen = s.length();
        int pillarNum;
        StringBuilder res = null;
        if (numRows == 1 || strLen <= numRows) return s;//don't bother just ret as is
        res = new StringBuilder();
        pillarNum = (int)Math.ceil((strLen + numRows - 2) / (2.0*(numRows - 1)));

        int steps = 2*numRows - 2;
        int leftIdx, rightIdx;

        for (int i = 0; i < numRows-1; ++i) {
            
            for (int j = 0; j < pillarNum; ++j) {
                leftIdx = steps*j - i;
                rightIdx = steps*j + i;
                if (leftIdx == rightIdx) {
                    if (leftIdx >= 0 && leftIdx < strLen) {
                        res.append(s.charAt(leftIdx));
                    }
                } else {
                    if (leftIdx >= 0 && leftIdx < strLen) {
                        res.append(s.charAt(leftIdx));    
                    }
                    if (rightIdx >= 0 && rightIdx < strLen) {
                        res.append(s.charAt(rightIdx));    
                    }
                }
            }
            
        }

        for (int j = 0; j < pillarNum; ++j) {
            rightIdx = steps*j + numRows-1;

            if (rightIdx >= 0 && rightIdx < strLen) {
                res.append(s.charAt(rightIdx));    
            }
        }

        return res.toString();
    } 

}