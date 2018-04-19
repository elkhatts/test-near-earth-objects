package com.salah.elkhattab.services;

import com.salah.elkhattab.model.NeoObject;
import java.util.Date;
import java.util.List;

/**
 *
 * @author salah EL KHATTAB elkhatts@gmail.com
 * @version 1.0
 * @since 2018-04-18
 * @description This is the interface that a NearEarthObjectServiceImpl
 * implements It's used in a Spring framwork context
 *
 */
public interface NeoObjectService {

    /**
     *
     * @param startDate
     * @return the final a formated string of the result returned by the web service
     */
    public String getNearEarthObjects(Date startDate, Date endDate);

    /**
     *
     * @param nearEarthObjects
     * @return the Closest NearEarth Object returned by the web service
     */
    public NeoObject getClosestNearEarthObject(List<NeoObject> nearEarthObjects);

    /**
     *
     * @param nearEarthObjects
      * @return the Largest NearEarth Object returned by the web service
     */
    public NeoObject getLargestNearEarthObject(List<NeoObject> nearEarthObjects);

    /**
     *
     * @param startDate
     * @param endDate
     * @return all NearEarth Object returned by the web service
     */
    public List<NeoObject> getNearEarthObjects(String startDate, String endDate);

    /**
     *
     * @param neo
      * @return a NearEarth Object details
     */
    public String getDetails(NeoObject neo);
}
