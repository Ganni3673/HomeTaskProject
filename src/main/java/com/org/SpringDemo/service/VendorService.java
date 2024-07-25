package com.org.SpringDemo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.SpringDemo.json.EmailJson;
import com.org.SpringDemo.json.MessageJson;
import com.org.SpringDemo.json.VendorJson;
import com.org.SpringDemo.model.EmailModel;
import com.org.SpringDemo.model.EmployeeModel;
import com.org.SpringDemo.model.VendorModel;
import com.org.SpringDemo.repository.VendorRepo;

@Service
public class VendorService {

	
	
	@Autowired
	private VendorRepo vendorRepo;
	
	public MessageJson addvendor(VendorJson vendorJson) {
		
		MessageJson mess =new MessageJson();
		Optional<VendorModel> mod=vendorRepo.findByIdVendor(vendorJson.getId());
		if(mod.isPresent()) {
			mess.setMessage("already vendor detail is prasent");
			mess.setStatuscode(400);
		}else {
			VendorModel vm=new VendorModel();
			vm.setId(vendorJson.getId());
			vm.setEmail(vendorJson.getEmail());
			vm.setName(vendorJson.getName());
			vm.setUpi(vendorJson.getUpi());
			vendorRepo.save(vm);
			mess.setMessage("vendor details are added successfully");
			mess.setStatuscode(200);
		}
		
	
		return mess;
	}
	
	//================================================================================

	  private List<VendorModel> vendors;

	    public VendorService(List<VendorModel> vendors) {
	        this.vendors = vendors;
	    }

	    public List<VendorModel> getVendorsByEmails(List<String> vendorEmails) {
	        return vendors.stream()
	                .filter(vendor -> vendorEmails.contains(vendor.getEmail()))
	                .collect(Collectors.toList());
	    }
//==================================================================================
	//get all vendor details
	    public List<VendorModel> getAllVendors() {
			
			
			List<VendorModel> list=new ArrayList<VendorModel>();
			Collection<VendorModel> mod=vendorRepo.findAll();
			
			for(VendorModel empd:mod) {
				list.add(empd);
				
				
			}
			
			return list;
		}

	
}


