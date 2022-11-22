import java.util.Arrays;
import java.util.Objects;

public class Calculate {
    private int length;
    private int height;
    private int nums[];

    public Calculate(int length, int height, int ...nums) {
        setLength(length);
        setHeight(height);
        setNums(nums);
    }

    public Calculate(Calculate obj){
        this.height = obj.height;
        this.length = obj.length;
        this.nums = obj.nums;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getNums() {
        return nums;
    }

    public void setNums(int[] nums) {
        this.nums = nums;
    }

    @Override
    public Object clone(){
        return new Calculate(this.length,this.height,this.nums);
    }

    @Override
    public boolean equals(Object obj) {
        Calculate temp = (Calculate) obj;
        if (temp.length == this.length)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "Calculate{" +
                "length=" + length +
                ", height=" + height +
                ", nums=" + Arrays.toString(nums) +
                '}';
    }
}
