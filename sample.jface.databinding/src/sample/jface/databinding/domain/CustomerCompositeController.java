package sample.jface.databinding.domain;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;

import sample.jface.databinding.validation.BeanValidator;
import sample.jface.databinding.validation.CustomControlDecorationUpdater;


public class CustomerCompositeController {
	private CustomerComposite m_customerComposite;
	private DataBindingContext m_bindingContext;
	private sample.jface.databinding.domain.Customer customer = new sample.jface.databinding.domain.Customer();

	public CustomerCompositeController(CustomerComposite customerComposite, sample.jface.databinding.domain.Customer newCustomer) {
		m_customerComposite = customerComposite;
		setCustomer(newCustomer);
		m_bindingContext = initDataBindings();
	}

	public CustomerCompositeController(CustomerComposite customerComposite) {
		m_customerComposite = customerComposite;
		if (customer != null) {
			m_bindingContext = initDataBindings();
		}
	}

	public sample.jface.databinding.domain.Customer getCustomer() {
		return customer;
	}

	public void setCustomer(sample.jface.databinding.domain.Customer newCustomer) {
		setCustomer(newCustomer, true);
	}

	public void setCustomer(sample.jface.databinding.domain.Customer newCustomer, boolean update) {
		customer = newCustomer;
		if (update) {
			if (m_bindingContext != null) {
				m_bindingContext.dispose();
				m_bindingContext = null;
			}
			if (customer != null) {
				m_bindingContext = initDataBindings();
			}
			
		}
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue addressLineObserveWidget = SWTObservables.observeText(m_customerComposite.getAddressLineText(), SWT.Modify);
		IObservableValue addressLineObserveValue = PojoObservables.observeValue(customer, "addressLine");
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setAfterConvertValidator(new BeanValidator(customer));
		Binding address=bindingContext.bindValue(addressLineObserveWidget, addressLineObserveValue, strategy, null);
		// Add some decorations
		ControlDecorationSupport.create(address, SWT.TOP | SWT.LEFT,m_customerComposite, new CustomControlDecorationUpdater());
		//
		IObservableValue cityObserveWidget = SWTObservables.observeText(m_customerComposite.getCityText(), SWT.Modify);
		IObservableValue cityObserveValue = PojoObservables.observeValue(customer, "city");
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setAfterConvertValidator(new BeanValidator(customer));
		Binding city=bindingContext.bindValue(cityObserveWidget, cityObserveValue, strategy_1,null );
		// Add some decorations
		ControlDecorationSupport.create(city, SWT.TOP | SWT.LEFT,m_customerComposite, new CustomControlDecorationUpdater());
		//
		IObservableValue nameObserveWidget = SWTObservables.observeText(m_customerComposite.getNameText(), SWT.Modify);
		IObservableValue nameObserveValue = PojoObservables.observeValue(customer, "name");
		UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setAfterConvertValidator(new BeanValidator(customer));
		Binding name=bindingContext.bindValue(nameObserveWidget, nameObserveValue, strategy_2, null);
		// Add some decorations
		ControlDecorationSupport.create(name, SWT.TOP | SWT.LEFT,m_customerComposite, new CustomControlDecorationUpdater());
		//
		IObservableValue zipObserveWidget = SWTObservables.observeText(m_customerComposite.getZipText(), SWT.Modify);
		IObservableValue zipObserveValue = PojoObservables.observeValue(customer, "zip");
		UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setAfterConvertValidator(new BeanValidator(customer));
		Binding zip=bindingContext.bindValue(zipObserveWidget, zipObserveValue, strategy_3, null);
		// Add some decorations
		ControlDecorationSupport.create(zip, SWT.TOP | SWT.LEFT,m_customerComposite, new CustomControlDecorationUpdater());
		//
		return bindingContext;
	}
}