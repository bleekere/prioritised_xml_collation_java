package prioritised_xml_collation;

import java.util.List;

/**
 * Created by ellibleeker on 06/04/2017.
 */
public interface SegmenterInterface {
    // Interface cannot have instance variables
    // Interface is instantiated by methods in ContentTypeSegmenter
    List<Segment> calculateSegmentation(EditGraphTable table);
}