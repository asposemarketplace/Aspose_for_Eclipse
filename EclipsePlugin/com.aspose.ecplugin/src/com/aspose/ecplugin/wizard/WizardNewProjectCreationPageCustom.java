/*
 * Copyright (c) 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 * Author: Mohsan.Raza
 */

package com.aspose.ecplugin.wizard;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.aspose.ecplugin.ECPluginConstants;

public class WizardNewProjectCreationPageCustom extends WizardNewProjectCreationPage {
	public Button asposeWordsButton;
	public Button asposeCellsButton;
	public Button asposePdfButton;
	public Button asposeSlidesButton;
	public Button asposePdfKitButton;
	public Button asposeBarcodeButton;
	
	// Commented as we currently not showing MetaFiles Component in Wizard Options
	//public Button asposeMetafilesButton;
	
	public Button asposeEmailButton;
	public Button asposeOCRButton;
	public Button asposeImagingButton;

	public Button checkUncheckAll;
	public ProgressBar	progressBar;

	/**
	 * 
	 * @param pageName
	 */
	public WizardNewProjectCreationPageCustom(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		createECComponents(parent);

	}


	@Override
	public boolean validatePage() {
		boolean result = super.validatePage();
		if(!result)
			return result;

		if(!isComponentSelected())
		{
			setErrorMessage(ECPluginConstants.IS_COMPONENT_SELECTED);
			return false;
		}

		setErrorMessage(null);
		setMessage(null);
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isComponentSelected()
	{
		if(asposeCellsButton.getSelection())
			return true;
		if(asposeWordsButton.getSelection())
			return true;
		if(asposePdfButton.getSelection())
			return true;
		if(asposeSlidesButton.getSelection())
			return true;
		if(asposePdfKitButton.getSelection())
			return true;
		if(asposeBarcodeButton.getSelection())
			return true;
		
		// Commented as we currently not showing MetaFiles Component in Wizard Options
		/*
		if(asposeMetafilesButton.getSelection())
			return true;
		*/
		
		if(asposeEmailButton.getSelection())
			return true;
		if(asposeOCRButton.getSelection())
			return true;
		if(asposeImagingButton.getSelection())
			return true;

		return false;
	}
	/**
	 * 
	 * @param title
	 * @param message
	 * @param style
	 * @return
	 */
	public int showMessage(String title, String message,int style)
	{
		MessageBox msgBox = new MessageBox(getShell(),style/*SWT.ICON_WARNING | SWT.YES | SWT.NO | SWT.CANCEL*/);
		msgBox.setMessage(message);
		msgBox.setText(title);
		return msgBox.open();
	}

	/**
	 * 
	 * @param parent
	 */
	private void createECComponents(Composite parent){
		Composite composite = (Composite) getControl ();
		Composite dataArea = new Composite (composite, SWT.NONE);
		dataArea.setLayout (new GridLayout (5, false));
		dataArea.setLayoutData (new GridData (GridData.HORIZONTAL_ALIGN_FILL));

		Group parentStyleGroup;
		parentStyleGroup = new Group(dataArea, SWT.NONE);
		parentStyleGroup.setLayout(new GridLayout());
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		parentStyleGroup.setLayoutData(gridData);

		Group parentStyleGroupSel;
		parentStyleGroupSel = new Group(dataArea, SWT.BOTTOM);
		parentStyleGroupSel.setLayout(new GridLayout());
		GridData gridDataSel = new GridData(GridData.HORIZONTAL_ALIGN_FILL,GridData.HORIZONTAL_ALIGN_FILL,true,true);
		parentStyleGroupSel.setLayoutData(gridDataSel);
		parentStyleGroupSel.setText("Common Uses:");

		parentStyleGroup.setText("Select Components:");

		checkUncheckAll = new Button(parentStyleGroup, SWT.CHECK|SWT.BOLD);
		checkUncheckAll.setText("Select All");
		checkUncheckAll.setToolTipText(ECPluginConstants.ASPOSE_ALL_COMPONENTS_TEXT);
		checkUncheckAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (checkUncheckAll.getSelection()) {
					setButtonsValue(true);
				} else {
					setButtonsValue(false);
				}
			}
		});


		asposeCellsButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeCellsButton.setText(ECPluginConstants.ASPOSE_CELLS);
		asposeCellsButton.setToolTipText(ECPluginConstants.ASPOSE_CELLS_FEATURE_TEXT);
		asposeCellsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});


		asposeWordsButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeWordsButton.setText(ECPluginConstants.ASPOSE_WORDS);
		asposeWordsButton.setToolTipText(ECPluginConstants.ASPOSE_WORDS_FEATURE_TEXT);
		asposeWordsButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});


		asposePdfButton = new Button(parentStyleGroup, SWT.CHECK);
		asposePdfButton.setText(ECPluginConstants.ASPOSE_PDF);
		asposePdfButton.setToolTipText(ECPluginConstants.ASPOSE_PDF_FEATURE_TEXT);
		asposePdfButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});

		asposeSlidesButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeSlidesButton.setText(ECPluginConstants.ASPOSE_SLIDES);
		asposeSlidesButton.setToolTipText(ECPluginConstants.ASPOSE_SLIDES_FEATURE_TEXT);
		asposeSlidesButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});

		
		asposeBarcodeButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeBarcodeButton.setText(ECPluginConstants.ASPOSE_BARCODE);
		asposeBarcodeButton.setToolTipText(ECPluginConstants.ASPOSE_BARCODE_FEATURE_TEXT);
		asposeBarcodeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});
 
		// Commented as we currently not showing MetaFiles Component in Wizard Options
/*		asposeMetafilesButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeMetafilesButton.setText(ECPluginConstants.ASPOSE_METAFILES);
		asposeMetafilesButton.setToolTipText(ECPluginConstants.ASPOSE_METAFILES_FEATURE_TEXT);
		asposeMetafilesButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});
*/
		asposeEmailButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeEmailButton.setText(ECPluginConstants.ASPOSE_EMAIL);
		asposeEmailButton.setToolTipText(ECPluginConstants.ASPOSE_EMAIL_FEATURE_TEXT);
		asposeEmailButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});

		asposeOCRButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeOCRButton.setText(ECPluginConstants.ASPOSE_OCR);
		asposeOCRButton.setToolTipText(ECPluginConstants.ASPOSE_OCR_FEATURE_TEXT);
		asposeOCRButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});

		asposeImagingButton = new Button(parentStyleGroup, SWT.CHECK);
		asposeImagingButton.setText(ECPluginConstants.ASPOSE_IMAGING);
		asposeImagingButton.setToolTipText(ECPluginConstants.ASPOSE_IMAGING_FEATURE_TEXT);
		asposeImagingButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});

		asposePdfKitButton = new Button(parentStyleGroup, SWT.CHECK);
		asposePdfKitButton.setText(ECPluginConstants.ASPOSE_PDF_KIT);
		asposePdfKitButton.setToolTipText(ECPluginConstants.ASPOSE_PDF_KIT_FEATURE_TEXT);
		asposePdfKitButton.setVisible(false);
		asposePdfKitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {setPageComplete(validatePage());}});

		Label info = new Label(parentStyleGroupSel,SWT.FILL);
		info.setText(ECPluginConstants.ASPOSE_ALL_COMPONENTS_TEXT);

		Link javaHomeLink = new Link(parentStyleGroupSel,SWT.FILL);
		javaHomeLink.setText(ECPluginConstants.ASPOSE_JAVA_COMP_LINK_TEXT);
		javaHomeLink.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				try
				{ 
					@SuppressWarnings("unused")
					Process p=Runtime.getRuntime().exec(ECPluginConstants.ASPOSE_JAVA_COMP_LINK_OPN_CMD); 
				} 
				catch(IOException e1) 
				{System.out.println(e1);} 

			}
		});

		progressBar = new ProgressBar(parentStyleGroup, SWT.HORIZONTAL|SWT.SMOOTH);
		progressBar.setVisible(false);

	}
	/**
	 * 
	 * @param value
	 */
	void setButtonsValue(boolean value){
		asposeWordsButton.setSelection(value);
		asposeCellsButton.setSelection(value);
		asposePdfButton.setSelection(value);
		asposeSlidesButton.setSelection(value);
		asposePdfKitButton.setSelection(value);
		asposeBarcodeButton.setSelection(value);
		
		// Commented as we currently not showing MetaFiles Component in Wizard Options
		//asposeMetafilesButton.setSelection(value);
		
		asposeEmailButton.setSelection(value);
		asposeOCRButton.setSelection(value);
		asposeImagingButton.setSelection(value);

	}
}
