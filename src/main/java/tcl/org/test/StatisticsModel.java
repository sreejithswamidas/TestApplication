//Model Class for Statistics API
package tcl.org.test;

public class StatisticsModel {
    int count;
    float average;
    float min;
    float max;
    float total;

    StatisticsModel(){
        this.count=0;
        this.average=0;
        this.min=0;
        this.max=0;
        this.total=0;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}


