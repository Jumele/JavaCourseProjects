abstract public class Turist implements Comparable<Turist> {

    public abstract int prioritate();


    @Override
    public int compareTo(Turist o) {
       return  this.prioritate() - o.prioritate();
    }


}
