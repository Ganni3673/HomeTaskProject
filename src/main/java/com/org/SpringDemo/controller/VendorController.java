package com.org.SpringDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.SpringDemo.json.MessageJson;
import com.org.SpringDemo.json.VendorJson;
import com.org.SpringDemo.model.VendorModel;
import com.org.SpringDemo.service.VendorService;

@RestController
@CrossOrigin
@RequestMapping("/api/vendor")
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	public ResponseEntity<VendorJson> addVendor(@RequestBody VendorJson vendorJson){
		MessageJson mess=new MessageJson();
		mess=vendorService.addvendor(vendorJson);
		if(mess.getStatuscode()==400) {
			return new ResponseEntity<VendorJson>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<VendorJson>(HttpStatus.OK);
		}
	}


//===============================================================
@GetMapping("/getAllVendor")
public List<VendorModel> getAllVendors() {
    return vendorService.getAllVendors();
}
}