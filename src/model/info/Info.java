package model.info;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info {

    //DateGetter--------------------------------------------------------------------------------------------------------
    public String getDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date());
    }

    //validation Method-------------------------------------------------------------------------------------------------
    public void numbersValidation (KeyEvent e, JTextField jTextField){
        jTextField.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9')
                || (e.getKeyCode() == KeyEvent.VK_BACK_SPACE));
    }
}
