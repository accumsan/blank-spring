package com.minhdd.isograd.battledev;

import com.minhdd.isograd.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class MyTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test1() throws FileNotFoundException {
        test("data/input1.txt", "data/output1.txt");
    }

    @Test
    public void test2() throws FileNotFoundException {
        test("data/input2.txt", "data/output2.txt");
    }

    private void test(String input, String output) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(input));
    }
}
