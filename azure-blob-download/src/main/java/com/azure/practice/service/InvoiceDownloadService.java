package com.azure.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.practice.util.AzureBlobUtil;

@Service
public class InvoiceDownloadService {

	@Autowired
	AzureBlobUtil azureBlobUtil;

	public List<byte[]> downloadInvoiceByUsingContainerName(String containerName) {
		long startTime = System.currentTimeMillis();
		List<byte[]> blobsList = azureBlobUtil.blobForGivenContainerName(containerName);
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println("Total Time in MILLIS: " + totalTime);
		System.out.println("Total no of records downloaded: " + blobsList.size());
		return blobsList;
	}
}
