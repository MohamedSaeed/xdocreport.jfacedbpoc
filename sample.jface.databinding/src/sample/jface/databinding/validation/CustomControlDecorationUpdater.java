package sample.jface.databinding.validation;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationUpdater;

public class CustomControlDecorationUpdater extends ControlDecorationUpdater {

	@Override
	protected String getDescriptionText(IStatus status) {
		if(status instanceof MultiStatus){
			StringBuffer buffer = new StringBuffer();
			MultiStatus multiStatus= (MultiStatus)status;
			IStatus[] children=	multiStatus.getChildren();
			for (int i = 0; i < children.length; i++) {
				IStatus[] children2=children[i].getChildren();
				for (int j = 0; j < children2.length; j++) {
					buffer.append(children2[i].getMessage()+"\n");
				}
			
			}
			return buffer.toString();
		}
		//return super.getDescriptionText(status);
		return super.getDescriptionText(status);
	}
}
