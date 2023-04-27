package com.azure.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azure.practice.service.InvoiceDownloadService;

@RestController
@RequestMapping(path = "/sc3services")
public class InvoiceDownloadController {
	
	@Autowired
	InvoiceDownloadService downloadService;
	
	@GetMapping(path = "/download-invoice")
	public List<byte[]> downloadInvoiceByUsingContainerName(@RequestParam String containerName) {
		return downloadService.downloadInvoiceByUsingContainerName(containerName);
	}
	
}
