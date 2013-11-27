/*
 * Copyright (c) 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 * Author: Mohsan.Raza
 */
package com.aspose.ecplugin;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

import com.aspose.AsposeDownloadsSoapProxy;
import com.aspose.ProductRelease;
import com.aspose.ecplugin.AsposeJavaComponent;
import com.aspose.ecplugin.AsposeJavaComponents;
import com.aspose.ecplugin.wizard.WizardNewProjectCreationPageCustom;

import java.rmi.RemoteException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;


import org.eclipse.swt.SWT;

/**
 * 
 * @author mohsan.raza
 *
 */
public class AsposeComponentsManager {
	WizardNewProjectCreationPageCustom _pageOne = null;
	public AsposeComponentsManager(WizardNewProjectCreationPageCustom page)
	{
		_pageOne = page;
	}

	/**
	 * 
	 * @return
	 */
	public boolean downloadComponents()
	{
		if(!isIneternetConnected())
		{
			_pageOne.showMessage(ECPluginConstants.INTERNET_CONNECTION_REQUIRED_MESSAGE_TITLE, ECPluginConstants.INTERNET_CONNECTION_REQUIRED_MESSAGE, SWT.ICON_WARNING | SWT.OK);
			return false;
		}

		for(AsposeJavaComponent component:AsposeJavaComponents.list.values())
		{

			if(component.is_selected())
			{
				ProductRelease productRelease = getProductReleaseInfo(component.get_name());
				component.set_downloadUrl(productRelease.getDownloadLink());
				component.set_downloadFileName(productRelease.getFileName());
				component.set_changeLog(productRelease.getChangeLog());
				component.set_latestVersion(productRelease.getVersionNumber());
				if(libraryAlreadyExists(component.get_downloadFileName()))
				{
					String currentComponentVersion = readVersion(component);
					component.set_currentVersion(currentComponentVersion);
					
					if(currentComponentVersion != null && currentComponentVersion.equals(component.get_latestVersion())  )
					{

						component.set_downloaded(true);
						//storeVersion(component);
					}
					else
					{
						storeReleaseNotes(component);
						String htmlFilePath = getLibaryDownloadPath()+  component.get_name() + ".htm"; // path to your new file
						File htmlFile = new File(htmlFilePath);

						// open the default web browser for the HTML page
						try {
							Desktop.getDesktop().browse(htmlFile.toURI());
						} catch (IOException e) {
							e.printStackTrace();
						}

						try {
							Desktop.getDesktop().open(htmlFile);
						} catch (IOException e) {
							e.printStackTrace();
						}
						if(_pageOne.showMessage(component.get_name()+ " - " + ECPluginConstants.NEW_VERSION_MESSAGE_TITLE, ECPluginConstants.NEW_VERSION_MESSAGE +"\nLatest Version: "+ component.get_latestVersion() +"\nCurrent Version: "+ component.get_currentVersion() , SWT.ICON_INFORMATION | SWT.YES|SWT.NO) == SWT.YES)
						{
							if(downloadFileFromInternet(component.get_downloadUrl(), component.get_downloadFileName()))
							{
								component.set_downloaded(true);
								storeVersion(component);
							}	
						}
						else
						{
							component.set_downloaded(true);
						}
					}
				}
				else
				{
					if(downloadFileFromInternet(component.get_downloadUrl(), component.get_downloadFileName()))
					{
						component.set_downloaded(true);
						storeVersion(component);
					}
					else
					{
						return false;
					}
				}
			}
		}

		return true;
	}

	/**
	 * 
	 * @param component
	 * @return
	 */
	public String readVersion(AsposeJavaComponent component)
	{
		String localPath = getLibaryDownloadPath()+  component.get_name() + ".ver";
		BufferedReader reader;
		String line = null;

		try {
			reader = new BufferedReader(new FileReader(localPath));
			line = reader.readLine();
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return  line;
	}

	/**
	 * 
	 * @param component
	 */
	public void storeReleaseNotes(AsposeJavaComponent component)
	{
		String localPath = getLibaryDownloadPath()+  component.get_name() + ".htm";
		PrintWriter writer;
		try {
			writer = new PrintWriter(localPath, "UTF-8");
			writer.println(component.get_changeLog());
			writer.close();
		} catch (FileNotFoundException e) {
			//writer.close();
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			//writer.close();
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param component
	 */
	public void storeVersion(AsposeJavaComponent component)
	{
		String localPath = getLibaryDownloadPath()+  component.get_name() + ".ver";
		PrintWriter writer;
		try {
			writer = new PrintWriter(localPath, "UTF-8");
			writer.println(component.get_latestVersion());
			writer.close();
		} catch (FileNotFoundException e) {
			//writer.close();
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			//writer.close();
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @param productName
	 * @return
	 */
	public ProductRelease getProductReleaseInfo(String productName)
	{
		AsposeDownloadsSoapProxy proxy = new AsposeDownloadsSoapProxy();
		proxy.setEndpoint(ECPluginConstants.WEBSERVICE_ENDPOINT);

		try {
			return proxy.getProductRelease("Java", productName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * @param libFileName
	 * @return
	 */
	private boolean libraryAlreadyExists(String libFileName)
	{
		File confirmPath = new File(getLibaryDownloadPath() + libFileName);
		if(confirmPath.exists())
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param urlStr
	 * @return
	 */
	private long getFileDownloadLength(String urlStr)
	{
		URL url;
		long fileLenth=0;
		try {
			url = new URL(urlStr);

			URLConnection connection = url.openConnection();
			connection.connect();

			fileLenth = connection.getContentLength();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileLenth;
	}
	/**
	 * 
	 * @param urlStr
	 * @param outputFile
	 * @return
	 */
	public boolean downloadFileFromInternet(String urlStr, String outputFile) {
		InputStream input;
		int bufferSize = 4096;
		String localPath = getLibaryDownloadPath();
		try {
			URL url = new URL(urlStr);
			input = url.openStream();
			byte[] buffer = new byte[bufferSize];
			File f = new File(localPath + outputFile);
			OutputStream output = new FileOutputStream(f);
			int bytes = 0;
			long totalLength = getFileDownloadLength(urlStr);
			long pages = totalLength / bufferSize;
			_pageOne.progressBar.setVisible(true);
			_pageOne.progressBar.setMaximum((int) pages);
			_pageOne.progressBar.setMinimum(0);
			_pageOne.progressBar.setSelection(0);			

			int currentPage = 0;
			try {
				int bytesRead;
				while ((bytesRead = input.read(buffer, 0, buffer.length)) >= 0) {
					output.write(buffer, 0, bytesRead);
					bytes = bytes + buffer.length;
					_pageOne.progressBar.setSelection(currentPage);
					_pageOne.progressBar.redraw();
					currentPage =currentPage + 1;
				}               

				output.flush();
				output.close();
				_pageOne.progressBar.setSelection(currentPage);
				extractFolder(localPath + outputFile, localPath + removeExtention(outputFile) );

				_pageOne.progressBar.setSelection(0);
				_pageOne.progressBar.setVisible(false);
			} finally {

			}
		} catch (Exception ex) {
			_pageOne.progressBar.setSelection(0);
			_pageOne.progressBar.setVisible(false);;
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param filePath
	 * @return
	 */
	public static String removeExtention(String filePath) {
		File f = new File(filePath);
		if (f.isDirectory()) return filePath;
		String name = f.getName();
		final int lastPeriodPos = name.lastIndexOf('.');
		if (lastPeriodPos <= 0)
		{
			return filePath;
		}
		else
		{
			File renamed = new File(f.getParent(), name.substring(0, lastPeriodPos));
			return renamed.getPath();
		}
	}
	/**
	 * 
	 * @return
	 */
	public static boolean isIneternetConnected()
	{
		try {
			InetAddress address = InetAddress.getByName(ECPluginConstants.INTERNTE_CONNNECTIVITY_PING_URL);
			if(address == null)
			{
				return false;
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 
	 * @return
	 */
	public static String getLibaryDownloadPath()
	{
		String path = "";
		path = System.getProperty("user.home");
		path = path + "/aspose/ecplugin/";
		File confirmPath = new File(path);
		if(!confirmPath.exists())
			new File(path).mkdirs();
		return path;
	}

	public static String getAsposeHomePath()
	{
		String path = "";
		path = System.getProperty("user.home");
		path = path + "/aspose/";
		return path;
	}
	/**
	 * 
	 * @param zipFile
	 * @param outputFolder
	 */
	public void unZipFile(String zipFile, String outputFolder){

		byte[] buffer = new byte[1024];

		try{
			File folder = new File(outputFolder);
			if(!folder.exists()){
				folder.mkdir();
			}
			ZipInputStream zis = 
					new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry ze = zis.getNextEntry();
			while(ze!=null){

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);
				System.out.println("file unzip : "+ newFile.getAbsoluteFile());
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);             
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}

				fos.close();   
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			System.out.println("Done");

		}catch(IOException ex){
			ex.printStackTrace(); 
		}
	} 

	/**
	 * 
	 * @param zipFile
	 * @param newPath
	 * @throws ZipException
	 * @throws IOException
	 */
	static public void extractFolder(String zipFile,String newPath) throws ZipException, IOException 
	{
		System.out.println(zipFile);
		int BUFFER = 2048;
		File file = new File(zipFile);

		ZipFile zip = new ZipFile(file);
		new File(newPath).mkdir();
		@SuppressWarnings("rawtypes")
		Enumeration zipFileEntries = zip.entries();
		while (zipFileEntries.hasMoreElements())
		{
			ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
			String currentEntry = entry.getName();
			File destFile = new File(newPath, currentEntry);
			File destinationParent = destFile.getParentFile();
			destinationParent.mkdirs();

			if (!entry.isDirectory())
			{
				BufferedInputStream is = new BufferedInputStream(zip
						.getInputStream(entry));
				int currentByte;
				byte data[] = new byte[BUFFER];

				FileOutputStream fos = new FileOutputStream(destFile);
				BufferedOutputStream dest = new BufferedOutputStream(fos,
						BUFFER);
				while ((currentByte = is.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, currentByte);
				}
				dest.flush();
				dest.close();
				is.close();
			}
		}
	}

}
