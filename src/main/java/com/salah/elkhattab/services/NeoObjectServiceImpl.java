package com.salah.elkhattab.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.salah.elkhattab.model.NeoObject;
import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import com.salah.elkhattab.NeoApplication;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 *
 * @author salah EL KHATTAB elkhatts@gmail.com
 * @version 1.0
 * @since 2018-04-18
 * @description This is the concret service implementation of
 * NearEarthObjectService interface It's used in a Spring Framwork context
 *
 */
@Service
public class NeoObjectServiceImpl implements NeoObjectService {

    private static Log logger = LogFactory.getLog(NeoApplication.class);

    /**
     *
     * @param startDate
     * @return
     * @see the Javadoc descriptin in the interface NearEarthObjectService
     */
    @Override
    public String getNearEarthObjects(Date startDate, Date endDate) {

        String response = null;

        List<NeoObject> neoObjects = getNearEarthObjects(NeoApplication.simpleDateFormat.format(startDate), NeoApplication.simpleDateFormat.format(endDate));

        if (!neoObjects.isEmpty()) {
            StringBuffer buffer = new StringBuffer();
            NeoObject largestNEO = getLargestNearEarthObject(neoObjects);
            NeoObject closestNEO = getClosestNearEarthObject(neoObjects);
            buffer.append("\n================================================");
            buffer.append("\nTotal number of NEOs: " + neoObjects.size() + " \n================================================");
            buffer.append("\nLargest NEO: \n------------" + getDetails(largestNEO));
            buffer.append("\n================================================");
            buffer.append("\nClosest NEO: \n------------" + getDetails(closestNEO));
            buffer.append("\n================================================");

            response = buffer.toString();

        }
        return response;

    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     * @see the Javadoc descriptin in the interface NearEarthObjectService
     * Jersey API is used for RESTfull client
     * Any Restfull client can be used like Spring Restfull or Apache Http API
     */
    @Override
    public List<NeoObject> getNearEarthObjects(String startDate, String endDate) {
        List<NeoObject> nearEarthObjects = new ArrayList<>();

        final Response response = ClientBuilder.newClient()
                .target("https://api.nasa.gov/neo/rest/v1/feed")
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate)
                .queryParam("api_key", "VYnTDDfLv4n3QsJpar1tRbXIC8l1LSI160QMPcbT")
                .request()
                .get();

        
        JsonNode json = response.readEntity(ObjectNode.class);
        
        ObjectMapper mapper = new ObjectMapper();
        Iterator<JsonNode> iterator = json.get("near_earth_objects").elements();
        while (iterator.hasNext()) {
            for (JsonNode jsonNode : iterator.next()) {
                NeoObject neo = mapper.convertValue(jsonNode, NeoObject.class);
                nearEarthObjects.add(neo);
            }
        }

        return nearEarthObjects;
    }

    /**
     *
     * @param neo
     * @return
     * @see the Javadoc descriptin in the interface NearEarthObjectService
     */
    @Override
    public String getDetails(NeoObject neo) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n\nName: " + neo.getName());
        buffer.append("\nID: " + neo.getNeo_reference_id());
        buffer.append("\nMin diameter: " + neo.getEstimated_diameter().getKilometers().getEstimated_diameter_min() + " km");
        buffer.append("\nMax diameter: " + neo.getEstimated_diameter().getKilometers().getEstimated_diameter_max() + " km");
        buffer.append("\nDistance: " + neo.getClose_approach_data().get(0).getMiss_distance().getKilometers() + " km");
        buffer.append("\nUrl: " + neo.getNasa_jpl_url());
        buffer.append("\nAbsolute Magnitude: " + neo.getAbsolute_magnitude_h());
        buffer.append("\nPotentially Hazardous: " + neo.isIs_potentially_hazardous_asteroid());

        return buffer.toString();
    }

    /**
     *
     * @param nearEarthObjects
     * @return
     * @see the Javadoc descriptin in the interface NearEarthObjectService
     */
    @Override
    public NeoObject getLargestNearEarthObject(List<NeoObject> nearEarthObjects) {

        Collections.sort(nearEarthObjects, new Comparator<NeoObject>() {
            @Override
            public int compare(NeoObject o1, NeoObject o2) {
                return o1.getEstimated_diameter().getKilometers().getEstimated_diameter_max() > o2.getEstimated_diameter().getKilometers().getEstimated_diameter_max() ? -1 : 0;
            }
        });
        return nearEarthObjects.get(0);
    }

    /**
     *
     * @param nearEarthObjects
     * @return
     * @see the Javadoc descriptin in the interface NearEarthObjectService
     */
    @Override
    public NeoObject getClosestNearEarthObject(List<NeoObject> nearEarthObjects) {

        Collections.sort(nearEarthObjects, new Comparator<NeoObject>() {
            @Override
            public int compare(NeoObject o1, NeoObject o2) {
                return Double.parseDouble(o1.getClose_approach_data().get(0).getMiss_distance().getKilometers()) > Double.parseDouble(o2.getClose_approach_data().get(0).getMiss_distance().getKilometers()) ? 0 : -1;
            }
        });
        return nearEarthObjects.get(0);
    }
}
