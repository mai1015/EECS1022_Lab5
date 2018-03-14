package eecs1022.lab5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mai1015 on 2018-03-09.
 */
public class BankTest {

    private Bank b;
    @Before
    public void setUp() throws Exception {
        b = new Bank();
        b.addClient(new Client("A", 100));
        b.addClient(new Client("B", 200));
        b.addClient(new Client("C", 300));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getClient() throws Exception {
        assertEquals(b.getClient("A"), new Client("A", 100));
        assertEquals(b.getClient("C"), new Client("C", 300));
    }

    @Test(expected = Error.class)
    public void addClient() throws Exception {
        b.addClient(new Client("A", 200));
        b.addClient(new Client("D", -200));
    }

    @Test(expected = Error.class)
    public void transfer() throws Exception {
        //b.transfer(b.getClient("A"), null, 100);
        //b.transfer(null, b.getClient("A"), 100);
        b.transfer(b.getClient("C"), b.getClient("A"), -100);
    }

}