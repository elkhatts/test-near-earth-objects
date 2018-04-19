package com.salah.elkhattab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.salah.elkhattab.services.NeoObjectService;
import java.util.Calendar;

/**
 *
 * @author salah EL KHATTAB elkhatts@gmail.com
 * @version 1.0
 * @since 2018-04-18
 * @description This is the entry point of the Spring boot Application The
 * application is a client of the RESTful web service for near earth Asteroid
 * information. This application can implemented as a web application by addig a
 * Spring mvc controller that call the service and some html pages
 *
 */
@SpringBootApplication
public class NeoApplication {

    private static Log logger = LogFactory.getLog(NeoApplication.class);
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new SpringApplication(NeoApplication.class).run(args);
        context.start();

        BufferedReader br = null;
        echoMessage();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                logger.info("Enter the date : ");
                String input = br.readLine();
                if ("q".equals(input)) {
                    logger.info("Exit!");
                    System.exit(0);
                }
                Date startDate = simpleDateFormat.parse(simpleDateFormat.format(new Date()));

                logger.info("input : " + input);
                try {
                    startDate = simpleDateFormat.parse(input);
                } catch (Exception e) {
                    System.out.println("Pleae provide a correct date! the default date is used.");
                }
                                Calendar c = Calendar.getInstance();
                c.setTime(startDate);
                c.add(Calendar.DATE, 6);
                Date endDate = c.getTime();
                
                logger.info(">> Processing date: " + simpleDateFormat.format(startDate) +" To "+simpleDateFormat.format(endDate));
                NeoObjectService service = context.getBean(NeoObjectService.class);
                String response = service.getNearEarthObjects(startDate, endDate);
                if (response != null) {
                    logger.info(response);
                } else {
                    logger.info("\n\n Error processing your request! no data for this date");
                }
                //echoMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     *
     */
    private static void echoMessage() {
        logger.info("\n\n Welcome to Near Earth Object Web Service from the NASA! ");
        logger.info(" NeoWs is a RESTful web service for near earth Asteroid information. \n With NeoWs a user can: search for Asteroids based on their closest approach date to Earth, \n lookup a specific Asteroid with its NASA JPL small body id, as well as browse the overall data-set.");
        logger.info("\n\n Please enter a date in format: \"yyyy-MM-dd\". Default is today. -- or -- \"q\" to exit.");
    }
}
