package org.launchcode.techjobs.oo;



import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JobTest {
    //    //TODO: Create your unit tests here
//
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(2,job1.getId());
        assertNotEquals(1,job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){

        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));


        assertEquals("Product tester",job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
        assertTrue(job1.getName().equals("Product tester"));
        assertTrue(job1.getEmployer().getValue().equals("ACME"));
        assertTrue(job1.getLocation().getValue().equals("Desert"));
        assertTrue(job1.getPositionType().getValue().equals("Quality control"));
        assertTrue(job1.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Poland"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(false,job1.getLocation().getValue().equals(job2.getLocation().getValue()));

    }

    @Test
    public void  testToStringStartsAndEndsWithNewLine(){

        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Poland"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));


        String expected = System.lineSeparator()+"ID:  "+5+System.lineSeparator()+
                "Name: "+"Product tester"+System.lineSeparator()+
                "Employer: "+"ACME"+System.lineSeparator()+
                "Location: "+"Poland"+System.lineSeparator()+
                "Position Type: "+"Quality control"+System.lineSeparator()+
                "Core Competency: "+"Persistence"+System.lineSeparator();

        assertEquals(expected,job2.toString());

    }

    @Test
    public void  testToStringContainsCorrectLabelsAndData(){
        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Poland"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String expected =  System.lineSeparator()+"ID:  "+4+System.lineSeparator()+
                "Name: "+"Product tester"+System.lineSeparator()+
                "Employer: "+"ACME"+System.lineSeparator()+
                "Location: "+"Poland"+System.lineSeparator()+
                "Position Type: "+"Quality control"+System.lineSeparator()+
                "Core Competency: "+"Persistence"+System.lineSeparator();


        assertEquals(expected,job2.toString());

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location(""),
                new PositionType(""),
                new CoreCompetency("Persistence"));
        String expected = System.lineSeparator() +
                "ID:  " + job2.getId() + System.lineSeparator() +
                "Name: " + "Product tester" + System.lineSeparator() +
                "Employer: " + "ACME" + System.lineSeparator() +
                "Location: " + "Data not available" + System.lineSeparator() +
                "Position Type: " + "Data not available" + System.lineSeparator() +
                "Core Competency: " + "Persistence" + System.lineSeparator();

        assertEquals(expected,job2.toString());

    }

}
