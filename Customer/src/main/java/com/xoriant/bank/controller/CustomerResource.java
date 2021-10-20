package com.xoriant.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Transactions;
import com.xoriant.bank.model.Userdetails;
import com.xoriant.bank.service.BankService;

@RestController
@RefreshScope
@RequestMapping("/bank/customerservice")
public class CustomerResource {

	@Autowired
	BankService bankservice;
	
	@GetMapping("/hello")
	public String helloworld()
	{
		return "Hello";
	}
	
	@GetMapping("/getbalance/{accountnumber}")
	public String getbalance(@PathVariable int accountnumber) {
		return "Your Balance is"+bankservice.GetBalance(accountnumber);
	}
	
	@PostMapping("/adduserdetails/{emailid}")
	public Userdetails addUserdetails(@RequestBody Userdetails userdetails,@PathVariable String emailid)
	{
		return bankservice.addUserdetails(userdetails, emailid);
	}
	
	@GetMapping("/getministatement/{accountnumber}")
	public List<Transactions> getministatement(@PathVariable int accountnumber)
	{
		return bankservice.getministatement(accountnumber);
	}
	@GetMapping("/getaccounts/{customerid}")
	public List<Account> getaccount(@PathVariable int customerid)
	{
		return bankservice.getaccount(customerid);
	}
	
	@GetMapping("/getcustomstatement/{start}/{end}")
	public List<Transactions> getministatement(@PathVariable String startdate,@PathVariable String enddate)
	{
		return bankservice.customreport(startdate, enddate);
	}
	@PostMapping("/changepassword")
	public String changepassword(@RequestBody Map<String, String> body)
	{
		String username=body.get("username");
		String password=body.get("password");
		return bankservice.changepassword(username, password);
	}
}
