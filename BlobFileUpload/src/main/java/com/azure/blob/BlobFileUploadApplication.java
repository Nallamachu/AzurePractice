package com.azure.blob;

import java.io.File;
import java.io.FileInputStream;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
//import com.microsoft.windowsazure.serviceruntime.RoleEnvironment;


public class BlobFileUploadApplication {

	public static final String storageConnectionString = "DefaultEndpointsProtocol=https;"
			+ "AccountName=blobstorageaccount12345;"
			+ "AccountKey=4Kk642QfAUi8W/e+RD3SRE3rZbYoXaJrDusAyC1po9xcz3TXbxpo25rabiTT/rSLwKbf3mm14C5PeBV1mSy8SA==;"
			+ "EndpointSuffix=core.windows.net";

	public static void main(String[] args) {
		try {
			// String storageConnectionString = getStorageConnectionString();
			uploadBlob(storageConnectionString);
		} catch (Exception re) {
			re.printStackTrace();
		}
	}

	private static void uploadBlob(String storageConnectionString) {
		try {
			// Retrieve storage account from connection-string.
			CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);

			// Create the blob client.
			CloudBlobClient blobClient = storageAccount.createCloudBlobClient();

			// Get a reference to a container.
			// The container name must be lower case
			CloudBlobContainer container = blobClient.getContainerReference("blobstoragecontainer");

			// Create the container if it does not exist.
			container.createIfNotExists();

			container.uploadPermissions(publicBlobContainer());

			// Define the path to a local file.
			//final String filePath = "C:\\Users\\USER\\Documents\\index.html";
			final String filePath = ".\\data\\1M_Sample_CSV.csv";

			// Create or overwrite the "myimage.jpg" blob with contents from a local file.
			CloudBlockBlob blob = container.getBlockBlobReference("1M_Sample_CSV.csv");
			File source = new File(filePath);
			blob.upload(new FileInputStream(source), source.length());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("File uploaded successfully");
	}

	private static BlobContainerPermissions publicBlobContainer() {
		// Create a permissions object.
		BlobContainerPermissions containerPermissions = new BlobContainerPermissions();

		// Include public access in the permissions object.
		containerPermissions.setPublicAccess(BlobContainerPublicAccessType.CONTAINER);

		return containerPermissions;
	}

	/*
	 * private static String getStorageConnectionString() { return
	 * RoleEnvironment.getConfigurationSettings().get(storageConnectionString); }
	 */
}
