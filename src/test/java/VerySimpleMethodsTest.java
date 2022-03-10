import org.junit.*;
import ru.muctr.ForTestedMethods.VerySimpleMethods;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

/**
 * @author Evgenia Skichko
 */
public class VerySimpleMethodsTest {
    private double delta = 1e-9;
    VerySimpleMethods verySimpleMethods;

    @BeforeClass
    public static void createOneObject(){
        System.out.println("1 time");
    }

    @Before
    public void createObject(){
        verySimpleMethods = new VerySimpleMethods();
        System.out.println("Перед каждым тестовым методом");
    }

    @Test
    public void testSum1(){
        Assert.assertEquals(5, verySimpleMethods.sum(2,3));
    }

    @Test
    @Ignore("testSum2 в разработке")
    public void testSum2(){
        Assert.assertEquals(5, verySimpleMethods.sum(7,3));
    }

    @Test
    public void testSumDouble(){//6.15 и 6.15000004
        Assert.assertEquals(6.15, verySimpleMethods.sumDouble(5, 1.1500000000001), delta);
    }
    @Test
    public void sumArrayShouldBeMoreThan10(){
//        Assert.assertTrue(verySimpleMethods.sumArray(new int[]{1,2,13}));
        Assume.assumeTrue(verySimpleMethods.sumArrayMoreThan10(new int[]{1,2,3}));
    }

    @Test(timeout = 800)
    public void sumArrayShouldBeMoreThan10_timeout(){
        verySimpleMethods.sumArray(new int[]{1,2,13});
    }

    //**************** Тесты с Assert.assertThat ********************************************************
    @Test
    public void stringShouldContainSubstring(){
        Assert.assertThat(verySimpleMethods.getSomeString(), containsString("New"));
    }

    @Test
    public void stringShouldEqualAnotherString(){
        Assert.assertThat(verySimpleMethods.getSomeString(), equalTo("New String"));
    }

    //для того чтобы использовать матчеры greaterThan, lessThan, lessThanOrEqualTo и др.,
    // нужно подключить в pom-файл зависимость hamcrest-all
    @Test
    public void sumArrayShouldBeMoreThan10AndLessThan20(){ //
        Assert.assertThat(verySimpleMethods.sumArray(new int[]{1,2,13}),
                allOf(greaterThan(10), lessThan(20)));
    }

    @Test
    public void sumArrayShouldBeMoreThan10ORLessThan20OREqualTo15(){ //
        Assert.assertThat(verySimpleMethods.sumArray(new int[]{1,2,13}),
                anyOf(greaterThan(10), lessThan(20), equalTo(15)));
    }
}
