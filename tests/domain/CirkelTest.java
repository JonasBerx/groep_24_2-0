package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirkelTest {
    private Punt middelPunt, middelPunt2;
    private int radius, radius2;
    private int xCoordinaat, yCoordinaat, xCoordinaat2, yCoordinaat2;
    private Cirkel cirkel, cirkel2, cirkelNull, cirkel3;

    @Before
    public void setUp() throws Exception, DomainException {
        xCoordinaat = 5;
        yCoordinaat = 10;
        radius = 5;
        middelPunt = new Punt(xCoordinaat, yCoordinaat);
        cirkel = new Cirkel(middelPunt, radius);
        cirkel2 = new Cirkel(middelPunt, radius);

        xCoordinaat2 = 2;
        yCoordinaat2 = 8;
        radius2 = 8;
        middelPunt2 = new Punt(xCoordinaat2, yCoordinaat2);
        cirkel3 = new Cirkel(middelPunt2, radius2);

    }

    @Test
    public void Cirkel_maakt_cirkel_met_gegeven_middelpunt_en_radius() throws DomainException {
        cirkel = new Cirkel(middelPunt, radius);
        assertEquals(middelPunt, cirkel.getMiddelpunt());
        assertEquals(radius, cirkel.getRadius());
    }


    @Test(expected = DomainException.class)
    public void Cirkel_gooit_exception_als_middelpunt_gelijk_aan_null() throws DomainException {
        new Cirkel(null, radius);
    }

    @Test(expected = DomainException.class)
    public void Cirkel_gooit_exception_als_straal_negatief_is() throws DomainException {
        new Cirkel(middelPunt, -5);
    }

    @Test(expected = DomainException.class)
    public void Cirkel_gooit_exception_als_straal_gelijk_aan_0() throws DomainException {
        new Cirkel(middelPunt, 0);
    }

    @Test
    public void equals_returns_true_als_parameters_hetzelfde_zijn(){
        assertTrue(cirkel.equals(cirkel2));
    }

    @Test (expected = DomainException.class)
    public void equals_returns_false_als_tweede_cirkel_null_is() throws DomainException {
        cirkelNull = new Cirkel(null, 0);
        assertFalse(cirkel.equals(cirkelNull));
    }

    @Test
    public void equals_returns_false_als_middelpunten_verschillend_zijn(){
        assertFalse(cirkel.equals(cirkel3));
    }

    @Test
    public void equals_false_als_radiusen_verschillend_zijn(){
        assertFalse(cirkel.equals(cirkel3));
    }

}
