import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.muctr.ForTestedMethods.VerySimpleMethods;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Evgenia Skichko
 */
@RunWith(Parameterized.class)
public class VerySimpleMethodsTest_Parameterized {
    private int a;
    private int b;
    private int sum;

    public VerySimpleMethodsTest_Parameterized(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {2,3,5},
                {10, 20, 30},
                {4,7,11}
        });
    }

    @Test
    public void testSum(){
        VerySimpleMethods verySimpleMethods = new VerySimpleMethods();
        Assert.assertEquals(sum, verySimpleMethods.sum(a, b));
    }
}
