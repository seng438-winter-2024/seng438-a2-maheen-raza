import org.w3c.dom.ranges.Range;

public class RangeTest {

    // Test cases for equals() method written by Maham Jamal (UCID: 30153574)
    @Test
    public void testEqualsValidInput() {
        Range obj = new Range(1, 5);
        assertTrue(obj.equals(new Range(1, 5)));
    }

    @Test
    public void testEqualsSameRanges() {
        Range obj1 = new Range(1, 5);
        Range obj2 = new Range(1, 5);
        assertTrue(obj1.equals(obj2));
    }

    @Test
    public void testEqualsDifferentRanges() {
        Range obj1 = new Range(1, 5);
        Range obj2 = new Range(2, 6);
        assertFalse(obj1.equals(obj2));
    }

    @Test
    public void testEqualsNullObject() {
        Range obj = new Range(1, 5);
        assertFalse(obj.equals(null));
    }

    @Test
    public void testEqualsReflexivity() {
        Range obj = new Range(1, 5);
        assertTrue(obj.equals(obj));
    }

    @Test
    public void testEqualsSymmetry() {
        Range obj1 = new Range(1, 5);
        Range obj2 = new Range(1, 5);
        assertTrue(obj1.equals(obj2) && obj2.equals(obj1));
    }

    @Test
    public void testEqualsTransitivity() {
        Range obj1 = new Range(1, 5);
        Range obj2 = new Range(1, 5);
        Range obj3 = new Range(1, 5);
        assertTrue(obj1.equals(obj2) && obj2.equals(obj3) && obj1.equals(obj3));
    }

    @Test
    public void testEqualsConsistency() {
        Range obj = new Range(1, 5);
        assertTrue(obj.equals(new Range(1, 5)));
        assertTrue(obj.equals(new Range(1, 5)));
    }

    // Test cases for hashCode() method written by Maham Jamal (UCID: 30153574)
    @Test
    public void testHashCodeValidInput() {
        Range obj = new Range(1, 5);
        assertNotNull(obj.hashCode());
    }

    @Test
    public void testHashCodeSameObjects() {
        Range obj1 = new Range(1, 5);
        Range obj2 = new Range(1, 5);
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    public void testHashCodeDifferentObjects() {
        Range obj1 = new Range(1, 5);
        Range obj2 = new Range(2, 6);
        assertTrue(obj1.hashCode() != obj2.hashCode());
    }

    @Test
    public void testHashCodeConsistentHashCodes() {
        Range obj = new Range(1, 5);
        int hashCode1 = obj.hashCode();
        int hashCode2 = obj.hashCode();
        assertEquals(hashCode1, hashCode2);
    }

    @Test(expected = NullPointerException.class)
    public void testHashCodeNullObject() {
        Range obj = null;
        obj.hashCode();

    }

    // Test cases for getCentralValue() method written by Mehrnaz Zafari (UCID:
    // 30118953)

    @Test
    public void centralValueOfPositiveRange() {
        Range positiveRange = new Range(2, 4);
        assertEquals("The central value of -1 and 1 should be 0",
                3, positiveRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfNegativeRange() {
        Range negativeRange = new Range(-5, -1);
        assertEquals("The central value of a negative range from -5 to -1 should be -3",
                -3, negativeRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfSymmetricRangeShouldBeMidpoint() {
        Range symmetricRange = new Range(-3, 3);
        assertEquals("The central value of a symmetric range from -3 to 3 should be 0",
                0, symmetricRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfAsymmetricRangeShouldBeMidpoint() {
        Range symmetricRange = new Range(-2, 4);
        assertEquals("The central value of a symmetric range from -2 to 4 should be 1",
                1, symmetricRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfOddLenghtRange() {
        Range oddLenghtRange = new Range(1, 6);
        assertEquals("The central value of a symmetric range from -2 to 4 should be 1",
                3.5, oddLenghtRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfEvenLenghtRange() {
        Range oddLenghtRange = new Range(2, 6);
        assertEquals("The central value of a symmetric range from 2 to 6 should be 6",
                4, oddLenghtRange.getCentralValue(), .000000001d);
    }

    @Test
    public void centralValueOfSinglePointRangeShouldBeThatValue() {
        Range singlePointRange = new Range(5, 5);
        assertEquals("The central value of a single-point range with value 5 should be 5",
                5, singlePointRange.getCentralValue(), .000000001d);
    }

    // Test cases for contains() method written by Mehrnaz Zafari (UCID:
    // 30118953)

    @Test
    public void shouldContainZero() {
        Range obj1 = new Range(-1, 1);
        assertTrue("The Range from -1 to 1 should contain", obj1.contains(0));
    }

    @Test
    public void shouldContainCentralValue() {
        Range obj1 = new Range(-1, 1);
        double centralValue = obj1.getCentralValue();
        assertTrue("The Range from -1 to 1 should contain", obj1.contains(centralValue));
    }

    @Test
    public void shouldNotContainValueOutside() {
        Range obj1 = new Range(-1, 1);
        assertFalse("The Range from -1 to 1 should not contain", obj1.contains(-2.0));
    }

    @Test
    public void shouldContainLowerBound() {
        Range obj1 = new Range(0, 2);
        double lowerBound = obj1.getLowerBound();
        assertTrue("The Range from 0 to 2 should not contain", obj1.contains(lowerBound));
    }

    @Test
    public void shouldContainUpperBound() {
        Range obj1 = new Range(4, 5);
        double upperBound = obj1.getUpperBound();
        assertTrue("The Range from 4 to 5 should not contain", obj1.contains(upperBound));
    }

    @Test
    public void shouldNotContainValueJustBelowLowerBound() {
        Range obj1 = new Range(2, 4);
        assertFalse("The Range from 2 to 4 should not contain a value just below its lower bound",
                obj1.contains(obj1.getLowerBound() - 0.000001d));
    }

    @Test
    public void shouldNotContainValueJustAboveUpperBound() {
        Range obj1 = new Range(2, 4);
        assertFalse("The Range from 2 to 4 should not contain a value just above its upper bound",
                obj1.contains(obj1.getUpperBound() + 0.000001d));
    }

}
