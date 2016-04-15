package com.minhdd;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.assertj.core.api.Assertions.assertThat;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(classes = TestConfig.class)
public class Example {
    class Computer{
        int equalsTo(Computer computer) {
            return 0;
        }
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock private Computer computer;

    @Test
    public void mock_example() {
        Mockito.when(computer.equalsTo(null)).thenReturn(1);
    }

    @Test
    public void array_compare() {
        Computer[] expected = new Computer[6];
        Computer[] actual = new Computer[6];
        assertThat(actual).usingElementComparator(Computer::equalsTo).isEqualTo(expected);
    }

    @Test
    public void array_list_compare() {
        List<Computer> computers = new ArrayList<>();
        MatcherAssert.assertThat(computers, contains(
                allOf(hasProperty("x", is(0)), hasProperty("y", is(0))),
                allOf(hasProperty("x", is(0)), hasProperty("y", is(1)))
        ));
    }

    @Test
    public void file_read() throws IOException {
        Stream<String> stream = Files.lines(Paths.get("data/input1.txt"));
        Scanner sc = new Scanner(new FileInputStream("data/input1.txt"));
    }

    @Test
    public void java8() {
        Stream<Computer> computerStream = range(0, 6).mapToObj(i -> new Computer());
        Computer[] computers = computerStream.toArray(size -> new Computer[size]);
        Computer[] computers2 = computerStream.toArray(Computer[]::new);
        List<Computer> computersList = computerStream.collect(toList());


    }
}
