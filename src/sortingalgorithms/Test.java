package sortingalgorithms;

public class Test implements Comparable<Test> {
    private Integer digit;

    public Test(Integer digit) {
        this.digit = digit;
    }

    @Override
    public int compareTo(Test obj) {
        return this.digit.compareTo(obj.digit);
    }

    public Integer getDigit() {
        return digit;
    }
}
