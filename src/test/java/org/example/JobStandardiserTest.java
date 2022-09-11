package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JobStandardiserTest {

    @Test
    void architectShouldReturnArchitect() {
        JobStandardiser js = new JobStandardiser();
        assertEquals(Job.ARCHITECT.label, js.standardise("architect"));
    }

    @Test
    void softwareDeveloperShouldReturnSoftwareEngineer() {
        JobStandardiser js = new JobStandardiser();
        assertEquals(Job.SOFTWARE_ENGINEER.label, js.standardise("software developer"));
    }

    @Test
    void backEndDeveloperShouldReturnSoftwareEngineer() {
        JobStandardiser js = new JobStandardiser();
        assertEquals(Job.SOFTWARE_ENGINEER.label, js.standardise("back-end developer"));
    }

    @Test
    void chiefAccountantShouldReturnAccountant() {
        JobStandardiser js = new JobStandardiser();
        assertEquals(Job.ACCOUNTANT.label, js.standardise("chief accountant"));
    }

    @Test
    void developerWithTypoShouldReturnEngineer() {
        JobStandardiser js = new JobStandardiser();
        assertEquals(Job.SOFTWARE_ENGINEER.label, js.standardise("softare develper"));
    }
}