import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String sentence = "Hamlet is in the building!";
        String toChange = "Hamlet";
        String expected = "Leon is in the building!";

        Pattern pattern = Pattern.compile(toChange);
        Matcher matcher = pattern.matcher(sentence);

        String actual = matcher.replaceAll("Leon");

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testChangeHoratioToTariq() {
        String sentence = "Horatio is in the building!";
        String toChange = "Horatio";
        String expected = "Tariq is in the building!";

        Pattern pattern = Pattern.compile(toChange);
        Matcher matcher = pattern.matcher(sentence);

        String actual = matcher.replaceAll("Tariq");

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHoratio() {
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Is Horatio here?");
        boolean horatioFound = matcher.find();

        Assert.assertTrue(horatioFound);

    }

    @Test
    public void testFindHamlet() {
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Is Hamlet here?");
        boolean horatioFound = matcher.find();

        Assert.assertTrue(horatioFound);
    }

    @Test
    public void testDontFindHoratio() {
        Pattern pattern = Pattern.compile("horatio", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Is Alice here?");
        boolean horatioFound = matcher.find();

        Assert.assertFalse(horatioFound);

    }

    @Test
    public void testDontFindHamlet() {
        Pattern pattern = Pattern.compile("hamlet", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("Is Bob here?");
        boolean horatioFound = matcher.find();

        Assert.assertFalse(horatioFound);
    }
}