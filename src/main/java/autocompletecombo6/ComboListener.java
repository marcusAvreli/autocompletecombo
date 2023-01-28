package autocompletecombo6;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
//import org.apache.commons.lang3.text.WordUtils;

public class ComboListener extends KeyAdapter
{
@SuppressWarnings("rawtypes")
JComboBox cbListener;
@SuppressWarnings("rawtypes")
Searchable<Model, String>  vector;

@SuppressWarnings("rawtypes")
public ComboListener(JComboBox cbListenerParam, Searchable<Model, String> s)
{
    cbListener = cbListenerParam;
    vector = s;
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public void keyReleased(KeyEvent key)
{
            // TODO Auto-generated method stub
            String text = ((JTextField)key.getSource()).getText();

            cbListener.setModel(new DefaultComboBoxModel(getFilteredList(text).toArray()));
            cbListener.setSelectedIndex(-1);
            ((JTextField)cbListener.getEditor().getEditorComponent()).setText(text);
            cbListener.showPopup();
}


@SuppressWarnings({ "rawtypes", "unchecked" })
public List<Model> getFilteredList(String text)
{
    Vector v = new Vector();
   /* for(int a = 0;a<vector.size();a++)
    {
        if(vector.get(a).toString().startsWith(text))
        {
            v.add(vector.get(a).toString());
        }
                    else if(vector.get(a).toString().startsWith(text.toLowerCase()))
        {
            v.add(vector.get(a).toString());
        }
                     else if(vector.get(a).toString().startsWith(text.toUpperCase()))
        {
            v.add(vector.get(a).toString());
        }
                     else if(vector.get(a).toString().startsWith((text)))
        {
            v.add(vector.get(a).toString());
        }
                     else if(vector.get(a).toString().startsWith((text)))
        {
            v.add(vector.get(a).toString());
        }
    }*/
    List<Model> founds =  (List<Model>) vector.search(text);
    return founds;
}
}