package com.xoriant.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.bank.model.Account;
import com.xoriant.bank.model.Customer;
import com.xoriant.bank.model.Transactions;
import com.xoriant.bank.service.BankService;

@RestController
@RequestMapping("/bank/managerservice")
public class ManagerResource {

	@Autowired
	BankService bankservice;
	
	@PostMapping("/customer")
	public Customer addcustomer(@RequestBody Customer customer) {
		return bankservice.Addcustomer(customer);
	}
	
	@PostMapping("/customer")
	public String editcustomer(@RequestParam("customerid") int customerid,@RequestBody Customer customer) {
		return bankservice.editcustomer(customerid, customer);
	}
	@DeleteMapping("/customer/{customerid}")
	public String deletecustomer(@PathVariable int customerid)
	{
		return bankservice.deletecustomer(customerid);
	}
	
	@PostMapping("/account")
	public Account addaccount(@RequestBody Account account)
	{
		return bankservice.addaccount(account);
	}
	
	@DeleteMapping("/account/{accountid}")
	public String deleteaccount(@PathVariable int accountid)
	{
		return bankservice.deleteaccount(accountid);
	}
	
	@PutMapping("/deposit/{accountnumber}/{amount}")
	public String depositamount(@PathVariable int accountnumber,@PathVariable float amount)
	{
		return bankservice.deposit(accountnumber, amount);
	}
	
	@PutMapping("/withdraw/{accountnumber}/{amount}")
	public String withdrawamount(@PathVariable int accountnumber,@PathVariable float amount)
	{
		return bankservice.withdraw(accountnumber, amount);
	}
	
	@PutMapping("/fundtransfer/{sender}/{receiver}/{amount}")
	public String fundtransfer(@PathVariable int sender,@PathVariable int receiver,@PathVariable float amount)
	{
		return bankservice.fundtransfer(sender, receiver, amount);
	}
	
	@GetMapping("/getministatement/{accountnumber}")
	public List<Transactions> getministatement(@PathVariable int accountnumber)
	{
		return bankservice.getministatement(accountnumber);
	}
	
	@PostMapping("/changepassword")
	public String changepassword(@RequestBody Map<String, String> body)
	{
		String username=body.get("username");
		String password=body.get("password");
		return bankservice.changepassword(username, password);
	}
}
