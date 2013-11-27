/*
 * Copyright (c) 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 * Author: Mohsan.Raza
 */

package com.aspose.ecplugin;

import java.util.HashMap;
import java.util.Map;

public class AsposeJavaComponents {
	public static Map<String,AsposeJavaComponent> list = new HashMap<String,AsposeJavaComponent>();
	public AsposeJavaComponents()
	{
		list.clear();
		//if(!compInitialized)
		{
			//ASPOSE_CELLS
			AsposeJavaComponent asposeCells = new AsposeJavaComponent();
			asposeCells.set_downloadUrl("");
			asposeCells.set_downloadFileName("aspose-cells.zip");
			asposeCells.set_name(ECPluginConstants.ASPOSE_CELLS);
			asposeCells.set_remoteExamplesRepository("https://github.com/asposecells/Aspose_Cells_Java.git");
			list.put(ECPluginConstants.ASPOSE_CELLS, asposeCells);	

			//ASPOSE_WORDS
			AsposeJavaComponent asposeWords = new AsposeJavaComponent();
			asposeWords.set_downloadUrl("");
			asposeWords.set_downloadFileName("aspose-words.zip");
			asposeWords.set_name(ECPluginConstants.ASPOSE_WORDS);
			asposeWords.set_remoteExamplesRepository("https://github.com/asposewords/Aspose_Words_Java.git");
			list.put(ECPluginConstants.ASPOSE_WORDS, asposeWords);

			//ASPOSE_PDF
			AsposeJavaComponent asposePDF = new AsposeJavaComponent();
			asposePDF.set_downloadUrl("");
			asposePDF.get_downloadFileName();
			asposePDF.set_name(ECPluginConstants.ASPOSE_PDF);
			asposePDF.set_remoteExamplesRepository("https://github.com/asposepdf/Aspose_Pdf_Java.git");
			list.put(ECPluginConstants.ASPOSE_PDF, asposePDF);

			//ASPOSE_Slides
			AsposeJavaComponent asposeSlides = new AsposeJavaComponent();
			asposeSlides.set_downloadUrl("");
			asposeSlides.get_downloadFileName();
			asposeSlides.set_name(ECPluginConstants.ASPOSE_SLIDES);
			asposeSlides.set_remoteExamplesRepository("https://github.com/asposeslides/Aspose_Slides_Java.git");
			list.put(ECPluginConstants.ASPOSE_SLIDES, asposeSlides);

			//ASPOSE_PDF KIT
			AsposeJavaComponent asposePDFKit = new AsposeJavaComponent();
			asposePDFKit.set_downloadUrl("");
			asposePDFKit.get_downloadFileName();
			asposePDFKit.set_name(ECPluginConstants.ASPOSE_PDF_KIT);
			list.put(ECPluginConstants.ASPOSE_PDF_KIT, asposePDFKit);

			//ASPOSE_BarCode
			AsposeJavaComponent asposeBarcode = new AsposeJavaComponent();
			asposeBarcode.set_downloadUrl("");
			asposeBarcode.get_downloadFileName();
			asposeBarcode.set_name(ECPluginConstants.ASPOSE_BARCODE);
			asposeBarcode.set_remoteExamplesRepository("https://github.com/asposebarcode/Aspose_BarCode_Java.git");
			list.put(ECPluginConstants.ASPOSE_BARCODE, asposeBarcode);

			//ASPOSE_Meta Files
			AsposeJavaComponent asposeMetafiles = new AsposeJavaComponent();
			asposeMetafiles.set_downloadUrl("");
			asposeMetafiles.get_downloadFileName();
			asposeMetafiles.set_name(ECPluginConstants.ASPOSE_METAFILES);
			list.put(ECPluginConstants.ASPOSE_METAFILES, asposeMetafiles);

			//ASPOSE_Email
			AsposeJavaComponent asposeEmail = new AsposeJavaComponent();
			asposeEmail.set_downloadUrl("");
			asposeEmail.get_downloadFileName();
			asposeEmail.set_name(ECPluginConstants.ASPOSE_EMAIL);
			asposeEmail.set_remoteExamplesRepository("https://github.com/asposeemail/Aspose_Email_Java.git");
			list.put(ECPluginConstants.ASPOSE_EMAIL, asposeEmail);

			//ASPOSE_OCR
			AsposeJavaComponent asposeOCR = new AsposeJavaComponent();
			asposeOCR.set_downloadUrl("");
			asposeOCR.get_downloadFileName();
			asposeOCR.set_name(ECPluginConstants.ASPOSE_OCR);
			list.put(ECPluginConstants.ASPOSE_OCR, asposeOCR);

			//ASPOSE_Imaging
			AsposeJavaComponent asposeImaging = new AsposeJavaComponent();
			asposeImaging.set_downloadUrl("");
			asposeImaging.set_downloadFileName("");
			asposeImaging.set_name(ECPluginConstants.ASPOSE_IMAGING);
			asposeImaging.set_remoteExamplesRepository("https://github.com/asposeimaging/Aspose_Imaging_Java.git");
			list.put(ECPluginConstants.ASPOSE_IMAGING, asposeImaging);

			//compInitialized = true;
		}
	}

}
