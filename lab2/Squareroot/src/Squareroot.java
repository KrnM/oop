public class Squareroot {
    public static void main(String[] args) {
        double a = 3;
        double b = 2.5;
        double c = -0.5;
        double d = b * b - 4 * a * c;
        if (d>0 & (a!=0 & c!=0) ) {
            System.out.println("x1=" + (-b + Math.sqrt(d)) / (2*a));
            System.out.println("x2=" + (-b - Math.sqrt(d)) / (2*a));
        }
        else if (a==0 & b!=0 & c==0 ) {
            System.out.println("x1="+0.0);
            System.out.println("x2="+0.0);
        }
        else if (d==0 & a!=0) {
            System.out.println("x1=" + (-b / (2*a)));
            System.out.println("x2=" + (-b / (2*a)));
        }
        else {
            System.out.println("x1=");
            System.out.println("x2=");
        }
    }
}
