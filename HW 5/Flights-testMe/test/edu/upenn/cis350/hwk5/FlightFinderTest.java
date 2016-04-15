package edu.upenn.cis350.hwk5;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by RajatBhageria on 4/12/16.
 */
public class FlightFinderTest extends TestCase {

    private FlightFinder finder;

    @Before
    public void testSetup(){
        finder = new FlightFinder();
    }

    @Test
    public void testDirectOnlyTrueAndFlightExists(){
        assertEquals(1,finder.findFlights(true, "PHL", "BOS", 0));
        assertEquals(true, finder.getDirectFlights().contains(new Flight("PHL", "BOS", 95, 185)));
        assertEquals(true,finder.getIndirectFlights().isEmpty());

    }


    @Test
    public void testCaseSensitive(){
        assertEquals(1,finder.findFlights(true, "phl", "bos", 0));
        assertEquals(true, finder.getDirectFlights().contains(new Flight("PHL", "BOS", 95, 185)));
        assertEquals(true,finder.getIndirectFlights().isEmpty());

    }
    @Test
    public void testDirectOnlyTrueAndSameAirport(){
        assertEquals(0,finder.findFlights(true, "PHL", "PHL", 0));
        assertEquals(true,finder.getDirectFlights().isEmpty());
        assertEquals(true,finder.getIndirectFlights().isEmpty());

    }

    @Test
    public void testDirectOnlyFalseAndSameAirport(){
        assertEquals(0,finder.findFlights(false, "PHL", "PHL", 0));
        assertEquals(true,finder.getDirectFlights().isEmpty());
        assertEquals(true,finder.getIndirectFlights().isEmpty());

    }

    @Test
    public void testDirectOnlyTrueAndNoFlight(){
        assertEquals(0,finder.findFlights(true, "PHL", "SEA", 0));
        assertEquals(true,finder.getDirectFlights().isEmpty());
        assertEquals(true,finder.getIndirectFlights().isEmpty());
    }

    @Test
    public void testDirectOnlyFalseAndOnlyIndirectFlight(){
        assertEquals(1,finder.findFlights(false, "PHL", "SEA", 0));
        assertEquals(true,finder.getDirectFlights().isEmpty());
        assertEquals(true,finder.getIndirectFlights().contains(new Flight[]
                {new Flight("PHL", "ORD", 100, 270), new Flight("ORD", "SEA", 225, 300)}));
        assertEquals(false,finder.getIndirectFlights().isEmpty());

    }


    @Test
    public void testDirectOnlyFalseTimeLess(){
        assertEquals(2,finder.findFlights(false, "PHL", "CDG", 0));
        assertEquals(true, finder.getDirectFlights().contains(new Flight("PHL", "CDG", 605, 535)));
        assertEquals(true,finder.getIndirectFlights().contains(new Flight[]
                {new Flight("PHL", "ATL", 120, 325), new Flight("ATL", "CDG", 580, 440)}));
        assertEquals(false,finder.getIndirectFlights().isEmpty());
        assertEquals(false,finder.getDirectFlights().isEmpty());
    }

    @Test
    public void testDirectOnlyFalseTimeMore(){
        assertEquals(2,finder.findFlights(false, "PHL", "CDG", 720));
        assertEquals(true, finder.getDirectFlights().contains(new Flight("PHL", "CDG", 605, 535)));
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(false,finder.getDirectFlights().isEmpty());
    }

    @Test
    public void testDirectOnlyFalseTimeEqual(){
        assertEquals(2,finder.findFlights(false, "PHL", "CDG", 700));
        assertEquals(true, finder.getDirectFlights().contains(new Flight("PHL", "CDG", 605, 535)));
        assertEquals(true,finder.getIndirectFlights().contains(new Flight[]
                {new Flight("PHL", "ATL", 120, 325), new Flight("ATL", "CDG", 580, 440)}));
        assertEquals(false,finder.getIndirectFlights().isEmpty());
        assertEquals(false,finder.getDirectFlights().isEmpty());
    }

    @Test
    public void testNoLegalHome(){
        assertEquals(-1,finder.findFlights(false, "DEL", "BOS", 0));
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }
    @Test
    public void testNoLegalDestination(){
        assertEquals(-1,finder.findFlights(false, "PHL", "DEL", 0));
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }


    @Test
    public void testNoLegalHomeAndDestination(){
        assertEquals(-1,finder.findFlights(false, "MAD", "DEL", 0));
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }

    @Test
    public void testNoLegalHomeAndDestinationAndTrue(){
        assertEquals(-1,finder.findFlights(true, "MAD", "DEL", 0));
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }


    @Test
    public void testNumSearchesZero(){
        assertEquals(0,finder.getNumSearches());
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }


    @Test
    public void testNumSearchesOne(){
        assertEquals(1,finder.findFlights(false, "PHL", "BOS", 260));
        assertEquals(1,finder.getNumSearches());
    }


    @Test
    public void testNumSearchesMultiple(){
        assertEquals(1,finder.findFlights(false, "PHL", "BOS", 260));
        assertEquals(3,finder.findFlights(false, "PHL", "ATL", 260));
        assertEquals(1,finder.findFlights(true, "SFO", "DET", 260));
        assertEquals(3,finder.getNumSearches());
    }

    @Test
    public void testNumSearchesMultipleAndIllegalDestination(){
        assertEquals(-1,finder.findFlights(false, "PHL", "DEL", 260));
        assertEquals(-1,finder.findFlights(false, "PHL", "MAD", 260));
        assertEquals(1,finder.findFlights(true, "SFO", "DET", 260));
        assertEquals(1,finder.getNumSearches());

    }

    @Test
    public void testNumSearchesWhenNegativeTime(){
        assertEquals(-1,finder.findFlights(false, "PHL", "CDG", -1));
        assertEquals(0,finder.getNumSearches());
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }

    @Test
    public void testNumSearchesWhenDirectFalseAndNegativeTimeAndIllegalDest(){
        assertEquals(-1,finder.findFlights(false, "PHL", "MAD", -1));
        assertEquals(0,finder.getNumSearches());
        assertEquals(true,finder.getIndirectFlights().isEmpty());
        assertEquals(true,finder.getDirectFlights().isEmpty());
    }



}