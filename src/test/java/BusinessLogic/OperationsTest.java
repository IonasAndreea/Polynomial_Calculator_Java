package BusinessLogic;

import DataModules.Monomial;
import DataModules.Polynomial;
import org.junit.jupiter.api.Test;

import javax.sql.PooledConnection;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    private int nSuccessfulTests;

    @Test
    public void testRead() throws Exception{
        Polynomial p = new Polynomial();
        Polynomial p1 = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial m3 = new Monomial(-3.0, 2);
        Monomial m4 = new Monomial(2, 1);
        p.addM(m1);
        p.addM(m2);
        p1.addM(m3);
        p1.addM(m4);
        assertNotNull(p);
        assertTrue(p.equals(p1));
    }

    @Test
    public void testAdd() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial m3 = new Monomial(9, 2);
        Monomial m4 = new Monomial(-6, 1);
        Monomial mr1 = new Monomial(6, 2);
        Monomial mr2 = new Monomial(-4, 1);
        p1.addM(m1);
        p1.addM(m2);
        p2.addM(m3);
        p2.addM(m4);
        pr.addM(mr1);
        pr.addM(mr2);
        assertNotNull(p1);
        assertNotNull(p2);
        assertTrue(pr.equals(Operations.additionP(p1,p2)));
    }

    @Test
    public void testSub() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial m3 = new Monomial(9, 2);
        Monomial m4 = new Monomial(-6, 1);
        Monomial mr1 = new Monomial(-12, 2);
        Monomial mr2 = new Monomial(8, 1);
        p1.addM(m1);
        p1.addM(m2);
        p2.addM(m3);
        p2.addM(m4);
        pr.addM(mr1);
        pr.addM(mr2);
        assertNotNull(p1);
        assertNotNull(p2);
        assertTrue(pr.equals(Operations.subtractionP(p1,p2)));
    }

    @Test
    public void testMul() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial m3 = new Monomial(9, 2);
        Monomial m4 = new Monomial(-6, 1);
        Monomial mr1 = new Monomial(-27, 4);
        Monomial mr2 = new Monomial(36, 3);
        Monomial mr3 = new Monomial(-12, 2);
        p1.addM(m1);
        p1.addM(m2);
        p2.addM(m3);
        p2.addM(m4);
        pr.addM(mr1);
        pr.addM(mr2);
        pr.addM(mr3);
        assertNotNull(p1);
        assertNotNull(p2);
        assertTrue(pr.equals(Operations.multiplication(p1,p2)));
    }

    @Test
    public void testInteg() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial mr1 = new Monomial(-1, 3);
        Monomial mr2 = new Monomial(1, 2);
        p1.addM(m1);
        p1.addM(m2);
        pr.addM(mr1);
        pr.addM(mr2);
        assertNotNull(p1);
        assertTrue(pr.equals(Operations.integration(p1)));
    }

    @Test
    public void testDeriv() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial mr1 = new Monomial(-6, 1);
        Monomial mr2 = new Monomial(2, 0);
        p1.addM(m1);
        p1.addM(m2);
        pr.addM(mr1);
        pr.addM(mr2);
        assertNotNull(p1);
        assertTrue(pr.equals(Operations.derivation(p1)));
    }

    @Test
    public void testDerivInco() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-5.6, 2);
        Monomial m2 = new Monomial(2, 3);
        Monomial mr1 = new Monomial(6.7, 2);
        Monomial mr2 = new Monomial(-11, 1);
        p1.addM(m1);
        p1.addM(m2);
        pr.addM(mr1);
        pr.addM(mr2);
        assertNotNull(p1);
        assertTrue(pr.equals(Operations.derivation(p1)));
    }

    @Test
    public void testIntegInco() throws Exception{
        Polynomial p1 = new Polynomial();
        Polynomial pr = new Polynomial();
        Monomial m1 = new Monomial(-3, 2);
        Monomial m2 = new Monomial(2, 1);
        Monomial mr1 = new Monomial(-1.6, 5);
        Monomial mr2 = new Monomial(0, 2);
        p1.addM(m1);
        p1.addM(m2);
        pr.addM(mr1);
        pr.addM(mr2);
        assertNotNull(p1);
        assertTrue(pr.equals(Operations.integration(p1)));
    }
}