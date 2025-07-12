import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {
        assertEquals(50, 5*10);
        assertTrue(23>17);
        assertFalse(15 < 23);
        assertNull(null);
        assertNotNull(new Object());
    }
}

