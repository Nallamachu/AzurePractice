package com.azure.practice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobContainerItem;
import com.azure.storage.blob.models.BlobItem;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AzureBlobUtil {
	@Autowired
	AzureBlobProperties azureBlobProperties;

	/*
	 * blobServiceClient establishes the connection with Blob storage
	 */
	public BlobServiceClient blobServiceClient() {
		BlobServiceClient blobServiceClient = new BlobServiceClientBuilder()
				.connectionString(azureBlobProperties.getUrl()).buildClient();
		return blobServiceClient;
	}

	/*
	 * blobContainer will return the BlobContainerClient and it will allow us to do
	 * operations on specific container which we passed
	 */
	public BlobContainerClient blobContainerClient(String containerName) {
		BlobServiceClient blobServiceClient = blobServiceClient();
		BlobContainerClient blobContainerClient = blobServiceClient.getBlobContainerClient(containerName);
		return blobContainerClient;
	}

	/*
	 * blobContainerItemList will return all BlobContainerItem stored in blob
	 * storage
	 */
	public List<BlobContainerItem> blobContainerItemList() {
		blobServiceClient().listBlobContainers()
				.forEach(container -> System.out.printf("Name: %s%n", container.getName()));
		return blobServiceClient().listBlobContainers().stream().collect(Collectors.toList());
	}

	/*
	 * blobContainerItemsContainsGivenName will return all BlobContainerItem whos
	 * all name contains the given input
	 */
	public List<BlobContainerItem> blobContainerItemsContainsGivenName(String containerName) {
		return blobServiceClient().listBlobContainers().stream()
				.filter(container -> container.getName().contains(containerName)).collect(Collectors.toList());
	}

	public List<byte[]> blobForGivenContainerName(String containerName) {
		List<BlobContainerItem> blobContainerItems = blobContainerItemsContainsGivenName(containerName);
		List<byte[]> blobsList = new ArrayList<>();
		for(BlobContainerItem containerItem : blobContainerItems) {
			BlobContainerClient containerClient = blobContainerClient(containerItem.getName());
			Iterator<BlobItem> blobIterator = containerClient.listBlobs().iterator();
			while(blobIterator.hasNext()) {
				BlobItem blobItem = blobIterator.next();
				BlobClient blobClient = containerClient.getBlobClient(blobItem.getName());
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				blobClient.download(outputStream);
				final byte[] bytes = outputStream.toByteArray();
				blobsList.add(bytes);
			}
		}
		return blobsList;
	}

}
