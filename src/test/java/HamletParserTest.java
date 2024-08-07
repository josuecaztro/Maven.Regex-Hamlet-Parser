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
    }

    @Test
    public void testFindHamlet() {
    }
}