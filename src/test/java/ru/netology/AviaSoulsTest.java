package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void ShouldSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 18, 19);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "LA", 10_000, 2, 6);
        Ticket ticket5 = new Ticket("LA", "NY", 4000, 15, 20);
        Ticket ticket6 = new Ticket("NY", "MSK", 8000, 5, 12);
        Ticket ticket7 = new Ticket("SPB", "MSC", 5000, 1, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket1, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 18, 19);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "LA", 10_000, 2, 6);
        Ticket ticket5 = new Ticket("LA", "NY", 4000, 15, 20);
        Ticket ticket6 = new Ticket("NY", "MSK", 8000, 5, 12);
        Ticket ticket7 = new Ticket("SPB", "MSC", 5000, 1, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("SPB", "LA");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortZeroTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 18, 19);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "LA", 10_000, 2, 6);
        Ticket ticket5 = new Ticket("LA", "NY", 4000, 15, 20);
        Ticket ticket6 = new Ticket("NY", "MSK", 8000, 5, 12);
        Ticket ticket7 = new Ticket("SPB", "MSC", 5000, 1, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("LA", "SPB");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortFewTicketsByTimeFlight() {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 18, 19);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "LA", 10_000, 2, 6);
        Ticket ticket5 = new Ticket("LA", "NY", 4000, 15, 20);
        Ticket ticket6 = new Ticket("NY", "MSK", 8000, 5, 12);
        Ticket ticket7 = new Ticket("SPB", "MSC", 5000, 1, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {ticket2, ticket3, ticket1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortOneTicketsByTimeFlight() {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 18, 19);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "LA", 10_000, 2, 6);
        Ticket ticket5 = new Ticket("LA", "NY", 4000, 15, 20);
        Ticket ticket6 = new Ticket("NY", "MSK", 8000, 5, 12);
        Ticket ticket7 = new Ticket("SPB", "MSC", 5000, 1, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchAndSortBy("NY", "MSK", comparator);
        Ticket[] expected = {ticket6};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortZeroTicketsByTimeFlight() {
        AviaSouls manager = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("MSK", "SPB", 3000, 11, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 2000, 18, 19);
        Ticket ticket3 = new Ticket("MSK", "SPB", 5000, 10, 12);
        Ticket ticket4 = new Ticket("SPB", "LA", 10_000, 2, 6);
        Ticket ticket5 = new Ticket("LA", "NY", 4000, 15, 20);
        Ticket ticket6 = new Ticket("NY", "MSK", 8000, 5, 12);
        Ticket ticket7 = new Ticket("SPB", "MSC", 5000, 1, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.searchAndSortBy("MSK", "NY", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
