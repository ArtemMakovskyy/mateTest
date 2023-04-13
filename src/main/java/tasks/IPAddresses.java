package tasks;

import java.util.Arrays;

public class IPAddresses {
    public long countIPBetween(String start, String end) {
        String[] startIp = start.split("\\.");
        String[] endIp = end.split("\\.");
        long i4 = (Integer.parseInt(endIp[3]) - Integer.parseInt(startIp[3])) << 0;
        long i3 = (long) (Integer.parseInt(endIp[2]) - Integer.parseInt(startIp[2])) << 8;
        long i2 = (long) (Integer.parseInt(endIp[1]) - Integer.parseInt(startIp[1])) *256*256;
        long i1 = (long) (Integer.parseInt(endIp[0]) - Integer.parseInt(startIp[0])) *256*256*256;
        return i1+i2+i3+i4;
    }


}
