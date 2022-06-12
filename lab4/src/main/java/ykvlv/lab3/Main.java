package ykvlv.lab3;

import ykvlv.lab3.beans.mbeans.Area;
import ykvlv.lab3.beans.mbeans.Counter;
import ykvlv.lab3.hit.Hit;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        Counter counterBean = new Counter();
        Area areaBean = new Area();
        try {
            ObjectName nameForCounter = new ObjectName("ykvlv.lab3.beans.mbeans:type=basic, name=counter");
            ObjectName nameForArea = new ObjectName("ykvlv.lab3.beans.mbeans:type=basic, name=area");
            mBeanServer.registerMBean(counterBean, nameForCounter);
            mBeanServer.registerMBean(areaBean, nameForArea);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException |
                MBeanRegistrationException | NotCompliantMBeanException e) {
            e.printStackTrace();
        }
        while (true) {
            double x = readDouble("x");
            System.out.println();
            double y = readDouble("y");
            System.out.println();
            double r = readDouble("r");
            System.out.println();
            areaBean.calcArea(r);
            Hit hit = new Hit(x, y, r);
            counterBean.countHits(hit.isResult());
            System.out.println(hit);
            System.out.println();
        }
    }

    public static double readDouble(String inp) {
        while (true) {
            System.out.println("Enter " + inp);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input is invalid. Please, try again");
                System.out.println();
            }
        }
    }
}
