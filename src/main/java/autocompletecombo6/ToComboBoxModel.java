package autocompletecombo6;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToComboBoxModel extends AbstractListModel implements ComboBoxModel,ListSelectionListener {
    private Object selectedItem;
    private static final Logger logger = LoggerFactory.getLogger(ToComboBoxModel.class);
    private List<Model> orgs;

    public ToComboBoxModel(List orgs) {
      this.orgs = orgs;
    }
//combobox model
      @Override
    public Object getSelectedItem() {
    	  logger.info("getSelectedItem selected");
      return selectedItem;
    }
    //combobox model
      @Override
    public void setSelectedItem(Object newValue) {
    	  logger.info("set selected");
          for (Model o: orgs){
              if (newValue==o){
                  selectedItem=o;
                 // selectedObject = anObject;
                  fireContentsChanged(this, 0, orgs.size() - 1);
                  break;
              }
          }
    }
    //abstract list model
      @Override
    public int getSize() {
      return orgs.size();
    }
    //abstract list model
      @Override
    public String getElementAt(int i) {
      return orgs.get(i).getName();
    }
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		logger.info("hello");
		 ((JList)e.getSource()).getSelectedValue();
		
	}
  }