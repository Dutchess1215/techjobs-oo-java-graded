package org.launchcode.techjobs.oo.test;

import org.junit.Before;
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

//    Job testJob1;
//    Job testJob2;
//    Job testJob3;
//    Job testJob4;
//    Job testJob5;
//    @Before
//    public void createJobs(){
//         testJob1 = new Job();
//         testJob2 = new Job();
//         testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//         testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//         testJob5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
//    }
    @Test
    public void testSettingJobId (){
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId());

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
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString;
        jobString = testJob1.toString();
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

        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString;
        jobString = testJob.toString();
        assertEquals("\nID: " + testJob.getId() +
                "\nName: " + testJob.getName() +
                "\nEmployer: " + testJob.getEmployer() +
                "\nLocation: " + testJob.getLocation()+
                "\nPosition Type: " + testJob.getPositionType() +
                "\nCore Competency: " + testJob.getCoreCompetency() +"\n", jobString);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = testJob.toString();
        assertEquals(testJob.getName(), "Data not available");
        assertEquals(testJob.getLocation().getValue(), "Data not available");
        assertEquals(testJob.getPositionType().getValue(), "Data not available");
        assertEquals(testJob.getCoreCompetency().getValue(), "Data not available");
        assertEquals(testJob.getEmployer().getValue(), "Data not available");




    }
}
