package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private Feline feline;

    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return java.util.Arrays.asList(
                new Object[]{"Самец", true},
                new Object[]{"Самка", false}
        );
    }

    @Test
    public void doesHaveManeReturnsCorrectValue() throws Exception {
        Lion lion = new Lion(sex, feline);
        org.junit.Assert.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
