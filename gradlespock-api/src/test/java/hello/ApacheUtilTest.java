package hello;

import com.mga.model.Person;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.lang.reflect.Array;


/**
 *   23/05/2017.
 */



public class ApacheUtilTest {

    class TestTab<T> {
    }

    //TODO(MGA) : fix this
    @Test
    public void test() {
        Person[] personArray = new Person[5];
        TestTab<Integer>[] testTabArray = (TestTab[]) Array.newInstance(Integer.class, 3);

        int[] intTab = new int[3];

        ArrayUtils.nullToEmpty(intTab);
        ArrayUtils.nullToEmpty(personArray);

    }

}
