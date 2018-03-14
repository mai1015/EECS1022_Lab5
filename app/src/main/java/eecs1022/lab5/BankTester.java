package eecs1022.lab5;

/**
 * Created by mai1015 on 2018-03-13.
 */

public class BankTester {
    public static void main(String[] args) {
        Bank b = new Bank();

        try {
            if (b.getClient("a") == null)
                throw new Error("From-Client not found.");
        } catch (Error e) {
            e.printStackTrace();
        }
        b.addClient(new Client("a", 100));
        try {
            b.addClient(new Client("b", -100));
        }catch (Error e) {
            e.printStackTrace();
        }
        b.addClient(new Client("c", 100));
        b.addClient(new Client("d", 100));

        Client a = b.getClient("a");
        Client c = b.getClient("c");
        System.out.println("a: $" + a.getAmount());
        a.deposit(100);
        System.out.println("a: $" + a.getAmount());
        try {
            a.deposit(-100);
        } catch (Error e) {
            e.printStackTrace();
        }
        System.out.println(a);
        a.withdarw(100);
        System.out.println(a);
        try {
            a.withdarw(-100);
        } catch (Error e) {
            e.printStackTrace();
        }
        System.out.println(a);
        System.out.print(a.printHistory());
//        System.out.print(a.getTransactions());

        System.out.println(a);
        System.out.println(a);
        b.transfer(a, c, 50);

        System.out.println("a: $" + a.getAmount());
        System.out.println("c: $" + c.getAmount());
        try {
            b.transfer(a, c, -50);
        } catch (Error e) {
            e.printStackTrace();
        }
        System.out.println("a: $" + a.getAmount());
        System.out.println("c: $" + c.getAmount());

        System.out.print(a.printHistory());

        System.out.print(c.printHistory());
    }
}
