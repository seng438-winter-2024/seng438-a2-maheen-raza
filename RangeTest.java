

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

    @Test(expected = NullPointerException.class )
    public void testHashCodeNullObject() {
        Range obj = null;
         obj.hashCode();
    
    }
}
