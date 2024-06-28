package com.kahindi.briskspringdemo.config;


import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * This class is responsible for configuring transaction management in the application.
 * Transaction management allows the application to handle database transactions in a consistent and reliable manner.
 * By enabling transaction management, the application can ensure that each database operation is atomic and provides
 * consistency in case of failures or errors.
 *
 * @author <a href="https://github.com/kamarbaraka">samson baraka</a>.
 */
@EnableTransactionManagement /*enable trx management*/
public class TrxMngConfig {
}
