package autocompletecombo6;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//https://coderanch.com/t/508122/java/JComboBox-setSelectedItem-update-displayed
//https://github.com/optyfr/JRomManager/blob/ade61c712d0be0de1a9d8ac693904733070628ed/jrmstandalone/src/main/java/jrm/ui/ScannerFiltersPanel.java
public class App 
{
	  /**
     * @param args the command line arguments
     */
	private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {

                List<Model> myWords = new ArrayList<Model>();

                myWords.add(new Model("1","bike"));
                myWords.add(new Model("2","car"));
                myWords.add(new Model("3","cap"));
                myWords.add(new Model("4","cape"));
                myWords.add(new Model("5","canadian"));
                myWords.add(new Model("6","caprecious"));
                myWords.add(new Model("7","catepult"));
                

//                myWords.add("car");
//
//                myWords.add("cap");
//
//                myWords.add("cape");
//
//                myWords.add("canadian");
//
//                myWords.add("caprecious");
//
//                myWords.add("catepult");



                StringSearchable searchable = new StringSearchable(myWords);

                AutocompleteJComboBox combo = new AutocompleteJComboBox(searchable);

                

                JFrame frame = new JFrame();

                frame.add(combo);

                frame.pack();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.setVisible(true);
             

            }
        });

    }
    
}
