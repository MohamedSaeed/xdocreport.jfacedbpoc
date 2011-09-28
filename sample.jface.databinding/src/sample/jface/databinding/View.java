package sample.jface.databinding;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import sample.jface.databinding.domain.CustomerComposite;

public class View extends ViewPart {
	public static final String ID = "sample.jface.databinding.view";

	private CustomerComposite customerComposite;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		 customerComposite = new CustomerComposite(parent,SWT.NONE);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		customerComposite.setFocus();
	}
}