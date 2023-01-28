package autocompletecombo6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Noman
 */
/**
 *
 * Implementation of the Searchable interface that searches a List of String
 * objects. * This implementation searches only the beginning of the words, and
 * is not be optimized
 *
 * for very large Lists.
 *
 *
 * @author G. Cope
 *
 *
 *
 */
public class StringSearchable implements Searchable<Model, String> {
	private static final Logger logger = LoggerFactory.getLogger(StringSearchable.class);
    private List<Model> terms = new ArrayList<Model>();

    /**
     *
     * Constructs a new object based upon the parameter terms.
     *
     *
     * @param terms The inventory of terms to search.
     *
     */
    public StringSearchable(List<Model> terms) {

        this.terms.addAll(terms);

    }

    public List<Model> getTerms() {
		return terms;
	}

	public void setTerms(List<Model> terms) {
		this.terms = terms;
	}

	@Override
    public Collection<Model> search(String name) {
        List<Model> founds = new ArrayList<Model>();
      logger.info("key: "+name);
        for (Model m : terms) {
            if (m.getName().contains(name) || m.getId().contains(name)) {
                founds.add(m);
                System.out.println("found: "+m.getName());
            }
        }

        return founds;

    }
}