package com.minhdd.isograd.battledev;

import com.minhdd.isograd.TestConfig;
import com.minhdd.isograd.Utils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class MyTest {
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
