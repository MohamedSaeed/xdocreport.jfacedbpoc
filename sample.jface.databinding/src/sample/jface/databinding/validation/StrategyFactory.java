package sample.jface.databinding.validation;

import org.eclipse.core.databinding.UpdateValueStrategy;

public class StrategyFactory {

	 public static UpdateValueStrategy getStrategy() {
		   UpdateValueStrategy strategy = new UpdateValueStrategy();
		   strategy.setAfterConvertValidator(new BeanValidator());
		   return strategy;
		 }
}
