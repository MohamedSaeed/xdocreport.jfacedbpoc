package sample.jface.databinding.domain;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class CustomerComposite extends Composite {

	private CustomerCompositeController m_controller;
	private Text addressLineText;
	private Text cityText;
	private Text nameText;
	private Text zipText;

	public CustomerComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));

		new Label(this, SWT.NONE).setText("AddressLine:");

		addressLineText = new Text(this, SWT.BORDER | SWT.SINGLE);
		addressLineText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));

		new Label(this, SWT.NONE).setText("City:");

		cityText = new Text(this, SWT.BORDER | SWT.SINGLE);
		cityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Name:");

		nameText = new Text(this, SWT.BORDER | SWT.SINGLE);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		new Label(this, SWT.NONE).setText("Zip:");

		zipText = new Text(this, SWT.BORDER | SWT.SINGLE);
		zipText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		m_controller = new CustomerCompositeController(this);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public Text getAddressLineText() {
		return addressLineText;
	}

	public Text getCityText() {
		return cityText;
	}

	public Text getNameText() {
		return nameText;
	}

	public Text getZipText() {
		return zipText;
	}

}
