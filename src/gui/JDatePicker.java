package gui;

import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

class JDatePicker extends JPanel {
    private final JSpinner datePickerSpinner;

    public JDatePicker() {
        datePickerSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(datePickerSpinner, "yyyy-MM-dd");
        datePickerSpinner.setEditor(dateEditor);

        add(datePickerSpinner);
    }

    public Date getDate() {
        return (Date) datePickerSpinner.getValue();
    }
}

