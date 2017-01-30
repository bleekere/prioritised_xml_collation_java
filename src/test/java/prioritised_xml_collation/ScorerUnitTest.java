package prioritised_xml_collation;

import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ellibleeker on 30/01/2017.
 */
public class ScorerUnitTest {

    @Test
    public void testScoreXMLmatchPunctuation() {
        XMLToken tokenA = new TextToken(",");
        XMLToken tokenB = new TextToken("!");
        Scorer scorePunctuation = new TypeScorer();
        boolean resultScorer = scorePunctuation.match(tokenA, tokenB);
        assertThat(resultScorer, is(true));

    }

    @Test
    public void testScoreXMLnonMatchPunctuation() {
        XMLToken tokenA = new TextToken("black");
        XMLToken tokenB = new TextToken("!");
        Scorer scorePunctuation = new TypeScorer();
        boolean resultScorer = scorePunctuation.match(tokenA, tokenB);
        assertThat(resultScorer, is(false));
    }

    @Test
    public void testScoreXMLmatchCharacters() {
        XMLToken tokenA = new TextToken("cat");
        XMLToken tokenB = new TextToken("white");
        Scorer scorePunctuation = new TypeScorer();
        boolean resultScorer = scorePunctuation.match(tokenA, tokenB);
        assertThat(resultScorer, is(false));
        fail("TextToken content is not punctuation nor XMLElement");
    }

    @Test
    public void testScoreXMLMatchElement() {
        XMLToken tokenA = new ElementToken("s");
        XMLToken tokenB = new ElementToken("p");
        Scorer scorePunctuation = new TypeScorer();
        boolean resultScorer = scorePunctuation.match(tokenA, tokenB);
        assertThat(resultScorer, is(true));
    }

    @Test
    public void testScoreXMLnonMatchElement() {
        XMLToken tokenA = new ElementToken("p");
        XMLToken tokenB = new TextToken("!");
        Scorer scorePunctuation = new TypeScorer();
        boolean resultScorer = scorePunctuation.match(tokenA, tokenB);
        assertThat(resultScorer, is(false));
    }
}