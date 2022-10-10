package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import javax.naming.Name;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId (){

        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //checks that job classes are initialized correctly
        assertTrue(testJob.getName() == "Product tester");
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        //checks that inputs are stored correctly
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().toString(), "ACME");
        assertEquals(testJob.getLocation().toString(), "Desert");
        assertEquals(testJob.getPositionType().toString(), "Quality control");
        assertEquals(testJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {

        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(testJob1, testJob2);
        assertFalse(testJob1 == testJob2);

    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String jobString;
        Job testJob = new Job();
        jobString = testJob.toString();
        assertEquals(jobString.charAt(0), '\n');
        assertEquals(jobString.charAt(jobString.length()-1), '\n');
//        "\nID:  _______\n" +
//        "\nName: _______\n" +
//        "\nEmployer: _______\n" +
//        "\nLocation: _______\n" +
//        "\nPosition Type: _______\n" +
//        "\nCore Competency: _______)\n";

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        String jobString;
        Job testJob = new Job();
        jobString = testJob.toString();
        assertTrue(jobString.contains("ID"));
        assertTrue(jobString.contains("Name"));
        assertTrue(jobString.contains("Employer"));
        assertTrue(jobString.contains("Location"));
        assertTrue(jobString.contains("Position Type"));
        assertTrue(jobString.contains("Core Competency"));
        assertTrue(jobString.contains(testJob.getName()));
        //assertTrue(jobString.contains(testJob.getId()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
    }
}
