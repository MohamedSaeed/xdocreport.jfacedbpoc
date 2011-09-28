package sample.jface.databinding.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.hibernate.validator.HibernateValidator;

import sample.jface.databinding.Activator;

public class BeanValidator implements IValidator {

	ValidatorFactory factory = null;

	public BeanValidator() {

		ClassLoader bcp = Thread.currentThread().getContextClassLoader();

		Thread.currentThread().setContextClassLoader(
				HibernateValidator.class.getClassLoader());
		factory = Validation.buildDefaultValidatorFactory();
		Thread.currentThread().setContextClassLoader(bcp);
	}

	private Object bean;

	public BeanValidator(Object bean) {
		this.bean = bean;
		ClassLoader bcp = Thread.currentThread().getContextClassLoader();

		Thread.currentThread().setContextClassLoader(
				HibernateValidator.class.getClassLoader());
		factory = Validation.buildDefaultValidatorFactory();
		Thread.currentThread().setContextClassLoader(bcp);
	}

	@Override
	public IStatus validate(Object value) {

		Set<ConstraintViolation<Object>> violations = factory.getValidator()
				.validate(bean, new Class<?>[] { Default.class });
		if (violations.size() > 0) {
			List<IStatus> statusList = new ArrayList<IStatus>();
			for (ConstraintViolation<Object> cv : violations) {
				statusList.add(ValidationStatus.error(cv.getMessage()));
			}
			return new MultiStatus(Activator.PLUGIN_ID, IStatus.ERROR,
					statusList.toArray(new IStatus[statusList.size()]),
					"Validation errors", null);
		}

		return ValidationStatus.ok();
	}
}
