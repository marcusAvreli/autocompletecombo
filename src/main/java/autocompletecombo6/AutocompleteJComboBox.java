package autocompletecombo6;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author Noman
 */
/**
 *
 * JComboBox with an autocomplete drop down menu. This class is hard-coded for
 * String objects, but can be
 *
 * altered into a generic form to allow for any searchable item.  *
 * @author G. Cope
 *
 *
 *
 */
public class AutocompleteJComboBox extends JComboBox<Object>  implements ActionListener{
	private static final Logger logger = LoggerFactory.getLogger(AutocompleteJComboBox.class);
    static final long serialVersionUID = 4321421L;
    private final Searchable<Model, String> searchable;

    /**
     *
     * Constructs a new object based upon the parameter searchable
     *
     * @param s
     *
     */
    public AutocompleteJComboBox(Searchable<Model, String> s) {
        
       // super();
        
        this.searchable = s;
        
        List<Model> models = ((StringSearchable)s).getTerms();
        ToComboBoxModel toCombo = new ToComboBoxModel(models);
        //setModel(new DefaultComboBoxModel(models.toArray()));
        setModel(toCombo);
        setSelectedIndex(-1);
        setEditable(true);
        JTextField text = (JTextField) this.getEditor().getEditorComponent();
        text.setFocusable(true);
        text.setText("");
        text.addKeyListener(new ComboListener(this, s));
        addActionListener(this);
        addItemListener(e -> cbbxYearMinValueChanged(e));
        addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object object = getSelectedItem();
				logger.info("object:"+object);
			}
		});
      //  setMyVector();
       
        
    }
    
    public void actionPerformed(ActionEvent e) {
      JComboBox<AutocompleteJComboBox> combo = (JComboBox<AutocompleteJComboBox>) e.getSource();
        Object object = combo.getSelectedItem();
        if(null != object) {
     	   logger.info("get selected Item:"+object);
        }
    }
    private void cbbxYearMinValueChanged( ItemEvent e)
	{
    	
		if (e.getStateChange() == ItemEvent.SELECTED)
		{	Object objectItem = e.getItem();
			if(null != objectItem) {
				if(objectItem instanceof Model) {
					Model model = (Model)objectItem;
					logger.info("item:"+model.getId() + " name:"+model.getName());
				}
			}
		}
	}
    
}