# Prioritised XML collation

## What is it?
The "prioritised XML collation"-algorithm is a program that you can use to compare XML files of textual sources. When it collates an XML transcription, the program looks at the text characters _and_ the information in the XML elements. The program is based on the [CollateX algorithm](https://github.com/interedition/collatex), but departs from CollateX in a number of ways.  

The reasoning behind this approach is that XML transcriptions often contain a wealth of scholarly intelligence about the textual source. In general XML elements encompass metadata (e.g. the TEI ```<header>```), scholarly commentary (e.g. in a ```<note>```), or data from the physical artefact (e.g. the inscriptions on a manuscript). An XML transcription often permeates the boundaries of document and text, of structure and semantics, containing the scholar's analysis of both. By considering all that information during the collation process, the program is able to produce a more refined result.
 
## What does it do?

The collation consists of two rounds. In the first round, the program collates the text tokens. In case of a non-match, it looks at other characteristics of the token, e.g. what type it is (punctuation, text, or XML element) and uses that information to collate the non-matching tokens again. Subsequently, this second collation result is merged with the first collation result. 

## How does it work?

1. **Tokenisation**. The input XML file is parsed and tokenised on whitespace. This results in a list of Token objects. We distinguish TextTokens and ElementTokens. Each Token object contains a string of characters.
2. **First aligment**. The TextTokens and the ElementTokens are aligned based on their content. The alignment produces a list of Segment objects. Each Segment contains tokens from both witnesses, and it knows whether these tokens are a "match" or a "replacement".
3. **Second alignment**. The Tokens within the Segments marked with "replacement" (i.e. the Tokens that are not considered a match) are aligned again. This time the program looks only at their type. For now we distinguish three different types: "text", "punctuation", and "XML element". This operation also produces a list of Segment objects.
4. **Tree building**. The two lists of Segments are merged. Based on this latest list of Segments, the program builds a tree. Each Segment object is a node in the tree. 

The tree can be used for further processing. 

## Is it something for me?
If you are a literary or textual scholar, and you work with (TEI-)XML transcriptions, the answer to this question is most probabably: yes!  

Keep in mind that this code is under development.

For more information, take a look at the following abstracts and publications: 

- Bleeker, Elli. 2017. _Mapping Invention in Writing: Digital Infrastructure and the Role of the Editor_. PhD thesis; University of Antwerp. Especially chapter 4.3.
- Bleeker, Elli, Bram Buitendijk, and Ronald Haentjens Dekker. 2017. "Scholarly Intervention in Automated Collation Software". Paper presented at the [ESTS conference 2017](https://textualscholarship.eu/ests-2017/). 

You can also contact [Elli Bleeker](mailto:elli.bleeker@huygens.knaw.nl).