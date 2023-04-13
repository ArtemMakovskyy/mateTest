package tasks;

public class Main {
    public static void main(String[] args) {
        IPAddresses ipAddresses = new IPAddresses();
        String start = "10.0.0.0";
        String end = "10.0.0.50";
        long l = ipAddresses.countIPBetween(start, end);
        System.out.println(l);

        Long d = 256L * 256L * 256L * 256L;
        System.out.println(d);
    }
}
