package com.github.pires.example.fabric8.api.billing;

public interface BillingService {

  void createBillingAcount(final String userId);

  void addCash(final double value);

  void removeCash(final double value);

  double getBalance();

}