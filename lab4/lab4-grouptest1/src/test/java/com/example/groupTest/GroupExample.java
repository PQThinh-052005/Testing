package com.example.groupTest;

import org.testng.annotations.Test;

public class GroupExample {

    @Test(groups = { "Regression" })
    public void testCaseOne() {
        System.out.println("CaseOne in Regression group");
    }

    @Test(groups = { "Regression" })
    public void testCaseTwo() {
        System.out.println("CaseTwo in Regression group");
    }

    @Test(groups = { "Smoke test" })
    public void testCaseThree() {
        System.out.println("CaseThree in Smoke test group");
    }

    @Test(groups = { "Regression" })
    public void testCaseFour() {
        System.out.println("CaseFour in Regression group");
    }
}
