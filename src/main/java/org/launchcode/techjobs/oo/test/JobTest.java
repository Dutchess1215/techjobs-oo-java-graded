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
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //checks that job classes are initialized correctly
        assertTrue(testJob3.getName() == "Product tester");
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);

        //checks that inputs are stored correctly
        assertEquals(testJob3.getName(), "Product tester");
        assertEquals(testJob3.getEmployer().toString(), "ACME");
        assertEquals(testJob3.getLocation().toString(), "Desert");
        assertEquals(testJob3.getPositionType().toString(), "Quality control");
        assertEquals(testJob3.getCoreCompetency().toString(), "Persistence");

    }

    @Test
    public void testJobsForEquality() {

        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(testJob3, testJob4);
        assertFalse(testJob3 == testJob4);

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

        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String jobString;
        jobString = testJob3.toString();
        assertEquals("\nID: " + testJob3.getId() +
                "\nName: " + testJob3.getName() +
                "\nEmployer: " + testJob3.getEmployer() +
                "\nLocation: " + testJob3.getLocation()+
                "\nPosition Type: " + testJob3.getPositionType() +
                "\nCore Competency: " + testJob3.getCoreCompetency() +"\n", jobString);
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
