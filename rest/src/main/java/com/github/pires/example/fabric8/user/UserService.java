package com.github.pires.example.fabric8.user;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pires.example.fabric8.api.billing.BillingService;

@Path("/user")
public class UserService {

  private BillingService billingService;

  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Double> executeSomething() {
    log.info("Executing something...");
    List<Double> balances = new ArrayList<Double>();
    final String userId = "testUser";
    billingService.createBillingAcount(userId);
    billingService.addCash(1000);
    balances.add(billingService.getBalance());
    log.info("Current balance: {}", billingService.getBalance());
    billingService.removeCash(500);
    balances.add(billingService.getBalance());
    log.info("Current balance: {}", billingService.getBalance());
    return balances;
  }

  public BillingService getBillingService() {
    return billingService;
  }

  public void setBillingService(BillingService bs) {
    this.billingService = bs;
  }

}