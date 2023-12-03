package gui;
import businessLogic.car;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class CarTableModel extends AbstractTableModel {
    private List<car> cars;
    private String[] columnNames = {"Model", "Make", "Color"};

    public CarTableModel(List<car> cars) {
        this.cars = cars;
    }

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

    // Implement necessary methods such as getValueAt, getRowCount, getColumnCount, etc.
}

