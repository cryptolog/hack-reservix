package de.btcag.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Florian Postel, BTC AG (Oldenburg), 26.05.15 17:27
 * @version $LastChangedRevision$
 *          <p/>
 *          $LastChangedBy$
 *          <p/>
 *          $LastChangedDate$
 */
@EnableAutoConfiguration
@ComponentScan
public class ReservixApp {
  public static void main(String[] args) {
    SpringApplication.run(ReservixApp.class, args);
  }
}

