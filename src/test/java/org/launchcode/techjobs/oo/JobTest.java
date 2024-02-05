package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        //create two Job objects
        Job job1 = new Job();
        Job job2 = new Job();
        // verify that the IDs of the two object are distinct
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job productTester = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       // Testing value of each field
        assertEquals("Product tester", productTester.getName());
        assertEquals("ACME", productTester.getEmployer().getValue());
        assertEquals("Desert", productTester.getLocation().getValue());
        assertEquals("Quality control", productTester.getPositionType().getValue());
        assertEquals("Persistence", productTester.getCoreCompetency().getValue());
        // Testing class assignment of each field
        assertTrue(productTester.getName() instanceof String); //Name is a String Object in Java!
        assertTrue(productTester.getEmployer() instanceof Employer);
        assertTrue(productTester.getLocation() instanceof Location);
        assertTrue(productTester.getPositionType() instanceof PositionType);
        assertTrue(productTester.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
        Job job3 = new Job("Squancher", new Employer("Squanchy R US"), new Location("Squanch"), new PositionType("Squanchy"), new CoreCompetency("Squanchiest"));
        Job job4 = new Job("Squancher", new Employer("Squanchy R US"), new Location("Squanch"), new PositionType("Squanchy"), new CoreCompetency("Squanchiest"));
        assertNotEquals(job3, job4);
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job5 = new Job("Squancher", new Employer("Squanchy R US"), new Location("Squanch"), new PositionType("Squanchy"), new CoreCompetency("Squanchiest"));
        //assertTrue(job5.toString().startsWith(System.lineSeparator() && job5.toString().endsWith(System.lineSeparator())));
//assertEquals(String.valueOf(job5.toString().charAt(0)),(System.lineSeparator()));
      // assertEquals(String.valueOf(job5.toString().charAt(job5.toString().length()- 1)),(System.lineSeparator()));

        assertTrue(job5.toString().startsWith(System.lineSeparator()));
        assertTrue(job5.toString().endsWith(System.lineSeparator()));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job6 = new Job("Squancher", new Employer("Squanchy R US"), new Location("Squanch"), new PositionType("Squanchy"), new CoreCompetency("Squanchiest"));
        assertEquals(System.lineSeparator() +
                "ID: " + job6.getId() + "\n" +
                "Name: Squancher\n" +
                "Employer: Squanchy R US\n" +
                "Location: Squanch\n" +
                "Position Type: Squanchy\n" +
                "Core Competency: Squanchiest" + System.lineSeparator(), job6.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job7 = new Job("Squancher", new Employer("Squanchy R US"), new Location("Squanch"), new PositionType("Squanchy"), new CoreCompetency(""));
        assertEquals(System.lineSeparator() +
                "ID: " + job7.getId() + "\n" +
                "Name: Squancher\n" +
                "Employer: Squanchy R US\n" +
                "Location: Squanch\n" +
                "Position Type: Squanchy\n" +
                "Core Competency: Data not available" + System.lineSeparator(), job7.toString());
    }
}
