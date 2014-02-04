package com.github.pires.example.fabric8.billing;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pires.example.fabric8.api.billing.BillingService;

public class BillingServiceImpl implements BillingService {

  private static final Logger log = LoggerFactory
      .getLogger(BillingService.class);

  private double balance = 0;

  public BillingServiceImpl() {
    this.balance = 0;
  }

  public void createBillingAcount(final String userId) {
    log.info("Creating account for {}");
  }

  public void addCash(final double value) {
    this.balance += value;
    log.info("{} added", value);
  }

  public void removeCash(final double value) {
    balance -= value;
    log.info("{} removed", value);
  }

  public double getBalance() {
    return balance;
  }

  void activate(Map<String, ?> configuration) {
    log.info("Activating Billing service.");
  }

  void modified(Map<String, ?> configuration) {
    // TODO
  }

  void deactivate() {
    log.info("Deactivating Billing service.");
  }

}