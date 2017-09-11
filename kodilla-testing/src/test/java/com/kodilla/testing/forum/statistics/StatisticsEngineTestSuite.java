package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsEngineTestSuite {


    //TODO te mocki też można pewnie jakos uprościć, np. w ten sposób ze zrobisz metodę buildStandardMock() a potem zmieniasz mockowane wartości (chociaż nie jestem pewien czy jak już raz zrobisz when(...).then() to możesz nadpisać to jeszcze raz inną wartością, ale pewnie możesz).


    /*TODO
    Temat zaawansowany: mockowanie za pomocą adnotacji. Jeśli w każdym teście będziesz mockował obiekt Statistics, możesz zrobić w teście pole:
    @Mock
    private Statistics statsMock;
    i dodać metodę:
    @Before
    public void setUp() {
	    initMocks(this);
    }
    Wtedy przed każdym pojedyńczym testem będzie zainicjowany mock wszystkich pól, które mają adnotację @Mock. Poczytaj o tym jeśli Cię to zainteresuje.
    */


    @Test
    public void calculateAdvStatisticsNoPosts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(0);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(4, 0, 4, 1.0, 0.0, 0.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatistics1000Posts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(1000);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(4, 1000, 4, 1.0, 250.0, 0.004);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsNoComments() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(0);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(4, 4, 0, 0.0, 1.0, 0.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsLessCommentsThanPosts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4000);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(4, 4000, 4, 1.0, 1000.0, 0.001);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsMoreCommentsThanPosts() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        usersNamesMock.add("Jacek");
        usersNamesMock.add("Artur");
        usersNamesMock.add("Witalij");
        usersNamesMock.add("Karol");
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(4000);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(4, 4, 4000, 1000.0, 1.0, 1000.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsNoUsers() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(4);
        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(0, 4, 4, 0.0, 0.0, 1.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }

    @Test
    public void calculateAdvStatisticsSomeUsers() {
        //Given
        Statistics statsMock = mock(Statistics.class);
        List<String> usersNamesMock = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            usersNamesMock.add("Jacek");
        }
        when(statsMock.usersNames()).thenReturn(usersNamesMock);
        when(statsMock.postsCount()).thenReturn(4);
        when(statsMock.commentsCount()).thenReturn(4);

        StatisticsEngine seReal = new StatisticsEngine();

        StatisticsEngine seExpected = new StatisticsEngine(100, 4, 4, 0.04, 0.04, 1.0);

        //When
        seReal.calculateAdvStatistics(statsMock);
        //Then
        //System.out.println(seReal.toString());
        Assert.assertEquals(seExpected, seReal);
    }
}



